<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<html>
<spring:url value="/lib/css/header.css" var="headerCss" />
<link href="${headerCss}" rel="stylesheet">
<spring:url value="/lib/css/base.css" var="baseCss" />
<link href="${baseCss}" rel="stylesheet">
<div class="header-panel">
    <div class="header-container">
        <div class="navbar-list">
            <nav class="navlist">
                <ul>
                    <li><a class="header-a" type="button" href="/web">主页</a></li>
                    <li><a class="header-a" href="/web/userOperate">雇员管理</a></li>
                    <li><a class="header-a" href="/web/courseOperate">课程管理</a></li>
                    <li><a class="header-a" href="/web/schemaOperate">课表管理</a></li>
                    <li><a class="header-a" href="/web/customerOperate">客户管理</a></li>
                </ul>
            </nav>
        </div>
        <div class="navlist-login">
            <nav class="login-reminder">
                <ul>
                    <li><%if (request.getSession().getAttribute("userLogin") != null){%>
                        <a class="header-login-a" type="button" href="/web/userLogin/logout">logout</a>
                        <%} else{%>
                        <a class="header-login-a" type="button" href="/web/userLogin/goToLogin">login</a>
                        <%}%>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</html>
