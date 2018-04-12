package com.legend.cloud.entity.system;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 系统权限
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "system_permission")
public class SystemPermission extends AbstractEntity<SystemPermission> {
    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 权限名称
     */
    @Column(name = "permission_name")
    private String permissionName;
    /**
     * 标识
     */
    private String sign;
    /**
     * 描述
     */
    private String description;
    /**
     * 父级id
     */
    @Column(name = "parent_id")
    private Integer parentId;
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
