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
 * 文件存储表
 *
 * @author hupeiD
 * @date 2018-03-28 10:33:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_file")
public class BaseFile extends AbstractEntity<BaseFile> {
    private static final long serialVersionUID = 1L;

    /**
     * 
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
