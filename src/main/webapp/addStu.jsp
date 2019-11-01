<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>添加学生界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js">
    </script>
</head>
<body>
<div align="center">
    <table border="1" align="center">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>入学时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${stus}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.username}</td>
                <td>${s.gender}</td>
                <td>
                    <fmt:formatDate value="${s.registTime}" pattern="yyyy-MM-dd" />
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/claz/addStudent?stuId=${s.id}&clazId=${id}">添加</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
