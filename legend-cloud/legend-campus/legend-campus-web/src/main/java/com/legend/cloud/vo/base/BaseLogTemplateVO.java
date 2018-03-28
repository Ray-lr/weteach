package com.legend.cloud.vo.base;

import com.legend.cloud.entity.base.BaseLogTemplate;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 日志模板表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseLogTemplateVO extends AbstractVO<BaseLogTemplate> {
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

    @Override
    public BaseLogTemplate parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseLogTemplateVO parseFrom(BaseLogTemplate baseLogTemplate, String... ignoreProperties) {
        return (BaseLogTemplateVO) super.parseFrom(baseLogTemplate, ignoreProperties);
    }

    @Override
    public String toString() {
        return "BaseLogTemplateVO{" +
                ", id=" + getId() +
                ", template=" + getTemplate() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
