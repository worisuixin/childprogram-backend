package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Event;
import com.ruoyi.system.mapper.EventMapper;
import com.ruoyi.system.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 活动管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
@Service
public class EventServiceImpl implements IEventService 
{
    @Autowired
    private EventMapper eventMapper;

    /**
     * 查询活动管理
     * 
     * @param id 活动管理主键
     * @return 活动管理
     */
    @Override
    public Event selectEventById(Long id)
    {
        return eventMapper.selectEventById(id);
    }

    /**
     * 查询活动管理列表
     * 
     * @param event 活动管理
     * @return 活动管理
     */
    @Override
    public List<Event> selectEventList(Event event)
    {
        return eventMapper.selectEventList(event);
    }

    /**
     * 新增活动管理
     * 
     * @param event 活动管理
     * @return 结果
     */
    @Override
    public int insertEvent(Event event)
    {
        return eventMapper.insertEvent(event);
    }

    /**
     * 修改活动管理
     * 
     * @param event 活动管理
     * @return 结果
     */
    @Override
    public int updateEvent(Event event)
    {
        return eventMapper.updateEvent(event);
    }

    /**
     * 批量删除活动管理
     * 
     * @param ids 需要删除的活动管理主键
     * @return 结果
     */
    @Override
    public int deleteEventByIds(Long[] ids)
    {
        return eventMapper.deleteEventByIds(ids);
    }

    /**
     * 删除活动管理信息
     * 
     * @param id 活动管理主键
     * @return 结果
     */
    @Override
    public int deleteEventById(Long id)
    {
        return eventMapper.deleteEventById(id);
    }
}
