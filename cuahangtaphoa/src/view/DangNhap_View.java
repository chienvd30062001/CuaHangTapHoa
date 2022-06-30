package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.TaiKhoanDAO_Impl;
import model.TaiKhoanModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.Button;

public class DangNhap_View extends JFrame {
	private JTextField jtfTaiKhoan;
	private JTextField jtfMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap_View frame = new DangNhap_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap_View() {
		getContentPane().setBackground(SystemColor.info);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 343);
		getContentPane().setLayout(null);
		JButton btnDangKy = new JButton("Đăng Ký");
		btnDangKy.setForeground(SystemColor.controlText);
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnDangKy.setBackground(new Color(255, 228, 196));
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangKy_View formDangKy = new DangKy_View();
				formDangKy.setVisible(true);
				setVisible(false);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Bạn chưa có tài khoản ?");
		lblNewLabel_4.setBackground(SystemColor.info);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(466, 241, 168, 19);
		getContentPane().add(lblNewLabel_4);
		btnDangKy.setBounds(505, 270, 85, 16);
		getContentPane().add(btnDangKy);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 338, 303);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(DangNhap_View.class.getResource("/img/279970076_547265366922217_7920280922150710205_n.jpg")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DangNhap_View.class.getResource("/img/4105941-lock-login-password-security-sign-in-sign-out_113932.png")));
		lblNewLabel_1.setBounds(506, 21, 100, 93);
		getContentPane().add(lblNewLabel_1);
		
		jtfTaiKhoan = new JTextField();
		jtfTaiKhoan.setBounds(451, 124, 194, 23);
		getContentPane().add(jtfTaiKhoan);
		jtfTaiKhoan.setColumns(10);
		
		jtfMatKhau = new JTextField();
		jtfMatKhau.setBounds(451, 160, 194, 23);
		getContentPane().add(jtfMatKhau);
		jtfMatKhau.setColumns(10);
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.setBackground(new Color(255, 228, 196));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoanModel taiKhoan = new TaiKhoanModel();
				TaiKhoanDAO_Impl taiKhoanDAO = new TaiKhoanDAO_Impl();
				TrangChu_View tc = new TrangChu_View();
				String tk = jtfTaiKhoan.getText();
				String mk = jtfMatKhau.getText();
				
				boolean checkDangNhap = taiKhoanDAO.login(tk, mk);
				
				if(tk.equals("") && mk.equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin Tài Khoản và Mật Khẩu","Thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if(checkDangNhap == true)
					{
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công !","Thông báo",JOptionPane.INFORMATION_MESSAGE);
						tc.setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu sai!","Lỗi",JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
	});
		btnDangNhap.setBounds(476, 201, 145, 30);
		getContentPane().add(btnDangNhap);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00E0i Kho\u1EA3n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(379, 124, 71, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("M\u1EADt Kh\u1EA9u");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(379, 165, 71, 16);
		getContentPane().add(lblNewLabel_3);
	}
}
