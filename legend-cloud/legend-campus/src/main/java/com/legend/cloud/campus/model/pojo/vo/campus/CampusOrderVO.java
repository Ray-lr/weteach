package com.legend.cloud.campus.model.pojo.vo.campus;

import com.legend.cloud.campus.model.pojo.entity.campus.CampusOrder;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 课程订单
 *
 * @author Jim
 * @date 2018-04-09 22:11:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CampusOrderVO extends AbstractVO<CampusOrder, CampusOrderVO> {
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

}
