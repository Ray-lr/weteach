package com.legend.cloud.entity.system;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 菜单表
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "system_menu")
public class SystemMenu extends AbstractEntity<SystemMenu> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "parent_id")
    private Integer parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 额外添加的类
     */
    @Column(name = "class_name")
    private String className;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
