<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title></title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-collapse collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li><a href="/web/userOperate">雇员管理</a></li>
                <li><a href="/web/courseOperate">课程管理</a></li>
                <li><a href="/web/schemaOperate">课表管理</a></li>
                <li><a href="/web/customerOperate">客户管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <li><a type="button" href="/web">main</a></li>
                <li><%Cookie[] cookies = request.getCookies();
                    if (cookies!=null&&cookies.length > 1){%>
                    <a type="button" href="/web/userLogin/logout">logout</a>
                    <%} else{%>
                    <a type="button" href="/web/userLogin/goToLogin">login</a>
                    <%}%></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
