package cn.edu.whale.web.servlet;

import cn.edu.whale.domain.PageBean;
import cn.edu.whale.domain.ShopCartItem;
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
 * @Date: Created in 23:09 2019/12/3
 * @Modified By：
 */
@WebServlet("/FindShopCartByPageServlet")
public class FindShopCartByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//获取当前页码
        String rows = request.getParameter("rows");//获取每页显示的条数

        if (currentPage == null || currentPage.equals(""))
        {
            currentPage = "1";
        }
        if (rows == null || rows.equals(""))
        {
            rows = "5";
        }
        //2.调用service查询
        ShopCartService service = new ShopCartServiceImpl();
        PageBean<ShopCartItem> pb = service.findShopCartByPage(currentPage,rows);

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        //转发到list.jsp页面
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
