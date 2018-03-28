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
 * 课程
 *
 * @author hupeiD
 * @date 2018-03-27 16:48:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
     * 发布时间
     */
    private Date publishTime;
    /**
     * 完成时间
     */
    private Date finishTime;
    /**
     * 人数上限
     */
    private Integer personUpper;
    /**
     * 人数下限
     */
    private Integer personLower;
    /**
     * 参与课程人数
     */
    private Integer personNum;
    /**
     * 课程类型（求学或教学）
     */
    private String typeCourse;
    /**
     * 状态（0、未审核 1、审核驳回 2、审核通过 3、报名中 4、等待开课  5、开课中 6、结课 7、已完成 8、已取消）
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
