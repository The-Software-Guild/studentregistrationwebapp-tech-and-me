package com.softra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.softra.dto.Student;

public class StudentDao {

	public Connection openConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//Type-4 driver is a registered with DriverManager
			System.out.println("MYSQL driver registred with DriverManager");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/stu","root","root");
		} catch (ClassNotFoundException e) {
			System.out.println("MYSQL suitable driver not found");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void saveStudent(Student student) {
		Connection con = openConnection();
		try {
			String query = "INSERT INTO studenttbl (name, age, mobileno, address) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
			statement.setString(3, student.getMob());
			statement.setString(4, student.getAddr());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

