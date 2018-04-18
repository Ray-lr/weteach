package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 课程限制
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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
    @Column(name = "course_id")
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
    @Column(name = "person_upper")
    private Integer personUpper;
    /**
     * 人数下限
     */
    @Column(name = "person_lower")
    private Integer personLower;
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
