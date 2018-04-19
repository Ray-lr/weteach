package com.legend.cloud.campus.model.pojo.vo.base;

import com.legend.cloud.campus.model.pojo.entity.base.BaseAreas;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 地域表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BaseAreasVO extends AbstractVO<BaseAreas, BaseAreasVO> {
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

}
