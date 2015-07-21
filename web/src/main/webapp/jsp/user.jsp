<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src=".././lib/js/jquery-1.11.1.min.js"></script>
<link href=".././lib/css/bootstrap.css" rel="stylesheet"/>
<script src=".././lib/js/bootstrap.js"></script>
<script src=".././lib/js/bootstrap-table.js"></script>
<link href=".././calendar/styles/glDatePicker.default.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href=".././lib/css/bootstrap-table.css">
<script src=".././lib/js/bootstrap.min.js"></script>
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
<table data-toggle="table" data-url="data.json" data-striped="true" data-page-size=3 data-smart-display="true "data-search="true">
  <tr>
    <td align="center">姓名</td>
    <td align="center">用户名</td>
    <td align="center">性别</td>
    <td align="center">邮箱</td>
    <td align="center">简介</td>
    <td align="center">状态</td>
    <td align="center">职位</td>
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
      <td width="30px" align="center"><c:out value="${item.employee.state}"/></td>
      <td width="30px" align="center"><c:out value="${item.employee.type}"/></td>
      <td width="30px" align="center"><a type="button" href="/web/userOperate/delete?userId=<c:out value="${item.userId}"/>">delete</a></td>
      <td width="30px" align="center"><a type="button" href="/web/userOperate/goToUpdate?userId=<c:out value="${item.userId}"/>">update</a></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
