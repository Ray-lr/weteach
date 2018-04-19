package com.legend.module.core.model.pojo.vo;

import com.legend.module.core.model.pojo.AbstractPojo;
import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractVO<T extends AbstractEntity, TVO extends AbstractVO> extends AbstractPojo<T> {
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
    public TVO parseFrom(T t, String... ignoreProperties) {
        BeanUtils.copyProperties(t, this, ignoreProperties);
        return (TVO) this;
    }

    /**
     * 将Entity集合赋值到VO集合中
     *
     * @param tList            集合Entity
     * @param ignoreProperties 忽略的字段
     * @return VO集合
     */
    @SuppressWarnings("unchecked")
    public List<TVO> parseFrom(List<T> tList, String... ignoreProperties) {
        return tList.stream().map(t -> {
            try {
                Object object = this.getClass().newInstance();
                BeanUtils.copyProperties(t, object, ignoreProperties);
                return (TVO) object;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

}
