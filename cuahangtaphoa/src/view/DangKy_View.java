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
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class DangKy_View extends JFrame {
	private JTextField jtfTaiKhoan_dk;
	private JPasswordField jtfMatKhau_dk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy_View frame = new DangKy_View();
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
	public DangKy_View() {
		getContentPane().setBackground(SystemColor.info);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 343);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 338, 303);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(DangNhap_View.class.getResource("/img/279970076_547265366922217_7920280922150710205_n.jpg")));
		panel.add(lblNewLabel);
		
		jtfTaiKhoan_dk = new JTextField();
		jtfTaiKhoan_dk.setBounds(459, 154, 194, 23);
		getContentPane().add(jtfTaiKhoan_dk);
		jtfTaiKhoan_dk.setColumns(10);
		
		JButton btnDangNhap = new JButton("Xác nhận");
		btnDangNhap.setBackground(new Color(255, 222, 173));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tk_dk=jtfTaiKhoan_dk.getText();
				String mk_dk=jtfMatKhau_dk.getText();
				if(!tk_dk.equals("") && !mk_dk.equals("")) {
					TaiKhoanModel tk = new TaiKhoanModel();
					TaiKhoanDAO_Impl taiKhoanDAO =new TaiKhoanDAO_Impl();
					
					tk.setTenDangNhap(tk_dk);
					tk.setMatKhau(mk_dk);
					
					taiKhoanDAO.register(tk);
					
				}
			}
	});
		btnDangNhap.setBounds(459, 242, 92, 26);
		getContentPane().add(btnDangNhap);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00E0i Kho\u1EA3n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(386, 154, 71, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("M\u1EADt Kh\u1EA9u");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(386, 195, 71, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(DangKy_View.class.getResource("/img/register_login_signup_icon_219991 (1).png")));
		lblNewLabel_1.setBounds(493, 49, 77, 66);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap_View dn = new DangNhap_View();
				
				dn.setVisible(true);
				setVisible(false);
			}
		});
		btnThot.setBackground(Color.RED);
		btnThot.setBounds(568, 242, 85, 26);
		getContentPane().add(btnThot);
		
		jtfMatKhau_dk = new JPasswordField();
		jtfMatKhau_dk.setBounds(459, 187, 194, 24);
		getContentPane().add(jtfMatKhau_dk);
	}
}
