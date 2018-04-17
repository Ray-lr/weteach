package com.legend.cloud.vo.campus;

import com.legend.cloud.entity.campus.CampusCourse;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
public class CampusCourseVO extends AbstractVO<CampusCourse> {
    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
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
     * 系别id
     */
    private Integer dept;
    /**
     * 系别的name
     */
    private String dept_string;
    /**
     * 专业id
     */
    private Integer major;
    /**
     * 专业的name
     */
    private String major_string;
    /**
     * 课程id
     */
    private Integer course;
    /**
     * 课程的name
     */
    private String course_string;
    /**
     * 课时节数
     */
    private Integer lessonNum;
    /**
     * 支付积分（求学悬赏）
     */
    private Integer payCredits;
    /**
     * 得到积分（教学收取）
     */
    private Integer getCredits;
    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;
    /**
     * 报名截止日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date applyEndTime;
    /**
     * 开课时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginTime;
    /**
     * 结课时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    /**
     * 完成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

    @Override
    public CampusCourse parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusCourseVO parseFrom(CampusCourse campusCourse, String... ignoreProperties) {
        return (CampusCourseVO) super.parseFrom(campusCourse, ignoreProperties);
    }

}
