package com.legend.cloud.vo.base;

import com.legend.cloud.entity.base.BaseUser;
import com.legend.module.core.vo.AbstractVO;
import com.legend.module.core.vo.core.UserVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 用户
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseUserVO extends UserVO<BaseUser> {
    private static final long serialVersionUID = 1L;

    /**
     * id
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
    public BaseUser parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseUserVO parseFrom(BaseUser baseUser, String... ignoreProperties) {
        return (BaseUserVO) super.parseFrom(baseUser, ignoreProperties);
    }

    @Override
    public String toString() {
        return "BaseUserVO{" +
                ", id=" + getId() +
                ", username=" + getUsername() +
                ", password=" + getPassword() +
                ", phone=" + getPhone() +
                ", nickName=" + getNickName() +
                ", isEnabled=" + getIsEnabled() +
                ", status=" + getStatus() +
                ", lastLoginTime=" + getLastLoginTime() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
