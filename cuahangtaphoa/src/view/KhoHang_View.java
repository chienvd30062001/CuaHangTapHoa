package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextPane;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.JDBC4LoadBalancedMySQLConnection;

import model.SanPhamModel;
import DAO.DBConnect;
import DAO.SanPhamDAO;
import DAO.SanPhamDAO_Impl;
import Helper.ImageHelper;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class KhoHang_View extends JFrame {

  	private JPanel contentPane;
	private JTextField jtfTimKiem;
	private JTextField jtfGiamGia;
	private JButton btnNewButton_4;
	private static JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblMasp;
	//private JLabel lblmage;
	private JTextField jtfMaSP;
	private JTextField jtfTenSP;
	private JTextField jtfSoLuong;
	private JTextField jtfGia;
	private byte[] sanphamImage;
	 private String luuAnh = "";
	 private String parentLuuAnh= "";

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
		getContentPane().setBackground(Color.WHITE);
		
		SanPhamDAO_Impl spDAO = new SanPhamDAO_Impl();
		List<SanPhamModel> listMuaHang = new ArrayList<>();
		
		
		setTitle("CuaHangTapHoa");
		setSize(1036, 558);
		getContentPane().setLayout(null);
		
		JLabel lblmage = new JLabel("");
		lblmage.setBackground(Color.GRAY);
		lblmage.setBounds(819, 335, 160, 130);
		getContentPane().add(lblmage);
		
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
				sanphamImage = null;
				ImageIcon icon  = new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\dialogue.png");
				Image img = ImageHelper.resize(icon.getImage(), 160, 140);
				ImageIcon resizeIcon = new ImageIcon(img);
				lblmage.setIcon(resizeIcon);
				showData(spDAO.getAll());
			}
		});
		
		btnLamMoi.setBounds(528, 41, 108, 26);
		getContentPane().add(btnLamMoi);
		
		jtfGiamGia = new JTextField();
		jtfGiamGia.setColumns(10);
		jtfGiamGia.setBounds(819, 287, 160, 25);
		getContentPane().add(jtfGiamGia);
		
		btnNewButton_4 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu_View tc = new TrangChu_View();
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setBounds(917, 10, 95, 21);
		getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 79, 616, 432);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layDuLieu();
				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
				  String indexHinhAnh = String.valueOf(table.getValueAt(table.getSelectedRow(),0));
				 luuAnh= sp_DAO.getPathHinhAnhByName(indexHinhAnh);
				ImageIcon icon = new ImageIcon(luuAnh);
				lblmage.setIcon(icon);
//				System.out.println(String.valueOf(icon));
//				Image img = ImageHelper.resize(icon.getImage(), 160, 140);
//				ImageIcon resizeIcon = new ImageIcon(img);
//				lblmage.setIcon(resizeIcon);
				
			}
		});
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
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(701, 288, 108, 24);
		getContentPane().add(lblNewLabel_1);
		
		lblMasp = new JLabel("Mã Sản Phẩm");
		lblMasp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMasp.setBounds(701, 80, 95, 24);
		getContentPane().add(lblMasp);
		
		jtfMaSP = new JTextField();
		jtfMaSP.setColumns(10);
		jtfMaSP.setBounds(819, 79, 160, 25);
		getContentPane().add(jtfMaSP);
		
		jtfTenSP = new JTextField();
		jtfTenSP.setColumns(10);
		jtfTenSP.setBounds(819, 131, 160, 25);
		getContentPane().add(jtfTenSP);
		
		jtfSoLuong = new JTextField();
		jtfSoLuong.setColumns(10);
		jtfSoLuong.setBounds(819, 184, 160, 25);
		getContentPane().add(jtfSoLuong);
		
		jtfGia = new JTextField();
		jtfGia.setColumns(10);
		jtfGia.setBounds(819, 237, 160, 25);
		getContentPane().add(jtfGia);
		JLabel lblTensp = new JLabel("Tên Sản Phẩm");
		lblTensp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTensp.setBounds(701, 132, 108, 24);
		getContentPane().add(lblTensp);
		
		JLabel lblSoluong = new JLabel("Số Lượng");
		lblSoluong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoluong.setBounds(701, 184, 85, 25);
		getContentPane().add(lblSoluong);
		
		JLabel lblGia = new JLabel("Giá");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGia.setBounds(701, 238, 85, 24);
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
				sp.setHinhAnh(luuAnh);
				//String imgPath = lblmage.getText();
				//sp.setHinhAnh(String.valueOf(sanphamImage));
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
		btnNewButton_2_1.setBounds(680, 490, 100, 21);
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
		btnNewButton_2_2.setBounds(900, 490, 100, 21);
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
				sp.setHinhAnh(luuAnh);
				spDAO.update(sp);
				JOptionPane.showMessageDialog(null, "Save Success");
				showData(spDAO.getAll());
			}
		});
		btnNewButton_2_3.setForeground(Color.BLACK);
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_3.setBackground(Color.YELLOW);
		btnNewButton_2_3.setBounds(790, 490, 100, 21);
		getContentPane().add(btnNewButton_2_3);
		
		JLabel lblNewLabel = new JLabel("Chi Tiết Sản Phẩm");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(722, 39, 239, 25);
		getContentPane().add(lblNewLabel);
		
//		JLabel lblmage = new JLabel("Anh");
//		lblmage.setBounds(829, 322, 171, 123);
//		getContentPane().add(lblmage);
		
		JButton btnNewButton_2_1_1 = new JButton("Chọn");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(new File("E:\\doan\\cuahangtaphoa\\src\\img"));
				chooser.setFileFilter(new FileFilter() {
					
					@Override
					public String getDescription() {
						
						return "Image File (*.png)";
					}
					
					@Override
					public boolean accept(File f) {
						if(f.isDirectory()) {
							return true;
						}else
						{
							return f.getName().toLowerCase().endsWith(".png");
						}
					}
				});;
				if(chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) {
					return;
				}
				File file= chooser.getSelectedFile();
					luuAnh = file.getPath();
					//parentLuuAnh = file.getParent();
					System.out.println(luuAnh);
				try {
					ImageIcon icon = new ImageIcon(file.getPath());
					Image img = ImageHelper.resize(icon.getImage(), 160, 140);
					ImageIcon resizeIcon = new ImageIcon(img);
					lblmage.setIcon(resizeIcon);
					
					
					sanphamImage = ImageHelper.toByteArray(img, "png");				
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				//FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "gif");
				//chooser.addChoosableFileFilter(filter);
				
			}
		});
		btnNewButton_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1_1.setBackground(Color.BLUE);
		btnNewButton_2_1_1.setBounds(680, 365, 100, 21);
		getContentPane().add(btnNewButton_2_1_1);
		
		
		
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
		//lblmage.setText(String.valueOf(modelTable.getValueAt(index, 5)));
		
	//xu ly lay anh	
		//SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
		//  String indexHinhAnh = String.valueOf(table.getValueAt(table.getSelectedRow(),0));
		// luuAnh= sp_DAO.getPathHinhAnhByName(indexHinhAnh);
		// luuAnh.replace("\", "\\");
		 // sp_DAO.getByName(table.getValueAt(index, 1));
		//luuAnh = String.valueOf(modelTable.getValueAt(index, 5));
		 
		System.out.println(luuAnh);
	
		//lblmage.setIcon(luuAnh);
		//System.out.println(luuAnh);
//		luuAnh = String.valueOf(modelTable.getValueAt(index, 5));
//		System.out.println(luuAnh);
//		ImageIcon icon = new ImageIcon(luuAnh);
//		Image img = ImageHelper.resize(icon.getImage(), 160, 140);
//		ImageIcon resizeIcon = new ImageIcon(img);
//	lblmage.setIcon(resizeIcon);
	
}
}
