<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<html>
<script src=".././lib/js/jquery-1.11.1.min.js"></script>
<%--<script src=".././lib/js/xmlhttpTest.js"></script>--%>
<script src=".././lib/js/postTest.js"></script>
<%--<script src=".././lib/js/ajaxTest.js"></script>--%>


<head>
    <title></title>
</head>
<body>
  <table class="table-body">
      <tr>
        <td align="center"> <input type="text" id="city"/></td>
        <td align="center"><input type="text" id="state"/></td>
        <td align="center"><button />submit</td>
        <%--<td align="center"><button onclick="callServer()"/>submit</td>--%>
      </tr>
    <tr>
      <td align="center" ><input type="text" id = "zipCode"/> </td>
    </tr>
  </table>
</body>
</html>
