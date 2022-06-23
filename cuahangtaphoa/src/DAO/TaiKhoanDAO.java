package DAO;

import model.TaiKhoanModel;

public interface TaiKhoanDAO {
	public boolean login(String tdn, String mk);
	public void register(TaiKhoanModel tkm);
}
