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
 * 课时
 *
 * @author hupeiD
 * @date 2018-03-28 10:33:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "campus_course_lesson")
public class CampusCourseLesson extends AbstractEntity<CampusCourseLesson> {
	private static final long serialVersionUID = 1L;

	/**
	 * 课时id
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 课程id
     */
	private Integer courseId;
	/**
	 * 上课时间
     */
	private Date beginTime;
	/**
	 * 下课时间
     */
	private Date endTime;
	/**
	 * 地点
     */
	private String location;
	/**
	 * 状态（0、课时未开始 1、课时结束 2、课时进行中
     */
	private Integer status;
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
