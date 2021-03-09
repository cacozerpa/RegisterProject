package com.cgzu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cgzu.controllers.UpdateController;


/**
 * Servlet implementation class UpdateServlet
 */
@MultipartConfig()
@WebServlet("/update")

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    String ss = null;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String ss = (String) session.getAttribute("User");
		
		String Tlf = request.getParameter("Tlf");
		String Direccion = request.getParameter("direccion");
		String Ci = request.getParameter("ci");
		String Apodo = request.getParameter("apodo");
		
		String update = UpdateController.Update(Tlf, Direccion, Ci, Apodo, ss);
		
		if(update.equals("Updated")) {
			
			System.out.print("User Updated!");
			response.setStatus(200);
			
		}else {
			System.out.print("Update Error");
			response.setStatus(400);
		}
		
		
	}
	
	

}
