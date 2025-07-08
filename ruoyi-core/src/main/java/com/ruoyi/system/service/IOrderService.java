package com.ruoyi.system.service;

import com.ruoyi.system.domain.Order;

import java.util.List;

/**
 * 订单列表Service接口
 * 
 * @author ruoyi
 * @date 2024-11-10
 */
public interface IOrderService 
{
    /**
     * 查询订单列表
     * 
     * @param id 订单列表主键
     * @return 订单列表
     */
    public Order selectOrderById(Long id);

    /**
     * 查询订单列表列表
     * 
     * @param order 订单列表
     * @return 订单列表集合
     */
    public List<Order> selectOrderList(Order order);

    List<Order> selectOrderListById(Long userId);

    /**
     * 新增订单列表
     * 
     * @param order 订单列表
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改订单列表
     * 
     * @param order 订单列表
     * @return 结果
     */
    public int updateOrder(Order order);

    /**
     * 批量删除订单列表
     * 
     * @param ids 需要删除的订单列表主键集合
     * @return 结果
     */
    public int deleteOrderByIds(Long[] ids);

    /**
     * 删除订单列表信息
     * 
     * @param id 订单列表主键
     * @return 结果
     */
    public int deleteOrderById(Long id);
}
