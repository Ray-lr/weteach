package com.legend.cloud.campus.model.pojo.vo.campus;

import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseLesson;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 课时
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusCourseLessonVO extends AbstractVO<CampusCourseLesson, CampusCourseLessonVO> {
    private static final long serialVersionUID = 1L;

    /**
     * 课时id
     */
    private Integer id;
    /**
     * 课程id
     */
    private Integer courseId;
    /**
     * 上课时间
     */
    private Date beginTime;
    /**
     * 下课时间
     */
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
