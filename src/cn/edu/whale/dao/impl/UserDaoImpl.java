package cn.edu.whale.dao.impl;

import cn.edu.whale.dao.UserDao;
import cn.edu.whale.domain.User;
import cn.edu.whale.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 17:40 2019/11/2
 * @Modified By：
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        String sql = "select * from tab_user where username = ?";
        //注意此方法，如果没有查询到数据，它不会返回null，而会报异常
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {

        }
        return user;
    }

    @Override
    public void save(User user) {
        String sql = "insert into tab_user(username,password,userphone,email) values(?,?,?,?)";
        template.update(sql, user.getUsername(), user.getPassword(), user.getUserphone(), user.getEmail());
    }

    public User login(User loginUser) {

        try {
            //编写SQL
            String sql = "select * from tab_user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
