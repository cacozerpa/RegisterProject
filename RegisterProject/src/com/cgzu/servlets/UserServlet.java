package com.cgzu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cgzu.controllers.UserController;
/**
 * Servlet implementation class UserServlet
 */
@MultipartConfig()
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		session.getAttribute("User");
		
		UserController user = new UserController();
		
		List<String> lista = user.showUser("User");
		
		PrintWriter writer = response.getWriter();
		writer.print(lista);
		writer.flush();
		
		response.setStatus(200);
		
		
		
	//	if(user != null) {
	//		response.setStatus(200);
	//		System.out.print("Showing User");
	//	}else {
	//		response.setStatus(400);
	//		System.out.print("Not Showing");
	//	}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
