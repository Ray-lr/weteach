package com.legend.module.core.web.controller.user;

import com.legend.module.core.entity.user.User;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.code.result.user.UserResultCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.contant.message.result.user.UserResultMessage;
import com.legend.module.core.model.group.user.AccountLoginGroup;
import com.legend.module.core.model.group.user.PhoneLoginGroup;
import com.legend.module.core.model.group.user.RegisterGroup;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxError;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.service.user.UserService;
import com.legend.module.core.utils.HttpSessionUtils;
import com.legend.module.core.vo.core.UserVO;
import com.legend.module.core.web.controller.LegendController;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.HibernateValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @date 2018/2/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractUserController<TVO extends UserVO> extends
        LegendController<TVO> {

    private static final Validator VALIDATOR = Validation.byProvider(HibernateValidator.class).configure().failFast
            (false).buildValidatorFactory().getValidator();

    /**
     * 由继承的子类实现具体的userService
     *
     * @return userService<T>
     */
    public abstract UserService getUserService();


    /**
     * 登录前的操作，如无特殊需求可忽视
     * <p>
     * 允许在子类重写方法
     * </p>
     *
     * @param tvo - vo
     */
    protected boolean loginPreProcess(TVO tvo) {
        return true;
    }

    /**
     * 登录成功后的操作，如无特殊需求可忽视，默认登录成功
     * <p>
     * 允许在子类重写方法
     * </p>
     */
    protected Ajax loginProcess(TVO tvo) {
        return Ajax.success(UserResultMessage.LOGIN_SUCCESS);
    }

    /**
     *
     */
    protected boolean logoutPreProcess(TVO tvo) {
        return true;
    }

    /**
     * 登出成功后的操作，如无特殊需求可忽视
     * <p>
     * 允许在子类重写方法
     * </p>
     */
    protected Ajax logoutProcess(TVO tvo) {
        return Ajax.success(UserResultMessage.LOGIN_OUT_SUCCESS);
    }

    /**
     * 注册成功后的操作，如无特殊需求可忽视
     * <p>
     * 允许在子类重写方法
     * </p>
     */
    protected void registerProcess(TVO tvo) {

    }

    /**
     * 修改密码成功后的操作，如无特殊需求可忽视
     * <p>
     * 允许在子类重写方法
     * </p>
     */
    protected void updatePasswordProcess(TVO tvo) {

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Ajax login(TVO tvo) {
        try {
            if (tvo == null) {
                return Ajax.error(UserResultMessage.IS_BLANK, UserResultCode.IS_BLANK);
            }
            return checkUser(tvo);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.PUT)
    @ResponseBody
    public Ajax logout() {
        try {
            TVO currentUser = (TVO) getCurrentUser();
            if (loginPreProcess(currentUser)) {
                removeCurrentUser();
            }
            return logoutProcess(currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping("/image/")
    @ResponseBody
    public Ajax imageCode(String code) {
        return null;
    }

    @RequestMapping("/sms")
    @ResponseBody
    public Ajax sendSMS(String phone) {
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Ajax register(@Validated({RegisterGroup.class}) TVO tvo, BindingResult bindingResult) {
        return null;
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Ajax updatePassword() {
        return null;
    }

    /**
     * 验证图片验证码
     *
     * @param code 图片验证码
     * @return true or false
     */
    protected AjaxError checkImageCode(String code) {
        if (StringUtils.isBlank(code)) {
            return new AjaxError(UserResultMessage.IMAGE_CODE_IS_BLANK, UserResultCode.IMAGE_CODE_IS_BLANK);
        }
        String imageCode = String.valueOf(HttpSessionUtils.getAttribute(Key.IMAGECODE));
        if (StringUtils.isBlank(imageCode)) {
            return new AjaxError(UserResultMessage.IMAGE_CODE_NOT_EXIST, UserResultCode.IMAGE_CODE_NOT_EXIST);
        }
        return imageCode.equals(code) ? null : new AjaxError(UserResultMessage.IMAGE_CODE_WRONG, UserResultCode.IMAGE_CODE_WRONG);
    }

    /**
     * 验证短信验证码
     * <p>
     * 允许在子类重写验证方法
     * </p>
     *
     * @param code 短信验证码
     * @return true or false
     */
    protected AjaxError checkSMSCode(String code) {
        if (StringUtils.isBlank(code)) {
            return new AjaxError(UserResultMessage.SMS_CODE_IS_BLANK, UserResultCode.SMS_CODE_IS_BLANK);
        }
        String smsCode = String.valueOf(HttpSessionUtils.getAttribute(Key.SMSCODE));
        if (StringUtils.isBlank(smsCode)) {
            return new AjaxError(UserResultMessage.SMS_CODE_NOT_SENT, UserResultCode.SMS_CODE_NOT_SENT);
        }
        return smsCode.equals(code) ? null : new AjaxError(UserResultMessage.SMS_CODE_WRONG, UserResultCode.SMS_CODE_WRONG);
    }

    /**
     * 验证手机号是否相同
     * <p>
     * 允许在子类重写验证方法
     * </p>
     *
     * @param phoneNum 手机号
     * @return true or false
     */
    protected AjaxError checkPhone(String phoneNum) {
        if (StringUtils.isBlank(phoneNum)) {
            return new AjaxError(UserResultMessage.PHONE_IS_BLANK, UserResultCode.PASSWORD_IS_BLANK);
        }
        String phone = String.valueOf(HttpSessionUtils.getAttribute(Key.PHONE));
        if (StringUtils.isBlank(phone)) {
            return new AjaxError(UserResultMessage.SMS_CODE_NOT_SENT, UserResultCode.SMS_CODE_NOT_SENT);
        }
        return phoneNum.equals(phone) ? null : new AjaxError(UserResultMessage.PHONE_WRONG, UserResultCode.PHONE_WRONG);
    }

    /**
     * 验证用户信息有效性
     *
     * @param tvo tvo
     * @return Ajax
     */
    private Ajax checkUser(TVO tvo) {
        if (loginPreProcess(tvo)) {
            if (getCurrentUser() != null) {
                return Ajax.success(UserResultMessage.LOGIN_SUCCESS);
            }
            AjaxError ajaxerror;
            User user;
            if (StringUtils.isBlank(tvo.getPhone()) && StringUtils.isBlank(tvo.getUsername())) {
                return Ajax.error(UserResultMessage.IS_BLANK, UserResultCode.IS_BLANK);
            }
            if (StringUtils.isBlank(tvo.getUsername())) {
                if ((ajaxerror = validatePhoneLogin(tvo)) != null) {
                    return Ajax.error(ajaxerror);
                }
                if ((ajaxerror = checkPhone(tvo.getPhone())) != null) {
                    return Ajax.error(ajaxerror);
                }
                if ((ajaxerror = checkSMSCode(tvo.getSmsCode())) != null) {
                    return Ajax.error(ajaxerror);
                }
                if ((user = getUserService().getByPhone(tvo.getPhone())) == null) {
                    return Ajax.error(UserResultMessage.USER_NOT_EXIST, UserResultCode.USER_NOT_EXIST);
                }
            } else {
                if ((ajaxerror = validateAccountLogin(tvo)) != null) {
                    return Ajax.error(ajaxerror);
                }
                if ((ajaxerror = checkImageCode(tvo.getImageCode())) != null) {
                    return Ajax.error(ajaxerror);
                }
                if ((user = getUserService().getByUsernameAndPassword(tvo.getUsername(), tvo.getPassword())) == null) {
                    return Ajax.error(UserResultMessage.USER_NOT_EXIST, UserResultCode.USER_NOT_EXIST);
                }
            }
            setCurrentUser((TVO) tvo.parseFrom(user, "password",
                    "last_login_time", "create_time", "update_time"));
        }
        return loginProcess(tvo);
    }

    /**
     * 可以在子类自定义手机号登录验证逻辑
     * <p>
     * 允许在子类重写验证方法
     * </p>
     *
     * @param tvo tvo
     * @return AjaxError
     */
    protected AjaxError validatePhoneLogin(TVO tvo) {
        return validateLogin(tvo, PhoneLoginGroup.class);
    }

    /**
     * 可以在子类自定义用户名登录验证逻辑
     * <p>
     * 允许在子类重写验证方法
     * </p>
     *
     * @param tvo tvo
     * @return AjaxError
     */
    protected AjaxError validateAccountLogin(TVO tvo) {
        return validateLogin(tvo, AccountLoginGroup.class);
    }

    /**
     * 默认的登录验证
     *
     * @param tvo    tvo
     * @param groups 验证分组
     * @return AjaxError
     */
    private AjaxError validateLogin(TVO tvo, Class<?>... groups) {
        Set<ConstraintViolation<TVO>> violationSet;
        if ((violationSet = VALIDATOR.validate(tvo, groups)).isEmpty()) {
            return null;
        }
        List<AjaxError> errors = AjaxValidate.validate(violationSet);
        if (errors.isEmpty()) {
            return null;
        }
        return errors.get(0);
    }


}
