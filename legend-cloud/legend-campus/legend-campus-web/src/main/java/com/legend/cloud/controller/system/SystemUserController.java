package com.legend.cloud.controller.system;


import com.alibaba.fastjson.JSON;
import com.legend.cloud.controller.base.BaseUserController;
import com.legend.cloud.entity.system.SystemUser;
import com.legend.cloud.service.system.SystemUserService;
import com.legend.cloud.vo.system.SystemUserVO;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.message.result.user.UserResultMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.service.user.UserService;
import com.legend.module.core.web.controller.user.AbstractUserController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/admin/user")
public class SystemUserController extends AbstractUserController<SystemUserVO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseUserController.class);

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private SecurityManager securityManager;


    @Override
    public UserService getUserService() {
        return systemUserService;
    }

    @Override
    protected boolean loginPreProcess(SystemUserVO systemUserVO) {
        return false;
    }

    @Override
    protected Ajax loginProcess(SystemUserVO systemUserVO) {
        UsernamePasswordToken token = new UsernamePasswordToken(systemUserVO.getUsername(), systemUserVO.getPassword
                (), systemUserVO.getRememberMe(), "admin");
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (!subject.isAuthenticated()) {
                return Ajax.error();
            }
            SystemUser systemUser = (SystemUser) subject.getPrincipal();
            // 更新最后登录时间
            systemUser.setLastLoginTime(new Date());
            systemUserService.updateById(systemUser);
            // 设置用户到session
            SystemUserVO currentUser = new SystemUserVO().parseFrom(systemUser);
            currentUser.setHost("admin");
            setCurrentUser(JSON.toJSONString(currentUser));
            LOGGER.info(String.valueOf(getCurrentUser()));
            return Ajax.success(UserResultMessage.LOGIN_SUCCESS).put(Key.URL, "/direct/index");
        } catch (IncorrectCredentialsException e) {
            System.err.println(e.getLocalizedMessage());
            return Ajax.error(UserResultMessage.USERNAME_OR_PASSWORD_WRONG);
        } catch (AuthenticationException e) {
            System.err.println(e.getLocalizedMessage());
            return Ajax.error(UserResultMessage.USERNAME_WRONG);
        }
    }

    @Override
    protected boolean logoutPreProcess(SystemUserVO systemUserVO) {
        return false;
    }

    @Override
    protected Ajax logoutProcess(SystemUserVO systemUserVO) {
        return Ajax.error();
    }
}
