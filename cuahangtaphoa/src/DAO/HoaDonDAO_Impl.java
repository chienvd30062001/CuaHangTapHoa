package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import view.BanHang_View;
import model.HoaDonModel;


public class HoaDonDAO_Impl implements HoaDonDAO {

	@Override
	public void insertHoaDon(HoaDonModel hdm,int maHD) {
		String query ="insert into chitiethoadon values(?,?,?,?,?,?,?,?)";
		try {
		Connection connection = DBConnect.getConnection();
		
		PreparedStatement pstmt =connection.prepareStatement(query);
		pstmt.setString(1,String.valueOf(maHD));
		pstmt.setString(2,hdm.getMaSanPham());
		pstmt.setString(3,hdm.getTenSanPham());
		pstmt.setInt(4,hdm.getSoLuong());
		pstmt.setInt(5,hdm.getGia());
		pstmt.setInt(6,hdm.getGiamGia());
		pstmt.setInt(7,hdm.getNhanTuKhach());
		pstmt.setInt(8,hdm.getTraLaiKhach());
		pstmt.setInt(9,hdm.getTongCong());
		pstmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
 	
}
