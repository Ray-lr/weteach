package com.legend.cloud.entity.base;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 地域表
 *
 * @author hupeiD
 * @date 2018-03-26 22:19:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_areas")
public class BaseAreas extends AbstractEntity<BaseAreas> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
