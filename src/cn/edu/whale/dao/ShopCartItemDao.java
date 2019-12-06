package cn.edu.whale.dao;


import cn.edu.whale.domain.ShopCartItem;

import java.util.List;
import java.util.Map;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 23:24 2019/11/6
 * @Modified By：
 */
public interface ShopCartItemDao {
    int insert(ShopCartItem sci);

    int delete(int giid);

    int update(ShopCartItem sci);

    List<ShopCartItem> select(int giid);

    List<ShopCartItem> searchAll();

    int findTotalCount();

    List<ShopCartItem> findByPage(int start, int rows);
}
