package com.legend.cloud.vo.system;

import com.legend.cloud.entity.system.SystemRole;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 系统角色
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemRoleVO extends AbstractVO<SystemRole> {
    private static final long serialVersionUID = 1L;

    /**
     * 系统角色id
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 标识
     */
    private String sign;
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
    public SystemRole parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public SystemRoleVO parseFrom(SystemRole systemRole, String... ignoreProperties) {
        return (SystemRoleVO) super.parseFrom(systemRole, ignoreProperties);
    }

    @Override
    public String toString() {
        return "SystemRoleVO{" +
                ", id=" + getId() +
                ", roleName=" + getRoleName() +
                ", sign=" + getSign() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
