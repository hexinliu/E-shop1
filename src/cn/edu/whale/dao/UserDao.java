package cn.edu.whale.dao;

import cn.edu.whale.domain.User;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 17:39 2019/11/2
 * @Modified By：
 */
public interface UserDao {
    //根据用户名查询用户信息
    public User findByUsername(String username);

    //
    public void save(User user);

    //
    public User login(User loginUser);

}
