<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加班级界面</title>
</head>
<body>
<div align="center">
    <form method="post" action="${pageContext.request.contextPath}/claz/addClaz">
        班级名:<input type="text" name="clazname" /> <br>
        创建时间:<input type="date" name="time" /> <br>
        <input type="submit" value="注册" />
    </form>
</div>
</body>
</html>
