package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import model.NhanVienModel;
import model.SanPhamModel;

public interface NhanVienDAO {
	public List<NhanVienModel> getAll();
	public List<NhanVienModel> getByName(NhanVienModel spm);
	public void insert(NhanVienModel spm);
	public void delete(NhanVienModel spm);
	public void update(NhanVienModel spm);
	public String getPathHinhAnhByName(String maSP);
	
}
