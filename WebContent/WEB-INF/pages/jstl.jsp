<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <h1>
<c:out value="${param.user }" default="guest user"></c:out>
<c:set var="x" value="10" scope="request"/>
<c:set var="y" value="20" scope="request"/>
<c:set var="xy" value="${x+y }" scope="session"/>
Result<c:set value="${xy }"/>
</h1> --%>
<%-- 

<h1>
User Name:${param.name}
<c:catch var="e">
<%
	int age=Integer.parseInt(request.getParameter("age"));
%>
${param.age}<br>
</c:catch>
<c:if test="${e!=null}">
<c:out value="${e}"/>
</c:if>
${param.height}
25
</h1>--%>
<c:forTokens items="a,b,c,d,e,f" delims="," var="x"></c:forTokens>

<c:forEach items="${xyz }" var="obj">
<h1>Hello Abhi!!----${obj.Email }---------${obj.password }</h1>
</c:forEach> 
</body>
</html>