package com.labEx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	String firstName = request.getParameter("fname");
	        String lastName = request.getParameter("lname");
	        String course = request.getParameter("courses");
	        String gender = request.getParameter("gender");
	        String[] languages = request.getParameterValues("language[]");
	        String[] transportation = request.getParameterValues("trans");
	        String phoneNum = request.getParameter("phoneNum");
	        String address = request.getParameter("address");
	        String email = request.getParameter("email");

	        // Set response content type
	        response.setContentType("text/html");

	        // Output the form data
	        PrintWriter out = response.getWriter();
	        out.println("<html><body>");
	        out.println("<h2>Registration Details:</h2>");
	        out.println("<p><strong>First Name:</strong> " + firstName + "</p>");
	        out.println("<p><strong>Last Name:</strong> " + lastName + "</p>");
	        out.println("<p><strong>Course:</strong> " + course + "</p>");
	        out.println("<p><strong>Gender:</strong> " + gender + "</p>");
	        out.println("<p><strong>Languages:</strong> ");
	        if (languages != null) {
	            for (String language : languages) {
	                out.println(language + " ");
	            }
	        }
	        out.println("</p>");
	        out.println("<p><strong>Transportation:</strong> " + transportation + "</p>");
	        out.println("<p><strong>Phone Number:</strong> " + phoneNum + "</p>");
	        out.println("<p><strong>Address:</strong> " + address + "</p>");
	        out.println("<p><strong>Email:</strong> " + email + "</p>");
	        out.println("</body></html>");
	}

}
