<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<jsp:useBean id="helloWorldForm" scope="session" class="com.cart.form.HelloWorldForm"/>
<html>
<head>
    <title></title>
</head>
<body>
<h1><bean:write name="helloWorldForm" property="greeting" /></h1>

<h1><%= helloWorldForm.getGreeting() %></h1>

</body>
</html>
