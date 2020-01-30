<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.File,java.lang.management.ManagementFactory,java.util.concurrent.TimeUnit" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <textarea rows="30" cols="60" name = "data"></textarea><br><br>
     <%
     boolean flag=true;
     int i=1;
     while(flag){
      long freeSpace = new File("/").getFreeSpace();
      long memorySize=new File("/").getTotalSpace();
      long usedRamSpace=memorySize-freeSpace; 
      float rup=(float)(usedRamSpace*100)/memorySize;
      
      long diskSize= ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
      long feeSize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getFreePhysicalMemorySize();
      long usedDiskSpace=diskSize-feeSize;
      float disk=(float)(usedDiskSpace*100)/diskSize; 
     
      double CPU=((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getSystemCpuLoad(); 
      CPU=CPU*100;
      out.println(rup+"&nbsp; &nbsp; "+disk+" &nbsp; &nbsp; "+CPU);
      try{ TimeUnit.SECONDS.sleep(3);}        
      catch(InterruptedException E){System.out.println("Exception"+E);}
      i++;
      if(i==2)
       flag=false;
     }
     %>
     
</body>
</html>