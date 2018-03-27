package com.legend.cloud.dao.mapper.base;

        import com.legend.cloud.entity.base.BaseAreas;
        import com.legend.cloud.entity.base.BaseAreasExample;
        import com.legend.module.core.dao.mapper.LegendMapper;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Component;

/**
 * BaseAreas的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:53
 */
@Mapper
@Component
public interface BaseAreasMapper extends LegendMapper<BaseAreas> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(BaseAreasExample example);
}