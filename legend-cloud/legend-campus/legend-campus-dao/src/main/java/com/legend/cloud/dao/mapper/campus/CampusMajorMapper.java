package com.legend.cloud.dao.mapper.campus;

        import com.legend.cloud.entity.campus.CampusMajor;
        import com.legend.cloud.entity.campus.CampusMajorExample;
        import com.legend.module.core.dao.mapper.LegendMapper;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Component;

/**
 * CampusMajor的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-29 20:08:43
 */
@Mapper
@Component
public interface CampusMajorMapper extends LegendMapper<CampusMajor> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusMajorExample example);
}