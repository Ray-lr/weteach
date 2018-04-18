package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 统计
 *
 * @author hupeiD
 * @date 2018-04-18 21:56:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "campus_statistics")
public class CampusStatistics extends AbstractEntity<CampusStatistics> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 描述
     */
    private String description;
    /**
     * 备注
     */
    private String remark;
    /**
     * 具体数据
     */
    private Integer data;
    /**
     * 概率数据
     */
    private Double probability;
    /**
     * 编号
     */
    private String code;
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
