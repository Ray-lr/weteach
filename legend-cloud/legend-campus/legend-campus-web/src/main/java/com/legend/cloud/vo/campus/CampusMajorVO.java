package com.legend.cloud.vo.campus;

        import com.legend.cloud.entity.campus.CampusMajor;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 院系专业表
 *
 * @author hupeiD
 * @date 2018-03-29 20:08:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusMajorVO extends AbstractVO<CampusMajor> {
    private static final long serialVersionUID = 1L;

            /**
         * 
         */
        private Integer id;
            /**
         * 名称
         */
        private String name;
            /**
         * 系别id
         */
        private Integer deptId;
            /**
         * 简称
         */
        private String abbreviation;
            /**
         * 类型（1，院系；2，专业）
         */
        private Integer typeMajor;
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
    
    @Override
    public CampusMajor parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusMajorVO parseFrom(CampusMajor campusMajor, String... ignoreProperties) {
        return (CampusMajorVO) super.parseFrom(campusMajor, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusMajorVO{" +
                                ", id=" + getId() +
                                ", name=" + getName() +
                                ", deptId=" + getDeptId() +
                                ", abbreviation=" + getAbbreviation() +
                                ", typeMajor=" + getTypeMajor() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
