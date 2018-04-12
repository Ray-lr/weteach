package com.legend.cloud.entity.campus;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 教师表
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "campus_teacher")
public class CampusTeacher extends AbstractEntity<CampusTeacher> {
    private static final long serialVersionUID = 1L;

    /**
     * 教师id
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
     * 认证资格数量
     */
    @Column(name = "verify_num")
    private Integer verifyNum;
    /**
     *
     */
    @Column(name = "is_enabled")
    private Boolean isEnabled;
    /**
     * 课程参与量
     */
    @Column(name = "order_join")
    private Integer orderJoin;
    /**
     * 课程发布量
     */
    @Column(name = "order_publish")
    private Integer orderPublish;
    /**
     * 课程完成量
     */
    @Column(name = "order_finish")
    private Integer orderFinish;
    /**
     * 教学完成率
     */
    @Column(name = "percentage_complete")
    private Double percentageComplete;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
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
