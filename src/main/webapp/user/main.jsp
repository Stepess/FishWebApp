<%--
  Created by IntelliJ IDEA.
  User: Senpai
  Date: 13.08.2018
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Welcome</title></head>
<body>
<jsp:include page="/WEB-INF/component/header.jsp"></jsp:include>
<h3>Welcome</h3>
<hr/>
${sessionScope.login}, hello!
<h1> session role: ${sessionScope.role}</h1>
<hr/>
<h1>This is user page</h1>
<form name="logoutForm" method="POST" action="/app">
    <input type="hidden" name="command" value="logout">
    <input type="submit" value="Log out"/>
</form>
</body></html>
