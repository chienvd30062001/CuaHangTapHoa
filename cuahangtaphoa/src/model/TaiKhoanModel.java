package model;

public class TaiKhoanModel {
	
	/*
	 * public TaiKhoanModel(String tenDangNhap, String matKhau, boolean trangThai) {
	 * this.tenDangNhap = tenDangNhap; this.matKhau = matKhau; this.trangThai =
	 * trangThai; }
	 * 
	 * public TaiKhoanModel() { this.tenDangNhap = ""; this.matKhau = "";
	 * this.trangThai = false; }
	 */

	private String tenDangNhap;
	private String matKhau;
	private boolean trangThai;
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	
}
