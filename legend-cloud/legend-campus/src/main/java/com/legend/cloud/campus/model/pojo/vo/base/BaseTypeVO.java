package com.legend.cloud.campus.model.pojo.vo.base;

import com.legend.cloud.campus.model.pojo.entity.base.BaseType;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 基础类型
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseTypeVO extends AbstractVO<BaseType, BaseTypeVO> {
    private static final long serialVersionUID = 1L;

    /**
     * 基础类型id
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
