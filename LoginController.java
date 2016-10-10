package com.acadgild.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(userName.equals("Arpit") && password.equals("Arpit@123"))
		{
			HttpSession session = request.getSession(true);

			String title = "Welcome to my Website";
			session.setAttribute("userIdKey", "ABCD");
			session.setAttribute("visitCountKey", 1);
			session.setAttribute("userName", userName);
			
			Cookie c1 = new Cookie("userName", userName);
			c1.setMaxAge(365*24*60*60);
			//c1.setMaxAge(0);
			//c1.setHttpOnly(true);
			//c1.setSecure(true);
			response.addCookie(c1);
			
			Cookie c2 = new Cookie("password", password);
			c2.setMaxAge(365*24*60*60);
			//c2.setMaxAge(0);
			//c2.setHttpOnly(true);
			//c2.setSecure(true);
			response.addCookie(c2);
			response.sendRedirect("Home.jsp");	
			
			
			
		}
		
		
		else
		{
			
			//response.sendRedirect("error.jsp");
			request.setAttribute("errorMessage", "user name or password is invalid");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
	}

}
