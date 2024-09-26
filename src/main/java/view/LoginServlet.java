package view;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		String studentId = req.getParameter("studentId");
		String password = req.getParameter("password");
		
		try {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			if(studentId != null && password != null) {
				
				if((studentId.equalsIgnoreCase("25337") || studentId.equalsIgnoreCase("staff")) && 
						password.equalsIgnoreCase("123")) {
					if(studentId.equalsIgnoreCase("staff")) {
						req.setAttribute("role","admin");
					}else if(studentId.equalsIgnoreCase("25337")){
						req.setAttribute("role","student");
					}
					RequestDispatcher dispatcher = req.getRequestDispatcher("home");
					dispatcher.forward(req, res);
					
				}else {
					out.println("<h1>Invalid user Name or Password</h1>");
					RequestDispatcher dispatcher = req.getRequestDispatcher("/index.html");
					dispatcher.forward(req, res);
				}
				
			}else {
				out.println("<body>");
				out.println("<h1>Field are required</h1>");
				out.println("<\body>");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
