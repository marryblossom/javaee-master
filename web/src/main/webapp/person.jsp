<%@ page import="java.util.List" %>
<%@ page import="com.tw.core.bean.Person" %>
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

<form action="update" method="post">
<table>
    <tr>
        <td width="50px" align="center">姓名</td>
        <td width="90px" align="center">性别</td>
        <td width="50px" align="center">邮箱</td>
        <td width="50px" align="center">年龄</td>
        <td width="50px" align="center"></td>
    </tr>

    <tr>
        <%Person person  = (Person)request.getAttribute("person");%>
        <td width="50px" align="center" hidden><input name="id" type="text" value="<%=person.getId()%>"/></td>
        <td width="50px" align="center"><input name="name" type="text" value="<%=person.getName()%>"/></td>
        <td width="50px" align="center"><%=person.getGender()%><br />
            <%if (person.getGender().equals("male")){%>
                <input type="radio" name="gender" value="male" checked/> male
                <input type="radio" name="gender" value="female" /> female
            <%} else{%>
                <input type="radio" name="gender" value="male" /> male
                <input type="radio" name="gender" value="female" checked/> female
            <%}%>
        </td>
        <td width="50px" align="center"><input name="email" value="<%=person.getEmail()%>"/></td>
        <td width="50px" align="center"><input name="age" value="<%=person.getAge()%>"/></td>
        <td><input type="submit" value="Submit" /></td>
        </tr>
</table>
</form>
</body>
</html>
