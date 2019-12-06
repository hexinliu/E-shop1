package cn.edu.whale.domain;

import java.util.List;
import java.util.Map;

/**
 * @Author: hexin Liu
 * @Description:    分页对象
 * @Date: Created in 23:01 2019/12/3
 * @Modified By：
 */
//在这里使用泛型的意义：将来可能不光给购物车数据进行分页，还可能给用户，商品等数据进行分页，使用泛型可以进行灵活的复用
public class PageBean<T> {
    private int totalCount;//总记录数
    private int totalPage;//总页码
    private List<T> list;//每页的数据
    private int currentPage;//当前页码
    private int rows;//每页显示的记录数

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
