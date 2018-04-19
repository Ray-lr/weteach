package com.legend.cloud.campus.model.pojo.vo.base;

import com.legend.cloud.campus.model.pojo.entity.base.BaseOrder;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 基础订单
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BaseOrderVO extends AbstractVO<BaseOrder, BaseOrderVO> {
    private static final long serialVersionUID = 1L;

    /**
     * 基础订单id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户类型
     */
    private String typeUser;
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 标题
     */
    private String title;
    /**
     * 简介
     */
    private String description;
    /**
     * 详情
     */
    private String details;
    /**
     * 备注
     */
    private String remark;
    /**
     * 货币类型
     */
    private String typeCurrency;
    /**
     * 支付总金额
     */
    private BigDecimal paymentAmount;
    /**
     * 支付类型（0、现金 1、银行卡 2、支付宝 3、微信）
     */
    private String typePayment;
    /**
     * 订单开始时间
     */
    private Date beginTime;
    /**
     * 订单结束时间
     */
    private Date endTime;
    /**
     * 状态（0、预支付订单 1、已支付 2、已关闭 3、已申请退款）
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

}
