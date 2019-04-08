package com.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MerriageEligibility extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      PrintWriter pw = null;
      String tname = null;
      String tage = null;
      String tgender=null;
      int age = 0;
      
      //create print writer object
      pw = resp.getWriter();
      
      resp.setContentType("text/html");
      
       try {
      //get value from request object
       tname = req.getParameter("pname");
       tage = req.getParameter("page");
       age = Integer.parseInt(tage);
       }
       catch(Exception e){
    	   pw.println("<h1 style = 'color:green; text-align:center'>Name and Age is Required</h1>");
       }
   
           if(req.getParameter("gender").equalsIgnoreCase("MALE"))
       	   tgender = "male";
           else
    	   tgender = "female";
 
     if(tname!=null && age!=0) {    
         if(tgender=="female" && age>=18) {
    	     pw.println("<br><h1 style='color'red; text-align:center'>Miss "+tname+" you are eligible for marriage</h1>"); 
          }
           else if(tgender=="male" && age>=21) {
    	   pw.println("<br><h1 style='color'red; text-align:center'>Mr."+tname+" you are eligible for marriage</h1>");
       }  	   
        else {
    	   pw.println("<br><h1 style='color'green; text-align:center'>Mr/Miss/Mrs."+tname+" you are not eligible for voting</h1>");
       }
         
         pw.println("<br><a href ='input.html'><image src='home.jpg' height='10%' width='10%'></a>");
   }//if
      
       pw.close();
   }//get(-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                doGet(req,resp);
	}//post(-)
}//class

