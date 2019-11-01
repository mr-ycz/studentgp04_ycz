<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js">
    </script>
</head>
<body>

    <div align="center">
        <form method="post" action="${pageContext.request.contextPath}/user/regist">
            用户名:<input type="text" name="username" /> <br>
            密码:<input type="password" name="password" /> <br>
            性别:<input type="radio" name="gender" value="男" checked="checked" />男
            <input type="radio" name="gender" value="女" />女 <br>
            身份:<input type="radio" name="sta" value="老师" checked="checked" />老师
            <input type="radio" name="sta" value="学生" />学生 <br>
            <input type="submit" value="注册" />
        </form>
    </div>

</body>
</html>
