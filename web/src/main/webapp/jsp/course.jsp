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
      <form action="addCourse" method="post">
        <ul class="user-input-info">
          <li>
            <i>课程名称：</i><span><input class="input-insert" type="text" name="courseName"/></span>
          </li>
          <li>
            <i>课程简介：</i><span><input class="input-insert" type="text" name="introduction"/></span>
          </li>
          <span><input class="input-button" type="submit" value="Submit" /></span>
        </ul>
      </form>
    </div>
  </div>
</div>
</div>
<div class="data-show">
  <p class="check-list">健身房课程</p>
  <div class="table">
    <div class="table-container">
      <div class="table-title">
        <div class="table-header-inner">
          <table class="table-header">
            <thead>
            <tr>
              <th>
                <div class="th-inner">课程名称</div>
              </th>
              <th>
                <div class="th-inner">课程简介</div>
              </th>
              <th>
                <div class="th-inner">课程状态</div>
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
            <c:forEach items="${courses}" var="item" varStatus="status">
              <tr>
                <td width="50px" align="center"> <div class="th-inner"><c:out value="${item.name}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.introduction}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><c:out value="${item.state}"/></div></td>
                <td width="30px" align="center"><div class="th-inner"><a class="btn user unlock" type="button" href="/web/courseOperate/unlockCourse?courseId=<c:out value="${item.courseId}"/>">unlock</a></div></td>
                <td width="30px" align="center"><div class="th-inner"><a class="btn user delete" type="button" href="/web/courseOperate/deleteCourse?courseId=<c:out value="${item.courseId}"/>">delete</a></div></td>
                <td width="30px" align="center"><div class="th-inner"><a class="btn user update" type="button" href="/web/courseOperate/goToCourseUpdate?courseId=<c:out value="${item.courseId}"/>">update</a></div></td>
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
