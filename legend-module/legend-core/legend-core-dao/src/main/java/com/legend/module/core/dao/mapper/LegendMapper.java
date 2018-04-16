package com.legend.module.core.dao.mapper;

import com.legend.module.core.dao.mapper.external.SelectGroupMapper;
import com.legend.module.core.dao.mapper.external.UpdateDeletedMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Administrator
 * @date 2018/1/12
 */
public interface LegendMapper<T> extends Mapper<T>,
        MySqlMapper<T>,
        IdsMapper<T>,
        UpdateDeletedMapper<T>,
        SelectGroupMapper<T> {
}