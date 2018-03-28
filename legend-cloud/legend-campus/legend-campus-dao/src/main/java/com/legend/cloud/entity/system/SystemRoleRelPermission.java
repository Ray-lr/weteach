package com.legend.cloud.entity.system;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 系统角色关联系统权限
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "system_role_rel_permission")
public class SystemRoleRelPermission extends AbstractEntity<SystemRoleRelPermission> {
    private static final long serialVersionUID = 1L;

    /**
     * 关联id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
