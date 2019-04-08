package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlToServletToDBServlet extends HttpServlet{
	private static final String GET_EMP_DETAIL="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		int eno=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		//get PrintWriter object
		pw=res.getWriter();
		//set content
		res.setContentType("text/html");
		    
		
			
		
		
		try{
			eno=Integer.parseInt(req.getParameter("empno"));
			//load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//established the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","programmer","coding");
			//create preparedStatement object
			ps=con.prepareStatement(GET_EMP_DETAIL);
			
			ps.setInt(1,eno);
			
			//create ResultSet object
			rs=ps.executeQuery();
			
			if(rs!=null){
				if(rs.next()){
					pw.println("Employee number\t: "+rs.getInt(1)+"<br>");
					pw.println("Employee name  \t: "+rs.getString(2)+"<br>");
					pw.println("Employee sal   \t: "+rs.getInt(3)+"<br>");
					pw.println("Employee job   \t: "+rs.getString(4)+"<br>");
					pw.println("Employee deptno\t: "+rs.getInt(5)+"<br>");
				}
				else{
					pw.println("Record not found....");
				}
			}//if
		}//try
		catch(SQLException se){
			pw.println("Internal DataBase problem..");
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){
			pw.println("Internal JDBC problem..");
		}
		catch(NumberFormatException ne){
			pw.println("Please enter only integer numbers ....");
		}
		
		finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(ps!=null){
					ps.close();
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try{
				if(con!=null){
					con.close();
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			pw.println("<br><br><a href='index.html'>HOME</a>");
		}//finally
	}//doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
