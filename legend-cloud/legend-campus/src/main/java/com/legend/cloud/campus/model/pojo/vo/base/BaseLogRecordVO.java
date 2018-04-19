package com.legend.cloud.campus.model.pojo.vo.base;

import com.legend.cloud.campus.model.pojo.entity.base.BaseLogRecord;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 日志记录
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BaseLogRecordVO extends AbstractVO<BaseLogRecord, BaseLogRecordVO> {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 内容
     */
    private String content;
    /**
     * 操作类型
     */
    private Integer typeOption;
    /**
     * 用户类型1、前台2、后台
     */
    private Integer typeUser;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 方法名称
     */
    private String method;
    /**
     * 执行时间
     */
    private Date executeTime;
    /**
     * 状态(0、异常 1、成功 2、返回失败)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
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
