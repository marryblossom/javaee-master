<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: marry
  Date: 7/7/15
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title></title>

</head>
<body>
<jsp:include page="/jsp/head.jsp"/>


<form action="update" method="post">
<table>
    <tr>
        <td width="50px" align="center">姓名</td>
        <td width="90px" align="center">性别</td>
        <td width="50px" align="center">邮箱</td>
        <td width="50px" align="center">简介</td>
        <td width="50px" align="center"></td>
    </tr>

    <tr>

        <td width="50px" align="center" hidden><input name="userId" type="text" value="<c:out value="${user.userId}"/>"/></td>
        <td width="50px" align="center"><input name="employeeName" type="text" value="<c:out value="${user.employee.employeeName}"/>"/></td>
        <td width="50px" align="center"><c:out value="${user.employee.gender}"/><br />
            <%--<%if ${user.employee.gender}.equals("male")){%>--%>
                <%--<input type="radio" name="gender" value="male" checked/> male--%>
                <%--<input type="radio" name="gender" value="female" /> female--%>
            <%--<%} else{%>--%>
                <input type="radio" name="gender" value="male" /> male
                <input type="radio" name="gender" value="female" checked/> female
            <%--<%}%>--%>
        </td>
        <td width="50px" align="center"><input name="email" value="<c:out value="${user.employee.email}"/>"/></td>
        <td width="50px" align="center"><input name="introduction" value="<c:out value="${user.employee.introduction}"/>"/></td>
        <td><input type="submit" value="Submit" /></td>
        </tr>
</table>
</form>
</body>
</html>
