package com.legend.cloud.vo.base;

        import com.legend.cloud.entity.base.BaseOrder;
        import com.legend.module.core.vo.AbstractVO;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.util.Date;
        import java.math.BigDecimal;


/**
 * 基础订单
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseOrderVO extends AbstractVO<BaseOrder> {
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
    
    @Override
    public BaseOrder parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseOrderVO parseFrom(BaseOrder baseOrder, String... ignoreProperties) {
        return (BaseOrderVO) super.parseFrom(baseOrder, ignoreProperties);
    }

    @Override
    public String toString() {
        return "BaseOrderVO{" +
                                ", id=" + getId() +
                                ", userId=" + getUserId() +
                                ", typeUser=" + getTypeUser() +
                                ", orderNumber=" + getOrderNumber() +
                                ", title=" + getTitle() +
                                ", description=" + getDescription() +
                                ", details=" + getDetails() +
                                ", remark=" + getRemark() +
                                ", typeCurrency=" + getTypeCurrency() +
                                ", paymentAmount=" + getPaymentAmount() +
                                ", typePayment=" + getTypePayment() +
                                ", beginTime=" + getBeginTime() +
                                ", endTime=" + getEndTime() +
                                ", status=" + getStatus() +
                                ", createTime=" + getCreateTime() +
                                ", updateTime=" + getUpdateTime() +
                                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
