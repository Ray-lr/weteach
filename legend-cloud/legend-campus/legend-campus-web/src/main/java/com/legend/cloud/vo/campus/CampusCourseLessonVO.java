package com.legend.cloud.vo.campus;

import com.legend.cloud.entity.campus.CampusCourseLesson;
import com.legend.module.core.vo.AbstractVO;
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
public class CampusCourseLessonVO extends AbstractVO<CampusCourseLesson> {
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

    @Override
    public CampusCourseLesson parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusCourseLessonVO parseFrom(CampusCourseLesson campusCourseLesson, String... ignoreProperties) {
        return (CampusCourseLessonVO) super.parseFrom(campusCourseLesson, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusCourseLessonVO{" +
                ", id=" + getId() +
                ", courseId=" + getCourseId() +
                ", beginTime=" + getBeginTime() +
                ", endTime=" + getEndTime() +
                ", location=" + getLocation() +
                ", status=" + getStatus() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
