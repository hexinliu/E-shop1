<%--
  Created by IntelliJ IDEA.
  User: 馨
  Date: 2019/10/31
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            //发送AJAX请求，加载所有省份数据
            $.get("ProvinceServlet",{},function(data){
               //1.获取select
               var province = $("#province");
               //2.遍历json数组
                $(data).each(function () {
                    //3.创建<option>
                    var option = "<option id='"+this.id+"'>"+this.name+"</option>"
                    //4.调用select的append追加<option>
                    province.append(option);
                })
            });
        });
    </script>
</head>
<body>
    <select id="province">
        <option>--请选择城市--</option>
    </select>
</body>
</html>
