package DAO;

import java.util.List;

import model.SanPhamModel;
import model.TaiKhoanModel;

public interface TaiKhoanDAO {
	public boolean login(String tdn, String mk);
	public void register(TaiKhoanModel tkm);
	public void hoatDongDangNhap(String tkm);
	public void hoatDongDangXuat(String tkm);
	public String tenDangNhapTaiKhoanHD();
	public List<TaiKhoanModel> getAll() ;
	public void update(TaiKhoanModel tkm);
	public boolean getQuyen();
			
}
