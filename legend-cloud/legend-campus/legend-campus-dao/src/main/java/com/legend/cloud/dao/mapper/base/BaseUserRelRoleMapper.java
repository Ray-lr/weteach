package com.legend.cloud.dao.mapper.base;

        import com.legend.cloud.entity.base.BaseUserRelRole;
        import com.legend.cloud.entity.base.BaseUserRelRoleExample;
        import com.legend.module.core.dao.mapper.LegendMapper;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Component;

/**
 * BaseUserRelRole的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-27 21:30:17
 */
@Mapper
@Component
public interface BaseUserRelRoleMapper extends LegendMapper<BaseUserRelRole> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(BaseUserRelRoleExample example);
}