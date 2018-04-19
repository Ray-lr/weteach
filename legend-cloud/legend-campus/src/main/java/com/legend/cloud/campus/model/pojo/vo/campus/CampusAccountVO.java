package com.legend.cloud.campus.model.pojo.vo.campus;

import com.legend.cloud.campus.model.pojo.entity.campus.CampusAccount;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 个人信息表
 *
 * @author hupeiD
 * @date 2018-04-19 17:14:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CampusAccountVO extends AbstractVO<CampusAccount, CampusAccountVO> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户基础id
     */
    private Integer userId;
    /**
     * 用户实名
     */
    private String name;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别
     */
    private Boolean sex;
    /**
     * 出生年月
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    /**
     * 省/直辖市/自治区/特别行政区
     */
    private Integer province;
    /**
     * 市/自治州
     */
    private Integer city;
    /**
     * 县/区
     */
    private Integer county;
    /**
     * 入学年份
     */
    private String enrollmentYear;
    /**
     * 系别
     */
    private String dept;
    /**
     * 专业
     */
    private String major;
    /**
     * 方向
     */
    private String direction;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 联系方式（QQ,微信,等等）
     */
    private String contact;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 
     */
    private Double reputationRating;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

    @Override
    @SuppressWarnings("unchecked")
    public CampusAccountVO parseFrom(CampusAccount campusAccount, String... ignoreProperties) {
        return (CampusAccountVO) super.parseFrom(campusAccount, ignoreProperties);
    }

}
