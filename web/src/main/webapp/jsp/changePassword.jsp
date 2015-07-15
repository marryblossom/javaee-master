<%--
  Created by IntelliJ IDEA.
  User: marry
  Date: 7/13/15
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="/jsp/head.jsp"></jsp:include>
<form action="updatePassword" method="post">
  <table>
    <tr>
      <td width="50px" align="center">旧密码</td>
      <td width="90px" align="center">新密码</td>
      <td width="50px" align="center"></td>
    </tr>

    <tr>
      <td width="50px" align="center" ><input name="oldPassword" type="text"/></td>
      <td width="50px" align="center"><input name="newPassword" type="text" /></td>
      <td><input type="submit" value="Submit" /></td>
    </tr>
  </table>
</form>

</body>
</html>
