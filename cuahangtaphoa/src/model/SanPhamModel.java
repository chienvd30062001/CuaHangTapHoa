package model;

public class SanPhamModel {
	private String maSP;
	private String tenSP;
	private int soLuong;
	private int gia;
	
	public SanPhamModel() {
		super();
		this.maSP = "";
		this.tenSP = "";
		this.soLuong = 0;
		this.gia = 0;
	}
	public SanPhamModel(String maSP, String tenSP, int soLuong, int gia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	 public int tinhTongTien(int sotien) {
		 return sotien+tinhTongTien(sotien);
	 }
}
