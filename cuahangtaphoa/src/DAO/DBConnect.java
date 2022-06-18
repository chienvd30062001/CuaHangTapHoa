package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import model.SanPhamModel;

public class DBConnect {
	 public static Connection getConnection() {
	        Connection cons = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cons = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/cuahangtaphoa", "root", "123456");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return cons;
	    }

	    public static void main(String[] args) {
	    	 try {
	             // connnect to database 'testdb'
	             Connection conn = getConnection();
	             // crate statement
	             Statement stmt =(Statement) conn.createStatement();
	             // get data from table 'student'
	             ResultSet rs = stmt.executeQuery("select * from sanpham");
	             // show data
	             while (rs.next()) {
	                 System.out.println(rs.getString(1)+ " " +  rs.getString(1)+ " " +  rs.getInt(3)+ " " + rs.getInt(4));
	                
	             }
	             // close connection
	             conn.close();
	         } catch (Exception ex) {
	             ex.printStackTrace();
	         }
	    }
	
	}

