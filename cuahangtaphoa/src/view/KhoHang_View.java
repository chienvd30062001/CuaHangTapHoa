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
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;

public class KhoHang_View extends JFrame {

  	private JPanel contentPane;
	private JTextField jtfTimKiem;
	private JTextField jtfGiamGia;
	private JButton btnNewButton_4;
	private static JTable table;
	private JLabel lblNewLabel_1;
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
					KhoHang_View frame = new KhoHang_View();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KhoHang_View() {
		
		SanPhamDAO_Impl spDAO = new SanPhamDAO_Impl();
		List<SanPhamModel> listMuaHang = new ArrayList<>();
		
		setTitle("CuaHangTapHoa");
		setSize(1036, 558);
		getContentPane().setLayout(null);
		
		jtfTimKiem = new JTextField();
		jtfTimKiem.setBounds(20, 41, 388, 25);
		getContentPane().add(jtfTimKiem);
		jtfTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp= new SanPhamModel();
				sp.setTenSP(jtfTimKiem.getText());
				showData(spDAO.getByName(sp));
			}
		});
		btnTimKiem.setBounds(418, 41, 100, 26);
		getContentPane().add(btnTimKiem);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfMaSP.setText("");
				jtfTenSP.setText("");
				jtfSoLuong.setText("");
				jtfGia.setText("");
				jtfGiamGia.setText("");
				showData(spDAO.getAll());
			}
		});
		btnLamMoi.setBounds(528, 41, 108, 26);
		getContentPane().add(btnLamMoi);
		
		jtfGiamGia = new JTextField();
		jtfGiamGia.setColumns(10);
		jtfGiamGia.setBounds(819, 331, 160, 25);
		getContentPane().add(jtfGiamGia);
		
		btnNewButton_4 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_4.setForeground(new Color(255, 51, 0));
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setBounds(927, 10, 85, 21);
		getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 79, 616, 374);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, "", null},
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
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Gi\u1EA3m gi\u00E1 (%)"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(111);
		table.getColumnModel().getColumn(2).setPreferredWidth(59);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		lblNewLabel_1 = new JLabel("Gi\u1EA3m gi\u00E1 (%)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(701, 332, 108, 24);
		getContentPane().add(lblNewLabel_1);
		
		lblMasp = new JLabel("Mã Sản Phẩm");
		lblMasp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMasp.setBounds(701, 124, 95, 24);
		getContentPane().add(lblMasp);
		
		jtfMaSP = new JTextField();
		jtfMaSP.setColumns(10);
		jtfMaSP.setBounds(819, 123, 160, 25);
		getContentPane().add(jtfMaSP);
		
		jtfTenSP = new JTextField();
		jtfTenSP.setColumns(10);
		jtfTenSP.setBounds(819, 175, 160, 25);
		getContentPane().add(jtfTenSP);
		
		jtfSoLuong = new JTextField();
		jtfSoLuong.setColumns(10);
		jtfSoLuong.setBounds(819, 228, 160, 25);
		getContentPane().add(jtfSoLuong);
		
		jtfGia = new JTextField();
		jtfGia.setColumns(10);
		jtfGia.setBounds(819, 281, 160, 25);
		getContentPane().add(jtfGia);
		
		JLabel lblTensp = new JLabel("Tên Sản Phẩm");
		lblTensp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTensp.setBounds(701, 176, 108, 24);
		getContentPane().add(lblTensp);
		
		JLabel lblSoluong = new JLabel("Số Lượng");
		lblSoluong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoluong.setBounds(701, 228, 85, 25);
		getContentPane().add(lblSoluong);
		
		JLabel lblGia = new JLabel("Giá");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGia.setBounds(701, 282, 85, 24);
		getContentPane().add(lblGia);
		
		JButton btnNewButton_2_1 = new JButton("Lưu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setMaSP(jtfMaSP.getText());
				sp.setTenSP(jtfTenSP.getText());
				sp.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
				sp.setGia(Integer.parseInt(jtfGia.getText()));
				sp.setGiamGia(Integer.parseInt(jtfGiamGia.getText()));
				spDAO.insert(sp);
				JOptionPane.showMessageDialog(null, "Save Success");
				showData(spDAO.getAll());
				jtfMaSP.setText("");
				jtfTenSP.setText("");
				jtfSoLuong.setText("");
				jtfGia.setText("");
				jtfGiamGia.setText("");
			}
		});
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1.setBackground(Color.BLUE);
		btnNewButton_2_1.setBounds(690, 405, 100, 21);
		getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Xóa");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setMaSP(jtfMaSP.getText());
				spDAO.delete(sp);
				showData(spDAO.getAll());
			}
		});
		btnNewButton_2_2.setForeground(Color.BLACK);
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2_2.setBounds(910, 405, 100, 21);
		getContentPane().add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Cập nhật");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setMaSP(jtfMaSP.getText());
				sp.setTenSP(jtfTenSP.getText());
				sp.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
				sp.setGia(Integer.parseInt(jtfGia.getText()));
				sp.setGiamGia(Integer.parseInt(jtfGiamGia.getText()));
				spDAO.update(sp);
				JOptionPane.showMessageDialog(null, "Save Success");
				showData(spDAO.getAll());
			}
		});
		btnNewButton_2_3.setForeground(Color.BLACK);
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_3.setBackground(Color.YELLOW);
		btnNewButton_2_3.setBounds(800, 405, 100, 21);
		getContentPane().add(btnNewButton_2_3);
		
		JButton btnLayDuLieu = new JButton("Lấy dữ liệu");
		btnLayDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layDuLieu();
			}
		});
		btnLayDuLieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLayDuLieu.setBounds(904, 432, 108, 21);
		getContentPane().add(btnLayDuLieu);
		
		JLabel lblNewLabel = new JLabel("Chi Tiết Sản Phẩm");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(722, 39, 239, 25);
		getContentPane().add(lblNewLabel);
		
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
					sanpham.getMaSP(),sanpham.getTenSP(),sanpham.getSoLuong(),sanpham.getGia(),sanpham.getGiamGia()
			});
		});
	}

	/*
	 * public void showData_2(List<SanPhamModel> spList) { List<SanPhamModel>
	 * listSanPham = new ArrayList<>(); listSanPham = spList; DefaultTableModel
	 * tableModel; table_1.getModel(); tableModel
	 * =(DefaultTableModel)table_1.getModel(); tableModel.setRowCount(0);
	 * listSanPham.forEach((sanpham)-> { tableModel.addRow(new Object[] {
	 * sanpham.getMaSP(),sanpham.getTenSP(),sanpham.getSoLuong(),sanpham.getGia()
	 * }); }); }
	 */
	public void layDuLieu() {
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		int index = table.getSelectedRow();
		//SanPhamModel sp = new SanPhamModel();
		jtfMaSP.setText(String.valueOf(modelTable.getValueAt(index, 0)));
		jtfTenSP.setText(String.valueOf(modelTable.getValueAt(index, 1)));
		jtfSoLuong.setText(String.valueOf(modelTable.getValueAt(index,2)));
		jtfGia.setText(String.valueOf(modelTable.getValueAt(index, 3)));
		jtfGiamGia.setText(String.valueOf(modelTable.getValueAt(index, 4)));
		
	
}
}
