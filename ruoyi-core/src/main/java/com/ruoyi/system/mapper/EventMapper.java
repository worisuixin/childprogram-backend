package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Event;

import java.util.List;

/**
 * 活动管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
public interface EventMapper 
{
    /**
     * 查询活动管理
     * 
     * @param id 活动管理主键
     * @return 活动管理
     */
    public Event selectEventById(Long id);

    /**
     * 查询活动管理列表
     * 
     * @param event 活动管理
     * @return 活动管理集合
     */
    public List<Event> selectEventList(Event event);

    /**
     * 新增活动管理
     * 
     * @param event 活动管理
     * @return 结果
     */
    public int insertEvent(Event event);

    /**
     * 修改活动管理
     * 
     * @param event 活动管理
     * @return 结果
     */
    public int updateEvent(Event event);

    /**
     * 删除活动管理
     * 
     * @param id 活动管理主键
     * @return 结果
     */
    public int deleteEventById(Long id);

    /**
     * 批量删除活动管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEventByIds(Long[] ids);
}
