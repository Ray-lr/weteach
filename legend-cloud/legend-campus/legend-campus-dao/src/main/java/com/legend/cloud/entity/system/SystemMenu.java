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
 * 菜单表
 *
 * @author hupeiD
 * @date 2018-03-28 10:33:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "system_menu")
public class SystemMenu extends AbstractEntity<SystemMenu> {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 菜单名称
     */
	private String name;
	/**
	 * url
     */
	private String url;
	/**
	 * 描述
     */
	private String description;
	/**
	 * 菜单等级
     */
	private Integer hierarchy;
	/**
	 * 父级id
     */
	private Integer parentId;
	/**
	 * 排序
     */
	private Integer sort;
	/**
	 * 额外添加的类
     */
	private String className;
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
