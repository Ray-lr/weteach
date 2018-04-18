package com.legend.cloud.campus.model.pojo.entity.system;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 系统角色关联系统权限
 *
 * @author hupeiD
 * @date 2018-04-18 21:56:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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
    @Column(name = "role_id")
    private Integer roleId;
    /**
     * 系统权限id
     */
    @Column(name = "permission_id")
    private Integer permissionId;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
