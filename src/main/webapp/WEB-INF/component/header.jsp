<%--
  Created by IntelliJ IDEA.
  User: Senpai
  Date: 18.08.2018
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test = "${sessionScope.role == 'USER'}">sadasdasd</c:if>

<p>Hello, ${sessionScope.role}, ${sessionScope.login}</p>