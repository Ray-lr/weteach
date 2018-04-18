package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 院系-专业-课程分类
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "campus_course_category")
public class CampusCourseCategory extends AbstractEntity<CampusCourseCategory> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父级id
     */
    @Column(name = "parent_id")
    private Integer parentId;
    /**
     * 简称
     */
    private String abbreviation;
    /**
     * 相关描述
     */
    private String description;
    /**
     * 类型（1，院系；2，专业；3，课程）
     */
    @Column(name = "type_course_category")
    private Integer typeCourseCategory;
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
