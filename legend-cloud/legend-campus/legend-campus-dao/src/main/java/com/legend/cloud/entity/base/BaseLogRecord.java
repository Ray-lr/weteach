package com.legend.cloud.entity.base;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 日志记录
 *
 * @author hupeiD
 * @date 2018-03-26 22:19:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_log_record")
public class BaseLogRecord extends AbstractEntity<BaseLogRecord> {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
