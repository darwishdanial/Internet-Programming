package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.VCDBean;

@WebServlet("/ShopingServlet")
public class ShopingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        Vector buylist = (Vector) session.getAttribute("cart");

        String action = request.getParameter("action");

        if (action.equals("VIEW"))
        {
				if (buylist != null && (buylist.size() > 0))
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
					dispatcher.forward(request, response);
				}
				else 
				{
				
					RequestDispatcher dispatcher = request.getRequestDispatcher("empty.jsp");
					dispatcher.forward(request, response);
				
				}
        }
        else if (action.equals("CHECKOUT"))
        {
	            if (buylist != null && (buylist.size() > 0))
	            {
					RequestDispatcher mm = request.getRequestDispatcher("checkOut.jsp");
					mm.forward(request, response);
	                session.invalidate();
	            }
	            else
	            {
	            	RequestDispatcher dispatcher = request.getRequestDispatcher("empty.jsp");
					dispatcher.forward(request, response);
	            }
       }
        else if (action.equals("LOGOUT"))
        {
				session.invalidate();
				RequestDispatcher dispatcher = request.getRequestDispatcher("logOut.jsp");
				dispatcher.forward(request, response);
	     }
	}
        
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");

                HttpSession session = request.getSession(true);
                String action = request.getParameter("action");

                Vector buylist = (Vector)session.getAttribute("cart");

                boolean match = false;
                if (action.equals("ADD"))
                {
	            	VCDBean vcd = getVCD(request);
	            	if (buylist == null)
	            	{
	                        //add first vcd to the cart
	                        buylist = new Vector();
	                        buylist.addElement(vcd);
	            	}
	            	else
	            	{
	                        for(int i=0; i<buylist.size(); i++)
	                        {
	                            VCDBean aVCD = (VCDBean)buylist.elementAt(i);
	                            
	                            if (aVCD.getTitle().equals(vcd.getTitle()))
	                            {
	                                aVCD.setQuantity(aVCD.getQuantity() + vcd.getQuantity());
	                                buylist.setElementAt(aVCD, i);
	                                match = true;
	                            }
	                        }
	                        
	                        if (!match)
	                            buylist.addElement(vcd);
	            	}
	
		    		session.setAttribute("cart", buylist);
		    		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
					dispatcher.forward(request, response);

                }
                else if (action.equals("DELETE"))
                {
		    		String del = request.getParameter("delindex");
		    		VCDBean vcd = (VCDBean)buylist.elementAt((new Integer(del)).intValue());
		    		String title = vcd.getTitle().trim();
		    		int d = (new Integer(del)).intValue();
	            	buylist.removeElementAt(d);
	            	
	            	request.setAttribute("title", title);
	            	RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
					dispatcher.forward(request, response);
					
                }
    }

	
	void sendPage(HttpServletRequest request, HttpServletResponse response, String fileName) throws ServletException, IOException
    {
                // Get the dispatcher; it gets the main page to the user
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(fileName);

                if (dispatcher == null)
                {
    		System.out.println("There was no dispatcher");
                    // No dispatcher means the html file could not be found.
                    response.sendError(response.SC_NO_CONTENT);
                }
                else
                    dispatcher.forward(request, response);
    }


    VCDBean getVCD(HttpServletRequest request)
    {
                String myVCD = request.getParameter("VCD");
                String qty = request.getParameter("qty");
                StringTokenizer t = new StringTokenizer(myVCD,"|");
                String title = t.nextToken();
                String actor = t.nextToken();

                String price = t.nextToken();
                //price = price.replace('$',' ').trim();
                price = price.replace('R',' ').trim();
                price = price.replace('M',' ').trim();

                VCDBean vcd = new VCDBean();
                vcd.setTitle(title);
                vcd.setActor(actor);
                vcd.setPrice((new Float(price)).floatValue());
                vcd.setQuantity((new Integer(qty)).intValue());
                return vcd;
     }
        
        
}

