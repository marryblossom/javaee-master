<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title></title>
</head>
<body>
<a type="button" href="/web">main</a>
  <%Cookie[] cookies = request.getCookies();
    if (cookies!=null&&cookies.length > 1){%>
        <a type="button" href="/web/userLogin/logout">logout</a>
    <%} else{%>
        <a type="button" href="/web/userLogin/goToLogin">login</a>
    <%}%>
</body>
</html>
