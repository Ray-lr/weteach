package com.legend.module.core.dao.provider;


import com.legend.module.core.model.annotation.FieldIsDeleted;
import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityField;
import tk.mybatis.mapper.mapperhelper.FieldHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/2/15
 */
public class UpdateDeletedProvider extends MapperTemplate {
    public UpdateDeletedProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String updateDeletedById(MappedStatement ms) {
        Class<?> entityClass = this.getEntityClass(ms);
        List<EntityField> fields = FieldHelper.getFields(entityClass);
        String isDeleted = "is_deleted";

        for (Object field : fields) {
            EntityField entityField = (EntityField) field;
            if (entityField.isAnnotationPresent(FieldIsDeleted.class) && Boolean.class.equals(entityField
                    .getJavaType())) {
                isDeleted = entityField.getName();
            }
        }

        return SqlHelper.updateTable(entityClass, this.tableName(entityClass)) +
                "<set>" +
                isDeleted + " = " + "1" +
                "</set>" +
                SqlHelper.wherePKColumns(entityClass);
    }
}
