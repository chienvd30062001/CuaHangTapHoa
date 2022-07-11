package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import view.BanHang_View;
import model.HoaDonModel;
import model.SanPhamModel;

public class HoaDonDAO_Impl implements HoaDonDAO {

	@Override
	public void insertChiTietHoaDon(HoaDonModel hdm, int maHD) {
		String query = "insert into chitiethoadon values(?,?,?,?,?,?)";
		try {
			Connection connection = DBConnect.getConnection();

			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, String.valueOf(maHD));
			pstmt.setString(2, hdm.getMaSanPham());
			pstmt.setString(3, hdm.getTenSanPham());
			pstmt.setInt(4, hdm.getSoLuong());
			pstmt.setInt(5, hdm.getGia());
			pstmt.setInt(6, hdm.getGiamGia());
			pstmt.execute();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void deleteHoaDonBySelected(int maHD) {
		String query = "delete from hoadon where MaHD=" + maHD+";";
		System.out.println(query);
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void insertHoaDon(HoaDonModel hdm, int maHD) {
		String query = "insert into hoadon values(?,?,?,?)";
		try {
			Connection connection = DBConnect.getConnection();

			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, String.valueOf(maHD));
			pstmt.setInt(2, hdm.getTongTien());
			pstmt.setInt(3, hdm.getNhanTuKhach());
			pstmt.setInt(4, hdm.getTraLaiKhach());

			pstmt.execute();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void deleteChiTietHoaDon() {
		String query = "delete from chitiethoadon";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void deleteHoaDon() {
		String query = "delete from hoadon";
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<HoaDonModel> getAllHoaDon() {
		List<HoaDonModel> hoaDonlist = new ArrayList<>();
		String query = "select * from hoadon";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				HoaDonModel hd = new HoaDonModel();
				hd.setMaHoaDon(rs.getInt(1));
				hd.setTongTien(rs.getInt(2));
				hd.setNhanTuKhach(rs.getInt(3));
				hd.setTraLaiKhach(rs.getInt(4));
				hoaDonlist.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hoaDonlist;
	}

	@Override
	public List<HoaDonModel> getAllChiTietHoaDon() {
		List<HoaDonModel> chiTietHoaDonlist = new ArrayList<>();
		String query = "select * from chitiethoadon ";
		System.out.println(query);
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				HoaDonModel cthd = new HoaDonModel();
				cthd.setMaHoaDon(rs.getInt(1));
				cthd.setMaSanPham(rs.getString(2));
				cthd.setTenSanPham(rs.getString(3));
				cthd.setSoLuong(rs.getInt(4));
				cthd.setGia(rs.getInt(5));
				cthd.setGiamGia(rs.getInt(6));
				chiTietHoaDonlist.add(cthd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return chiTietHoaDonlist;
	}

// hien thi du lieu từ jtablehoadon sang jtablechitiehoadon
	@Override
	public List<HoaDonModel> getAllChiTietHoaDonfromHoaDon(int index) {
		List<HoaDonModel> chiTietHoaDonlist = new ArrayList<>();
		int maHD = index + 1;
		String query = "select * from chitiethoadon where maHD=" + maHD;
		System.out.println(query);
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				HoaDonModel cthd = new HoaDonModel();
				cthd.setMaHoaDon(rs.getInt(1));
				cthd.setMaSanPham(rs.getString(2));
				cthd.setTenSanPham(rs.getString(3));
				cthd.setSoLuong(rs.getInt(4));
				cthd.setGia(rs.getInt(5));
				cthd.setGiamGia(rs.getInt(6));
				chiTietHoaDonlist.add(cthd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return chiTietHoaDonlist;
	}

//hien thi jtable xuong jtextfield
	@Override
	public List<HoaDonModel> getAllChiTietHoaDonToJtf(String Index) {
		List<HoaDonModel> chiTietHoaDonlist = new ArrayList<>();
		String query = "select * from chitiethoadon where MaSP='" + Index + "'";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				HoaDonModel cthd = new HoaDonModel();
				cthd.setMaHoaDon(rs.getInt(1));
				cthd.setMaSanPham(rs.getString(2));
				cthd.setTenSanPham(rs.getString(3));
				cthd.setSoLuong(rs.getInt(4));
				cthd.setGia(rs.getInt(5));
				cthd.setGiamGia(rs.getInt(6));
				chiTietHoaDonlist.add(cthd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return chiTietHoaDonlist;
	}

	@Override
	public List<HoaDonModel> getAllHoaDonByName(HoaDonModel hdm) {
		List<HoaDonModel> hoaDonListSearch = new ArrayList<>();
		String query = "select * from hoadon where maHD='" + hdm.getMaHoaDon() + "'";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				HoaDonModel hd = new HoaDonModel();
				hd.setMaHoaDon(rs.getInt(1));
				hd.setTongTien(rs.getInt(2));
				hd.setNhanTuKhach(rs.getInt(3));
				hd.setTraLaiKhach(rs.getInt(4));

				hoaDonListSearch.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hoaDonListSearch;
	}

	@Override
	public int getMaHD() {
		int maHDCuoi = 0;
		String query = "SELECT MaHD FROM hoadon ORDER BY MaHD DESC LIMIT 1;";
		try {
			Connection connection = DBConnect.getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				maHDCuoi = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(maHDCuoi);
		return maHDCuoi;
	}

}
