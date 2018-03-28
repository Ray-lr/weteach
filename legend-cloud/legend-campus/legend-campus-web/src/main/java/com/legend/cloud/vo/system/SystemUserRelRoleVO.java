package com.legend.cloud.vo.system;

import com.legend.cloud.entity.system.SystemUserRelRole;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 系统用户关联系统角色
 *
 * @author hupeiD
 * @date 2018-03-28 10:17:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemUserRelRoleVO extends AbstractVO<SystemUserRelRole> {
    private static final long serialVersionUID = 1L;

    /**
     * 关联id
     */
    private Integer id;
    /**
     * 系统用户id
     */
    private Integer systemUserId;
    /**
     * 系统角色id
     */
    private Integer systemRoleId;
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
    public SystemUserRelRole parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public SystemUserRelRoleVO parseFrom(SystemUserRelRole systemUserRelRole, String... ignoreProperties) {
        return (SystemUserRelRoleVO) super.parseFrom(systemUserRelRole, ignoreProperties);
    }

    @Override
    public String toString() {
        return "SystemUserRelRoleVO{" +
                ", id=" + getId() +
                ", systemUserId=" + getSystemUserId() +
                ", systemRoleId=" + getSystemRoleId() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
