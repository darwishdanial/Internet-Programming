package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VCDBean
 */
@WebServlet("/VCDBean")
public class VCDBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public VCDBean() {}
    
    private String title, actor;
    private float price;
    private int quantity;
    
    public void setTitle(String title)
  	{
    	this.title = title;
  	}

  	public void setActor(String actor)
  	{
    	this.actor = actor;
  	}

  	public void setPrice(float price)
  	{
    	this.price = price;
  	}

  	public void setQuantity(int quantity)
  	{
    	this.quantity = quantity;
  	}

  	//*******************************************
  	public String getTitle()
  	{
    	return title;
  	}

  	public String getActor()
  	{
    	return actor;
  	}

  	public float getPrice()
  	{
    	return price;
  	}

  	public int getQuantity()
  	{
    	return quantity;
  	}

}
