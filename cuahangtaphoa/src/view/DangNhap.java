package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TaiKhoanController;

import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JDialog;

public class DangNhap extends JDialog {

	private JPanel contentPane;
	private JTextField jtfTenDangNhap;
	private JTextField jtfMatKhau;
	private JLabel jlbMsg;
	private JButton btnLogin;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DangNhap frame = new DangNhap();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public DangNhap(Frame parent , boolean modal) {
		super(parent,modal);
		TaiKhoanController controller = new TaiKhoanController(this, btnLogin, jtfTenDangNhap, jtfMatKhau, jlbMsg);
		controller.setEvent();
		this.init();
	}
	
	public void init() {
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 345, 394);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DangNhap.class.getResource("/img/279970076_547265366922217_7920280922150710205_n.jpg")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(DangNhap.class.getResource("/img/Safeimagekit-resized-imgpng (1).png")));
		lblNewLabel_1.setBounds(479, 10, 100, 100);
		getContentPane().add(lblNewLabel_1);
		
		jtfTenDangNhap = new JTextField();
		jtfTenDangNhap.setBounds(519, 165, 180, 25);
		getContentPane().add(jtfTenDangNhap);
		jtfTenDangNhap.setColumns(10);
		
		jtfMatKhau = new JTextField();
		jtfMatKhau.setColumns(10);
		jtfMatKhau.setBounds(519, 215, 180, 25);
		getContentPane().add(jtfMatKhau);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.RED);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(396, 278, 300, 27);
		getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.RED);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(399, 315, 300, 27);
		getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(396, 161, 100, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2_1.setBounds(396, 211, 100, 25);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel jlbMsg = new JLabel("New label");
		jlbMsg.setBounds(399, 352, 300, 13);
		getContentPane().add(jlbMsg);
		
		this.setVisible(true);
		
	
	}
	
}
