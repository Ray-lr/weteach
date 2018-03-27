package com.legend.cloud.service.base.impl;

        import com.legend.cloud.dao.mapper.base.BaseTypeMapper;
        import com.legend.cloud.entity.base.BaseType;
        import com.legend.cloud.entity.base.BaseTypeExample;
        import com.legend.cloud.service.base.BaseTypeService;
        import com.legend.module.core.service.core.impl.AbstractLegendService;
        import org.apache.commons.lang.StringUtils;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import tk.mybatis.mapper.common.Mapper;

        import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2018/3/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BaseTypeServiceImpl extends AbstractLegendService<BaseType> implements BaseTypeService {

    @Resource
    private BaseTypeMapper baseTypeMapper;

    @Override
    public Mapper<BaseType> getMapper() {
        return baseTypeMapper;
    }

    @Override
    protected Object getExample(BaseType baseType, String order, String sort) {
            BaseTypeExample example = new BaseTypeExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
            BaseTypeExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (baseType ==null){
            return example;
        }

                    if (baseType.getId() != null){
            criteria.andIdEqualTo(baseType.getId());
        }
                    if (baseType.getName() != null){
            criteria.andNameEqualTo(baseType.getName());
        }
                    if (baseType.getDescription() != null){
            criteria.andDescriptionEqualTo(baseType.getDescription());
        }
                    if (baseType.getSign() != null){
            criteria.andSignEqualTo(baseType.getSign());
        }
                    if (baseType.getParameter() != null){
            criteria.andParameterEqualTo(baseType.getParameter());
        }
                    if (baseType.getCreateTime() != null){
            criteria.andCreateTimeEqualTo(baseType.getCreateTime());
        }
                    if (baseType.getUpdateTime() != null){
            criteria.andUpdateTimeEqualTo(baseType.getUpdateTime());
        }
                    if (baseType.getIsDeleted() != null){
            criteria.andIsDeletedEqualTo(baseType.getIsDeleted());
        }
                return example;
    }

}
