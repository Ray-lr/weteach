package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 课程订单
 *
 * @author hupeiD
 * @date 2018-04-18 21:56:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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
    @Column(name = "base_order_id")
    private Integer baseOrderId;
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 课程id
     */
    @Column(name = "course_id")
    private Integer courseId;
    /**
     * 积分
     */
    private Integer credits;
    /**
     * 订单类型(参与或发起)
     */
    @Column(name = "type_course")
    private String typeCourse;
    /**
     * 是否该课程发起人
     */
    @Column(name = "is_host")
    private Boolean isHost;
    /**
     * 状态{0、已创建 1、已完成 2、已取消）
     */
    private Integer status;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
