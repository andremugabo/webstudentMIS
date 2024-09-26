package view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		RequestDispatcher dispatcher;
		String role = (String) req.getAttribute("role");
		if(role.equalsIgnoreCase("admin")) {
			dispatcher = req.getRequestDispatcher("/admin/adminDashboard.html");
		}else {
			dispatcher = req.getRequestDispatcher("/student/studentDashboard.html");
		}
		dispatcher.forward(req, res);
	}

}
