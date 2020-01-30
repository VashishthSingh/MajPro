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

 <style type="text/css">
   #table{border:2px solid gray;margin-top:20px;margin-left:20px;}
   #data{border:2px solid silver;padding:10px;}
   .tableH{border:2px solid silver;padding:10px;}
 </style>
 
</head>
<body>
    <!-- ${arrayList}<br/><br/> -->
   <c:if test="${!arrayList.isEmpty()}">
        <table id="table">
              <tr>
                 <th class="tableH">cpuUti</th>
                 <th class="tableH">readDateTime</th>
                 <th class="tableH">ramUti</th>
                 <th class="tableH">diskUti</th>
               </tr>
               <c:forEach items="${arrayList}" var="map">
                   <!--<c:out value="${map}"></c:out>&nbsp;&nbsp;-->
                   <tr>
                     <c:forEach items="${map.keySet()}" var="key">
                         <td id="data">
                           <!--<c:out value="${key} : "></c:out>-->
                           <c:out value="${map.get(key)}"></c:out>
                         </td>
                     </c:forEach> 
                   </tr>
               </c:forEach>
        </table>
   </c:if>
   
</body>
</html>