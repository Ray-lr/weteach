package com.legend.cloud.vo.campus;

        import com.legend.cloud.entity.campus.CampusCourse;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 课程
 *
 * @author hupeiD
 * @date 2018-03-27 16:48:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
    
    @Override
    public CampusCourse parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusCourseVO parseFrom(CampusCourse campusCourse, String... ignoreProperties) {
        return (CampusCourseVO) super.parseFrom(campusCourse, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusCourseVO{" +
                                ", id=" + getId() +
                                ", userId=" + getUserId() +
                                ", title=" + getTitle() +
                                ", description=" + getDescription() +
                                ", remark=" + getRemark() +
                                ", dept=" + getDept() +
                                ", major=" + getMajor() +
                                ", course=" + getCourse() +
                                ", publishTime=" + getPublishTime() +
                                ", finishTime=" + getFinishTime() +
                                ", personUpper=" + getPersonUpper() +
                                ", personLower=" + getPersonLower() +
                                ", personNum=" + getPersonNum() +
                                ", typeCourse=" + getTypeCourse() +
                                ", status=" + getStatus() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
