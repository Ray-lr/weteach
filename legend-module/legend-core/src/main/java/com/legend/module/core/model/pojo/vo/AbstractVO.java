package com.legend.module.core.model.pojo.vo;

import com.legend.module.core.model.pojo.AbstractPojo;
import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

/**
 * @author Administrator
 * @date 2018/3/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractVO<T extends AbstractEntity> extends AbstractPojo<T> {
    private static final long serialVersionUID = 1L;

    /**
     * 将VO赋值到Entity
     *
     * @param ignoreProperties 忽略的字段
     * @return t
     */
    public T parseTo(String... ignoreProperties) {
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
    @SuppressWarnings("unchecked")
    protected <TVO extends AbstractVO> TVO parseFrom(T t, String... ignoreProperties) {
        BeanUtils.copyProperties(t, this, ignoreProperties);
        return (TVO) this;
    }

    @Override
    public String toString() {
        return null;
    }
}
