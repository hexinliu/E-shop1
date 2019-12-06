package cn.edu.whale.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.whale.dao.UserDao;
import cn.edu.whale.dao.impl.UserDaoImpl;
import cn.edu.whale.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 16:54 2019/11/6
 * @Modified By：
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User loginuser = new User();
        try {
            BeanUtils.populate(loginuser, map);     //注意是Apache commons下的BeanUtils
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserDao的login方法
        UserDao dao = new UserDaoImpl();
        User user = dao.login(loginuser);

        //判断user
        if (user == null) {
            //System.out.println("登录失败");
            request.getRequestDispatcher("/FailServlet").forward(request, response);
        } else {
            //System.out.println("登录成功");
            //存储数据，以显示欢迎某某某
            request.setAttribute("user", user);
            request.getRequestDispatcher("/SuccessServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
