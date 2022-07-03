package model;

import java.sql.Date;

public class NhanVienModel {
	private String maNhanVien; //ID trong database (nhanvien)
	private String tenNhanVien;
	private Date ngaySinh;
	private String queQuan;	
	private String diaChi;
	private Date thoiGianVao;
	private String hinhAnh;
	
	
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getThoiGianVao() {
		return thoiGianVao;
	}
	public void setThoiGianVao(Date thoiGianVao) {
		this.thoiGianVao = thoiGianVao;
	}
}
