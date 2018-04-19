package com.legend.cloud.campus.model.pojo.vo.base;

import com.legend.cloud.campus.model.pojo.entity.base.BaseFile;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 文件存储表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BaseFileVO extends AbstractVO<BaseFile, BaseFileVO> {
    private static final long serialVersionUID = 1L;

    /**
     *
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
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 地址
     */
    private String url;
    /**
     * 文件名称
     */
    private String fileName;
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
