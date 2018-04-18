package com.legend.cloud.campus.model.pojo.vo.system;

import com.legend.cloud.campus.model.pojo.entity.system.SystemRoleRelPermission;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 系统角色关联系统权限
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class SystemRoleRelPermissionVO extends AbstractVO<SystemRoleRelPermission> {
    private static final long serialVersionUID = 1L;

    /**
     * 关联id
     */
    private Integer id;
    /**
     * 系统角色id
     */
    private Integer roleId;
    /**
     * 系统权限id
     */
    private Integer permissionId;
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
    public SystemRoleRelPermissionVO parseFrom(SystemRoleRelPermission systemRoleRelPermission, String... ignoreProperties) {
        return (SystemRoleRelPermissionVO) super.parseFrom(systemRoleRelPermission, ignoreProperties);
    }

}
