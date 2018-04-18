package com.legend.cloud.campus.model.pojo.vo.campus;

import com.alibaba.fastjson.annotation.JSONField;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusUserInfo;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Null;
import java.util.Date;


/**
 * 个人信息表
 *
 * @author Jim
 * @date 2018-04-10 16:04:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CampusUserInfoVO extends AbstractVO<CampusUserInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Null
    private Integer id;
    /**
     * 用户基础id
     */
    @Null
    private Integer baseUserId;
    /**
     * 用户实名
     */
    private String name;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 性别
     */
    @JSONField(serialize = false)
    private String sex;
    /**
     * 出生年月
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(serialize = false)
    private Date birthday;
    /**
     * 省/直辖市/自治区/特别行政区
     */
    @JSONField(serialize = false)
    private Integer province;
    /**
     * 市/自治州
     */
    @JSONField(serialize = false)
    private Integer city;
    /**
     * 县/区
     */
    @JSONField(serialize = false)
    private Integer county;
    /**
     * 入学年份
     */
    @JSONField(serialize = false)
    private String enrollmentYear;
    /**
     * 系别id
     */
    private String dept;
    /**
     * 专业id
     */
    private String major;
    /**
     * 方向
     */
    private String direction;
    /**
     * 电话
     */
    @JSONField(serialize = false)
    @Null
    private String phone;
    /**
     * 邮箱
     */
    @JSONField(serialize = false)
    private String email;
    /**
     * 联系方式（QQ,微信,等等）
     */
    @JSONField(serialize = false)
    private String contact;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 积分量
     */
    @JSONField(serialize = false)
    private Integer credits;
    /**
     * 积分信誉等级
     */
    private String creditsLevel;
    /**
     * 参与课程数
     */
    @JSONField(serialize = false)
    private Integer orderJoin;
    /**
     * 课程发布数
     */
    @JSONField(serialize = false)
    private Integer orderPublish;
    /**
     * 课程完成数
     */
    @JSONField(serialize = false)
    private Integer orderFinish;
    /**
     * 课程完成率
     */
    @JSONField(serialize = false)
    private Double percentageComplete;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(serialize = false)
    @Null
    private Date createTime;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(serialize = false)
    @Null
    private Date updateTime;
    /**
     * 是否删除
     */
    @JSONField(serialize = false)
    @Null
    private Boolean isDeleted;
    /**
     * 系的name
     */
    private String dept_string;
    /**
     * 专业的name
     */
    private String major_string;

    @Override
    public CampusUserInfoVO parseFrom(CampusUserInfo campusUserInfo, String... ignoreProperties) {
        return (CampusUserInfoVO) super.parseFrom(campusUserInfo, ignoreProperties);
    }

}
