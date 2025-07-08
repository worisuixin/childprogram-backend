package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.CartItem;
import com.ruoyi.system.mapper.CartItemMapper;
import com.ruoyi.system.service.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 购物车商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-09
 */
@Service
public class CartItemServiceImpl implements ICartItemService 
{
    @Autowired
    private CartItemMapper cartItemMapper;

    /**
     * 查询购物车商品
     * 
     * @param id 购物车商品主键
     * @return 购物车商品
     */
    @Override
    public CartItem selectCartItemById(Long id)
    {
        return cartItemMapper.selectCartItemById(id);
    }

    @Override
    public CartItem selectCartItemByIdAndUser(Long id, Long userId) {
        return cartItemMapper.selectCartItemByIdAndUser(id, userId);
    }

    @Override
    public CartItem selectCartItem(Integer courseId, Long userId) {
        return cartItemMapper.selectCartItem(courseId, userId);
    }

    @Override
    public long selectCartItemCount(Long userId) {
        List<CartItem> items = cartItemMapper.selectCartItemListById(userId);
        Optional<Long> reduce = items.stream().map(CartItem::getCount).reduce(Long::sum);
        return reduce.orElse(0L);
    }

    /**
     * 查询购物车商品列表
     * 
     * @param cartItem 购物车商品
     * @return 购物车商品
     */
    @Override
    public List<CartItem> selectCartItemList(CartItem cartItem)
    {
        return cartItemMapper.selectCartItemList(cartItem);
    }

    @Override
    public List<CartItem> selectCartItemListById(Long userId) {
        return cartItemMapper.selectCartItemListById(userId);
    }

    /**
     * 新增购物车商品
     * 
     * @param cartItem 购物车商品
     * @return 结果
     */
    @Override
    public int insertCartItem(CartItem cartItem)
    {
        return cartItemMapper.insertCartItem(cartItem);
    }

    /**
     * 修改购物车商品
     * 
     * @param cartItem 购物车商品
     * @return 结果
     */
    @Override
    public int updateCartItem(CartItem cartItem)
    {
        return cartItemMapper.updateCartItem(cartItem);
    }

    /**
     * 批量删除购物车商品
     * 
     * @param ids 需要删除的购物车商品主键
     * @return 结果
     */
    @Override
    public int deleteCartItemByIds(Long[] ids)
    {
        return cartItemMapper.deleteCartItemByIds(ids);
    }

    /**
     * 删除购物车商品信息
     * 
     * @param id 购物车商品主键
     * @return 结果
     */
    @Override
    public int deleteCartItemById(Long id)
    {
        return cartItemMapper.deleteCartItemById(id);
    }

    @Override
    public int deleteCartItemByIdAndUser(Long id, Long userId) {
        return cartItemMapper.deleteCartItemByIdAndUser(id, userId);
    }
}
