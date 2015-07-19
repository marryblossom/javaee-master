<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<jsp:include page="/jsp/head.jsp"/>
<form action="addUserAndEmployee" method="post">
  <table>
    <tr>
      <td align="center">姓名：</td>
      <td align="center">用户名：</td>
      <td align="center">密码：</td>
      <td align="center">性别：</td>
      <td align="center">邮箱：</td>
      <td align="center">简介：</td>
      <td></td>
    </tr>
    <tr>
      <td><input type="text" name="username"/></td>
      <td><input type="text" name="employeename"/></td>
      <td><input type="text" name="password"/></td>
      <td><input type="radio" name="gender" value="male" /> male
        <input type="radio" name="gender" value="female" /> female</td>
      <td><input type="text" name="email" /></td>
      <td><input type="text" name="introduction" /></td>
      <td><input type="submit" value="Submit" /></td>
    </tr>
  </table>


</form>
<table>
  <tr>
    <td align="center">姓名：</td>
    <td align="center">用户名：</td>
    <td align="center">性别：</td>
    <td align="center">邮箱：</td>
    <td align="center">简介：</td>
    <td align="center">用户状态：</td>
    <td></td>
    <td></td>
  </tr>
  <c:forEach items="${users}" var="item" varStatus="status">
    <tr>
      <td width="50px" align="center"><c:out value="${item.userName}"/></td>
      <td width="30px" align="center"><c:out value="${item.employee.employeeName}"/></td>
      <td width="30px" align="center"><c:out value="${item.employee.gender}"/></td>
      <td width="30px" align="center"><c:out value="${item.employee.email}"/></td>
      <td width="30px" align="center"><c:out value="${item.employee.introduction}"/></td>
      <td width="30px" align="center"><c:out value="${item.state}"/></td>
      <td width="30px" align="center"><a type="button" href="/web/userOperate/delete?userId=<c:out value="${item.userId}"/>">delete</a></td>
      <td width="30px" align="center"><a type="button" href="/web/userOperate/goToUpdate?userId=<c:out value="${item.userId}"/>">update</a></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
