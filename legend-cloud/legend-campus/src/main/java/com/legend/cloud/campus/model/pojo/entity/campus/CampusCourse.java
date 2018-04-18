package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 课程
 *
 * @author hupeiD
 * @date 2018-04-12 14:41:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "campus_course")
public class CampusCourse extends AbstractEntity<CampusCourse> {
    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 备注
     */
    private String remark;
    /**
     * 系别
     */
    private Integer dept;
    /**
     * 专业
     */
    private Integer major;
    /**
     * 课程
     */
    private Integer course;
    /**
     * 课时节数
     */
    @Column(name = "lesson_num")
    private Integer lessonNum;
    /**
     * 支付积分（求学悬赏）
     */
    @Column(name = "pay_credits")
    private Integer payCredits;
    /**
     * 得到积分（教学收取）
     */
    @Column(name = "get_credits")
    private Integer getCredits;
    /**
     * 发布时间
     */
    @Column(name = "publish_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;
    /**
     * 报名截止日期
     */
    @Column(name = "apply_end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyEndTime;
    /**
     * 开课时间
     */
    @Column(name = "begin_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    /**
     * 结课时间
     */
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;
    /**
     * 参与课程人数
     */
    @Column(name = "person_num")
    private Integer personNum;
    /**
     * 课程类型（求学或教学）
     */
    @Column(name = "type_course")
    private String typeCourse;
    /**
     * 状态（0、未审核 1、审核驳回 2、审核通过 3、报名中 4、等待开课  5、开课中 6、结课 7、已完成 8、已取消）
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
