<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src=".././lib/js/jquery-1.11.1.min.js"></script>
<link href=".././lib/css/bootstrap.css" rel="stylesheet"/>
<script src=".././lib/js/bootstrap-table.js"></script>
<link href=".././calendar/styles/glDatePicker.default.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href=".././lib/css/bootstrap-table.css">
<script src=".././lib/js/bootstrap.min.js"></script>
<head>
  <title></title>
</head>
<body>
<jsp:include page="/jsp/head.jsp"/>
<div>
<form action="addSchema" method="post">
  <table>
    <tr>
      <td width="50px" align="center">课程</td>
      <td width="50px" align="center">教练</td>
      <td width="90px" align="center">时间</td>
      <td width="50px" align="center"></td>
      <td width="50px" align="center"></td>
    </tr>
    <tr>
      <td align="center">
        <select name="courseId">
          <c:forEach items="${courses}" var="course" varStatus="status">
          <option value ="<c:out value="${course.courseId}"/>"><c:out value="${course.name}"/></option>
          </c:forEach>
        </select>
      </td>
      <td align="center">
        <select name="coachId">
          <c:forEach items="${employees}" var="employee" varStatus="status">
          <option value ="<c:out value="${employee.emloyeeId}"/>"><c:out value="${employee.employeeName}"/></option>
          </c:forEach>
          </select>
      </td>
      <td align="center">
        <input type="text" id="example" name="date"/>
      </td>
      <td align="center">
        <input type="submit" value="Submit" />
      </td>
      <td width="50px" align="center"></td>
    </tr>
  </table>
</form>
  <a type="button" href="/web/schemaOperate/schemaPrivateShow">private</a>
  </div>
<div>
  <table data-toggle="table"  data-striped="true">
    <tr>
      <td align="center" data-field="name">课程名称</td>
      <td align="center">负责教练</td>
      <td align="center">课程时间安排</td>
      <td align="center">课程状态</td>
      <td align="center">课程类型</td>
      <td></td>
      <td></td>
    </tr>
    <c:forEach items="${schemas}" var="item" varStatus="status">
      <tr>
        <td width="50px" align="center"><c:out value="${item.course.name}"/></td>
        <td width="30px" align="center"><c:out value="${item.employee.employeeName}"/></td>
        <td width="30px" align="center"><c:out value="${item.date}"/></td>
        <td width="30px" align="center"><c:out value="${item.state}"/></td>
        <td width="30px" align="center"><c:out value="${item.type}"/></td>
        <td width="50px" align="center"><a type="button" href="/web/schemaOperate/deleteSchema?schemasId=<c:out value="${item.schemaId}"/>">delete</a></td>
          <td width="50px" align="center"><a type="button" href="/web/schemaOperate/goToSchemaUpdate?schemasId=<c:out value="${item.schemaId}"/>">update</a></td>
      </tr>
    </c:forEach>
  </table>
</div>

<script src=".././calendar/glDatePicker.min.js"></script>
<script type="text/javascript">
  $(window).load(function()
  {
    $('#example').glDatePicker();
  });
</script>
</body>
</html>
