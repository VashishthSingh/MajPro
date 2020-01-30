<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.concurrent.TimeUnit" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>
     <!-- Connecting to DB -->
     <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/report"  
     user="root"  password="password"/>  
     
     <!--  Executing Query -->
     <sql:query dataSource="${db}" var="rs">  
      SELECT * from storeData;  
     </sql:query> 
     
     <!--  Printing Data -->
     <c:forEach items="${rs.rows}" var="getRow">
      <c:out value="${getRow.ramUti}"></c:out>&nbsp;
      <c:out value="${getRow.diskUti}"></c:out>&nbsp;
      <c:out value="${getRow.cpuUti}"></c:out>&nbsp;
      <c:out value="${getRow.readDateTime}"></c:out>
      <br/><br/><br/> 
     </c:forEach>
     
</body>
</html>