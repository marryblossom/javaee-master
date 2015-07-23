<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: marry
  Date: 7/7/15
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<spring:url value="/lib/css/user.css" var="userCss" />
<link href="${userCss}" rel="stylesheet">
<spring:url value="/lib/css/table.css" var="tableCss" />
<link href="${tableCss}" rel="stylesheet">
<html>
<script src=".././lib/js/jquery-1.11.1.min.js"></script>
<%--<link href=".././lib/css/bootstrap.css" rel="stylesheet"/>--%>
<%--<script src=".././lib/js/bootstrap.js"></script>--%>
<%--<script src=".././lib/js/bootstrap-table.js"></script>--%>
<link href=".././calendar/styles/glDatePicker.default.css" rel="stylesheet" type="text/css">
<%--<link rel="stylesheet" href=".././lib/css/bootstrap-table.css">--%>
<%--<script src=".././lib/js/bootstrap.min.js"></script>--%>
<head>
  <title></title>
</head>
<body>
<jsp:include page="/jsp/head.jsp"/>
<div class="insert-input">
  <div class="user-container">
    <div class="user-insert-input">
      <form action="addUserAndEmployee" method="post">
        <ul class="user-input-info">
          <li>
            <i>姓名：</i><span><input class="input-insert" type="text" name="username"/></span>
          </li>
          <li>
            <i>用户名：</i><span><input class="input-insert" type="text" name="employeename"/></span>
          </li>
          <li>
            <i>密码：</i><span><input class="input-insert" type="password" name="password"/></span>
          </li>

          <li>
            <i>性别：</i><span><input class="input-insert" type="radio" name="gender" value="male" /> male
            <input type="radio" name="gender" value="female" /> female</span>
          </li>
          <li>
            <i>邮箱：</i><span><input class="input-insert" type="text" name="email" /></span>
          </li>
          <li>
            <i>简介：</i><span><input class="input-insert-area" type="text" name="introduction" /></span>
          </li>
          <%--<li>--%>
            <span><input class="input-button" type="submit" value="Submit" /></span>
          <%--</li>--%>
        </ul>
      </form>
    </div>
  </div>
</div>
</div>
<div class="data-show">
  <p class="check-list">雇员列表</p>
  <div class="table">
    <div class="table-container">
      <div class="table-title">
        <div class="table-header-inner">
          <table class="table-header">
            <thead>
            <tr>
              <th>
                <div class="th-inner">姓名</div>
              </th>
              <th>
                <div class="th-inner">用户名</div>
              </th>
              <th>
                <div class="th-inner">性别</div>
              </th>
              <th>
                <div class="th-inner">邮箱</div>
              </th>
              <th>
                <div class="th-inner">简介</div>
              </th>
              <th>
                <div class="th-inner">状态</div>
              </th>
              <th>
                <div class="th-inner">职位</div>
              </th>
              <th>
                <div class="th-inner"></div>
              </th>
              <th>
                <div class="th-inner"></div>
              </th>
            </tr>
            </thead>
          </table>
        </div>
        <div class="table-body-inner">
          <table class="table-body">
            <c:forEach items="${users}" var="item" varStatus="status">
              <tr>
                <td width="50px" align="center"> <div class="th-inner"><c:out value="${item.userName}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.employee.employeeName}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.employee.gender}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.employee.email}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.employee.introduction}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.employee.state}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.employee.type}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><a class="btn user delete" type="button" href="/web/userOperate/delete?userId=<c:out value="${item.userId}"/>">delete</a></div></td>
                <td width="30px" align="center"><div class="th-inner"><a class="btn user update" type="button" href="/web/userOperate/goToUpdate?userId=<c:out value="${item.userId}"/>">update</a></div></td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </div>

    </div>
  </div>
</div>


</body>
</html>
