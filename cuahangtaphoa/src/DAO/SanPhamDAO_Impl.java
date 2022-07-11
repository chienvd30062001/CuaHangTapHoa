package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.HoaDonModel;
import model.SanPhamModel;
import view.KhoHang_View;

public class SanPhamDAO_Impl implements SanPhamDAO {

	@Override
	public List<SanPhamModel> getAll() {
		List<SanPhamModel> sanPhamList = new ArrayList<>();
		String query = "select * from sanpham";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getString(6));
				sanPhamList.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPhamList;
	}

	@Override
	public List<SanPhamModel> getAllMuaHang() {
		List<SanPhamModel> sanPhamList = new ArrayList<>();
		String query = "select * from muahang";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getString(6));
				sanPhamList.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPhamList;
	}

	@Override
	public void insert(SanPhamModel spm) {
		String query = "insert into sanpham values(?,?,?,?,?,?)";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, spm.getMaSP());
			pstmt.setString(2, spm.getTenSP());
			pstmt.setInt(3, spm.getSoLuong());
			pstmt.setInt(4, spm.getGia());
			pstmt.setInt(5, spm.getGiamGia());
			pstmt.setString(6, spm.getHinhAnh());
			System.out.println(spm.getHinhAnh());
			pstmt.execute();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void delete(SanPhamModel spm) {
		String query = "delete from sanpham where MaSP='" + spm.getMaSP() + "';";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(SanPhamModel spm) {
		String query = "update sanpham set MaSP=?,TenSp=?,SoLuong=?,Gia=?,GiamGia=?,HinhAnh=? where MaSP='"
				+ spm.getMaSP() + "'";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, spm.getMaSP());
			pstmt.setString(2, spm.getTenSP());
			pstmt.setInt(3, spm.getSoLuong());
			pstmt.setInt(4, spm.getGia());
			pstmt.setInt(5, spm.getGiamGia());
			pstmt.setString(6, spm.getHinhAnh());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<SanPhamModel> getByName(SanPhamModel spm) {
		List<SanPhamModel> sanPhamListSearch = new ArrayList<>();
		String query = "select * from sanpham where sanpham.TenSP='" + spm.getTenSP() + "'";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getString(6));
				sanPhamListSearch.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sanPhamListSearch;
	}

	@Override
	public String getPathHinhAnhByName(String maSP) {
		String HinhAnh = "";
		String query = "select HinhAnh from sanpham where sanpham.MaSP='" + maSP + "'";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2),
				// rs.getInt(3), rs.getInt(4),rs.getInt(5),rs.getString(6));
				HinhAnh = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return HinhAnh;
	}

	@Override
	public void updateAfterBuy(SanPhamModel spm, int sl_mua) {
		String query = "update sanpham set MaSP=?,TenSp=?,SoLuong=?-'" + sl_mua + "',Gia=? where MaSP='" + spm.getMaSP()
				+ "'";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, spm.getMaSP());
			pstmt.setString(2, spm.getTenSP());
			pstmt.setInt(3, spm.getSoLuong());
			pstmt.setInt(4, spm.getGia());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void insertMuaHang(SanPhamModel spm, int maHD) {
		String query = "insert into muahang values(?,?,?,?,?,?)";
		try {

			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, spm.getMaSP());
			pstmt.setString(2, spm.getTenSP());
			pstmt.setInt(3, spm.getSoLuong());
			pstmt.setInt(4, spm.getGia());
			pstmt.setInt(5, spm.getGiamGia());
			pstmt.setInt(6, maHD);
			pstmt.execute();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void deleteMuaHang() {
		String query = "delete from muahang";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteMuaHangByMaSP(String maSP) {
		String query = "delete from muahang where MaSP='" + maSP + "'";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void updateSanPhamSauThanhToan(SanPhamModel spm) {
		List<SanPhamModel> listMuaHang = new ArrayList<>();
		listMuaHang = getByName(spm);
		int soLuongBanDau = listMuaHang.get(0).getSoLuong();

		String query = "update sanpham set MaSP=?,TenSp=?,SoLuong=" + soLuongBanDau
				+ "-?,Gia=?,GiamGia=?,HinhAnh=? where MaSP='" + spm.getMaSP() + "'";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, spm.getMaSP());
			pstmt.setString(2, spm.getTenSP());
			pstmt.setInt(3, spm.getSoLuong());
			pstmt.setInt(4, spm.getGia());
			pstmt.setInt(5, spm.getGiamGia());
			pstmt.setString(6, spm.getHinhAnh());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}