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
    <script type="text/javascript">
        $(function () {
            $("#cc").click(function(){
                alert("cc");
//                $.ajax({
//                type: "GET",
//                url:'hello',
//                // dataType: "json",
////                data:{account:$('#account').val()},
//                error:function(){
//                    alert("error occured!!!");
//                },
//                success:function(data){
//                    alert("success")
//                    alert(data.size);
//                    // $('#dataShow').append("<td>"+data.get(0).getName(1)+"</td>");
//
//                }
//            });
            });

        })
        function deleteData(id) {
            window.location.href = "/web/delete?id="+id;
        }
        function jumpToUpdate(id){
            alert(id);
          //  window.location.href = "/web/update?id="+id;
        }
    </script>
    <title></title>

</head>
    <body>
    <form action="hello" method="post">
        <table>
            <tr>
                <td align="center">name：</td>
                <td align="center">gender：</td>
                <td align="center">email：</td>
                <td align="center">age：</td>
                <td></td>
            </tr>
            <tr>
                <td><input type="text" name="name"/></td>
                <td><input type="radio" name="gender" value="male" /> male
                    <input type="radio" name="gender" value="female" /> female</td>
                <td><input type="text" name="email" /></td>
                <td><input type="text" name="age" /></td>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>


    </form>
<table>
    <tr>
        <td align="center">name：</td>
        <td align="center">gender：</td>
        <td align="center">email：</td>
        <td align="center">age：</td>
        <td></td>
    </tr>
    <%
        List<Person> people = (List<Person>) request.getAttribute("people");
        for (int i = 0; i <people.size() ; i++) {
    %>
    <tr>
        <td width="50px" align="center"><%=people.get(i).getName()%></td>
        <td width="30px" align="center"><%=people.get(i).getGender()%></td>
        <td width="30px" align="center"><%=people.get(i).getEmail()%></td>
        <td width="30px" align="center"><%=people.get(i).getAge()%></td>
        <%--<td width="30px" align="center"><button onclick="deleteData(<%=people.get(i).getId()%>)" name="delete" value="delete" >delete</button></td>--%>
        <%--<td width="30px" align="center"><button onclick="jumpToUpdate(<%=people.get(i).getId()%>)" name="update" value="update" >update</button></td>--%>
        <td width="30px" align="center"><a type="button" href="/web/delete?id=<%=people.get(i).getId()%>">delete</a></td>
        <td width="30px" align="center"><a type="button" href="/web/update?id=<%=people.get(i).getId()%>">update</a></td>
    </tr>
    <%}%>
</table>
    </body>
</html>
