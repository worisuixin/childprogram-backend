package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Blog;
import com.ruoyi.system.domain.BlogDetail;
import com.ruoyi.system.mapper.BlogMapper;
import com.ruoyi.system.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客文章管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
@Service
public class BlogServiceImpl implements IBlogService 
{
    @Autowired
    private BlogMapper blogMapper;

    /**
     * 查询博客文章管理
     * 
     * @param id 博客文章管理主键
     * @return 博客文章管理
     */
    @Override
    public Blog selectBlogById(Long id)
    {
        return blogMapper.selectBlogById(id);
    }

    /**
     * 查询博客文章管理列表
     * 
     * @param blog 博客文章管理
     * @return 博客文章管理
     */
    @Override
    public List<Blog> selectBlogList(Blog blog)
    {
        return blogMapper.selectBlogList(blog);
    }

    /**
     * 新增博客文章管理
     * 
     * @param blog 博客文章管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertBlog(Blog blog)
    {
        int rows = blogMapper.insertBlog(blog);
        insertBlogDetail(blog);
        return rows;
    }

    /**
     * 修改博客文章管理
     * 
     * @param blog 博客文章管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateBlog(Blog blog)
    {
        blogMapper.deleteBlogDetailById(blog.getId());
        insertBlogDetail(blog);
        return blogMapper.updateBlog(blog);
    }

    /**
     * 批量删除博客文章管理
     * 
     * @param ids 需要删除的博客文章管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBlogByIds(Long[] ids)
    {
        blogMapper.deleteBlogDetailByIds(ids);
        return blogMapper.deleteBlogByIds(ids);
    }

    /**
     * 删除博客文章管理信息
     * 
     * @param id 博客文章管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteBlogById(Long id)
    {
        blogMapper.deleteBlogDetailById(id);
        return blogMapper.deleteBlogById(id);
    }

    /**
     * 新增博客文章详情信息
     * 
     * @param blog 博客文章管理对象
     */
    public void insertBlogDetail(Blog blog)
    {
        List<BlogDetail> blogDetailList = blog.getBlogDetailList();
        Long id = blog.getId();
        if (StringUtils.isNotNull(blogDetailList))
        {
            List<BlogDetail> list = new ArrayList<BlogDetail>();
            for (BlogDetail blogDetail : blogDetailList)
            {
                blogDetail.setId(id);
                list.add(blogDetail);
            }
            if (list.size() > 0)
            {
                blogMapper.batchBlogDetail(list);
            }
        }
    }
}
