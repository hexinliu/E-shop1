package cn.edu.whale.service;

import cn.edu.whale.domain.PageBean;
import cn.edu.whale.domain.ShopCartItem;

import java.util.List;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 21:55 2019/12/1
 * @Modified By：
 */
public interface ShopCartService {
    void deleteShopCart(String id);
    List<ShopCartItem> findAll();

    void delSelected(String[] dids);
    //分页查询
    PageBean<ShopCartItem> findShopCartByPage(String currentPage, String rows);
}
