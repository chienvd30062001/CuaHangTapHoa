package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import model.NhanVienModel;
import model.SanPhamModel;

public class NhanVienDAO_Impl implements NhanVienDAO {
	@Override
	public List<NhanVienModel> getAll() {
		List<NhanVienModel>nhanVienList = new ArrayList<>();
		String query ="select * from nhanvien";
		try {
			Connection connection = DBConnect.getConnection(); 
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				NhanVienModel nv = new NhanVienModel();
				nv.setMaNhanVien(rs.getString(1));	
				nv.setTenNhanVien(rs.getString(2));	
				nv.setNgaySinh(rs.getDate(3));	
				nv.setQueQuan(rs.getString(4));	
				nv.setDiaChi(rs.getString(5));	
				nv.setThoiGianVao(rs.getDate(6));	
				nhanVienList.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanVienList;
	}
	
	@Override
	public List<NhanVienModel> getByName(NhanVienModel spm) {
		List<NhanVienModel>nhanVienListSearch = new ArrayList<>();
		String query ="select * from nhanvien where TenNhanVien='"+spm.getTenNhanVien()+"'";
		try {
			Connection connection = DBConnect.getConnection(); 
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				NhanVienModel nv = new NhanVienModel();
				nv.setMaNhanVien(rs.getString(1));	
				nv.setTenNhanVien(rs.getString(2));	
				nv.setNgaySinh(rs.getDate(3));	
				nv.setQueQuan(rs.getString(4));	
				nv.setDiaChi(rs.getString(5));	
				nv.setThoiGianVao(rs.getDate(6));	
				nhanVienListSearch.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanVienListSearch;
	}

	@Override
	public void insert(NhanVienModel spm) {
		 String query ="insert into nhanvien values(?,?,?,?,?,?,?)";
			try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt =connection.prepareStatement(query);
			pstmt.setString(1,spm.getMaNhanVien());
			pstmt.setString(2,spm.getTenNhanVien());
			pstmt.setDate(3,(Date) spm.getNgaySinh());
			pstmt.setString(4,spm.getQueQuan());
			pstmt.setString(5,spm.getDiaChi());
			pstmt.setDate(6,(Date) spm.getThoiGianVao());
			pstmt.setString(7,spm.getHinhAnh());
			System.out.println(spm.getHinhAnh());
			pstmt.execute();		
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(NhanVienModel spm) {
		 String query ="delete from nhanvien where ID='"+spm.getMaNhanVien()+"'";
			try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt =connection.prepareStatement(query);
			pstmt.executeUpdate();		
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(NhanVienModel spm) {
		 String query ="update nhanvien set ID=?,TenNV=?,NgaySinh=?,QueQuan=?,DiaChi=?,ThoiGianVao=?,HinhAnh=? where ID='"+spm.getMaNhanVien()+"'";
			try {
				Connection connection = DBConnect.getConnection();
				PreparedStatement pstmt =connection.prepareStatement(query);
				pstmt.setString(1,spm.getMaNhanVien());
				pstmt.setString(2,spm.getTenNhanVien());
				pstmt.setDate(3,(Date) spm.getNgaySinh());
				pstmt.setString(4,spm.getQueQuan());
				pstmt.setString(5,spm.getDiaChi());
				pstmt.setDate(6,(Date) spm.getThoiGianVao());
				pstmt.setString(7,spm.getHinhAnh());
				pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public String getPathHinhAnhByName(String maNhanVien) {
		String HinhAnh ="";
		String query ="select HinhAnh from nhanvien where ID='"+maNhanVien+"'";
		try {
			Connection connection = DBConnect.getConnection(); 
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				//SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),rs.getInt(5),rs.getString(6));
				HinhAnh =rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return HinhAnh;
	}
}
