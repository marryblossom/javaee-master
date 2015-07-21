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


<form action="updateCustomer" method="post">
  <table>
    <tr>
      <td width="50px" align="center">客户</td>
      <td width="90px" align="center">简介</td>
      <td width="50px" align="center">状态</td>
      <td width="50px" align="center"></td>
    </tr>

    <tr>

      <td width="50px" align="center" hidden><input name="customerId" type="text" value="<c:out value="${customer.customerId}"/>"/></td>
      <td width="50px" align="center"><input name="name" type="text" value="<c:out value="${customer.name}"/>"/></td>
      <td width="50px" align="center"><input name="introduction" type="text" value="<c:out value="${customer.introduction}"/>"/></td>
      <td width="50px" align="center"><c:out value="${customer.state}"/><br />
      <td><input type="submit" value="Submit" /></td>
    </tr>
  </table>
</form>
</body>
</html>
