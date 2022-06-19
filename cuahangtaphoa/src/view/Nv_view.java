package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Canvas;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import model.SanPhamModel;
import DAO.DBConnect;
import DAO.SanPhamDAO;
import DAO.SanPhamDAO_Impl;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Nv_view extends JFrame {

	private JPanel contentPane;
	private JTextField jtfTimKiem;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private static JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane_1;
	private static JTable table_1;
	private JLabel lblMasp;
	private JTextField jtfMaSP;
	private JTextField jtfTenSP;
	private JTextField jtfSoLuong;
	private JTextField jtfGia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nv_view frame = new Nv_view();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Nv_view() {
		
		SanPhamDAO_Impl spDAO = new SanPhamDAO_Impl();
		
		setTitle("CuaHangTapHoa");
		setSize(1036, 558);
		getContentPane().setLayout(null);
		
		jtfTimKiem = new JTextField();
		jtfTimKiem.setBounds(20, 41, 466, 25);
		getContentPane().add(jtfTimKiem);
		jtfTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tim Kiem");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp= new SanPhamModel();
				sp.setTenSP(jtfTimKiem.getText());
				showData(spDAO.getByName(sp));
			}
		});
		btnTimKiem.setBounds(508, 40, 130, 26);
		getContentPane().add(btnTimKiem);
		
		JButton btnLamMoi = new JButton("Lam Moi");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfMaSP.setText("");
				jtfTenSP.setText("");
				jtfSoLuong.setText("");
				jtfGia.setText("");
			}
		});
		btnLamMoi.setBounds(565, 474, 85, 21);
		getContentPane().add(btnLamMoi);
		
		textField_1 = new JTextField();
		textField_1.setBounds(846, 312, 153, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(846, 341, 153, 19);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(846, 370, 153, 19);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(846, 399, 153, 19);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(846, 428, 153, 19);
		getContentPane().add(textField_5);
		
		btnNewButton_2 = new JButton("Thanh to\u00E1n");
		btnNewButton_2.setBackground(new Color(0, 255, 255));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(819, 474, 85, 21);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Xu\u1EA5t");
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(914, 474, 85, 21);
		getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_4.setForeground(new Color(255, 51, 0));
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setBounds(927, 10, 85, 21);
		getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 79, 618, 310);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, ""},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"MaSP", "TenSP", "SoLuong", "Gia"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(111);
		table.getColumnModel().getColumn(2).setPreferredWidth(59);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("T\u1EA1m t\u00EDnh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(701, 312, 94, 15);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Gi\u1EA3m gi\u00E1 (%)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(701, 342, 94, 15);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Tr\u1EA3 l\u1EA1i kh\u00E1ch");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(701, 429, 94, 15);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("T\u1ED5ng C\u1ED9ng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(701, 371, 94, 15);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nh\u1EADn t\u1EEB kh\u00E1ch");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(701, 400, 94, 15);
		getContentPane().add(lblNewLabel_4);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(677, 79, 335, 211);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"MaSP", "TenSP", "SoLuong", "Gia", "Xoa"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(93);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(53);
		scrollPane_1.setViewportView(table_1);
		
		lblMasp = new JLabel("MaSP");
		lblMasp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMasp.setBounds(40, 400, 85, 15);
		getContentPane().add(lblMasp);
		
		jtfMaSP = new JTextField();
		jtfMaSP.setColumns(10);
		jtfMaSP.setBounds(40, 427, 130, 20);
		getContentPane().add(jtfMaSP);
		
		jtfTenSP = new JTextField();
		jtfTenSP.setColumns(10);
		jtfTenSP.setBounds(201, 427, 130, 20);
		getContentPane().add(jtfTenSP);
		
		jtfSoLuong = new JTextField();
		jtfSoLuong.setColumns(10);
		jtfSoLuong.setBounds(356, 426, 130, 20);
		getContentPane().add(jtfSoLuong);
		
		jtfGia = new JTextField();
		jtfGia.setColumns(10);
		jtfGia.setBounds(508, 426, 130, 20);
		getContentPane().add(jtfGia);
		
		JLabel lblTensp = new JLabel("TenSP");
		lblTensp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTensp.setBounds(207, 401, 85, 15);
		getContentPane().add(lblTensp);
		
		JLabel lblSoluong = new JLabel("SoLuong");
		lblSoluong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoluong.setBounds(356, 400, 85, 15);
		getContentPane().add(lblSoluong);
		
		JLabel lblGia = new JLabel("Gia");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGia.setBounds(508, 400, 85, 15);
		getContentPane().add(lblGia);
		
		JButton btnNewButton_2_1 = new JButton("Luu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setMaSP(jtfMaSP.getText());
				sp.setTenSP(jtfTenSP.getText());
				sp.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
				sp.setGia(Integer.parseInt(jtfGia.getText()));
				spDAO.insert(sp);
				JOptionPane.showMessageDialog(null, "Save Success");
				showData(spDAO.getAll());
			}
		});
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2_1.setBackground(Color.BLUE);
		btnNewButton_2_1.setBounds(280, 474, 85, 21);
		getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Xoa");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setMaSP(jtfMaSP.getText());
				spDAO.delete(sp);
				showData(spDAO.getAll());
			}
		});
		btnNewButton_2_2.setForeground(Color.BLACK);
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2_2.setBackground(Color.RED);
		btnNewButton_2_2.setBounds(375, 474, 85, 21);
		getContentPane().add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Cap Nhat");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setMaSP(jtfMaSP.getText());
				sp.setTenSP(jtfTenSP.getText());
				sp.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
				sp.setGia(Integer.parseInt(jtfGia.getText()));
				spDAO.update(sp);
				JOptionPane.showMessageDialog(null, "Save Success");
				showData(spDAO.getAll());
			}
		});
		btnNewButton_2_3.setForeground(Color.BLACK);
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2_3.setBackground(Color.YELLOW);
		btnNewButton_2_3.setBounds(470, 474, 85, 21);
		getContentPane().add(btnNewButton_2_3);
		
		this.setVisible(true);
		
		showData(spDAO.getAll());
	}
	
	public void showData(List<SanPhamModel> spList) {
		List<SanPhamModel> listSanPham = new ArrayList<>();
		listSanPham = spList;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel =(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listSanPham.forEach((sanpham)-> {
			tableModel.addRow(new Object[] {
					sanpham.getMaSP(),sanpham.getTenSP(),sanpham.getSoLuong(),sanpham.getGia()
			});
		});
	}
}
