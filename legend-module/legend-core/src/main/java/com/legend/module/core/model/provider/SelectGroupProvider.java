package com.legend.module.core.model.provider;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

/**
 * @author Administrator
 * @date 2018/2/15
 */
public class SelectGroupProvider extends MapperTemplate {
    private MapperHelper mapperHelper;

    public SelectGroupProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
        this.mapperHelper = mapperHelper;
    }

    private static String exampleOrderBy(Class<?> entityClass) {
        StringBuilder sql = new StringBuilder();
        sql.append("<if test=\"example.orderByClause != null\">");
        sql.append("order by ${example.orderByClause}");
        sql.append("</if>");
        String orderByClause = EntityHelper.getOrderByClause(entityClass);
        if (orderByClause.length() > 0) {
            sql.append("<if test=\"example.orderByClause == null\">");
            sql.append("ORDER BY ").append(orderByClause);
            sql.append("</if>");
        }

        return sql.toString();
    }

    public String selectGroupByName(MappedStatement ms) {
        Class<?> entityClass = this.getEntityClass(ms);
        Class entityGroupClass;

        try {
            entityGroupClass = Class.forName(entityClass.getName().replace("entity", "go") + "Go");
            EntityHelper.initEntityNameMap(entityGroupClass, this.mapperHelper.getConfig());
        } catch (ClassNotFoundException var5) {
            entityGroupClass = entityClass;
        }

        this.setResultType(ms, entityGroupClass);
        return SqlHelper.selectAllColumns(entityClass) +
                " ,count(*) group_count " +
                SqlHelper.fromTable(entityClass, this.tableName(entityClass)) +
                SqlHelper.updateByExampleWhereClause() +
                " group by ${name} " +
                exampleOrderBy(entityClass);
    }
}
