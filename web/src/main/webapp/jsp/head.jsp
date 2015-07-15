<%--
  Created by IntelliJ IDEA.
  User: marry
  Date: 7/13/15
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title></title>
</head>
<body>

<%--<a type="button" href="/web/goToUpdatePassword?id=<c:out valuel="${item.id}"/>">exchange</a>--%>

  <%Cookie[] cookies = request.getCookies();
    if (cookies.length > 1){%>
        <a type="button" href="/web/logout">logout</a>
    <%} else{%>
        <a type="button" href="/web/goToLogin">login</a>
    <%}%>
<%--<%String cookie = (String)request.getAttribute("personIdInCookie");--%>
  <%--if (!(cookie.equals(""))){%>--%>
<%--<a type="button" href="/web/logout">logout</a>--%>
<%--<%} else{%>--%>
<%--<a type="button" href="/web/goToLogin">login</a>--%>
<%--<%}%>--%>

</body>
</html>
