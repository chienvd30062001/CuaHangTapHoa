package service;

import DAO.TaiKhoanDAO;
import DAO.TaiKhoanDAO_Impl;
import model.TaiKhoanModel;

public class TaiKhoanService_Impl implements TaiKhoanService{
	private TaiKhoanDAO taiKhoanDAO = null;
	
	
	public TaiKhoanService_Impl() {
		taiKhoanDAO = new TaiKhoanDAO_Impl();
	}


	@Override
	public TaiKhoanModel login(String tdn, String mk) {
		
		return taiKhoanDAO.login(tdn, mk);
	}

}
