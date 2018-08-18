<%--
  Created by IntelliJ IDEA.
  User: Senpai
  Date: 18.08.2018
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : 'en_US'}" scope="session"/>
<fmt:setLocale value="${language}" scope="session" />
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en_US" ${language == 'en_US' ? 'selected' : ''}>English</option>
        <option value="uk_UA" ${language == 'uk_UA' ? 'selected' : ''}>Ukrainian</option>
    </select>
</form>
<c:set var="language" value="${not empty param.language ? param.language : 'en_US'}" scope="session"/>
<fmt:bundle basename="pagecontent" prefix = "label." >
    <fmt:message key="login"/>
    <fmt:message key="password"/>
</fmt:bundle>
<c:if test = "${sessionScope.role == 'USER'}">sadasdasd</c:if>

<p>Hello, ${sessionScope.role}, ${sessionScope.login}</p>