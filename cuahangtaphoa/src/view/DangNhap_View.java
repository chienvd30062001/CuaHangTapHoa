package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.TaiKhoanDAO_Impl;
import Helper.ImageHelper;
import model.TaiKhoanModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.Component;
import javax.swing.JPasswordField;

public class DangNhap_View extends JFrame {
	private JTextField jtfTaiKhoan;
	private JPasswordField jtfMatKhau;
	private static boolean taiKhoanDangNhap;

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
		TaiKhoanDAO_Impl tkDAO = new TaiKhoanDAO_Impl();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 695);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(242,242,242));
		
		jtfTaiKhoan = new JTextField();
		jtfTaiKhoan.setAlignmentX(Component.RIGHT_ALIGNMENT);
		jtfTaiKhoan.setBounds(670, 261, 194, 25);
		getContentPane().add(jtfTaiKhoan);
		jtfTaiKhoan.setColumns(10);
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.setBackground(new Color(148, 189, 242));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoanModel taiKhoan = new TaiKhoanModel();
				TaiKhoanDAO_Impl taiKhoanDAO = new TaiKhoanDAO_Impl();
				TrangChu_View tc = new TrangChu_View();
				TrangChuNhanVien_View tcnv = new TrangChuNhanVien_View();
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
						tkDAO.hoatDongDangNhap(jtfTaiKhoan.getText());
						taiKhoanDangNhap = tkDAO.getQuyen();
						System.out.println(taiKhoanDangNhap);
						if(tk.equals("admin") || taiKhoanDangNhap == true) 
						{
							tc.setVisible(true);
							setVisible(false);
						}
						else
						{
							tcnv.setVisible(true);
							setVisible(false);
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu sai!","Lỗi",JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
	});
		btnDangNhap.setBounds(652, 377, 183, 30);
		getContentPane().add(btnDangNhap);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00E0i Kho\u1EA3n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(553, 261, 89, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("M\u1EADt Kh\u1EA9u");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(553, 305, 89, 25);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblAnhBia = new JLabel("");
		lblAnhBia.setAlignmentX(0.5f);
		ImageIcon icon =new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\login\\617899945bc0c8bef34edefba03ca8bd.png");
		Image img = ImageHelper.resize(icon.getImage(), 440, 660);
		ImageIcon resizeIcon = new ImageIcon(img);
		lblAnhBia.setIcon(resizeIcon);
		lblAnhBia.setBounds(0, 0, 440, 660);
		getContentPane().add(lblAnhBia);
		
		jtfMatKhau = new JPasswordField();
		jtfMatKhau.setBounds(670, 308, 194, 25);
		getContentPane().add(jtfMatKhau);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\login\\user (2).png"));
		lblNewLabel.setBounds(708, 127, 111, 81);
		getContentPane().add(lblNewLabel);
	}
}
