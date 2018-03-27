package com.legend.cloud.dao.mapper.base;

        import com.legend.cloud.entity.base.BaseFile;
        import com.legend.cloud.entity.base.BaseFileExample;
        import com.legend.module.core.dao.mapper.LegendMapper;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Component;

/**
 * BaseFile的mapper接口
 *
 * @author hupeiD
 * @date 2018-03-26 22:03:50
 */
@Mapper
@Component
public interface BaseFileMapper extends LegendMapper<BaseFile> {
    /**
     * 根据example筛选条件进行统计
     *
     * @param example example
     * @return count - 统计
     */
    long countByExample(BaseFileExample example);
}