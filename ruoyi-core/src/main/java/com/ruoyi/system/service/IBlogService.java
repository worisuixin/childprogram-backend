package com.ruoyi.system.service;

import com.ruoyi.system.domain.Blog;

import java.util.List;

/**
 * 博客文章管理Service接口
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
public interface IBlogService 
{
    /**
     * 查询博客文章管理
     * 
     * @param id 博客文章管理主键
     * @return 博客文章管理
     */
    public Blog selectBlogById(Long id);

    /**
     * 查询博客文章管理列表
     * 
     * @param blog 博客文章管理
     * @return 博客文章管理集合
     */
    public List<Blog> selectBlogList(Blog blog);

    /**
     * 新增博客文章管理
     * 
     * @param blog 博客文章管理
     * @return 结果
     */
    public int insertBlog(Blog blog);

    /**
     * 修改博客文章管理
     * 
     * @param blog 博客文章管理
     * @return 结果
     */
    public int updateBlog(Blog blog);

    /**
     * 批量删除博客文章管理
     * 
     * @param ids 需要删除的博客文章管理主键集合
     * @return 结果
     */
    public int deleteBlogByIds(Long[] ids);

    /**
     * 删除博客文章管理信息
     * 
     * @param id 博客文章管理主键
     * @return 结果
     */
    public int deleteBlogById(Long id);
}
