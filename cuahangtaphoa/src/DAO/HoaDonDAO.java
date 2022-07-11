package DAO;

import java.util.List;

import model.HoaDonModel;
import model.SanPhamModel;

public interface HoaDonDAO {
	public void insertChiTietHoaDon(HoaDonModel hdm, int maHD);

	public void insertHoaDon(HoaDonModel hdm, int maHD);

	public void deleteHoaDonBySelected(int maHD);

	public List<HoaDonModel> getAllHoaDon();

	public List<HoaDonModel> getAllChiTietHoaDon();

	public List<HoaDonModel> getAllChiTietHoaDonfromHoaDon(int index);

	public List<HoaDonModel> getAllChiTietHoaDonToJtf(String Index);

	public List<HoaDonModel> getAllHoaDonByName(HoaDonModel hdm);

	public void deleteHoaDon();

	public void deleteChiTietHoaDon();

	public int getMaHD();

	// public void deleteSanPhamInChiTietHoaDon(String maSP);
}
