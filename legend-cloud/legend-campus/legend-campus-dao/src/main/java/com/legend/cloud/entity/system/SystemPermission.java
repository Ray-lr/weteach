package com.legend.cloud.entity.system;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;



/**
 * 系统权限
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
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
     * 资源
     */
        	private String url;
	/**
     * 父级权限id
     */
        	private Integer parentId;
	/**
     * 排序
     */
        	private Integer sort;
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
