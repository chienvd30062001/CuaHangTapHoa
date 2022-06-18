package DAO;
import javax.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TaiKhoanModel;

public class TaiKhoanDAO_Impl implements TaiKhoanDAO {
	@Override
	public TaiKhoanModel login(String tdn, String mk)  {
	
		 Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM taikhoan WHERE TenDangNhap LIKE ? AND MatKhau LIKE ?";
        TaiKhoanModel taiKhoan = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tdn);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoan = new TaiKhoanModel();
                taiKhoan.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                taiKhoan.setTenDangNhap(rs.getString("TenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setTrangThai(rs.getBoolean("TrangThai"));
            }
            ps.close();
            cons.close();
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

