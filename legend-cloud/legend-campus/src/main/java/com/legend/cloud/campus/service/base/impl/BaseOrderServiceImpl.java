package com.legend.cloud.campus.service.base.impl;

import com.legend.cloud.campus.dao.mapper.base.BaseOrderMapper;
import com.legend.cloud.campus.model.pojo.entity.base.BaseOrder;
import com.legend.cloud.campus.model.pojo.entity.base.example.BaseOrderExample;
import com.legend.cloud.campus.service.base.BaseOrderService;
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
public class BaseOrderServiceImpl extends AbstractLegendService<BaseOrder> implements BaseOrderService {

    @Resource
    private BaseOrderMapper baseOrderMapper;

    @Override
    public Mapper<BaseOrder> getMapper() {
        return baseOrderMapper;
    }

    @Override
    protected Object getExample(BaseOrder baseOrder, String order, String sort) {
        BaseOrderExample example = new BaseOrderExample();
        if (StringUtils.isNotBlank(order)) {
            if (StringUtils.isNotBlank(sort)) {
                order = order.concat(" ").concat(sort);
            }
            example.setOrderByClause(order);
        }
        BaseOrderExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (baseOrder == null) {
            return example;
        }

        if (baseOrder.getId() != null) {
            criteria.andIdEqualTo(baseOrder.getId());
        }
        if (baseOrder.getUserId() != null) {
            criteria.andUserIdEqualTo(baseOrder.getUserId());
        }
        if (baseOrder.getTypeUser() != null) {
            criteria.andTypeUserEqualTo(baseOrder.getTypeUser());
        }
        if (baseOrder.getOrderNumber() != null) {
            criteria.andOrderNumberEqualTo(baseOrder.getOrderNumber());
        }
        if (baseOrder.getTitle() != null) {
            criteria.andTitleEqualTo(baseOrder.getTitle());
        }
        if (baseOrder.getDescription() != null) {
            criteria.andDescriptionEqualTo(baseOrder.getDescription());
        }
        if (baseOrder.getDetails() != null) {
            criteria.andDetailsEqualTo(baseOrder.getDetails());
        }
        if (baseOrder.getRemark() != null) {
            criteria.andRemarkEqualTo(baseOrder.getRemark());
        }
        if (baseOrder.getTypeCurrency() != null) {
            criteria.andTypeCurrencyEqualTo(baseOrder.getTypeCurrency());
        }
        if (baseOrder.getPaymentAmount() != null) {
            criteria.andPaymentAmountEqualTo(baseOrder.getPaymentAmount());
        }
        if (baseOrder.getTypePayment() != null) {
            criteria.andTypePaymentEqualTo(baseOrder.getTypePayment());
        }
        if (baseOrder.getBeginTime() != null) {
            criteria.andBeginTimeEqualTo(baseOrder.getBeginTime());
        }
        if (baseOrder.getEndTime() != null) {
            criteria.andEndTimeEqualTo(baseOrder.getEndTime());
        }
        if (baseOrder.getStatus() != null) {
            criteria.andStatusEqualTo(baseOrder.getStatus());
        }
        if (baseOrder.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(baseOrder.getCreateTime());
        }
        if (baseOrder.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(baseOrder.getUpdateTime());
        }
        if (baseOrder.getIsDeleted() != null) {
            criteria.andIsDeletedEqualTo(baseOrder.getIsDeleted());
        }
        return example;
    }


    @Override
    public int save(BaseOrder baseOrder) {
        if (baseOrder.getCreateTime() == null) {
            Date now = new Date();
            baseOrder.setCreateTime(now);
            baseOrder.setUpdateTime(now);
        }
        return super.save(baseOrder);
    }
}
