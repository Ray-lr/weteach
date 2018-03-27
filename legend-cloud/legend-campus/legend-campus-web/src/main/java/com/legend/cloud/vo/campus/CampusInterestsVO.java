package com.legend.cloud.vo.campus;

        import com.legend.cloud.entity.campus.CampusInterests;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 兴趣标签表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusInterestsVO extends AbstractVO<CampusInterests> {
    private static final long serialVersionUID = 1L;

            /**
         * 兴趣爱好id
         */
        private Integer id;
            /**
         * 名称
         */
        private String name;
            /**
         * 描述
         */
        private String description;
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
    public CampusInterests parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusInterestsVO parseFrom(CampusInterests campusInterests, String... ignoreProperties) {
        return (CampusInterestsVO) super.parseFrom(campusInterests, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusInterestsVO{" +
                                ", id=" + getId() +
                                ", name=" + getName() +
                                ", description=" + getDescription() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
