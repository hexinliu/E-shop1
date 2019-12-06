package cn.edu.whale.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 16:37 2019/12/1
 * @Modified By：
 */
public class ShopCart {
    private int scid;
    private int uid;
    private int sc_num;

    private Map<String,ShopCartItem> itemMap = new HashMap<String,ShopCartItem>();
    public ShopCart() {
    }

    public ShopCart(int scid, int uid, int sc_num) {
        this.scid = scid;
        this.uid = uid;
        this.sc_num = sc_num;
    }

    public Collection<ShopCartItem> getCartItems()
    {
          return itemMap.values();
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSc_num() {
        return sc_num;
    }

    public void setSc_num(int sc_num) {
        this.sc_num = sc_num;
    }
}
