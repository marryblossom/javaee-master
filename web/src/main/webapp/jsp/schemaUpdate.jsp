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
  <script src=".././lib/js/jquery-1.11.1.min.js"></script>
  <link href=".././lib/css/bootstrap.css" rel="stylesheet"/>
  <link href=".././calendar/styles/glDatePicker.default.css" rel="stylesheet" type="text/css">
  <script src=".././lib/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="/jsp/head.jsp"/>


<form action="schemaUpdate" method="post">
  <table>
    <tr>
      <td width="50px" align="center">课程</td>
      <td width="90px" align="center">教练</td>
      <td width="50px" align="center">时间</td>
      <td width="50px" align="center"></td>
    </tr>
<c:forEach items="${schemas}" var="item" varStatus="status">
    <tr>
      <td width="50px" align="center" hidden><input name="schemaId" type="text" value="<c:out value="${item.schemaId}"/>"/></td>
      <td width="50px" align="center" ><c:out value="${item.course.name}"/></td>
      <td width="50px" align="center"><c:out value="${item.employee.employeeName}"/></td>
      <td width="50px" align="center"><input type="text" id="example" name="date" value="<c:out value="${item.date}"/>"/></td>
      <td width="50px" align="center"><input type="submit" value="update" /></td>
    </tr>
  </c:forEach>
  </table>
</form>
<script src=".././calendar/glDatePicker.min.js"></script>
<script type="text/javascript">
  $(window).load(function()
  {
    $('#example').glDatePicker();
  });
</script>
</body>
</html>
