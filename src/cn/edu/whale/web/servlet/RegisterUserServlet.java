package cn.edu.whale.web.servlet;

import cn.edu.whale.domain.ResultInfo;
import cn.edu.whale.domain.User;
import cn.edu.whale.service.UserService;
import cn.edu.whale.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 17:36 2019/11/2
 * @Modified By：
 */
@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {

    static int i = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先判断验证码是否正确，验证码正确，再做下面所有操作，验证码不正确，下面所有动作不必做
        String checkCode = request.getParameter("checkCode");
        //从session中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("checkcode_server");
        session.removeAttribute("checkcode_server");
        //比较
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(checkCode)) {
            //验证码错误，返回错误信息
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误！");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getOutputStream().write(json.getBytes());
            return;
        }

        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        User user = new User();
        BeanUtils beanUtils = new BeanUtils();
        try {
            beanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service完成注册
        UserService service = new UserServiceImpl();
        boolean flag = service.register(user);
        //响应结果
        ResultInfo info = new ResultInfo();
        if (flag == true) {
            //注册成功
            info.setFlag(true);
            System.out.println(info);
        } else {
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败！用户名已存在");
        }
        /*将info对象序列化为json，并写回客户端*/
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getOutputStream().write(json.getBytes());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
