package com.legend.cloud.service.campus.impl;

import com.legend.cloud.dao.mapper.campus.CampusMajorMapper;
import com.legend.cloud.entity.campus.CampusMajor;
import com.legend.cloud.entity.campus.CampusMajorExample;
import com.legend.cloud.service.campus.CampusMajorService;
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
public class CampusMajorServiceImpl extends AbstractLegendService<CampusMajor> implements CampusMajorService {

    @Resource
    private CampusMajorMapper campusMajorMapper;

    @Override
    public Mapper<CampusMajor> getMapper() {
        return campusMajorMapper;
    }

    @Override
    protected Object getExample(CampusMajor campusMajor, String order, String sort) {
        CampusMajorExample example = new CampusMajorExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusMajorExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusMajor == null) {
            return example;
        }

        if (campusMajor.getId() != null) {
            criteria.andIdEqualTo(campusMajor.getId());
        }
        if (campusMajor.getName() != null) {
            criteria.andNameEqualTo(campusMajor.getName());
        }
        if (campusMajor.getDeptId() != null) {
            criteria.andDeptIdEqualTo(campusMajor.getDeptId());
        }
        if (campusMajor.getAbbreviation() != null) {
            criteria.andAbbreviationEqualTo(campusMajor.getAbbreviation());
        }
        if (campusMajor.getTypeMajor() != null) {
            criteria.andTypeMajorEqualTo(campusMajor.getTypeMajor());
        }
        if (campusMajor.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusMajor.getCreateTime());
        }
        if (campusMajor.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusMajor.getUpdateTime());
        }
        if (campusMajor.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusMajor.getIsDeleted());
        }
        return example;
    }

}
