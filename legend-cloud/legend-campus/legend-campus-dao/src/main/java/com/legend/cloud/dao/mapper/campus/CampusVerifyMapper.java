package com.legend.cloud.dao.mapper.campus;

        import com.legend.cloud.entity.campus.CampusVerify;
        import com.legend.cloud.entity.campus.CampusVerifyExample;
        import com.legend.module.core.dao.mapper.LegendMapper;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Component;

/**
 * CampusVerify的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:51
 */
@Mapper
@Component
public interface CampusVerifyMapper extends LegendMapper<CampusVerify> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(CampusVerifyExample example);
}