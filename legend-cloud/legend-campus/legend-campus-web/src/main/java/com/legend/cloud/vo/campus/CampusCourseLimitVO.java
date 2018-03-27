package com.legend.cloud.vo.campus;

        import com.legend.cloud.entity.campus.CampusCourseLimit;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 课程限制
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusCourseLimitVO extends AbstractVO<CampusCourseLimit> {
    private static final long serialVersionUID = 1L;

            /**
         * 
         */
        private Integer id;
            /**
         * 课程id
         */
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
    public CampusCourseLimit parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusCourseLimitVO parseFrom(CampusCourseLimit campusCourseLimit, String... ignoreProperties) {
        return (CampusCourseLimitVO) super.parseFrom(campusCourseLimit, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusCourseLimitVO{" +
                                ", id=" + getId() +
                                ", courseId=" + getCourseId() +
                                ", dept=" + getDept() +
                                ", major=" + getMajor() +
                                ", sex=" + getSex() +
                                ", grade=" + getGrade() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
