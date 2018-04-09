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
 * 课程订单
 *
 * @author Jim
 * @date 2018-04-09 22:11:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "campus_order")
public class CampusOrder extends AbstractEntity<CampusOrder> {
	private static final long serialVersionUID = 1L;

	/**
     * 课程订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	/**
     * 基础订单id
     */
    private Integer baseOrderId;
	/**
     * 用户id
     */
    private Integer userId;
	/**
     * 课程id
     */
    private Integer courseId;
	/**
     * 积分
     */
    private Integer credits;
	/**
     * 订单类型(求学或教学)
     */
    private String typeCourse;
	/**
     * 是否该课程发起人
     */
    private Boolean isHost;
    /**
     * 状态{0、已创建 1、已完成 2、已取消）
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
