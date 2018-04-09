package com.legend.cloud.vo.campus;

import com.legend.cloud.entity.campus.CampusOrder;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 课程订单
 *
 * @author Jim
 * @date 2018-04-09 22:11:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CampusOrderVO extends AbstractVO<CampusOrder> {
    private static final long serialVersionUID = 1L;

    /**
     * 课程订单id
     */
    private Integer id;
    /**
     * 基础订单id
     */
    private Integer baseOrderId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 课程id
     */
    private Integer courseId;
    /**
     * 积分
     */
    private Integer credits;
    /**
     * 订单类型(求学或教学)
     */
    private String typeCourse;
    /**
     * 是否该课程发起人
     */
    private Boolean isHost;
    /**
     * 状态{0、已创建 1、已完成 2、已取消）
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
    public CampusOrder parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public CampusOrderVO parseFrom(CampusOrder campusOrder, String... ignoreProperties) {
        return (CampusOrderVO) super.parseFrom(campusOrder, ignoreProperties);
    }

    @Override
    public String toString() {
        return "CampusOrderVO{" +
                ", id=" + getId() +
                ", baseOrderId=" + getBaseOrderId() +
                ", userId=" + getUserId() +
                ", courseId=" + getCourseId() +
                ", credits=" + getCredits() +
                ", typeCourse=" + getTypeCourse() +
                ", isHost=" + getIsHost() +
                ", status=" + getStatus() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                            '}';
    }
}
