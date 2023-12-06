package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.Auth;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//connect between business logic and view
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUserName(uname);
		user.setPassword(password);
		request.setAttribute("user", user);
		
		Auth auth = new Auth();
        String userRole = auth.validateCredentials(uname, password);
        
        //making descision
        
		try {
			
			if (uname==null || uname.equals("")){ //check the username = null
				throw new Exception();
			}else if ("admin".equals(userRole)) {
	            RequestDispatcher rd = request.getRequestDispatcher("adminPage.jsp");
	            rd.forward(request, response);
	        } else if ("coach".equals(userRole)) {
	            RequestDispatcher rd = request.getRequestDispatcher("coachPage.jsp");
	            rd.forward(request, response);
	        } else if ("trainee".equals(userRole)) {
	            RequestDispatcher rd = request.getRequestDispatcher("traineePage.jsp");
	            rd.forward(request, response);
	        } else {
	        	throw new Exception();
	        }
			
			
			
		}catch(Exception e) {
			
			RequestDispatcher rd = request.getRequestDispatcher("errorPage.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

}
