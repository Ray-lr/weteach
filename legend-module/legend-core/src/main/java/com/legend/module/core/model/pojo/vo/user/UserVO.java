package com.legend.module.core.model.pojo.vo.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.legend.module.core.model.contant.message.result.user.UserResultMessage;
import com.legend.module.core.model.contant.regex.Regexp;
import com.legend.module.core.model.group.user.AccountLoginGroup;
import com.legend.module.core.model.group.user.PhoneLoginGroup;
import com.legend.module.core.model.group.user.RegisterGroup;
import com.legend.module.core.model.group.user.UpdatePasswordGroup;
import com.legend.module.core.model.pojo.entity.user.User;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Administrator
 * @date 2018/3/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class UserVO<T extends User, TVO extends UserVO> extends AbstractVO<T, TVO> {

    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    @NotBlank(message = UserResultMessage.USERNAME_IS_BLANK, groups = {AccountLoginGroup.class, RegisterGroup.class,
            UpdatePasswordGroup.class})
    private String username;

    /**
     * 手机号
     */
    @NotBlank(message = UserResultMessage.PHONE_IS_BLANK, groups = {PhoneLoginGroup.class})
    @Pattern(regexp = Regexp.PHONE, message = UserResultMessage.PHONE_WRONG,
            groups = {PhoneLoginGroup.class})
    private String phone;

    /**
     * 密码
     */
    @NotBlank(message = UserResultMessage.PASSWORD_IS_BLANK, groups = {AccountLoginGroup.class, RegisterGroup.class,
            UpdatePasswordGroup.class})
    @Size(min = 6, message = UserResultMessage.PASSWORD_LENGTH_MIN, groups = {AccountLoginGroup.class, RegisterGroup
            .class, UpdatePasswordGroup.class})
    @JSONField(serialize = false)
    private String password;

    /**
     * 图片验证码
     */
    @NotNull(message = UserResultMessage.IMAGE_CODE_IS_BLANK, groups = {RegisterGroup.class})
    @Size(min = 4, max = 4, message = UserResultMessage.IMAGE_CODE_WRONG, groups = {RegisterGroup.class})
    @JSONField(serialize = false)
    private String imageCode;

    /**
     * 手机短信验证码
     */
    @NotNull(message = UserResultMessage.SMS_CODE_IS_BLANK, groups = {RegisterGroup.class, PhoneLoginGroup.class})
    @Size(min = 4, max = 4, message = UserResultMessage.SMS_CODE_WRONG, groups = {RegisterGroup.class, PhoneLoginGroup.class})
    @JSONField(serialize = false)
    private String smsCode;

    /**
     * 用户类型
     */
    private String typeUser;

    /**
     * 用户存储额外的用户信息
     */
    private Object account;

}
