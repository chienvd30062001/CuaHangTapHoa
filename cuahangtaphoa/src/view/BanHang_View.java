package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import model.HoaDonModel;
import model.SanPhamModel;
import DAO.DBConnect;
import DAO.HoaDonDAO_Impl;
import DAO.SanPhamDAO;
import DAO.SanPhamDAO_Impl;
import Helper.ImageHelper;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BanHang_View extends JFrame {

  	private JPanel contentPane;
	private JTextField jtfTimKiem;
	private JTextField jtfTongCong;
	private JTextField jtfNhanTuKhach;
	private JTextField jtfTraLaiKhach;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private static JTable tbSanPham;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane_1;
	private static JTable tbMuaHang;
	private JLabel lblMasp;
	private JTextField jtfMaSP;
	private JTextField jtfTenSP;
	private JTextField jtfSoLuong;
	private JTextField jtfGia;
	private JButton btnMua;
	private JTextField jtfGiamGia;
	private  static int maHD =1;
	private JLabel lbHinhAnh;
	private String luuAnh ="";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanHang_View frame = new BanHang_View();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BanHang_View() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
//				HoaDonDAO_Impl hd_DAO =new HoaDonDAO_Impl();				
//				hd_DAO.deleteChiTietHoaDon();
//				hd_DAO.deleteHoaDon();
//				sp_DAO.deleteMuaHang();
			}
		});
		
		SanPhamDAO_Impl spDAO = new SanPhamDAO_Impl();
		List<SanPhamModel> listMuaHang = new ArrayList<>();
		final int  TongTien ;
		
		lbHinhAnh = new JLabel("");
		lbHinhAnh.setBackground(Color.BLACK);
		lbHinhAnh.setBounds(417, 397, 110, 100);
		getContentPane().add(lbHinhAnh);
		
		setTitle("CuaHangTapHoa");
		setSize(1036, 558);
		getContentPane().setLayout(null);
		
		jtfTimKiem = new JTextField();
		jtfTimKiem.setBounds(20, 20, 454, 25);
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
		btnTimKiem.setBounds(484, 19, 130, 26);
		getContentPane().add(btnTimKiem);
		
		JButton btnLamMoi = new JButton("L\u00E0m m\u1EDBi");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfMaSP.setText("");
				jtfTenSP.setText("");
				jtfSoLuong.setText("");
				jtfGia.setText("");
				showData(spDAO.getAll());
			}
		});
		btnLamMoi.setBounds(552, 397, 94, 21);
		getContentPane().add(btnLamMoi);
		
		jtfTongCong = new JTextField();
		jtfTongCong.setColumns(10);
		jtfTongCong.setBounds(846, 370, 153, 19);
		getContentPane().add(jtfTongCong);
		
		jtfNhanTuKhach = new JTextField();
		jtfNhanTuKhach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int TongTien = Integer.parseInt(jtfTongCong.getText());
				int KhachTra =Integer.parseInt(jtfNhanTuKhach.getText());
				jtfTraLaiKhach.setText(String.valueOf(KhachTra - TongTien));
			}
		});
		jtfNhanTuKhach.addMouseListener(new MouseAdapter() {
		});
		jtfNhanTuKhach.setColumns(10);
		jtfNhanTuKhach.setBounds(846, 399, 153, 19);
		getContentPane().add(jtfNhanTuKhach);
		
		jtfTraLaiKhach = new JTextField();
		jtfTraLaiKhach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		jtfTraLaiKhach.setColumns(10);
		jtfTraLaiKhach.setBounds(846, 428, 153, 19);
		getContentPane().add(jtfTraLaiKhach);
		
		btnNewButton_2 = new JButton("Thanh to\u00E1n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
				luuHoaDon();
				sp_DAO.deleteMuaHang();
				showData_2(sp_DAO.getAllMuaHang());
				
			}
		});
		btnNewButton_2.setBackground(new Color(0, 255, 255));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(803, 474, 94, 21);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Xu\u1EA5t");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//spDAO.deleteMuaHang();
				//showData_2(spDAO.getAllMuaHang());
				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
			HoaDonDAO_Impl hd_DAO =new HoaDonDAO_Impl();				
			     hd_DAO.deleteChiTietHoaDon();
			     hd_DAO.deleteHoaDon();
				sp_DAO.deleteMuaHang();
			}
		});
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(907, 474, 92, 21);
		getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu_View tc = new TrangChu_View();
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setBounds(927, 10, 85, 21);
		getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 65, 626, 310);
		getContentPane().add(scrollPane);
		
		tbSanPham = new JTable();
		tbSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layDuLieu();
				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
				  String indexHinhAnh = String.valueOf(tbSanPham.getValueAt(tbSanPham.getSelectedRow(),0));
				 luuAnh= sp_DAO.getPathHinhAnhByName(indexHinhAnh);
				ImageIcon icon = new ImageIcon(luuAnh);
				//lbHinhAnh.setIcon(icon);
				Image img = ImageHelper.resize(icon.getImage(), 110, 100);
				ImageIcon resizeIcon = new ImageIcon(img);
				lbHinhAnh.setIcon(resizeIcon);
			}
		});
		tbSanPham.setModel(new DefaultTableModel(
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
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Gi\u1EA3m Gi\u00E1"
			}
		));
		tbSanPham.getColumnModel().getColumn(0).setPreferredWidth(49);
		tbSanPham.getColumnModel().getColumn(1).setPreferredWidth(61);
		tbSanPham.getColumnModel().getColumn(2).setPreferredWidth(53);
		tbSanPham.getColumnModel().getColumn(2).setMinWidth(6);
		tbSanPham.getColumnModel().getColumn(3).setPreferredWidth(50);
		tbSanPham.getColumnModel().getColumn(4).setPreferredWidth(57);
		tbSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tbSanPham);
		
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
		scrollPane_1.setBounds(677, 65, 322, 252);
		getContentPane().add(scrollPane_1);
		
		tbMuaHang = new JTable();
		tbMuaHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tbMuaHang.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Gi\u1EA3m Gi\u00E1 (%)"
			}
		));
		tbMuaHang.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbMuaHang.getColumnModel().getColumn(1).setPreferredWidth(93);
		tbMuaHang.getColumnModel().getColumn(2).setPreferredWidth(53);
		scrollPane_1.setViewportView(tbMuaHang);
		
		lblMasp = new JLabel("M\u00E3 S\u1EA3n Ph\u1EA9m");
		lblMasp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMasp.setBounds(20, 397, 85, 15);
		getContentPane().add(lblMasp);
		
		jtfMaSP = new JTextField();
		jtfMaSP.setColumns(10);
		jtfMaSP.setBounds(20, 422, 110, 20);
		getContentPane().add(jtfMaSP);
		
		jtfTenSP = new JTextField();
		jtfTenSP.setColumns(10);
		jtfTenSP.setBounds(20, 480, 110, 20);
		getContentPane().add(jtfTenSP);
		
		jtfSoLuong = new JTextField();
		jtfSoLuong.setColumns(10);
		jtfSoLuong.setBounds(151, 422, 110, 20);
		getContentPane().add(jtfSoLuong);
		
		jtfGia = new JTextField();
		jtfGia.setColumns(10);
		jtfGia.setBounds(151, 480, 110, 20);
		getContentPane().add(jtfGia);
		
		JLabel lblTensp = new JLabel("T\u00EAn S\u1EA3n Ph\u1EA9m");
		lblTensp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTensp.setBounds(20, 455, 85, 15);
		getContentPane().add(lblTensp);
		
		JLabel lblSoluong = new JLabel("S\u1ED1 L\u01B0\u1EE3ng");
		lblSoluong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoluong.setBounds(162, 397, 85, 15);
		getContentPane().add(lblSoluong);
		
		JLabel lblGia = new JLabel("Gi\u00E1");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGia.setBounds(151, 455, 95, 15);
		getContentPane().add(lblGia);
		
		btnMua = new JButton("Mua");
		btnMua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setMaSP(jtfMaSP.getText());
				sp.setTenSP(jtfTenSP.getText());
				sp.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
				sp.setGia(Integer.parseInt(jtfGia.getText()));
				sp.setGiamGia(Integer.parseInt(jtfGiamGia.getText()));
				spDAO.insertMuaHang(sp,maHD);
				JOptionPane.showMessageDialog(null, "Save Success");
				showData_2(spDAO.getAllMuaHang());
			  //tinh tien
                 Tong();
         		
			}
		});
		btnMua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMua.setBounds(552, 428, 94, 21);
		getContentPane().add(btnMua);
		
		jtfGiamGia = new JTextField();
		jtfGiamGia.setColumns(10);
		jtfGiamGia.setBounds(283, 422, 110, 20);
		getContentPane().add(jtfGiamGia);
		
		JLabel lblGimGi = new JLabel("Gi\u1EA3m Gi\u00E1");
		lblGimGi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGimGi.setBounds(283, 397, 85, 15);
		getContentPane().add(lblGimGi);
		
		
		
		this.setVisible(true);
		
		showData(spDAO.getAll());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
	
	public void luuHoaDon() {
		List<SanPhamModel> listMuaHang= new ArrayList<>();
		HoaDonModel hd = new HoaDonModel();
		SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
		HoaDonDAO_Impl hd_DAO =new HoaDonDAO_Impl();
		listMuaHang = sp_DAO.getAllMuaHang();
		System.out.print(listMuaHang);
	   for (int i = 0;i<listMuaHang.size();i++) {
		    hd.setMaHoaDon(maHD);
		    hd.setMaSanPham(listMuaHang.get(i).getMaSP()); 
			hd.setTenSanPham(listMuaHang.get(i).getTenSP());
			hd.setSoLuong(listMuaHang.get(i).getSoLuong());
			hd.setGia(listMuaHang.get(i).getGia());
			hd.setGiamGia(listMuaHang.get(i).getGiamGia());
			hd.setTongTien(Integer.parseInt(jtfTongCong.getText()));
			hd.setNhanTuKhach(Integer.parseInt(jtfNhanTuKhach.getText()));
			hd.setTraLaiKhach(Integer.parseInt(jtfTraLaiKhach.getText()));
			hd_DAO.insertHoaDon(hd, maHD);
			hd_DAO.insertChiTietHoaDon(hd,maHD);
	}
	   
	    jtfTongCong.setText("");
		jtfNhanTuKhach.setText("");
		jtfTraLaiKhach.setText("");
		maHD++;
	}
	
	
	
	public void showData(List<SanPhamModel> spList) {
		List<SanPhamModel> listSanPham = new ArrayList<>();
		listSanPham = spList;
		DefaultTableModel tableModel;
		tbSanPham.getModel();
		tableModel =(DefaultTableModel)tbSanPham.getModel();
		tableModel.setRowCount(0);
		listSanPham.forEach((sanpham)-> {
			tableModel.addRow(new Object[] {
					sanpham.getMaSP(),sanpham.getTenSP(),sanpham.getSoLuong(),sanpham.getGia(),sanpham.getGiamGia()
			});
		});
	}
	public void showData_2(List<SanPhamModel> spList) {
		List<SanPhamModel> listSanPham = new ArrayList<>();
		listSanPham = spList;
		DefaultTableModel tableModel;
		tbMuaHang.getModel();
		tableModel =(DefaultTableModel)tbMuaHang.getModel();
		tableModel.setRowCount(0);
		System.out.print(listSanPham);
		listSanPham.forEach((sanpham)-> {
			tableModel.addRow(new Object[] {
					sanpham.getMaSP(),sanpham.getTenSP(),sanpham.getSoLuong(),sanpham.getGia(),sanpham.getGiamGia()
			});
		});
	}
	
	public void layDuLieu() {
		DefaultTableModel modelTable = (DefaultTableModel) tbSanPham.getModel();
		int index = tbSanPham.getSelectedRow();
		//SanPhamModel sp = new SanPhamModel();
		jtfMaSP.setText(String.valueOf(modelTable.getValueAt(index, 0)));
		jtfTenSP.setText(String.valueOf(modelTable.getValueAt(index, 1)));
		jtfSoLuong.setText(String.valueOf(modelTable.getValueAt(index,2)));
		jtfGia.setText(String.valueOf(modelTable.getValueAt(index, 3)));
		jtfGiamGia.setText(String.valueOf(modelTable.getValueAt(index, 4)));
		
		
	
}
	
	public int Tong() {
		DecimalFormat x = new DecimalFormat("###,###,###");
		int Tong = 0;
		for(int i = 0 ; i<tbMuaHang.getRowCount();i++) {
			int SoLuong = (int) tbMuaHang.getValueAt(i, 2);
			int Gia =(int)tbMuaHang.getValueAt(i, 3);
			int GiamGia =100-(int)tbMuaHang.getValueAt(i, 4);
			Tong +=((SoLuong*Gia)*(GiamGia)/100);
			System.out.println(((SoLuong*Gia)*(GiamGia)/100));
		}
		jtfTongCong.setText(String.valueOf(Tong));
		return Tong;
	}
}
