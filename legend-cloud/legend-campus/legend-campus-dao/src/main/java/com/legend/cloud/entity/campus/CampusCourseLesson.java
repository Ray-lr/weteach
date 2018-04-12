package com.legend.cloud.entity.campus;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 课时
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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
    @Column(name = "course_id")
    private Integer courseId;
    /**
     * 上课时间
     */
    @Column(name = "begin_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    /**
     * 下课时间
     */
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
