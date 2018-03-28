package com.legend.cloud.vo.base;

import com.legend.cloud.entity.base.BaseLogRecord;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 日志记录
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseLogRecordVO extends AbstractVO<BaseLogRecord> {
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

    @Override
    public BaseLogRecord parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseLogRecordVO parseFrom(BaseLogRecord baseLogRecord, String... ignoreProperties) {
        return (BaseLogRecordVO) super.parseFrom(baseLogRecord, ignoreProperties);
    }

    @Override
    public String toString() {
        return "BaseLogRecordVO{" +
                ", id=" + getId() +
                ", userId=" + getUserId() +
                ", content=" + getContent() +
                ", typeOption=" + getTypeOption() +
                ", typeUser=" + getTypeUser() +
                ", ip=" + getIp() +
                ", method=" + getMethod() +
                ", executeTime=" + getExecuteTime() +
                ", status=" + getStatus() +
                ", remark=" + getRemark() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
