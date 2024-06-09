package com.qiujie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 员工基本信息
 * @TableName sys_information
 */
@TableName(value ="sys_information")
@Data
public class SysInformation implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 员工id
     */
    private Integer staffId;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 合同工作地点
     */
    private String location;

    /**
     * 员工编号
     */
    private Integer number;

    /**
     * 员工性质
     */
    private String type;

    /**
     * 性别
     */
    private String sex;

    /**
     * 户籍
     */
    private String domicile;

    /**
     * 实习类别
     */
    private String internship;

    /**
     * 部门
     */
    private String department;

    /**
     * 民族
     */
    private String ethnic;

    /**
     * 政治面貌
     */
    private String political;

    /**
     * 财务类别
     */
    private String finance;

    /**
     * 身份证
     */
    private String idcard;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 电话
     */
    private String phone;

    /**
     * 微信号
     */
    private String weixin;

    /**
     * 紧急联系人电话
     */
    private String emergency;

    /**
     * 住宅电话
     */
    private String residence;

    /**
     * 学历
     */
    private String degree;

    /**
     * 婚姻状况
     */
    private String marry;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 专业
     */
    private String major;

    /**
     * 职位
     */
    private String post;

    /**
     * 员工状态
     */
    private String status;

    /**
     * 工龄
     */
    private Integer age;

    /**
     * 兴趣爱好
     */
    private String hobby;

    /**
     * 备注
     */
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysInformation other = (SysInformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStaffId() == null ? other.getStaffId() == null : this.getStaffId().equals(other.getStaffId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getDomicile() == null ? other.getDomicile() == null : this.getDomicile().equals(other.getDomicile()))
            && (this.getInternship() == null ? other.getInternship() == null : this.getInternship().equals(other.getInternship()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getEthnic() == null ? other.getEthnic() == null : this.getEthnic().equals(other.getEthnic()))
            && (this.getPolitical() == null ? other.getPolitical() == null : this.getPolitical().equals(other.getPolitical()))
            && (this.getFinance() == null ? other.getFinance() == null : this.getFinance().equals(other.getFinance()))
            && (this.getIdcard() == null ? other.getIdcard() == null : this.getIdcard().equals(other.getIdcard()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getWeixin() == null ? other.getWeixin() == null : this.getWeixin().equals(other.getWeixin()))
            && (this.getEmergency() == null ? other.getEmergency() == null : this.getEmergency().equals(other.getEmergency()))
            && (this.getResidence() == null ? other.getResidence() == null : this.getResidence().equals(other.getResidence()))
            && (this.getDegree() == null ? other.getDegree() == null : this.getDegree().equals(other.getDegree()))
            && (this.getMarry() == null ? other.getMarry() == null : this.getMarry().equals(other.getMarry()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getPost() == null ? other.getPost() == null : this.getPost().equals(other.getPost()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getHobby() == null ? other.getHobby() == null : this.getHobby().equals(other.getHobby()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStaffId() == null) ? 0 : getStaffId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getDomicile() == null) ? 0 : getDomicile().hashCode());
        result = prime * result + ((getInternship() == null) ? 0 : getInternship().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getEthnic() == null) ? 0 : getEthnic().hashCode());
        result = prime * result + ((getPolitical() == null) ? 0 : getPolitical().hashCode());
        result = prime * result + ((getFinance() == null) ? 0 : getFinance().hashCode());
        result = prime * result + ((getIdcard() == null) ? 0 : getIdcard().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getWeixin() == null) ? 0 : getWeixin().hashCode());
        result = prime * result + ((getEmergency() == null) ? 0 : getEmergency().hashCode());
        result = prime * result + ((getResidence() == null) ? 0 : getResidence().hashCode());
        result = prime * result + ((getDegree() == null) ? 0 : getDegree().hashCode());
        result = prime * result + ((getMarry() == null) ? 0 : getMarry().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getPost() == null) ? 0 : getPost().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getHobby() == null) ? 0 : getHobby().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", staffId=").append(staffId);
        sb.append(", name=").append(name);
        sb.append(", location=").append(location);
        sb.append(", number=").append(number);
        sb.append(", type=").append(type);
        sb.append(", sex=").append(sex);
        sb.append(", domicile=").append(domicile);
        sb.append(", internship=").append(internship);
        sb.append(", department=").append(department);
        sb.append(", ethnic=").append(ethnic);
        sb.append(", political=").append(political);
        sb.append(", finance=").append(finance);
        sb.append(", idcard=").append(idcard);
        sb.append(", birthday=").append(birthday);
        sb.append(", phone=").append(phone);
        sb.append(", weixin=").append(weixin);
        sb.append(", emergency=").append(emergency);
        sb.append(", residence=").append(residence);
        sb.append(", degree=").append(degree);
        sb.append(", marry=").append(marry);
        sb.append(", school=").append(school);
        sb.append(", major=").append(major);
        sb.append(", post=").append(post);
        sb.append(", status=").append(status);
        sb.append(", age=").append(age);
        sb.append(", hobby=").append(hobby);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}