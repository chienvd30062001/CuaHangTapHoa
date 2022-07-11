package model;

public class TaiKhoanModel {
	private String tenDangNhap;
	private String matKhau;
	private boolean trangThai;
	private boolean quyen;
	
	public TaiKhoanModel() {
		super();
		this.tenDangNhap = "";
		this.matKhau = "";
		this.trangThai = false;
		this.quyen = false;
	}
	public TaiKhoanModel(String tenDangNhap, boolean quyen) {
		this.tenDangNhap = tenDangNhap;
		this.quyen = quyen;
	}
	public TaiKhoanModel(boolean quyen) {
		this.quyen = quyen;
	}
	public boolean isQuyen() {
		return quyen;
	}
	public void setQuyen(boolean quyen) {
		this.quyen = quyen;
	}
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
