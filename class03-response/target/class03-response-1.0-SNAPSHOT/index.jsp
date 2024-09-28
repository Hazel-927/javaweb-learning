<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>响应不同类型的文件</title>
  <style>
    ul li {
      list-style: none;
      float: left;
      margin-top: 40px;
    }

    ul li a{
      padding: 20px 50px;
      height: 40px;
      background-color: antiquewhite;
      color: black;
      box-sizing: border-box;
      margin-right: 10px;
      font-size: 16px;
      text-decoration: none;
    }

    ul li a:hover{
      background-color: antiquewhite;
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

</ul>
</body>
</html>