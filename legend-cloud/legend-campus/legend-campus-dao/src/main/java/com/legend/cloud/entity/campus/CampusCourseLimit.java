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
 * 课程限制
 *
 * @author Jim
 * @date 2018-04-06 11:13:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "campus_course_limit")
public class CampusCourseLimit extends AbstractEntity<CampusCourseLimit> {
	private static final long serialVersionUID = 1L;

	/**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	/**
     * 课程id
     */
    private Integer courseId;
	/**
     * 系别限制
     */
    private Integer dept;
	/**
     * 专业限制
     */
    private Integer major;
	/**
     * 性别限制
     */
    private Integer sex;
	/**
     * 年级限制
     */
    private Integer grade;
	/**
     * 人数上限
     */
    private Integer personUpper;
    /**
     * 人数下限
     */
    private Integer personLower;
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
