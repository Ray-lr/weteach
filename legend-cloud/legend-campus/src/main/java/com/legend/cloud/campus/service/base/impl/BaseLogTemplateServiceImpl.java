package com.legend.cloud.campus.service.base.impl;

import com.legend.cloud.campus.dao.mapper.base.BaseLogTemplateMapper;
import com.legend.cloud.campus.model.pojo.entity.base.BaseLogTemplate;
import com.legend.cloud.campus.model.pojo.entity.base.BaseLogTemplateExample;
import com.legend.cloud.campus.service.base.BaseLogTemplateService;
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
public class BaseLogTemplateServiceImpl extends AbstractLegendService<BaseLogTemplate> implements BaseLogTemplateService {

    @Resource
    private BaseLogTemplateMapper baseLogTemplateMapper;

    @Override
    public Mapper<BaseLogTemplate> getMapper() {
        return baseLogTemplateMapper;
    }

    @Override
    protected Object getExample(BaseLogTemplate baseLogTemplate, String order, String sort) {
        BaseLogTemplateExample example = new BaseLogTemplateExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        BaseLogTemplateExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (baseLogTemplate == null) {
            return example;
        }

        if (baseLogTemplate.getId() != null) {
            criteria.andIdEqualTo(baseLogTemplate.getId());
        }
        if (baseLogTemplate.getTemplate() != null) {
            criteria.andTemplateEqualTo(baseLogTemplate.getTemplate());
        }
        if (baseLogTemplate.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(baseLogTemplate.getCreateTime());
        }
        if (baseLogTemplate.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(baseLogTemplate.getUpdateTime());
        }
        if (baseLogTemplate.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(baseLogTemplate.getIsDeleted());
        }
        return example;
    }

}
