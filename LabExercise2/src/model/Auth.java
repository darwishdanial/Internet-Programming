package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //business logic
    public String validateCredentials(String username, String password) {
      
        if ("admin".equals(username) && "admin".equals(password)) {
            return "admin";
        } else if ("user1".equals(username) && "user1".equals(password)) {
            return "coach";
        } else if ("user2".equals(username) && "user2".equals(password)) {
            return "trainee";
        } else {
            return "invalid";
        }
    }

}
