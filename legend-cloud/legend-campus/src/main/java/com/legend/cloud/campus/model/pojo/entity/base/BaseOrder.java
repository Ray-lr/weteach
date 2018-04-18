package com.legend.cloud.campus.model.pojo.entity.base;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 基础订单
 *
 * @author hupeiD
 * @date 2018-04-18 21:56:01
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 用户类型(admin/user)
     */
    @Column(name = "type_user")
    private String typeUser;
    /**
     * 订单号
     */
    @Column(name = "order_number")
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
    @Column(name = "type_currency")
    private String typeCurrency;
    /**
     * 支付总金额
     */
    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;
    /**
     * 支付类型（0、现金 1、银行卡 2、支付宝 3、微信）
     */
    @Column(name = "type_payment")
    private String typePayment;
    /**
     * 订单开始时间
     */
    @Column(name = "begin_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    /**
     * 订单结束时间
     */
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    /**
     * 状态（0、预支付订单 1、已支付 2、已关闭 3、已申请退款）
     */
    private Integer status;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
