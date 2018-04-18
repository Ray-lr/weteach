package com.legend.cloud.campus.model.pojo.entity.base;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 地域表
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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
    @Column(name = "parent_id")
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
    @Column(name = "type_areas")
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
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
