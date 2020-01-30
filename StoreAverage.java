package com.clientserver.program;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class StoreAverage {
 public static void main(String []args){
 	float ramAverage=0.0f,diskAverage=0.0f,cpuAverage=0.0f;
  try{ 
 	while(true) {	
 	  // 1. Registering the Driver 
       Class.forName("com.mysql.jdbc.Driver"); 
       // 2. Creating connection between java code and database
       Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/report?useSSL=false","root","password");         
       // 3. Creating statement
       Statement stmt=(Statement) con.createStatement();
       Statement stmt1=(Statement) con.createStatement();
       LocalDateTime currentDateTtime = LocalDateTime.now();  // getting system current date and time
       LocalDateTime startingTime = currentDateTtime.minusSeconds(60); //setting start range
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
       String str=formatter.format(startingTime);
       startingTime=LocalDateTime.parse(str, formatter); 
       LocalDateTime endingTime=startingTime.plusSeconds(59); //setting end range
       
       // 4. Executing query
       // Calculating average of reading 
       ResultSet rs = stmt.executeQuery("select avg(ramUti),avg(diskUti),avg(cpuUti),count(ramUti) from storePercentData"+" where redDateTime>='"+startingTime+"' and redDateTime<='"+endingTime+"'");
       rs.next();
       // Getting averages
       ramAverage=rs.getFloat(1);
       diskAverage=rs.getFloat(2);
       cpuAverage=rs.getFloat(3);
       // Storing the averages up to 4 decimal place
       ramAverage=(float) (Math.round(ramAverage * 10000.0) / 10000.0);
       diskAverage=(float) (Math.round(diskAverage * 10000.0) / 10000.0);
       cpuAverage=(float) (Math.round(cpuAverage * 10000.0) / 10000.0);
       
       // Inserting average value to the Mean Table
       stmt1.executeUpdate("insert into storePercentMeanData(ramUti,diskUti,cpuUti,redDateTime)values("+ramAverage+","+diskAverage+","+cpuAverage+",'"+startingTime+"')");
       DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       // Printing output on console
       System.out.println(ramAverage+" "+diskAverage+" "+cpuAverage+" "+formatter1.format(startingTime)+" "+formatter1.format(endingTime));

       // 5. Closing the connection
       con.close(); 
       stmt.close();
       stmt1.close();
       rs.close();
       
       try{TimeUnit.SECONDS.sleep(60);}           
       catch(InterruptedException E){System.out.println(E);}
    }//end of while
  }//end of try     
  catch(Exception e){    	 
      System.out.println("Exception");         
      System.out.println(e);     
  }
}//end of main function
}//end of class
