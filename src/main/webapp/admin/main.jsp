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
<h3>Welcome</h3>
<hr/>
${sessionScope.login}, hello!
<hr/>
<a href="${pageContext.request.contextPath}/app">Logout</a>
</body></html>
