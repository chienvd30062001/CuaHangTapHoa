package test;

import view.DangNhap;

public class MainTest {
	public static void main(String[] args) {
		DangNhap dialog = new DangNhap();
		dialog.setTitle("Dang nhap he thong");
		dialog.setSize(750, 430);
		//dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
}
