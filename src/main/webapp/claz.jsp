<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>班级界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js">
    </script>
</head>
<body>
    <table align="center" border="1">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>创建时间</td>
            <shiro:hasRole name="teacher">
                <td>操作</td>
                <td>
                    <a href="${pageContext.request.contextPath}/claz/addClaz">增加班级</a>
                </td>
            </shiro:hasRole>
        </tr>
        <c:forEach items="${clazs}" var="claz">
            <tr>
                <td>${claz.id}</td>
                <td>${claz.clazname}</td>
                <td>
                    <fmt:formatDate value="${claz.createTime}" pattern="yyyy-MM-dd" />
                </td>
                <shiro:hasRole name="teacher">
                    <td>
                        <a href="${pageContext.request.contextPath}/claz/queryStu?id=${claz.id}">查看学生</a>
                    </td>
                </shiro:hasRole>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
