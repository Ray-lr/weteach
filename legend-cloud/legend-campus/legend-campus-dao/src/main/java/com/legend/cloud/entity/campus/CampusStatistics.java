package com.legend.cloud.entity.campus;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;



/**
 * 统计
 *
 * @author hupeiD
 * @date 2018-03-28 10:33:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "campus_statistics")
public class CampusStatistics extends AbstractEntity<CampusStatistics> {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 描述
     */
	private String description;
	/**
	 * 备注
     */
	private String remark;
	/**
	 * 具体数据
     */
	private Integer data;
	/**
	 * 概率数据
     */
	private Double probability;
	/**
	 * 编号
     */
	private String code;
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
