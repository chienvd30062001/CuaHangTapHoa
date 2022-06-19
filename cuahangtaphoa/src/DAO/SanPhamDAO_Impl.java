package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.SanPhamModel;
import view.Nv_view;

public class SanPhamDAO_Impl implements SanPhamDAO {

	@Override
	public List<SanPhamModel> getAll() {
		List<SanPhamModel>sanPhamList = new ArrayList<>();
		String query ="select * from sanpham";
		try {
			Connection connection = DBConnect.getConnection(); 
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				sanPhamList.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPhamList;
	}

	@Override
	public void insert(SanPhamModel spm) {
	 String query ="insert into sanpham values(?,?,?,?)";
		try {
		Connection connection = DBConnect.getConnection();
		PreparedStatement pstmt =connection.prepareStatement(query);
		pstmt.setString(1,spm.getMaSP());
		pstmt.setString(2,spm.getTenSP());
		pstmt.setInt(3,spm.getSoLuong());
		pstmt.setInt(4,spm.getGia());
		pstmt.execute();		
			
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	}

	@Override
	public void delete(SanPhamModel spm) {
		 String query ="delete from sanpham where name='"+spm.getMaSP()+"'";
			try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt =connection.prepareStatement(query);
			pstmt.executeUpdate();		
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(SanPhamModel spm) {
		 String query ="update sanpham set MaSP=?,TenSp=?,SoLuong=?,Gia=? name='"+spm.getMaSP()+"'";
			try {
				Connection connection = DBConnect.getConnection();
				PreparedStatement pstmt =connection.prepareStatement(query);
				pstmt.setString(1,spm.getMaSP());
				pstmt.setString(2,spm.getTenSP());
				pstmt.setInt(3,spm.getSoLuong());
				pstmt.setInt(4,spm.getGia());
				pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}

	@Override
	public List<SanPhamModel> getByName(SanPhamModel spm) {
		List<SanPhamModel>sanPhamListSearch = new ArrayList<>();
		String query ="select * from sanpham where sanpham.TenSP='"+spm.getTenSP()+"'";
		try {
			Connection connection = DBConnect.getConnection(); 
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				sanPhamListSearch.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.print(sanPhamListSearch);
		return sanPhamListSearch;
	}

}