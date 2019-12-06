package cn.edu.whale.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 16:36 2019/11/3
 * @Modified By：
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 100;
        int height = 50;
        //1.创建一个对象，能在内存中代表一个图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.green);//设置画笔颜色
        g.fillRect(0, 0, width, height);//填充背景色
        //2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, width - 1, height - 1);
        //2.3写验证码

        String str = "QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm0123456789";
        Random random = new Random();
        StringBuffer randomCode = new StringBuffer();

        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);
            randomCode.append(ch);
            g.setFont(new Font("黑体", Font.BOLD, 24));
            g.drawString(ch + "", width / 5 * i, height / 2);
        }
        //画干扰线
        g.setColor(Color.red);

        //随机生成坐标点

        for (int i = 1; i <= 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        request.getSession().setAttribute("checkcode_server", randomCode.toString());


        //3.将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
