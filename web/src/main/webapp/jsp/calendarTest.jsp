<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Example</title>
  <link href="./calendar/styles/glDatePicker.default.css" rel="stylesheet" type="text/css">
</head>
<body>
<input type="text" id="example" name="date"/>
<button onclick="getdata()" />

<script src="./lib/js/jquery-1.11.1.min.js"></script>
<script src="./calendar/glDatePicker.min.js"></script>

<script type="text/javascript">
  $(window).load(function()
  {
    $('#example').glDatePicker();
    alert($('#example').glDatePicker());
  });
</script>
<script type="text/javascript">
  function getdata(){
    alert(document.getElementById("example"));
  }

</script>
</body>
</html>
