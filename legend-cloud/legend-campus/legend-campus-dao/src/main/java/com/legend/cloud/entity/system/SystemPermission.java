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
 * 系统权限
 *
 * @author hupeiD
 * @date 2018-03-27 21:30:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
