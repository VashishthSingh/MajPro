<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.ArrayList" %>
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
    <table style="border:2px solid gray">
    <c:forEach items="${map.keySet()}" var="key">
    <tr>
        <td style="margin:5px;padding:5px;border:2px solid green"><c:out value="${key}"></c:out>&nbsp;&nbsp;</td>
        <c:set var="str2" value="${fn:split(map.get(key), ' ')}" /> 
        <c:forEach items="${str2}" var="val">
         <td style="margin:5px;padding:5px;border:2px solid green"><c:out value="${val}"></c:out>&nbsp;&nbsp;</td>
        </c:forEach>  
       </tr>
    </c:forEach>
    </table>
</body>
</html>