package com.legend.cloud.controller.base;


import com.alibaba.fastjson.JSON;
import com.legend.cloud.entity.base.BaseUser;
import com.legend.cloud.model.constant.attribute.TypeUser;
import com.legend.cloud.service.base.BaseUserService;
import com.legend.cloud.vo.base.BaseUserVO;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.message.result.user.UserResultMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.service.user.UserService;
import com.legend.module.core.vo.core.UserVO;
import com.legend.module.core.web.controller.user.AbstractUserController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
@RequestMapping("/base/user")
public class BaseUserController extends AbstractUserController<BaseUserVO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseUserController.class);

    @Resource
    private BaseUserService baseUserService;

    @Override
    public UserService getUserService() {
        return baseUserService;
    }

    @Override
    protected boolean loginPreProcess(BaseUserVO baseUserVO) {
        return false;
    }

    @Override
    protected Ajax loginProcess(BaseUserVO baseUserVO) {
        UsernamePasswordToken token = new UsernamePasswordToken(baseUserVO.getUsername(),
                baseUserVO.getPassword(), baseUserVO.getRememberMe(), TypeUser.USER);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (!subject.isAuthenticated()) {
                return Ajax.error();
            }
            UserVO currentUser = (UserVO) subject.getPrincipal();
            // 更新最后登录时间
            BaseUser baseUser = new BaseUser();
            baseUser.setId(currentUser.getId());
            baseUser.setLastLoginTime(new Date());
            baseUserService.updateById(baseUser);
            // 设置用户到session
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
    protected boolean logoutPreProcess(BaseUserVO baseUserVO) {
        return false;
    }

    @Override
    protected Ajax logoutProcess(BaseUserVO baseUserVO) {
        return Ajax.error();
    }


}
