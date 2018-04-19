package com.legend.cloud.campus.model.pojo.vo.system;

import com.legend.cloud.campus.model.pojo.entity.system.SystemMenu;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 菜单表
 *
 * @author hupeiD
 * @date 2018-03-27 21:30:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class SystemMenuVO extends AbstractVO<SystemMenu, SystemMenuVO> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * url
     */
    private String url;
    /**
     * 描述
     */
    private String description;
    /**
     * 菜单等级
     */
    private Integer hierarchy;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 额外添加的类
     */
    private String className;
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
