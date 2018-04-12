package com.legend.cloud.vo.campus;

import com.legend.cloud.entity.campus.CampusCourse;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;


/**
 * 课程
 *
 * @author Jim
 * @date 2018-04-10 13:47:00
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
    @NotNull
    private String title;
    /**
     * 描述
     */
    @NotNull
    private String description;
    /**
     * 备注
     */
    private String remark;
    /**
     * 系别
     */
    @NotNull
    private Integer dept;
    /**
     * 专业
     */
    @NotNull
    private Integer major;
    /**
     * 课程
     */
    @NotNull
    private Integer course;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @NotNull
    private Date publishTime;
    /**
     * 完成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @NotNull
    private Date finishTime;
    /**
     * 参与课程人数
     */
    private Integer personNum;
    /**
     * 该课程是否有课程限制
     */
    @Null
    private Boolean hasLimit;
    /**
     * 课程类型（求学或教学）
     */
    @NotNull
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

    @Override
    public CampusCourse parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusCourseVO parseFrom(CampusCourse campusCourse, String... ignoreProperties) {
        return (CampusCourseVO) super.parseFrom(campusCourse, ignoreProperties);
    }

}
