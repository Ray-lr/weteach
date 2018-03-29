package com.legend.module.core.vo.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.legend.module.core.entity.user.User;
import com.legend.module.core.model.contant.message.result.user.UserResultMessage;
import com.legend.module.core.model.contant.regex.Regexp;
import com.legend.module.core.model.group.user.AccountLoginGroup;
import com.legend.module.core.model.group.user.PhoneLoginGroup;
import com.legend.module.core.model.group.user.RegisterGroup;
import com.legend.module.core.model.group.user.UpdatePasswordGroup;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Administrator
 * @date 2018/3/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class UserVO<T extends User> extends AbstractVO<T> {

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
    @JsonIgnore
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 图片验证码
     */
    @NotNull(message = UserResultMessage.IMAGE_CODE_IS_BLANK, groups = {RegisterGroup.class})
    @Size(min = 4, max = 4, message = UserResultMessage.IMAGE_CODE_WRONG, groups = {RegisterGroup.class})
    @JsonIgnore
    private String imageCode;

    /**
     * 手机短信验证码
     */
    @NotNull(message = UserResultMessage.SMS_CODE_IS_BLANK, groups = {RegisterGroup.class, PhoneLoginGroup.class})
    @Size(min = 4, max = 4, message = UserResultMessage.SMS_CODE_WRONG, groups = {RegisterGroup.class, PhoneLoginGroup.class})
    @JsonIgnore
    private String smsCode;

    /**
     * 最后登录时间
     */
    @JsonIgnore
    private Date lastLoginTime;

    /**
     * 状态（0、离线 1、在线）
     */
    @JsonIgnore
    private Integer status;

    /**
     * 是否启用
     */
    @JsonIgnore
    private Boolean isEnabled;


    @Override
    public T parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public Object parseFrom(T t, String... ignoreProperties) {
        return super.parseFrom(t, ignoreProperties);
    }
}
