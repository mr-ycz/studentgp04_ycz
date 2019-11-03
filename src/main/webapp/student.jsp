<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>学生界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js">
    </script>
</head>
<body>

    <table align="center" border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>入学时间</td>
            <td>班级编号</td>
            <shiro:hasRole name="teacher">
                <td>
                    <a href="${pageContext.request.contextPath}/claz/addStu?id=${id}">增加学生</a>
                </td>
            </shiro:hasRole>
        </tr>
        <c:forEach items="${stus.list}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.username}</td>
                <td>${s.gender}</td>
                <td>
                    <fmt:formatDate value="${s.registTime}" pattern="yyyy-MM-dd" />
                </td>
                <td>${s.clazId}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/claz/updStu?id=${s.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div align="center">
        <%--首页，直接将pageNum设置为1然传入Servlet(userlist)中用来更新分页查询信息--%>
        <a href="${pageContext.request.contextPath}/claz/queryStu?id=${id}&pageNum=1&pageSize=10">首页</a>
        <a href="${pageContext.request.contextPath}/claz/queryStu?id=${id}&pageNum=${stus.prePage}">上一页</a>
            <c:forEach begin="1" end="${stus.pages}" varStatus="i">
                <a href="${pageContext.request.contextPath}/claz/queryStu?id=${id}&pageNum=${i.count}">${i.count}</a>
            </c:forEach>
        <a href="${pageContext.request.contextPath}/claz/queryStu?id=${id}&pageNum=${stus.nextPage}">下一页</a>
        <a href="${pageContext.request.contextPath}/claz/queryStu?id=${id}&pageNum=${stus.pages}">尾页</a>
    </div>
    <div align="center">你当前在第${stus.pageNum}页,共${stus.total}条数据,共${stus.pages}页</div>

</body>
</html>
