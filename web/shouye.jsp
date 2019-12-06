<%--
  Created by IntelliJ IDEA.
  User: 馨
  Date: 2019/12/1
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>电商</title>
    <link rel="stylesheet" type="text/css" href="css/standard.css">
    <script type="text/javascript" src="js/jquery-1.11.min.js"></script>
    <script type="text/javascript" src="js/etao.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
    <link href="css/cart.css" media="screen" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap.min.css" media="screen" rel="stylesheet" type="text/css"/>
</head>
<body class="mr-content">
<div class="con-up">
    <div class="logo">
        <img src="img/小组logo.png" alt="小组logo" class="logo-img">
    </div>
    <div class="hengdaohang">
        <div class="hengdaohang-item" onclick="liedaohangchange(0)"> 首页</div>
        <div class="hengdaohang-item" onclick="liedaohangchange(6)">收货地址</div>
        <div class="hengdaohang-item" onclick="liedaohangchange(7)">个人资料</div>
        <div class="hengdaohang-item" onclick="liedaohangchange(8)">修改密码</div>
    </div>

</div>
<div class="con-down">
    <div class="down-left">
        <div class="left-xinxi">
            <img src="img/头像.jpg" alt="头像" class="xinxi-touxiang">
            <div class="xinxi-name">梦醒的地方、</div>
        </div>
        <ul class="liedaohang">
            <li onclick="liedaohangchange(0)">我的订单</li>
            <li onclick="liedaohangchange(1);show()">我的购物车</li>
            <li onclick="liedaohangchange(2)">我的收藏</li>
            <li onclick="liedaohangchange(3)">我的积分</li>
            <li onclick="liedaohangchange(4)">退款维权</li>
            <li onclick="liedaohangchange(5)">我的足迹</li>
            <li onclick="liedaohangchange()">返回首页</li>
        </ul>
    </div>


    <!-- 订单界面 -->
    <div class="down-right" id="dingdan" style="display:block; background-color:white">
        首页订单界面
    </div>
    <!-- 购物车界面 -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="down-right" id="gouwuche" style="display:none; background-color: white">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">商品ID</label>
                <input type="text" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">购物车ID</label>
                <input type="email" class="form-control" id="exampleInputEmail2" >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th><input type="checkbox"></th>
                <th>编号</th>
                <th>商品ID</th>
                <th>购物车ID</th>
                <th>商品数量</th>
                <th>加入时间</th>
                <th>是否删除状态</th>
                <th>最终价格</th>
            </tr>
            <c:forEach items="${shopcart}" var="sc" varStatus="s">
                <!-- varStatus:循环状态对象
                .index:容器中元素的索引，从0开始
                .count:循环次数，从1开始-->
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${s.count}</td>
                    <td>${sc.gid}</td>
                    <td>${sc.scid}</td>
                    <td>${sc.g_num}</td>
                    <td>${sc.gi_time}</td>
                    <td>${sc.state}</td>
                    <td>${sc.final_pay}</td>
                </tr>
            </c:forEach>
            </thead>
        </table>
        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <span style="font-size: 20px;margin-left: 10px" >
                        共16条记录，共4页
                    </span>
                </ul>
            </nav>
        </div>
    </div>
    <!-- 收藏界面 -->
    <div class="down-right" id="shoucang" style="display:none; background-color: cyan">
        收藏界面
    </div>
    <!-- 积分界面 -->
    <div class="down-right" id="jifen" style="display:none; background-color: darkolivegreen">
        积分界面
    </div>
    <!-- 退款维权界面 -->
    <div class="down-right" id="tuikuan" style="display:none; background-color: darkslategray">
        退款维权界面
    </div>
    <!-- 我的足迹界面 -->
    <div class="down-right" id="zuji" style="display:none; background-color: green">
        我的足迹界面
    </div>


    <!-- 收货地址 -->
    <div class="down-right" id="shouhuodizhi" style="display:none; background-color: violet">
        收货地址
    </div>
    <!-- 个人资料界面 -->
    <div class="down-right" id="gerenziliao" style="display:none; background-color: blue">
        个人资料界面
    </div>
    <!-- 修改密码界面 -->
    <div class="down-right" id="xiugaimima" style="display:none; background-color: goldenrod">
        修改密码界面
    </div>


</div>

</body>


<!-- 导航切换代码 -->
<script>
    var item0 = document.getElementById('dingdan');
    var item1 = document.getElementById('gouwuche');
    var item2 = document.getElementById('shoucang');
    var item3 = document.getElementById('jifen');
    var item4 = document.getElementById('tuikuan');
    var item5 = document.getElementById('zuji');
    var item6 = document.getElementById('shouhuodizhi');
    var item7 = document.getElementById('gerenziliao');
    var item8 = document.getElementById('xiugaimima');
    var arr0 = new Array();
    arr0[0] = dingdan;
    arr0[1] = gouwuche;
    arr0[2] = shoucang;
    arr0[3] = jifen;
    arr0[4] = tuikuan;
    arr0[5] = zuji;
    arr0[6] = shouhuodizhi;
    arr0[7] = gerenziliao;
    arr0[8] = xiugaimima;

    function liedaohangchange(n) {
        console.log(arr0.length)
        var j;
        for (j = 0; j < arr0.length; j++) {
            if (j == n) {
                arr0[j].style.display = "block";
            } else {
                arr0[j].style.display = "none";
            }
        }
    }
</script>

<script type="text/javascript">
    function deleteShopCart(id) {
        if (confirm("您确定要删除吗？")){
            location.href="${pageContext.request.contextPath}/delShopCartServlet?id="+id;
        }
    }
</script>
<script type="text/javascript">
    function show() {
        location.href="${pageContext.request.contextPath}/FindShopCartByPageServlet";
    }
</script>
</html>
