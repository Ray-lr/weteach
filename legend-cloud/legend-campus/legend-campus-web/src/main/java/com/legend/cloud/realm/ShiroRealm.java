package com.legend.cloud.realm;

import com.legend.cloud.entity.system.SystemPermission;
import com.legend.cloud.entity.system.SystemRoleRelPermission;
import com.legend.cloud.entity.system.SystemUserRelRole;
import com.legend.cloud.model.constant.attribute.Key;
import com.legend.cloud.service.base.BaseUserService;
import com.legend.cloud.service.system.SystemPermissionService;
import com.legend.cloud.service.system.SystemRoleRelPermissionService;
import com.legend.cloud.service.system.SystemUserRelRoleService;
import com.legend.cloud.service.system.SystemUserService;
import com.legend.module.core.entity.user.User;
import com.legend.module.core.model.contant.message.exception.UserExceptionMessage;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/23
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private BaseUserService baseUserService;

    @Resource
    private SystemUserRelRoleService systemUserRelRoleService;

    @Resource
    private SystemRoleRelPermissionService systemRoleRelPermissionService;

    @Resource
    private SystemPermissionService systemPermissionService;

    private UsernamePasswordToken usernamePasswordToken;

    /**
     * 授权
     *
     * @param principalCollection principalCollection
     * @return simpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        List<String> permissionSigns = null;
        if ("system".equals(usernamePasswordToken.getHost())) {
            User currentUser = (User) principalCollection.getPrimaryPrincipal();
            List<Integer> roleIds = systemUserRelRoleService.getListByUserId(currentUser.getId()).stream().map
                    (SystemUserRelRole::getRoleId).collect(Collectors.toList());
            List<Integer> permissionIds = systemRoleRelPermissionService.getListByRoleIds(roleIds).stream().map
                    (SystemRoleRelPermission::getPermissionId).collect(Collectors.toList());
            permissionSigns = systemPermissionService.getListByPermissionIds(permissionIds).stream
                    ().map(SystemPermission::getSign).collect(Collectors.toList());
        } else if ("base".equals(usernamePasswordToken.getHost())) {
            System.out.println("baseUser login");
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
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
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        if (StringUtils.isBlank(usernamePasswordToken.getUsername())) {
            throw new AuthenticationException(UserExceptionMessage.USERNAME_IS_BLANK);
        }
        User currentUser = null;
        if (Key.SYSTEM.equals(usernamePasswordToken.getHost())) {
            currentUser = systemUserService.getByUserName(usernamePasswordToken.getUsername());
        } else if (Key.BASE.equals(usernamePasswordToken.getHost())) {
            currentUser = baseUserService.getByUserName(usernamePasswordToken.getUsername());
        }
        if (currentUser == null) {
            throw new AuthenticationException(UserExceptionMessage.USERNAME_IS_NOT_EXIST);
        }
        //将主体对象放入了Principal中
        return new SimpleAuthenticationInfo(currentUser, currentUser.getPassword(), getName());
    }

}
