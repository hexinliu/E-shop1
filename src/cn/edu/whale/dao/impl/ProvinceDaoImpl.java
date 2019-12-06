package cn.edu.whale.dao.impl;

import cn.edu.whale.dao.ProvinceDao;
import cn.edu.whale.domain.Province;
import cn.edu.whale.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 18:35 2019/11/17
 * @Modified By：
 */
public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        String sql = "select * from province";

        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
