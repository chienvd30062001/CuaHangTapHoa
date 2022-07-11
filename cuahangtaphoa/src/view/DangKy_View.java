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
		getContentPane().setBackground(new Color(242, 242, 242));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 700);
		getContentPane().setLayout(null);

		jtfTaiKhoan_dk = new JTextField();
		jtfTaiKhoan_dk.setBounds(655, 236, 215, 25);
		getContentPane().add(jtfTaiKhoan_dk);
		jtfTaiKhoan_dk.setColumns(10);

		JButton btnDangNhap = new JButton("Xác nhận");
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDangNhap.setBackground(new Color(148, 189, 242));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tk_dk = jtfTaiKhoan_dk.getText();
				String mk_dk = jtfMatKhau_dk.getText();
				if (!tk_dk.equals("") && !mk_dk.equals("")) {
					TaiKhoanModel tk = new TaiKhoanModel();
					TaiKhoanDAO_Impl taiKhoanDAO = new TaiKhoanDAO_Impl();

					tk.setTenDangNhap(tk_dk);
					tk.setMatKhau(mk_dk);

					taiKhoanDAO.register(tk);
					jtfTaiKhoan_dk.setText("");
					jtfMatKhau_dk.setText("");

				}
			}
		});
		btnDangNhap.setBounds(554, 364, 153, 26);
		getContentPane().add(btnDangNhap);

		JLabel lblNewLabel_2 = new JLabel("T\u00E0i Kho\u1EA3n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(554, 245, 71, 16);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("M\u1EADt Kh\u1EA9u");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(554, 290, 71, 16);
		getContentPane().add(lblNewLabel_3);

		JButton btnThot = new JButton("Thoát");
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu_View tc = new TrangChu_View();
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnThot.setBackground(new Color(255, 102, 102));
		btnThot.setBounds(717, 364, 153, 26);
		getContentPane().add(btnThot);

		jtfMatKhau_dk = new JPasswordField();
		jtfMatKhau_dk.setBounds(655, 281, 215, 25);
		getContentPane().add(jtfMatKhau_dk);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\login\\617899945bc0c8bef34edefba03ca8bd.png"));
		lblNewLabel.setBounds(0, 0, 440, 670);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\login\\add.png"));
		lblNewLabel_1.setBounds(701, 93, 79, 94);
		getContentPane().add(lblNewLabel_1);
	}
}
