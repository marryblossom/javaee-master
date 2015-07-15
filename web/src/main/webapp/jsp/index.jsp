<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="/jsp/head.jsp"/>
<form action="insert" method="post">
    <table>
        <tr>
            <td align="center">username：</td>
            <td align="center">password：</td>
            <td align="center">gender：</td>
            <td align="center">email：</td>
            <td align="center">age：</td>
            <td></td>
        </tr>
        <tr>
            <td><input type="text" name="name"/></td>
            <td><input type="text" name="password"/></td>
            <td><input type="radio" name="gender" value="male" /> male
                <input type="radio" name="gender" value="female" /> female</td>
            <td><input type="text" name="email" /></td>
            <td><input type="text" name="age" /></td>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>


</form>
<table>
    <tr>
        <td align="center">username：</td>
        <td align="center">gender：</td>
        <td align="center">email：</td>
        <td align="center">age：</td>
        <td></td>
    </tr>
    <c:forEach items="${people}" var="item" varStatus="status">
        <tr>
            <td width="50px" align="center"><c:out value="${item.name}"/></td>
            <td width="30px" align="center"><c:out value="${item.gender}"/></td>
            <td width="30px" align="center"><c:out value="${item.email}"/></td>
            <td width="30px" align="center"><c:out value="${item.age}"/></td>
            <td width="30px" align="center"><a type="button" href="/web/delete?id=<c:out value="${item.id}"/>">delete</a></td>
            <td width="30px" align="center"><a type="button" href="/web/goToUpdate?id=<c:out value="${item.id}"/>">update</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
