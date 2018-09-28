

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<jsp:useBean id="testForm" scope="session" class="com.cart.form.TestForm"/>
<html>
<head>
    <title></title>
</head>
<body>






<h1><%= testForm.getText() %></h1>

</body>
</html>
