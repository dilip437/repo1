package com.poc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		add("S-107", "Sonu");
		System.out.println("Add: S-107, Sonu");
		
		update("K-104", "Kiran");
		System.out.println("Update: K-104, Kiran");
		
		Student s=get("L-105");
		System.out.println("Read: " + s.getId() + ", " + s.getFirstName());
		
		delete("K-104");
		System.out.println("Delete: K-104");
	}
	
	private static Connection con=null;
	private static Connection getConnection() {
		
		try {
			if(con!=null) return con;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_schema", "admin", "Qwerty@#$%098765");
			return con;
		} catch (Exception e) {
			return null;
		}
	}
	
    public static int add(final String  id, final String firstName) {
        final String query = "INSERT INTO STUDENT VALUES ('" + id + "', '" + firstName + "')";
        try {
			Statement stmt=getConnection().createStatement();
			return stmt.executeUpdate(query); 
		} catch (SQLException e) {
		}
        return -1;
    }

    public static Student get(final String id) {
        try {
			Statement stmt=getConnection().createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM STUDENT WHERE ID = '" + id + "'"); 
			if(rs.next()) {
				return new Student(rs.getString(2), rs.getString(1));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public static int update(final String  id, final String firstName) {
        final String query = "UPDATE STUDENT SET FIRST_NAME='" + firstName + "' WHERE ID='" + id + "'";
        try {
			Statement stmt=getConnection().createStatement();
			return stmt.executeUpdate(query); 
		} catch (SQLException e) {
		}
        return -1;
    }
    
    public static int delete(final String id) {
        final String query = "DELETE FROM STUDENT WHERE ID='" + id + "'";
        try {
			Statement stmt=getConnection().createStatement();
			return stmt.executeUpdate(query); 
		} catch (SQLException e) {
		}
        return -1;
    }
}
