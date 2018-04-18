package com.legend.module.core.dao.mapper.external;


import com.legend.module.core.model.provider.SelectGroupProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/2/15
 */
public interface SelectGroupMapper<T> {
    /**
     * 分组查询
     *
     * @param var1 name
     * @param var2 example
     * @return list t
     */
    @SelectProvider(
            type = SelectGroupProvider.class,
            method = "dynamicSQL"
    )
    List<? extends T> selectGroupByName(@Param("name") String var1, @Param("example") Object var2);
}
