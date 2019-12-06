package cn.edu.whale.service.impl;

import cn.edu.whale.dao.ShopCartItemDao;
import cn.edu.whale.dao.impl.ShopCartItemDaoImpl;
import cn.edu.whale.domain.PageBean;
import cn.edu.whale.domain.ShopCartItem;
import cn.edu.whale.service.ShopCartService;

import java.util.List;
import java.util.Map;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 21:56 2019/12/1
 * @Modified By：
 */
public class ShopCartServiceImpl implements ShopCartService {
    private ShopCartItemDao scdao = new ShopCartItemDaoImpl();
    @Override
    public void deleteShopCart(String id) {
        scdao.delete(Integer.parseInt(id));
    }

    @Override
    public List<ShopCartItem> findAll() {
       return scdao.searchAll();
    }

    @Override
    public void delSelected(String[] dids) {
        //避免空指针异常
        if (dids != null && dids.length > 0){
            //1.遍历id数组
            for (String did : dids) {
                //2.调用dao删除
                scdao.delete(Integer.parseInt(did));
            }
        }
    }

    @Override
    public PageBean<ShopCartItem> findShopCartByPage(String _currentPage, String _rows) {
        //由于这两个参数在下面用的地方比较多，在这里提前进行类型转换
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //1.创建一个空的PageBean对象
        if (currentPage < 1)
        {
            currentPage = 1;
        }


        PageBean<ShopCartItem> pb = new PageBean<ShopCartItem>();//为了兼容低版本，将new出来的对象中的泛型补齐

        //3.调用dao查询总记录数
        int totalCount = scdao.findTotalCount();
        pb.setTotalCount(totalCount);
        int totalPage = (totalCount%rows) == 0 ? totalCount/rows : totalCount/rows + 1;
        if (currentPage > totalPage)
        {
            currentPage = totalPage;
        }
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //4.调用dao查询list集合
            //计算开始查询位置的记录索引
        int start = (currentPage - 1) * rows;
        List<ShopCartItem> list = scdao.findByPage(start, rows);
        pb.setList(list);
        pb.setTotalPage(totalPage);
        return pb;
    }
}
