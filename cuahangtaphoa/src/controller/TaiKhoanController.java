package controller;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.TaiKhoanModel;
import service.TaiKhoanService;
import service.TaiKhoanService_Impl;
import view.DangNhap;
import view.Nv_view;

public class TaiKhoanController {
	private JDialog dialog;
	private DangNhap dangnhap;
	private JTextField jtfTenDangNhap;
    private JButton btnLogin;
    private JTextField jtfMatKhau;
    private JLabel jlbMsg;
    
    private TaiKhoanService taiKhoanService = null;
    
	public TaiKhoanController(JDialog dialog, JTextField jtfTenDangNhap, JButton btnLogin, JTextField jtfMatKhau,JLabel jlbMsg) {
		this.dialog = dialog;
		this.jtfTenDangNhap = jtfTenDangNhap;
		this.btnLogin = btnLogin;
		this.jtfMatKhau = jtfMatKhau;
		this.jlbMsg = jlbMsg;
		
		taiKhoanService = new TaiKhoanService_Impl();
	};
	
	

	public void setEvent() {
		btnLogin.addMouseListener(new MouseAdapter(){
		
		@Override
		public void mouseClicked(MouseEvent e) {
		try {
			if(jtfTenDangNhap.getText().length() == 0 | jtfMatKhau.getText().length() == 0) 
			{
				jlbMsg.setText("Vui long nhap du lieu bat buoc !");
			}else
			{
				TaiKhoanModel taiKhoan = taiKhoanService.login(jtfTenDangNhap.getText(),jtfMatKhau.getText());
				if(taiKhoan == null) {
					jlbMsg.setText("Ten dang nhap mat khau khong dung !");
				}else if(!taiKhoan.isTrangThai())
				{
					jlbMsg.setText(" tai khoan tam khoa!");
				}else
				{
					dialog.dispose();
                    Nv_view frame = new Nv_view();
                    frame.setTitle("Quan ly tap hoa");
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setVisible(true);
				}
			}
		}catch(Exception ex) {
		  jlbMsg.setText(ex.toString());
		}
	}		
		@Override
        public void mouseEntered(MouseEvent e) {
			btnLogin.setBackground(new Color(0, 200, 83));
        }

        @Override
        public void mouseExited(MouseEvent e) {
        	btnLogin.setBackground(new Color(100, 221, 23));
        }
		
	});
  }
	}
		

    



