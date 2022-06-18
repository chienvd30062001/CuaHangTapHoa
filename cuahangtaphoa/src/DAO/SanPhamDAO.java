package DAO;

import java.util.List;

import model.SanPhamModel;

public interface SanPhamDAO {
	public List<SanPhamModel> getAll();
	//public void showData(List<SanPhamModel> spList);
	public List<SanPhamModel> getByName(SanPhamModel spm);
	public void insert(SanPhamModel spm);
	public void delete(SanPhamModel spm);
	public void update(SanPhamModel spm);
	//mo rong getbyma......
}
