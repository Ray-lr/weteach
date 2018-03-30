package com.legend.cloud.vo.system;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.legend.cloud.entity.system.SystemUser;
import com.legend.module.core.vo.core.UserVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 系统用户
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@JsonAutoDetect
public class SystemUserVO extends UserVO<SystemUser> {
    @JsonIgnore
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 记住我
     */
    private boolean rememberMe;
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
    /**
     * 创建时间
     */
    @JsonIgnore
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonIgnore
    private Date updateTime;
    /**
     * 是否删除
     */
    @JsonIgnore
    private Boolean isDeleted;
    @Override
    public SystemUser parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public SystemUserVO parseFrom(SystemUser systemUser, String... ignoreProperties) {
        return (SystemUserVO) super.parseFrom(systemUser, ignoreProperties);
    }
}
