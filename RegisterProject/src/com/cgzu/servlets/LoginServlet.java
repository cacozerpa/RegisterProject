package com.cgzu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.cgzu.controllers.LoginController;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
@MultipartConfig()
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String User = request.getParameter("User");
		String Password = request.getParameter("Password");
		
		
		String loggin = LoginController.login(User, Password);
		
		HttpSession session = request.getSession();
		
		if(loggin.equals("Logged!")) {
			System.out.println("Loggeado");
			session.setAttribute("User", User);
		
			response.setStatus(200);
			response.sendRedirect("http://localhost:8080/RegisterProject/user.html");
			return;

		}else {
			response.setStatus(500);
		}
		
		
	
	}

}
