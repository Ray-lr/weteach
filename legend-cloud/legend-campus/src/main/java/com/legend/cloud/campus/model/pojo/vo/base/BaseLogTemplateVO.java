package com.legend.cloud.campus.model.pojo.vo.base;

import com.legend.cloud.campus.model.pojo.entity.base.BaseLogTemplate;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 日志模板表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BaseLogTemplateVO extends AbstractVO<BaseLogTemplate, BaseLogTemplateVO> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 模板内容
     */
    private String template;
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
