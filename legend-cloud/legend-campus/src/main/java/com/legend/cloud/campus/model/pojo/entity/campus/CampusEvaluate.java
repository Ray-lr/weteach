package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 评价
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 课程id
     */
    @Column(name = "course_id")
    private Integer courseId;
    /**
     * 评价星级
     */
    @Column(name = "evaluate_star")
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
