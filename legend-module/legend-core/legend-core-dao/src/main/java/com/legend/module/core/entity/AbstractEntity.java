package com.legend.module.core.entity;


import com.legend.module.core.model.pojo.AbstractPojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Administrator
 * @date 2018/1/9
 */
public abstract class AbstractEntity<T extends AbstractEntity> extends AbstractPojo<T> {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
