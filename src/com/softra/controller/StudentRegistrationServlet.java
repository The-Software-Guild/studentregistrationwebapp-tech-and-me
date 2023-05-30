package com.softra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softra.dao.StudentDao;
import com.softra.dto.Student;

@WebServlet("/student/*")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDao studentDao;

    public StudentRegistrationServlet() {
        studentDao = new StudentDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form data
	    String name = request.getParameter("name");
	    String ageStr = request.getParameter("age");
	    int age = Integer.parseInt(ageStr);
	    String mobile = request.getParameter("mob");
	    String address = request.getParameter("addr");

	    // Create a new instance of the Student bean
	    Student stu = new Student(name, age, mobile, address);

	    // Create an instance of the StudentDao
	    StudentDao studentDao = new StudentDao();

	    // Save the student data to the database
	    studentDao.saveStudent(stu);

	    // Store the student bean as a request attribute
	    request.setAttribute("stu", stu);

	    // Forward the request to the success.jsp page
	    RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
	    rd.forward(request, response);
	}
}
