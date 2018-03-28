package com.legend.cloud.vo.base;

import com.legend.cloud.entity.base.BaseFile;
import com.legend.module.core.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 文件存储表
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseFileVO extends AbstractVO<BaseFile> {
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

    @Override
    public BaseFile parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseFileVO parseFrom(BaseFile baseFile, String... ignoreProperties) {
        return (BaseFileVO) super.parseFrom(baseFile, ignoreProperties);
    }

    @Override
    public String toString() {
        return "BaseFileVO{" +
                ", id=" + getId() +
                ", userId=" + getUserId() +
                ", typeUser=" + getTypeUser() +
                ", title=" + getTitle() +
                ", content=" + getContent() +
                ", url=" + getUrl() +
                ", fileName=" + getFileName() +
                ", createTime=" + getCreateTime() +
                ", updateTime=" + getUpdateTime() +
                ", isDeleted=" + getIsDeleted() +
                '}';
    }
}
