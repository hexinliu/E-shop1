package cn.edu.whale.test;

import cn.edu.whale.dao.UserDao;
import cn.edu.whale.dao.impl.UserDaoImpl;
import cn.edu.whale.domain.User;
import cn.edu.whale.service.UserService;
import cn.edu.whale.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 14:45 2019/11/3
 * @Modified By：
 */
public class UserRegisterTest {

    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("123456");
        user.setUserphone("12345678910");
        user.setEmail("123@qq.com");

        UserService service = new UserServiceImpl();
        boolean flag = service.register(user);
        System.out.println(flag);
    }
}
