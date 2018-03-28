package com.legend.cloud.vo.base;

import com.legend.cloud.entity.base.BaseAreas;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 地域表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseAreasVO extends AbstractVO<BaseAreas> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 地名
     */
    private String name;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * 简称
     */
    private String abbreviation;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 1、省 2、市 3、县 4、街道
     */
    private Integer typeAreas;
    /**
     * 唯一标识
     */
    private String sign;
    /**
     * 排序
     */
    private Integer sort;
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
    public BaseAreas parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseAreasVO parseFrom(BaseAreas baseAreas, String... ignoreProperties) {
        return (BaseAreasVO) super.parseFrom(baseAreas, ignoreProperties);
    }

    @Override
    public String toString() {
        return "BaseAreasVO{" +
                ", id=" + getId() +
                ", name=" + getName() +
                ", parentId=" + getParentId() +
                ", abbreviation=" + getAbbreviation() +
                ", longitude=" + getLongitude() +
                ", latitude=" + getLatitude() +
                ", typeAreas=" + getTypeAreas() +
                ", sign=" + getSign() +
                ", sort=" + getSort() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
