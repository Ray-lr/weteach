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
 * 教师表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
    private Integer userId;
    /**
     * 认证资格数量
     */
    private Integer verifyNum;
    /**
     *
     */
    private Boolean isEnabled;
    /**
     * 课程参与量
     */
    private Integer orderJoin;
    /**
     * 课程发布量
     */
    private Integer orderPublish;
    /**
     * 课程完成量
     */
    private Integer orderFinish;
    /**
     * 教学完成率
     */
    private Double percentageComplete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

}
