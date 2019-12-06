package cn.edu.whale.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 23:20 2019/11/6
 * @Modified By：
 */
public class ShopCartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private int giid;
    private int gid;
    private int scid;
    private int g_num;
    private Date gi_time;
    private int state;
    private Double final_pay;

    public ShopCartItem() {
    }

    public ShopCartItem(int giid, int gid, int scid, int g_num, Date gi_time, int state, Double final_pay) {
        this.giid = giid;
        this.gid = gid;
        this.scid = scid;
        this.g_num = g_num;
        this.gi_time = gi_time;
        this.state = state;
        this.final_pay = final_pay;
    }

    public int getGiid() {
        return giid;
    }

    public void setGiid(int giid) {
        this.giid = giid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getG_num() {
        return g_num;
    }

    public void setG_num(int g_num) {
        this.g_num = g_num;
    }

    public Date getGi_time() {
        return gi_time;
    }

    public void setGi_time(Date gi_time) {
        this.gi_time = gi_time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Double getFinal_pay() {
        return final_pay;
    }

    public void setFinal_pay(Double final_pay) {
        this.final_pay = final_pay;
    }
}
