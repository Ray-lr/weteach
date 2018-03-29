package com.legend.cloud.entity.campus;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;



/**
 * 院系专业表
 *
 * @author hupeiD
 * @date 2018-03-29 20:08:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "campus_major")
public class CampusMajor extends AbstractEntity<CampusMajor> {
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        	private Integer id;
	/**
     * 名称
     */
        	private String name;
	/**
     * 系别id
     */
        	private Integer deptId;
	/**
     * 简称
     */
        	private String abbreviation;
	/**
     * 类型（1，院系；2，专业）
     */
        	private Integer typeMajor;
	/**
     * 创建时间
     */
        	private Date createTime;
	/**
     * 修改时间
     */
        	private Date updateTime;
	/**
     * 是否删除
     */
        	private Boolean isDeleted;

}
