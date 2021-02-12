package com.cgzu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgzu.controllers.RegisterController;


/**
 * Servlet implementation class register
 */
@MultipartConfig()
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String User = request.getParameter("User");
		String Email = request.getParameter("Email");
		String ConfEmail = request.getParameter("ConfEmail");
		String Password = request.getParameter("Password");
		String ConfPassword = request.getParameter("ConfPassword");
		String Tlf = request.getParameter("Tlf");
		
		
		String registered = RegisterController.register(name, User, Email, ConfEmail, Password, ConfPassword, Tlf);
		if (registered.equals("registered")) {
			response.setStatus(200);
		}else {
			response.setStatus(500);
		}
	}

}
