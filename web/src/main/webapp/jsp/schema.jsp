<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<script src=".././lib/js/jquery-1.11.1.min.js"></script>--%>
<%--<link href=".././calendar/styles/glDatePicker.default.css" rel="stylesheet" type="text/css">--%>
<%--<spring:url value="/lib/css/user.css" var="userCss" />--%>
<%--<link href="${userCss}" rel="stylesheet">--%>
<%--<spring:url value="/lib/css/table.css" var="tableCss" />--%>
<%--<link href="${tableCss}" rel="stylesheet">--%>
<%--<head>--%>
  <%--<title></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="/jsp/head.jsp"/>--%>
<%--<div class="insert-input">--%>
  <%--<div class="user-container">--%>
    <%--<div class="user-insert-input">--%>
      <%--<form action="addSchema" method="post">--%>
        <%--<ul class="user-input-info">--%>
          <%--<li>--%>
            <%--<i>课程：</i>--%>
            <%--<span>--%>
              <%--<select name="courseId">--%>
                 <%--<c:forEach items="${courses}" var="course" varStatus="status">--%>
                      <%--<option value ="<c:out value="${course.courseId}"/>"><c:out value="${course.name}"/></option>--%>
                  <%--</c:forEach>--%>
              <%--</select>--%>
             <%--</span>--%>
          <%--</li>--%>
          <%--<li>--%>
            <%--<i>教练：</i>--%>
            <%--<span>--%>
              <%--<select name="coachId">--%>
                <%--<c:forEach items="${employees}" var="employee" varStatus="status">--%>
                  <%--<option value ="<c:out value="${employee.emloyeeId}"/>"><c:out value="${employee.employeeName}"/></option>--%>
                <%--</c:forEach>--%>
              <%--</select>--%>
            <%--</span>--%>
          <%--</li>--%>
          <%--<li>--%>
            <%--<i>时间：</i><span><input id="example" class="input-insert" type="text" name="date"/></span>--%>
          <%--</li>--%>
          <%--<span><input class="input-button" type="submit" value="Submit" /></span>--%>
        <%--</ul>--%>
      <%--</form>--%>
    <%--</div>--%>
  <%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="data-show">--%>
  <%--<p class="check-list">近期课程安排--%>
    <%--<a type="button" href="/web/schemaOperate/schemaPrivateShow">private</a>--%>
  <%--</p>--%>

  <%--<div class="table">--%>
    <%--<div class="table-container">--%>
      <%--<div class="table-title">--%>
        <%--<div class="table-header-inner">--%>
          <%--<table class="table-header">--%>
            <%--<thead>--%>
            <%--<tr>--%>
              <%--<th>--%>
                <%--<div class="th-inner">课程名称</div>--%>
              <%--</th>--%>
              <%--<th>--%>
                <%--<div class="th-inner">负责教练</div>--%>
              <%--</th>--%>
              <%--<th>--%>
                <%--<div class="th-inner">课程时间安排</div>--%>
              <%--</th>--%>
              <%--<th>--%>
                <%--<div class="th-inner">课程状态</div>--%>
              <%--</th>--%>
              <%--<th>--%>
                <%--<div class="th-inner">课程类型</div>--%>
              <%--</th>--%>
              <%--<th>--%>
                <%--<div class="th-inner"></div>--%>
              <%--</th>--%>
              <%--<th>--%>
                <%--<div class="th-inner"></div>--%>
              <%--</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
          <%--</table>--%>
        <%--</div>--%>
        <%--<div class="table-body-inner">--%>
          <%--<table class="table-body">--%>
            <%--<c:forEach items="${schemas}" var="item" varStatus="status">--%>
              <%--<tr>--%>
                <%--<td width="50px" align="center"> <div class="th-inner"><c:out value="${item.course.name}"/></div></td>--%>
                <%--<td width="30px" align="center"><div class="th-inner"><c:out value="${item.employee.employeeName}"/></div></td>--%>
                <%--<td width="30px" align="center"><div class="th-inner"><c:out value="${item.date}"/></div></td>--%>
                <%--<td width="30px" align="center"><div class="th-inner"><c:out value="${item.state}"/></div></td>--%>
                <%--<td width="30px" align="center"><div class="th-inner"><c:out value="${item.type}"/></div></td>--%>
                <%--<td width="30px" align="center"><div class="th-inner"><a class="btn user delete" type="button" href="/web/schemaOperate/deleteSchema?schemasId=<c:out value="${item.schemaId}"/>">delete</a></div></td>--%>
                <%--<td width="30px" align="center"><div class="th-inner"><a class="btn user update" type="button" href="/web/schemaOperate/goToSchemaUpdate?schemasId=<c:out value="${item.schemaId}"/>">update</a></div></td>--%>
              <%--</tr>--%>
            <%--</c:forEach>--%>
          <%--</table>--%>
        <%--</div>--%>
      <%--</div>--%>
    <%--</div>--%>
  <%--</div>--%>
<%--</div>--%>
<%--<script src=".././calendar/glDatePicker.min.js"></script>--%>
<%--<script type="text/javascript">--%>
  <%--$(window).load(function()--%>
  <%--{--%>
    <%--$('#example').glDatePicker();--%>
  <%--});--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>
