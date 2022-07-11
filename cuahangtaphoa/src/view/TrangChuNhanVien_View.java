package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.TaiKhoanDAO_Impl;
import view.DangNhap_View;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TrangChuNhanVien_View extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuNhanVien_View  frame = new TrangChuNhanVien_View ();
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
	public TrangChuNhanVien_View () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 531);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242,242,242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u1EECA H\u00C0NG T\u1EA0P H\u00D3A 3AE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(313, 46, 420, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("DANH M\u1EE4C QU\u1EA2N L\u00DD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(406, 114, 234, 25);
		contentPane.add(lblNewLabel_2);

		JButton btnKhoHang = new JButton("");
		btnKhoHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhoHang_View kh = new KhoHang_View();
				kh.setVisible(true);
				setVisible(false);
			}
		});
		btnKhoHang.setBackground(new Color(92,157,242));
		btnKhoHang.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\ManHinhChinh\\warehouse (4).png"));
		btnKhoHang.setBounds(598, 249, 125, 90);
		contentPane.add(btnKhoHang);

		JButton btnNewButton_4 = new JButton("\u0110\u0103ng Xu\u1EA5t");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap_View dn = new DangNhap_View();
				TaiKhoanDAO_Impl tkDAO = new TaiKhoanDAO_Impl();
				dn.setVisible(true);
				setVisible(false);
				tkDAO.hoatDongDangXuat(tkDAO.tenDangNhapTaiKhoanHD());
			}
		});
		btnNewButton_4.setBackground(new Color(255, 102, 102));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(897, 453, 125, 31);
		contentPane.add(btnNewButton_4);

		JButton btnBanHang = new JButton("");
		btnBanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BanHang_View bh = new BanHang_View();
				bh.setVisible(true);
				setVisible(false);
			}
		});
		btnBanHang.setBackground(new Color(92,157,242));
		btnBanHang.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\ManHinhChinh\\food-delivery.png"));
		btnBanHang.setBounds(294, 249, 125, 90);
		contentPane.add(btnBanHang);
		
		JLabel lblNewLabel_3 = new JLabel("Qu\u1EA3n L\u00FD B\u00E1n H\u00E0ng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(294, 198, 125, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Qu\u1EA3n L\u00FD Kho H\u00E0ng");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(598, 198, 125, 25);
		contentPane.add(lblNewLabel_3_1);
	}
}
