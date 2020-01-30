package com.mypack;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	public  void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0,column=1,columnCount=0;String val=null;
		Map<Integer,String> map=new HashMap<Integer,String>();  
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/report?useSSL=false","root","password"); 
	        Statement stmt=(Statement) con.createStatement();  
	        ResultSet rs=stmt.executeQuery("select * from storeData");
	        columnCount=rs.getMetaData().getColumnCount();
	        while (rs.next()){
	        	for(column=1;column<=columnCount;column++) {
	        		val=rs.getString(column);
	        		map.put(i,val);
	        		i++;
	        	}
	        }
	        request.setAttribute("map", map);
	        RequestDispatcher rd=request.getRequestDispatcher("/myjspfile3.jsp");
	        rd.forward(request, response);
            con.close();  
            stmt.close();
            rs.close();
	    }
	    catch(Exception ae) {
		  System.out.println("Ex: "+ae);
	    } 
	}
}
