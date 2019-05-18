<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>
<body>
<h1>Welcome to product detail page</h1>

<c:forEach items="${productCodeList}" var="item">
    <a href="/size/${item}">${item }</a><br>    
</c:forEach>
<br>
<c:if test = "${flag==0}">
         <c:out value="${message}"/>
      </c:if>
<c:if test = "${flag==1}">
     <c:forEach items="${myMap}" var="entry">
    Size : <c:out value="${entry.key}"/>  No of units available: <c:out value="${entry.value}"/> <br /> <br>
    </c:forEach> 
      </c:if>
      
</body>
</html>