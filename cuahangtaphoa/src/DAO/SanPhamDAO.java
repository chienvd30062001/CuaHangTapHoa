package DAO;

import java.util.List;

import model.SanPhamModel;

public interface SanPhamDAO {
	public List<SanPhamModel> getAll();
	public List<SanPhamModel> getAllMuaHang();
	public List<SanPhamModel> getByName(SanPhamModel spm);
	public void insert(SanPhamModel spm);
	public void insertMuaHang(SanPhamModel spm,int maHD);
	public void delete(SanPhamModel spm);
	public void deleteMuaHang();
	public void update(SanPhamModel spm);
	public void updateAfterBuy(SanPhamModel spm,int sl_mua);
	public String getPathHinhAnhByName(String maSP);

	//mo rong getbyma......
}
