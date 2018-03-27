package com.legend.module.core.vo;

import com.legend.module.core.entity.AbstractEntity;
import com.legend.module.core.model.pojo.AbstractPojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractVO<T extends AbstractEntity> extends AbstractPojo<T> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @NotNull
    private Integer id;

    /**
     * 创建时间
     */
    @NotNull
    private Date createTime;

    /**
     * 更新时间
     */
    @NotNull
    private Date updateTime;

    /**
     * 是否删除
     */
    @NotNull
    private Boolean isDeleted;


    /**
     * 将VO赋值到Entity
     *
     * @param ignoreProperties 忽略的字段
     * @return t
     */
    protected T parseTo(String... ignoreProperties) {
        T t = getT();
        BeanUtils.copyProperties(this, t, ignoreProperties);
        return t;
    }

    /**
     * 将Entity赋值到this
     *
     * @param t                Entity
     * @param ignoreProperties 忽略的字段
     * @return this
     */
    protected Object parseFrom(T t, String... ignoreProperties) {
        BeanUtils.copyProperties(t, this, ignoreProperties);
        return this;
    }

    @Override
    public String toString() {
        return null;
    }
}
