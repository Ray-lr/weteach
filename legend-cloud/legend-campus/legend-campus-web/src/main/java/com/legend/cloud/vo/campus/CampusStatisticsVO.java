package com.legend.cloud.vo.campus;

        import com.legend.cloud.entity.campus.CampusStatistics;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;


/**
 * 统计
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusStatisticsVO extends AbstractVO<CampusStatistics> {
    private static final long serialVersionUID = 1L;

            /**
         * 
         */
        private Integer id;
            /**
         * 描述
         */
        private String description;
            /**
         * 备注
         */
        private String remark;
            /**
         * 具体数据
         */
        private Integer data;
            /**
         * 概率数据
         */
        private Double probability;
            /**
         * 编号
         */
        private String code;
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
    public CampusStatistics parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusStatisticsVO parseFrom(CampusStatistics campusStatistics, String... ignoreProperties) {
        return (CampusStatisticsVO) super.parseFrom(campusStatistics, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusStatisticsVO{" +
                                ", id=" + getId() +
                                ", description=" + getDescription() +
                                ", remark=" + getRemark() +
                                ", data=" + getData() +
                                ", probability=" + getProbability() +
                                ", code=" + getCode() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
