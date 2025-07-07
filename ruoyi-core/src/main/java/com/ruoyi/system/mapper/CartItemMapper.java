package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.CartItem;

import java.util.List;

/**
 * 购物车商品Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-09
 */
public interface CartItemMapper 
{
    /**
     * 查询购物车商品
     * 
     * @param id 购物车商品主键
     * @return 购物车商品
     */
    public CartItem selectCartItemById(Long id);

    CartItem selectCartItemByIdAndUser(Long id, Long userId);

    CartItem selectCartItem(Integer courseId, Long userId);

    List<CartItem> selectCartItemListById(Long userId);

    /**
     * 查询购物车商品列表
     * 
     * @param cartItem 购物车商品
     * @return 购物车商品集合
     */
    public List<CartItem> selectCartItemList(CartItem cartItem);

    /**
     * 新增购物车商品
     * 
     * @param cartItem 购物车商品
     * @return 结果
     */
    public int insertCartItem(CartItem cartItem);

    /**
     * 修改购物车商品
     * 
     * @param cartItem 购物车商品
     * @return 结果
     */
    public int updateCartItem(CartItem cartItem);

    /**
     * 删除购物车商品
     * 
     * @param id 购物车商品主键
     * @return 结果
     */
    public int deleteCartItemById(Long id);

    public int deleteCartItemByIdAndUser(Long id, Long userId);

    /**
     * 批量删除购物车商品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCartItemByIds(Long[] ids);
}
