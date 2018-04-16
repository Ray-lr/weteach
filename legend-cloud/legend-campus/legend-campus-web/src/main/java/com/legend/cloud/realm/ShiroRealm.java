package com.legend.cloud.realm;

import com.legend.cloud.entity.base.BaseUserRelRole;
import com.legend.cloud.entity.campus.CampusUserInfo;
import com.legend.cloud.entity.system.SystemPermission;
import com.legend.cloud.entity.system.SystemRole;
import com.legend.cloud.entity.system.SystemRoleRelPermission;
import com.legend.cloud.entity.system.SystemUserRelRole;
import com.legend.cloud.model.constant.attribute.TypeUser;
import com.legend.cloud.service.base.BaseUserRelRoleService;
import com.legend.cloud.service.base.BaseUserService;
import com.legend.cloud.service.campus.CampusUserInfoService;
import com.legend.cloud.service.system.*;
import com.legend.cloud.vo.campus.CampusUserInfoVO;
import com.legend.module.core.entity.user.User;
import com.legend.module.core.model.contant.message.exception.UserExceptionMessage;
import com.legend.module.core.vo.core.UserVO;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/23
 */
public class ShiroRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroRealm.class);

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private BaseUserService baseUserService;

    @Resource
    private SystemUserRelRoleService systemUserRelRoleService;

    @Resource
    private SystemRoleService systemRoleService;

    @Resource
    private BaseUserRelRoleService baseUserRelRoleService;

    @Resource
    private SystemRoleRelPermissionService systemRoleRelPermissionService;

    @Resource
    private SystemPermissionService systemPermissionService;

    @Resource
    private CampusUserInfoService campusUserInfoService;

    /**
     * 授权
     *
     * @param principalCollection principalCollection
     * @return simpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserVO currentUser = (UserVO) principalCollection.getPrimaryPrincipal();
        List<Integer> roleIds = new ArrayList<>();
        List<Integer> permissionIds;
        Set<String> roleSigns;
        Set<String> permissionSigns = new HashSet<>();
        if (TypeUser.ADMIN.equals(currentUser.getTypeUser())) {
            roleIds = systemUserRelRoleService.getListByUserId(currentUser.getId()).stream().map
                    (SystemUserRelRole::getSystemRoleId).collect(Collectors.toList());
        } else if (TypeUser.USER.equals(currentUser.getTypeUser())) {
            roleIds = baseUserRelRoleService.getListByUserId(currentUser.getId()).stream().map
                    (BaseUserRelRole::getSystemRoleId).collect(Collectors.toList());
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (roleIds.isEmpty()) {
            LOGGER.info("Permission denied");
            return simpleAuthorizationInfo;
        }
        roleSigns = systemRoleService.getListByIds(roleIds).stream().map(SystemRole::getSign).collect(Collectors.toSet());
        permissionIds = systemRoleRelPermissionService.getListByRoleIds(roleIds).stream().map
                (SystemRoleRelPermission::getPermissionId).collect(Collectors.toList());
        if (!permissionIds.isEmpty()) {
            permissionSigns = systemPermissionService.getListByPermissionIds(permissionIds).stream
                    ().map(SystemPermission::getSign).collect(Collectors.toSet());
        }
        simpleAuthorizationInfo.addRoles(roleSigns);
        simpleAuthorizationInfo.addStringPermissions(permissionSigns);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录验证
     *
     * @param authenticationToken authenticationToken
     * @return simpleAuthenticationInfo
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if (StringUtils.isBlank(token.getUsername())) {
            throw new AuthenticationException(UserExceptionMessage.USERNAME_IS_BLANK);
        }
        User user;
        Object account = null;
        if (TypeUser.ADMIN.equals(token.getHost())) {
            user = systemUserService.getByUserName(token.getUsername());
            if (user == null) {
                throw new AuthenticationException(UserExceptionMessage.USERNAME_IS_NOT_EXIST);
            }
        } else if (TypeUser.USER.equals(token.getHost())) {
            user = baseUserService.getByUserName(token.getUsername());
            if (user == null) {
                throw new AuthenticationException(UserExceptionMessage.USERNAME_IS_NOT_EXIST);
            }
            CampusUserInfo campusUserInfo = campusUserInfoService.getByUserId(user.getId());
            if (campusUserInfo != null) {
                account = new CampusUserInfoVO().parseFrom(campusUserInfo);
            }
        } else {
            throw new AuthenticationException("用户类型无效");
        }
        @SuppressWarnings("unchecked") UserVO currentUser = (UserVO) new UserVO().parseFrom(user);
        currentUser.setAccount(account);
        currentUser.setTypeUser(token.getHost());
        //将主体对象放入了Principal中
        return new SimpleAuthenticationInfo(currentUser,
                currentUser.getPassword(),
                ByteSource.Util.bytes(currentUser.getUsername()), getName());
    }

}
