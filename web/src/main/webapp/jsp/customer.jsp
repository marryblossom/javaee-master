<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <spring:url value="/lib/css/user.css" var="userCss" />
  <link href="${userCss}" rel="stylesheet">
  <spring:url value="/lib/css/table.css" var="tableCss" />
  <link href="${tableCss}" rel="stylesheet">

</head>
<body>
<jsp:include page="/jsp/head.jsp"/>

<div class="insert-input">
  <div class="user-container">
    <div class="user-insert-input">
      <form action="addCustomer" method="post">
        <ul class="user-input-info">
          <li>
            <i>客户名称：</i><span><input class="input-insert" type="text" name="name"/></span>
          </li>
          <li>
            <i>简介：</i><span><input class="input-insert" type="text" name="introduction"/></span>
          </li>
          <span><input class="input-button" type="submit" value="Submit" /></span>
        </ul>
      </form>
    </div>
  </div>
</div>
</div>
<div class="data-show">
  <p class="check-list">客户信息</p>
  <div class="table">
    <div class="table-container">
      <div class="table-title">
        <div class="table-header-inner">
          <table class="table-header">
            <thead>
            <tr>
              <th>
                <div class="th-inner">客户</div>
              </th>
              <th>
                <div class="th-inner">简介</div>
              </th>
              <th>
                <div class="th-inner">状态</div>
              </th>
              <th>
                <div class="th-inner"></div>
              </th>
              <th>
                <div class="th-inner"></div>
              </th>
              <th>
                <div class="th-inner"></div>
              </th>
              <th>
                <div class="th-inner"></div>
              </th>
              <th>
                <div class="th-inner"></div>
              </th>
              <th>
                <div class="th-inner"></div>
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
            <c:forEach items="${customers}" var="item" varStatus="status">
              <tr>
                <td width="50px" align="center"> <div class="th-inner"><c:out value="${item.name}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.introduction}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.state}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><a class="btn user unlock" type="button" href="/web/customerOperate/unlockCustomer?customerId=<c:out value="${item.customerId}"/>">unlock</a></div></td>
                <td width="30px" align="center"><div class="th-inner"><a class="btn user delete" type="button" href="/web/customerOperate/deleteCustomer?customerId=<c:out value="${item.customerId}"/>">delete</a></div></td>
                <td width="30px" align="center"><div class="th-inner"><a class="btn user update" type="button" href="/web/customerOperate/goToCustomerUpdate?customerId=<c:out value="${item.customerId}"/>">update</a></div></td>
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
