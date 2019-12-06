package cn.edu.whale.web.servlet;

import cn.edu.whale.service.ShopCartService;
import cn.edu.whale.service.impl.ShopCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 16:15 2019/12/3
 * @Modified By：
 */
@WebServlet("/delSelectedServlet")
public class delSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有id
        String[] dids = request.getParameterValues("did");
        //调用service删除
        ShopCartService service = new ShopCartServiceImpl();
        service.delSelected(dids);
        //跳转到查询所有的servlet
        response.sendRedirect(request.getContextPath()+"/ShopCartListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
