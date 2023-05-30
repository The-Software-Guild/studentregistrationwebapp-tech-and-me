package com.softra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/*")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentRegistrationServlet() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.parseInt(ageStr);
		String mob = request.getParameter("mob");
		String addr = request.getParameter("addr");
		
		//Store the form data as request attributes
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("mob", mob);
		request.setAttribute("addr", addr);
		
		///Forward the request to the success page
		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request,response);
	}
}
