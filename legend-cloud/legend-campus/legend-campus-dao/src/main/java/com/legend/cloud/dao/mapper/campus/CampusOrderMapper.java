package com.legend.cloud.dao.mapper.campus;

        import com.legend.cloud.entity.campus.CampusOrder;
        import com.legend.cloud.entity.campus.CampusOrderExample;
        import com.legend.module.core.dao.mapper.LegendMapper;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Component;

/**
 * CampusOrder的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:52
 */
@Mapper
@Component
public interface CampusOrderMapper extends LegendMapper<CampusOrder> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusOrderExample example);
}