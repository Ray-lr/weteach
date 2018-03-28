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
 * 基础类型
 *
 * @author hupeiD
 * @date 2018-03-28 10:33:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_type")
public class BaseType extends AbstractEntity<BaseType> {
    private static final long serialVersionUID = 1L;

    /**
     * 基础类型id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 唯一标识
     */
    private String sign;
    /**
     * 数值
     */
    private String parameter;
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
