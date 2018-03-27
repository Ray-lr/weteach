package com.legend.cloud.dao.mapper.campus;

        import com.legend.cloud.entity.campus.CampusCourse;
        import com.legend.cloud.entity.campus.CampusCourseExample;
        import com.legend.module.core.dao.mapper.LegendMapper;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Component;

/**
 * CampusCourse的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-27 16:48:28
 */
@Mapper
@Component
public interface CampusCourseMapper extends LegendMapper<CampusCourse> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusCourseExample example);
}