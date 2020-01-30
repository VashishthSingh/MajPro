package com.mypack;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Map<String,String>> arrayList=new ArrayList<Map<String,String>>();  
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/report?useSSL=false","root","password"); 
	        Statement stmt=(Statement) con.createStatement();  
	        ResultSet rs=stmt.executeQuery("select * from storeData");
	        while (rs.next()){
	        	Map<String,String> map=new HashMap<String,String>();
	        	map.put("ramUti",rs.getString("ramUti"));
	        	map.put("diskUti",rs.getString("diskUti"));
	        	map.put("cpuUti",rs.getString("cpuUti"));
	        	map.put("readDateTime",rs.getString("readDateTime"));
	        	arrayList.add(map);
	        	//System.out.println(map);
	        }
	        //System.out.println(arrayList);
	        request.setAttribute("arrayList", arrayList);
	        RequestDispatcher rd=request.getRequestDispatcher("/myjspfile4.jsp");
	        rd.forward(request, response);
	        
	        // Using sendRedirect()
	        /*HttpSession session=request.getSession();
	        session.setAttribute("arrayList", arrayList);
	        response.sendRedirect("myjspfile4.jsp");*/
	        
            con.close();  
            stmt.close();
            rs.close();
	    }
		catch(Exception ae) {
			  System.out.println("Ex: "+ae);
		} 
	}

}
