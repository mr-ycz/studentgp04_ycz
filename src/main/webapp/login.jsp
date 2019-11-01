<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js">
    </script>
</head>
<body>

    <div align="center">
        <form id="form_log" method="post">
            用户名:<input type="text" name="username" /> <br><br>
            密码:<input type="password" name="password" /> <br><br>
            验证码:<img id="sercode" src="${pageContext.request.contextPath}/user/getCode" onclick="changecode(this)" />
                    <input type="text" id="code" name="capt" /><span id="checkMsg"></span><br><br>
            <input type="button" id="sub" value="登录" />
        </form>
    </div>


    <script type="text/javascript">
        var code=0;

        $(function(){
            // 输入的验证码 是否正确
            $("#code").blur(function(){
                if (this.value==null||this.value.trim().length==0) {
                    $("#checkMsg").html("验证码不能为空").css("color","red");
                    return;
                }
                $.post("${pageContext.request.contextPath}/user/checkCode","code="+this.value,function(data){
                    if(data=="0"){
                        $("#checkMsg").html("<font color='green'>OK</font>");
                        code=1;
                    }else if (data!="0") {
                        $("#checkMsg").html("<font color='red'>ERROR</font>");
                        $("#sercode").attr("src","${pageContext.request.contextPath}/user/getCode?num="+Math.random());
                    }
                })
            });

            //表单提交
            $("#sub").click(function () {
                if (code){
                    $.post("${pageContext.request.contextPath}/user/login",$("#form_log").serialize(),function(data){
                        if(data=="1"){
                            alert("登录成功");
                            location.href="${pageContext.request.contextPath}/claz/queryAll";
                        }else {
                            <%--$("#msg").html("${msg}");--%>
                            alert("用户名或密码错误");
                        }
                    })
                }else {
                    alert("请验证表单内容是否填写正确!");
                }
            })
        })

        function changecode(obj) {
            obj.src="${pageContext.request.contextPath}/user/getCode?num="+Math.random();
        }
    </script>
</body>
</html>
