package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

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
		String sql = "INSERT INTO taikhoan VALUES(?,?,0)";
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

}

