<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<h2>请登陆</h2>
<form action="login" method="post">
    <table>
        <tr>
            <td width="50px" align="center">用户名</td>
            <td width="90px" align="center">密码</td>
            <td width="50px" align="center"></td>
        </tr>

        <tr>
            <td width="50px" align="center"><input name="username" type="text"/></td>
            <td width="50px" align="center"><input name="password" type="text" /></td>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>