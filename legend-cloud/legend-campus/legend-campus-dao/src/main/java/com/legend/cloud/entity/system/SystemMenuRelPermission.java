package com.legend.cloud.entity.system;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 系统菜单权限关联表
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "system_menu_rel_permission")
public class SystemMenuRelPermission extends AbstractEntity<SystemMenuRelPermission> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 系统菜单表
     */
    @Column(name = "system_menu_id")
    private Integer systemMenuId;
    /**
     * 系统权限表
     */
    @Column(name = "system_permission_id")
    private Integer systemPermissionId;
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
