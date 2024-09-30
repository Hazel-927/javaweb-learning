<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>响应不同类型的文件</title>
    <script>
        /*
        分析：点击超链接或者图⽚，需要换⼀张
        1.给超链接和图⽚绑定单击事件
        2.重新设置图⽚的src属性值
        */
        window.onload = function () {
            //1.获取图⽚对象
            const img = document.getElementById("checkCode");
            //2.绑定单击事件
            img.onclick = function () {
                //加时间戳避免缓存
                const date = new Date().getTime();
                img.src = "/verifyCodeServlet?" + date;
            }
        }
    </script>
    <style>
        ul li {
            list-style: none;
            float: left;
            margin-top: 40px;
        }

        ul li a {
            padding: 20px 50px;
            height: 40px;
            background-color: antiquewhite;
            color: black;
            box-sizing: border-box;
            margin-right: 10px;
            font-size: 16px;
            text-decoration: none;
        }

        ul li a:hover {
            background-color: gold;
        }

        .downloadLink {
            padding: 20px 50px;
            height: 40px;
            background-color: chartreuse;
            color: black;
            box-sizing: border-box;
            margin-right: 10px;
            font-size: 16px;
            text-decoration: none;
        }

        .downloadLink:hover {
            background-color: pink;
        }
    </style>
</head>
<body>
<h1>
    <%="设置 Contnet-Type不同类型的资源"%>>
</h1>
<h2>
    <%="根据不同参数类型返回不同的资源"%>
</h2>
<br/>
<ul>
    <li>
        <a href="res?type=image">返回图片</a>
    </li>
    <li>
        <a href="res?type=pdf">返回pdf</a>
    </li>
    <li>
        <a href="res?type=txt">返回文档</a>
    </li>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <li>
        <img id="checkCode" src="/verifyCode" alt="img"/>
        <a id="change" href="">看不清换⼀张？</a>
    </li>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <li>
        <a href="download?filename=a.txt" class="downloadLink">下载文件</a>
    </li>
    <li>
        <a href="download?filename=image.png" class="downloadLink">下载壁纸</a>
    </li>
</ul>
</body>
</html>