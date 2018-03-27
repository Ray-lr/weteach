package com.legend.cloud.entity.campus;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;



/**
 * 兴趣标签表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "campus_interests")
public class CampusInterests extends AbstractEntity<CampusInterests> {
	private static final long serialVersionUID = 1L;

	/**
     * 兴趣爱好id
     */
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        	private Integer id;
	/**
     * 名称
     */
        	private String name;
	/**
     * 描述
     */
        	private String description;
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
