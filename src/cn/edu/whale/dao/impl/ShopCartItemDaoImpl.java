package cn.edu.whale.dao.impl;

import cn.edu.whale.dao.ShopCartItemDao;
import cn.edu.whale.domain.ShopCartItem;
import cn.edu.whale.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.List;
import java.util.Map;

/**
 * @Author: hexin Liu
 * @Description:    注意：new BeanPropertyRowMapper
 *          如果执行的sql返回的是一个多结果集的，它返回一个List集合
 *          如果执行的sql返回的是一个单结果集的，它返回一个对象
 * @Date: Created in 23:27 2019/11/6
 * @Modified By：
 */
public class ShopCartItemDaoImpl implements ShopCartItemDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int insert(ShopCartItem sci) {
        String sql = "insert into goods_item values(?,?,?,?,?,?,?)";

        int count = template.update(sql, sci.getGiid(), sci.getGid(), sci.getScid(), sci.getG_num(), sci.getGi_time(), sci.getState(), sci.getFinal_pay());

        return count;
    }

    @Override
    public int delete(int giid) {
            String sql = "delete from goods_item where giid = ?";
            int count = template.update(sql, giid);
            return count;

     }

    @Override
    public int update(ShopCartItem sci) {
        String sql = "update goods_item set giid = ?,gid = ?,g_num = ?,gi_time = ?,state = ?,final_pay = ? where scid = ?";
        int count = template.update(sql, sci.getGiid(), sci.getGid(), sci.getG_num(), sci.getGi_time(), sci.getState(), sci.getFinal_pay(), sci.getScid());

        return count;
    }

    @Override
    public List<ShopCartItem> select(int giid) {
        String sql = "select * from goods_item where giid = ?";
        List<ShopCartItem> list = template.query(sql, new BeanPropertyRowMapper<ShopCartItem>(ShopCartItem.class), giid);

        return list;
    }

    @Override
    public List<ShopCartItem> searchAll() {
        String sql = "select * from goods_item";
        List<ShopCartItem> list = template.query(sql,new BeanPropertyRowMapper<ShopCartItem>(ShopCartItem.class));
        return list;
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from goods_item";
        //JDK1.5新特性会自动拆箱，可以不用做类型转换
        Integer count = template.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<ShopCartItem> findByPage(int start, int rows) {
        String sql = "select * from goods_item limit ? , ?";
        List<ShopCartItem> list = template.query(sql,new BeanPropertyRowMapper<ShopCartItem>(ShopCartItem.class),start,rows);

        return list;
    }

}
