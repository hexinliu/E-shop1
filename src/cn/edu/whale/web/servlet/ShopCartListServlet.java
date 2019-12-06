package cn.edu.whale.web.servlet;

import cn.edu.whale.domain.ShopCart;
import cn.edu.whale.domain.ShopCartItem;
import cn.edu.whale.service.ShopCartService;
import cn.edu.whale.service.impl.ShopCartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 12:41 2019/12/3
 * @Modified By：
 */
@WebServlet("/ShopCartListServlet")
public class ShopCartListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用ShopCartService完成查询
        ShopCartService service = new ShopCartServiceImpl();
        List<ShopCartItem> shopCartItems = service.findAll();
        //将List存入request域
        request.setAttribute("shopcart",shopCartItems);
        //转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
