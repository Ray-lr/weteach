package com.legend.cloud.vo.system;

import com.legend.cloud.entity.system.SystemUser;
import com.legend.module.core.vo.core.UserVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 系统用户
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemUserVO extends UserVO<SystemUser> {
    private static final long serialVersionUID = 1L;

    /**
     * 系统用户id
     */
    private Integer id;
    /**
     * 记住我
     */
    private boolean rememberMe;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

    @Override
    public SystemUser parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public SystemUserVO parseFrom(SystemUser systemUser, String... ignoreProperties) {
        return (SystemUserVO) super.parseFrom(systemUser, ignoreProperties);
    }

    @Override
    public String toString() {
        return "SystemUserVO{" +
                ", id=" + getId() +
                ", username=" + getUsername() +
                ", password=" + getPassword() +
                ", phone=" + getPhone() +
                ", nickName=" + getNickName() +
                ", lastLoginTime=" + getLastLoginTime() +
                ", isEnabled=" + getIsEnabled() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
