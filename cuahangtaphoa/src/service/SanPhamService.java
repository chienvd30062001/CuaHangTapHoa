package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import DAO.DBConnect;
import model.SanPhamModel;

public class SanPhamService {
	public static List<SanPhamModel> getAll() {
		List<SanPhamModel>sanPhamList = new ArrayList<>();
		String query ="select * from sanpham";
		try {
			Connection connection = DBConnect.getConnection(); 
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				SanPhamModel sp = new SanPhamModel(rs.getString(0), rs.getString(1), rs.getInt(2), rs.getInt(3));
				sanPhamList.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPhamList;
	}
}
