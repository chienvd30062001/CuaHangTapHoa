package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import model.SanPhamModel;
import model.TaiKhoanModel;

public class TaiKhoanDAO_Impl implements TaiKhoanDAO {
	@Override
	public boolean login(String tdn, String mk)  {
	
		 Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM taikhoan WHERE TenDangNhap = ? AND MatKhau = ?";
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tdn);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            
        if (rs.next()) {
        	return true;
        }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public void register(TaiKhoanModel tkm) {
		Connection cons = DBConnect.getConnection();
		String sql = "INSERT INTO taikhoan VALUES(?,?,0,0)";
		try {
		    PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
		    ps.setString(1,tkm.getTenDangNhap());
		    ps.setString(2,tkm.getMatKhau());
		    
		    int rs = ps.executeUpdate();
		    
		    if(rs != 0)
		    {
		    	JOptionPane.showMessageDialog(null, "Đăng Ký Thành Công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		    }
		    else
		    {
		    	JOptionPane.showMessageDialog(null, "Đăng Ký Thất Bại","Lỗi",JOptionPane.ERROR_MESSAGE);
		    }
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Tài Khoản Tồn Tại","Lỗi",JOptionPane.ERROR_MESSAGE);
	    
		}
	}

	@Override
	public void hoatDongDangNhap(String tkm) {
		Connection cons = DBConnect.getConnection();
		String sql = "update taikhoan set TrangThai = 1 where TenDangNhap='"+tkm+"'";
		try {
		    PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
		    ps.executeUpdate();
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Tài Khoản Tồn Tại","Lỗi",JOptionPane.ERROR_MESSAGE);
	    
		}
	}

	@Override
	public String tenDangNhapTaiKhoanHD() {
		String tenDangNhap = "";
		Connection connection = DBConnect.getConnection();
		String query = "select TenDangNhap from taikhoan where TrangThai = 1";
		try {
			Statement stmt = (Statement) connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				tenDangNhap = rs.getString(1);
			}
		} catch (Exception e) {
			// todo
	    
		}
		return tenDangNhap;
	}
	@Override
	public void hoatDongDangXuat(String tkm) {
		Connection cons = DBConnect.getConnection();
		String sql = "update taikhoan set TrangThai = 0 where TenDangNhap='"+tkm+"';";
		try {
		    PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
		    ps.executeUpdate();
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Tài Khoản Tồn Tại","Lỗi",JOptionPane.ERROR_MESSAGE);
	    
		}
	}
	
	@Override
	public List<TaiKhoanModel> getAll() {
		List<TaiKhoanModel> taiKhoanList = new ArrayList<>();
		String query = "select TenDangNhap,Quyen from taikhoan";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				TaiKhoanModel sp = new TaiKhoanModel(rs.getString(1), rs.getBoolean(2));
				taiKhoanList.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return taiKhoanList;
	}
	@Override
	public void update(TaiKhoanModel spm) {
		String query = "update taikhoan set TenDangNhap=?,Quyen=? where TenDangNhap='"
				+ spm.getTenDangNhap() + "'";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, spm.getTenDangNhap());
			pstmt.setBoolean(2, spm.isQuyen());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public boolean getQuyen() {
		boolean quyen = false;
		
		String query = "select Quyen from taikhoan where TrangThai = 1";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				quyen = Boolean.valueOf(rs.getString(1));
			}
		} catch (Exception e) {
			// todo
	    
		}
		return quyen;
	}
}

