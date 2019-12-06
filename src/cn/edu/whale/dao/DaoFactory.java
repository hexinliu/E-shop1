package cn.edu.whale.dao;

import cn.edu.whale.dao.impl.ShopCartItemDaoImpl;
import cn.edu.whale.dao.impl.UserDaoImpl;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 17:19 2019/11/6
 * @Modified By：
 */
public class DaoFactory {
    public static UserDao createUserDaoImpl() {
        return new UserDaoImpl();
    }

    public static ShopCartItemDao createShopCartItemDaoImpl() {
        return new ShopCartItemDaoImpl();
    }
}
