package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.CartItem;
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.service.ICartItemService;
import com.ruoyi.system.service.ICourseService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车商品Controller
 * 
 * @author ruoyi
 * @date 2024-11-09
 */
@RestController
@RequestMapping("/system/item")
public class CartItemController extends BaseController
{
    @Autowired
    private ICartItemService cartItemService;

    @Autowired
    private ICourseService courseService;

    /**
     * 查询购物车商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:item:list')")
    @GetMapping("/list")
    public TableDataInfo list(CartItem cartItem)
    {
        startPage();
        List<CartItem> list = cartItemService.selectCartItemList(cartItem);
        return getDataTable(list);
    }

    /**
     * 导出购物车商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:item:export')")
    @Log(title = "购物车商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CartItem cartItem)
    {
        List<CartItem> list = cartItemService.selectCartItemList(cartItem);
        ExcelUtil<CartItem> util = new ExcelUtil<CartItem>(CartItem.class);
        util.exportExcel(response, list, "购物车商品数据");
    }

    /**
     * 获取购物车商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:item:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cartItemService.selectCartItemById(id));
    }

    /**
     * 新增购物车商品
     */
    @PreAuthorize("@ss.hasPermi('system:item:add')")
    @Log(title = "购物车商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CartItem cartItem)
    {
        return toAjax(cartItemService.insertCartItem(cartItem));
    }

    /**
     * 修改购物车商品
     */
    @PreAuthorize("@ss.hasPermi('system:item:edit')")
    @Log(title = "购物车商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CartItem cartItem)
    {
        return toAjax(cartItemService.updateCartItem(cartItem));
    }

    /**
     * 删除购物车商品
     */
    @PreAuthorize("@ss.hasPermi('system:item:remove')")
    @Log(title = "购物车商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cartItemService.deleteCartItemByIds(ids));
    }

    @GetMapping("/count")
    public AjaxResult itemCount() {
        return AjaxResult.success(cartItemService.selectCartItemCount(SecurityUtils.getUserId()));
    }

    @GetMapping("/my-list")
    public AjaxResult userList() {
        return AjaxResult.success(cartItemService.selectCartItemListById(SecurityUtils.getUserId()));
    }

    @DeleteMapping("/delete/{id}")
    public AjaxResult deleteItem(@PathVariable Long id) {
        return toAjax(cartItemService.deleteCartItemByIdAndUser(id, SecurityUtils.getUserId()));
    }

    @PutMapping("/increase/{id}")
    public AjaxResult increase(@PathVariable Long id) {
        CartItem item = cartItemService.selectCartItemByIdAndUser(id, SecurityUtils.getUserId());
        item.setCount(item.getCount() + 1);
        return toAjax(cartItemService.updateCartItem(item));
    }

    @PutMapping("/decrease/{id}")
    public AjaxResult decrease(@PathVariable Long id) {
        CartItem item = cartItemService.selectCartItemByIdAndUser(id, SecurityUtils.getUserId());
        long count = item.getCount();
        if(count <= 1) {
            return toAjax(cartItemService.deleteCartItemByIdAndUser(id, SecurityUtils.getUserId()));
        } else {
            item.setCount(item.getCount() - 1);
            return toAjax(cartItemService.updateCartItem(item));
        }
    }

    /**
     * 普通用户添加购物车商品
     */
    @PostMapping("/add/{courseId}")
    public AjaxResult addByUser(@PathVariable Integer courseId) {
        Course course = courseService.selectCourseById(courseId);
        if(course == null) return toAjax(false);
        Long userId = SecurityUtils.getUserId();
        CartItem item = cartItemService.selectCartItem(courseId, userId);
        if(item == null) {
            item = new CartItem();
            item.setUid(SecurityUtils.getUserId());
            item.setPrice(new BigDecimal(course.getPrice()));
            item.setTitle(course.getTitle());
            item.setCourseId(courseId.longValue());
            item.setCount(1L);
            cartItemService.insertCartItem(item);
        } else {
            item.setCount(item.getCount() + 1L);
            cartItemService.updateCartItem(item);
        }
        return toAjax(true);
    }
}
