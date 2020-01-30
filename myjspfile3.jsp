<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.ArrayList,java.util.Map" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <c:if test="${!map.isEmpty()}">
     <c:forEach items="${map.keySet()}" var="key">
        <c:out value="${key}"></c:out>&nbsp;&nbsp;
        <c:out value="${map.get(key)}"></c:out>&nbsp;&nbsp;
        <br/><br/>
     </c:forEach>
   </c:if>
   
</body>
</html>