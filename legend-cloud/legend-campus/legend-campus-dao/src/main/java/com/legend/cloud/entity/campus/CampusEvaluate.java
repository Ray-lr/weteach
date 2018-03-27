package com.legend.cloud.entity.campus;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;



/**
 * 评价
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "campus_evaluate")
public class CampusEvaluate extends AbstractEntity<CampusEvaluate> {
	private static final long serialVersionUID = 1L;

	/**
     * 评价记录id
     */
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        	private Integer id;
	/**
     * 用户id
     */
        	private Integer userId;
	/**
     * 课程id
     */
        	private Integer courseId;
	/**
     * 评价星级
     */
        	private String evaluateStar;
	/**
     * 详细评价
     */
        	private String detail;
	/**
     * 追加评价
     */
        	private String superaddition;
	/**
     * 状态（0，主动评价；1，被动评价；2，已追评）
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
