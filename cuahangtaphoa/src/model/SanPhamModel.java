package model;

public class SanPhamModel {
	private String maSP;
	private String tenSP;
	private int soLuong;
	private int gia;
	private int giamGia;
	private String hinhAnh;
	
	
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public int getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}
	public SanPhamModel() {
		super();
		this.maSP = "";
		this.tenSP = "";
		this.soLuong = 0;
		this.gia = 0;
		this.giamGia =0;
	}
	public SanPhamModel(String maSP, String tenSP, int soLuong, int gia, int giamGia,String hinhAnh) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.gia = gia;
		this.giamGia = giamGia;
		this.hinhAnh= hinhAnh;
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
