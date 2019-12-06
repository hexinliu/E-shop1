package cn.edu.whale.service.impl;

import cn.edu.whale.dao.UserDao;
import cn.edu.whale.dao.impl.UserDaoImpl;
import cn.edu.whale.domain.User;
import cn.edu.whale.service.UserService;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 17:37 2019/11/2
 * @Modified By：
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    //注册用户
    @Override
    public boolean register(User user) {
        //根据用户名查询用户对象，如果用户对象存在，返回false
        User u = dao.findByUsername(user.getUsername());
        //判断u是否等于null
        if (u != null) {
            //用户名存在，注册失败
            return false;
        }
        //保存用户信息
        dao.save(user);
        return true;
    }
}
