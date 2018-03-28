package com.legend.cloud.entity.base;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 基础订单
 *
 * @author hupeiD
 * @date 2018-03-28 10:33:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_order")
public class BaseOrder extends AbstractEntity<BaseOrder> {
    private static final long serialVersionUID = 1L;

    /**
     * 基础订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
