package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 教师管理对象 db_teacher
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
public class Teacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教师ID */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 职位 */
    @Excel(name = "职位")
    private String post;

    /** 联系方式1 */
    @Excel(name = "联系方式1")
    private String contact1;

    /** 联系方式2 */
    @Excel(name = "联系方式2")
    private String contact2;

    /** 联系方式3 */
    @Excel(name = "联系方式3")
    private String contact3;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPost(String post) 
    {
        this.post = post;
    }

    public String getPost() 
    {
        return post;
    }
    public void setContact1(String contact1) 
    {
        this.contact1 = contact1;
    }

    public String getContact1() 
    {
        return contact1;
    }
    public void setContact2(String contact2) 
    {
        this.contact2 = contact2;
    }

    public String getContact2() 
    {
        return contact2;
    }
    public void setContact3(String contact3) 
    {
        this.contact3 = contact3;
    }

    public String getContact3() 
    {
        return contact3;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("post", getPost())
            .append("contact1", getContact1())
            .append("contact2", getContact2())
            .append("contact3", getContact3())
            .toString();
    }
}
