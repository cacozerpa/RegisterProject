package com.cgzu.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgzu.controllers.DeleteController;

/**
 * Servlet implementation class DeleteServlet
 */
@MultipartConfig()
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String User = request.getParameter("User");
		String Password = request.getParameter("Password");
		
		System.out.print(User);
		System.out.print(Password);
		
		String delete = DeleteController.Delete(User, Password);
		
	if(delete.equals("deleted")) {
		System.out.print("User Deleted");
		response.setStatus(200);
	}else {
		response.setStatus(400);
	}
		
	}

}
