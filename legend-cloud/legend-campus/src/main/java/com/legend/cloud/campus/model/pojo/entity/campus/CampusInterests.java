package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 兴趣标签表
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "campus_interests")
public class CampusInterests extends AbstractEntity<CampusInterests> {
    private static final long serialVersionUID = 1L;

    /**
     * 兴趣爱好id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
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
