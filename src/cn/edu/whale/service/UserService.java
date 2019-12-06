package cn.edu.whale.service;

import cn.edu.whale.domain.User;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 17:36 2019/11/2
 * @Modified By：
 */
public interface UserService {
    //注册用户
    boolean register(User user);
}
