package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 课程对象 db_course
 * 
 * @author ruoyi
 * @date 2024-11-07
 */
public class Course extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程ID */
    private Integer id;

    /** 主讲老师 */
    @Excel(name = "主讲老师")
    private String teacher;

    /** 课程标题 */
    @Excel(name = "课程标题")
    private String title;

    /** 课程简介 */
    @Excel(name = "课程简介")
    private String about;

    /** 课程详细 */
    @Excel(name = "课程详细")
    private String description;

    /** 课程数量 */
    @Excel(name = "课程数量")
    private Long lessone;

    /** 课程价格 */
    @Excel(name = "课程价格")
    private Long price;

    /** 课程时长 */
    @Excel(name = "课程时长")
    private Long duration;

    /** 最大学生 */
    @Excel(name = "最大学生")
    private Long maxStudents;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setTeacher(String teacher) 
    {
        this.teacher = teacher;
    }

    public String getTeacher() 
    {
        return teacher;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setAbout(String about) 
    {
        this.about = about;
    }

    public String getAbout() 
    {
        return about;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setLessone(Long lessone) 
    {
        this.lessone = lessone;
    }

    public Long getLessone() 
    {
        return lessone;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setDuration(Long duration) 
    {
        this.duration = duration;
    }

    public Long getDuration() 
    {
        return duration;
    }
    public void setMaxStudents(Long maxStudents) 
    {
        this.maxStudents = maxStudents;
    }

    public Long getMaxStudents() 
    {
        return maxStudents;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacher", getTeacher())
            .append("title", getTitle())
            .append("about", getAbout())
            .append("description", getDescription())
            .append("lessone", getLessone())
            .append("price", getPrice())
            .append("duration", getDuration())
            .append("maxStudents", getMaxStudents())
            .toString();
    }
}
