package com.legend.cloud.campus.model.pojo.entity.campus;

import com.legend.module.core.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 教师资格认证
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "campus_verify")
public class CampusVerify extends AbstractEntity<CampusVerify> {
    private static final long serialVersionUID = 1L;

    /**
     * 教师资格id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 认证系别
     */
    private Integer dept;
    /**
     * 认证专业
     */
    private Integer major;
    /**
     * 认证理由
     */
    private String reason;
    /**
     * 认证证明（证书等）
     */
    private String evidence;
    /**
     * 状态（0，待审核；1，通过；2，未通过）
     */
    private Integer status;
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
