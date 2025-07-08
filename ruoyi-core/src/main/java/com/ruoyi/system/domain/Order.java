package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 订单列表对象 db_order
 * 
 * @author ruoyi
 * @date 2024-11-10
 */
public class Order extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单号 */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uid;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 合计金额 */
    @Excel(name = "合计金额")
    private Double pirce;

    /** 收件人名称 */
    @Excel(name = "收件人名称")
    private String name;

    /** 收件公司 */
    @Excel(name = "收件公司")
    private String company;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 街道地址1 */
    @Excel(name = "街道地址1")
    private String steet1;

    /** 街道地址2 */
    @Excel(name = "街道地址2")
    private String steet2;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postal;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 电子邮件 */
    @Excel(name = "电子邮件")
    private String email;

    /** 订单备注 */
    @Excel(name = "订单备注")
    private String note;

    /** 订单商品列表信息 */
    private List<OrderItem> orderItemList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setPirce(Double pirce) 
    {
        this.pirce = pirce;
    }

    public Double getPirce() 
    {
        return pirce;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setSteet1(String steet1) 
    {
        this.steet1 = steet1;
    }

    public String getSteet1() 
    {
        return steet1;
    }
    public void setSteet2(String steet2) 
    {
        this.steet2 = steet2;
    }

    public String getSteet2() 
    {
        return steet2;
    }
    public void setPostal(String postal) 
    {
        this.postal = postal;
    }

    public String getPostal() 
    {
        return postal;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }

    public List<OrderItem> getOrderItemList()
    {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList)
    {
        this.orderItemList = orderItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("time", getTime())
            .append("pirce", getPirce())
            .append("name", getName())
            .append("company", getCompany())
            .append("country", getCountry())
            .append("city", getCity())
            .append("steet1", getSteet1())
            .append("steet2", getSteet2())
            .append("postal", getPostal())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("note", getNote())
            .append("orderItemList", getOrderItemList())
            .toString();
    }
}
