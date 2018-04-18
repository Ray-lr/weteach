package com.legend.cloud.campus.service.campus.impl;

import com.legend.cloud.campus.dao.mapper.campus.CampusOrderMapper;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusOrder;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusOrderExample;
import com.legend.cloud.campus.service.campus.CampusOrderService;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Administrator
 * @date 2018/3/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CampusOrderServiceImpl extends AbstractLegendService<CampusOrder> implements CampusOrderService {

    @Resource
    private CampusOrderMapper campusOrderMapper;

    @Override
    public Mapper<CampusOrder> getMapper() {
        return campusOrderMapper;
    }

    @Override
    protected Object getExample(CampusOrder campusOrder, String order, String sort) {
        CampusOrderExample example = new CampusOrderExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        CampusOrderExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (campusOrder == null) {
            return example;
        }

        if (campusOrder.getId() != null) {
            criteria.andIdEqualTo(campusOrder.getId());
        }
        if (campusOrder.getBaseOrderId() != null) {
            criteria.andBaseOrderIdEqualTo(campusOrder.getBaseOrderId());
        }
        if (campusOrder.getUserId() != null) {
            criteria.andUserIdEqualTo(campusOrder.getUserId());
        }
        if (campusOrder.getCourseId() != null) {
            criteria.andCourseIdEqualTo(campusOrder.getCourseId());
        }
        if (campusOrder.getCredits() != null) {
            criteria.andCreditsEqualTo(campusOrder.getCredits());
        }
        if (campusOrder.getTypeCourse() != null) {
            criteria.andTypeCourseEqualTo(campusOrder.getTypeCourse());
        }
        if (campusOrder.getIsHost() != null) {
            criteria.andIsHostEqualTo(campusOrder.getIsHost());
        }
        if (campusOrder.getStatus() != null) {
            criteria.andStatusEqualTo(campusOrder.getStatus());
        }
        if (campusOrder.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(campusOrder.getCreateTime());
        }
        if (campusOrder.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(campusOrder.getUpdateTime());
        }
        if (campusOrder.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(campusOrder.getIsDeleted());
        }
        return example;
    }

    @Override
    public int save(CampusOrder campusOrder) {
        if (campusOrder.getCreateTime() == null) {
            Date now = new Date();
            campusOrder.setCreateTime(now);
            campusOrder.setUpdateTime(now);
        }
        return super.save(campusOrder);
    }
}
