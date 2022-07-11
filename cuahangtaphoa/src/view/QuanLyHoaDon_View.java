package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DAO.HoaDonDAO_Impl;
import Helper.ImageHelper;
import model.HoaDonModel;
import model.SanPhamModel;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class QuanLyHoaDon_View extends JFrame {

	private JPanel contentPane;
	private JTable tbHoaDon;
	private JTable tbChiTietHoaDon;
	private JTextField jtfMaSanPham;
	private JTextField jtfTenSanPham;
	private JTextField jtfSoLuong;
	private JTextField jtfGia;
	private JTextField jtfGiamGia;
	private JTextField jtfMaHopDong;
	private JTextField jtfTienKhachTra;
	private JTextField jtfTienTraKhach;
	private JTextField jtfTongDoanhThu;
	private JTextField jtfTongTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyHoaDon_View frame = new QuanLyHoaDon_View();
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
	public QuanLyHoaDon_View() {
		getContentPane().setBackground(new Color(242, 242, 242));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Quan Ly Hoa Don");
		setSize(1024, 666);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD H\u00F3a \u0110\u01A1n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(120, 8, 129, 29);
		getContentPane().add(lblNewLabel);
		
		JScrollPane sclpan = new JScrollPane();
		sclpan.setBounds(23, 66, 322, 286);
		getContentPane().add(sclpan);
		
		tbHoaDon = new JTable();
		tbHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbHoaDon.getSelectedRow();
				HoaDonDAO_Impl hd_DAO = new HoaDonDAO_Impl();
				showDataChiTietHoaDon(hd_DAO.getAllChiTietHoaDonfromHoaDon(row));
				jtfMaHopDong.setText(String.valueOf(tbHoaDon.getValueAt(row, 0)));
				jtfTongTien.setText(String.valueOf(tbHoaDon.getValueAt(row, 1)));
				jtfTienKhachTra.setText(String.valueOf(tbHoaDon.getValueAt(row, 2)));
				jtfTienTraKhach.setText(String.valueOf(tbHoaDon.getValueAt(row, 3)));		
				
			}
		});
		tbHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u1EE3p \u0111\u1ED3ng", "T\u1ED5ng ti\u1EC1n", "Ti\u1EC1n kh\u00E1ch tr\u1EA3", "Tr\u1EA3 l\u1EA1i kh\u00E1ch"
			}
		));
		sclpan.setViewportView(tbHoaDon);
		
		JScrollPane tb_HoaDon = new JScrollPane();
		tb_HoaDon.setBounds(382, 66, 596, 413);
		getContentPane().add(tb_HoaDon);
		
		tbChiTietHoaDon = new JTable();
		tbChiTietHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbChiTietHoaDon.getSelectedRow();
				showDataChiTietHoaDonByIndex(String.valueOf(tbChiTietHoaDon.getValueAt(row, 0)));
				
			}
		});
		tbChiTietHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng ", "Gi\u00E1", "Gi\u1EA3m Gi\u00E1"
			}
		));
		tb_HoaDon.setViewportView(tbChiTietHoaDon);
		
		jtfMaSanPham = new JTextField();
		jtfMaSanPham.setBounds(381, 580, 100, 21);
		getContentPane().add(jtfMaSanPham);
		jtfMaSanPham.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 S\u1EA3n Ph\u1EA9m");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(382, 554, 123, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn S\u1EA3n Ph\u1EA9m");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(510, 554, 95, 16);
		getContentPane().add(lblNewLabel_1_1);
		
		jtfTenSanPham = new JTextField();
		jtfTenSanPham.setColumns(10);
		jtfTenSanPham.setBounds(510, 580, 100, 21);
		getContentPane().add(jtfTenSanPham);
		
		JLabel lblNewLabel_1_2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(640, 554, 68, 16);
		getContentPane().add(lblNewLabel_1_2);
		
		jtfSoLuong = new JTextField();
		jtfSoLuong.setColumns(10);
		jtfSoLuong.setBounds(640, 580, 100, 21);
		getContentPane().add(jtfSoLuong);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gi\u00E1");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(758, 554, 68, 16);
		getContentPane().add(lblNewLabel_1_3);
		
		jtfGia = new JTextField();
		jtfGia.setColumns(10);
		jtfGia.setBounds(758, 580, 100, 21);
		getContentPane().add(jtfGia);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gi\u1EA3m gi\u00E1");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(878, 554, 68, 16);
		getContentPane().add(lblNewLabel_1_4);
		
		jtfGiamGia = new JTextField();
		jtfGiamGia.setColumns(10);
		jtfGiamGia.setBounds(878, 580, 100, 21);
		getContentPane().add(jtfGiamGia);
		
		JLabel lblNewLabel_1_5 = new JLabel("M\u00E3 H\u1EE3p \u0110\u1ED3ng");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(382, 489, 85, 16);
		getContentPane().add(lblNewLabel_1_5);
		
		jtfMaHopDong = new JTextField();
		jtfMaHopDong.setEnabled(false);
		jtfMaHopDong.setColumns(10);
		jtfMaHopDong.setBounds(382, 510, 120, 21);
		getContentPane().add(jtfMaHopDong);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Ti\u1EC1n Kh\u00E1ch Tr\u1EA3");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5_1.setBounds(702, 489, 100, 16);
		getContentPane().add(lblNewLabel_1_5_1);
		
		jtfTienKhachTra = new JTextField();
		jtfTienKhachTra.setEnabled(false);
		jtfTienKhachTra.setColumns(10);
		jtfTienKhachTra.setBounds(702, 510, 120, 21);
		getContentPane().add(jtfTienKhachTra);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Ti\u1EC1n tr\u1EA3 kh\u00E1ch");
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5_2.setBounds(868, 489, 95, 16);
		getContentPane().add(lblNewLabel_1_5_2);
		
		jtfTienTraKhach = new JTextField();
		jtfTienTraKhach.setEnabled(false);
		jtfTienTraKhach.setColumns(10);
		jtfTienTraKhach.setBounds(858, 510, 120, 21);
		getContentPane().add(jtfTienTraKhach);
		
		jtfTongDoanhThu = new JTextField();
		jtfTongDoanhThu.setEnabled(false);
		jtfTongDoanhThu.setColumns(10);
		jtfTongDoanhThu.setBounds(129, 387, 100, 21);
		getContentPane().add(jtfTongDoanhThu);
		
		JLabel lblNewLabel_1_6 = new JLabel("T\u1ED5ng doanh thu");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_6.setBounds(23, 388, 96, 16);
		getContentPane().add(lblNewLabel_1_6);
		
		
		HoaDonDAO_Impl hd_DAO = new HoaDonDAO_Impl();
		showDataHoaDon(hd_DAO.getAllHoaDon());
		//showDataChiTietHoaDon(hd_DAO.getAllChiTietHoaDon());
		jtfTongDoanhThu.setText(String.valueOf(TongDoanhThu()));
		
		JButton btnNewButton = new JButton("Quay Lại");
		btnNewButton.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\logout.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu_View tc = new TrangChu_View();
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 102, 102));
		btnNewButton.setBounds(868, 10, 111, 27);
		getContentPane().add(btnNewButton);
		
		JLabel jtf = new JLabel("Tổng Tiền");
		jtf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jtf.setBounds(538, 489, 68, 16);
		getContentPane().add(jtf);
		
		jtfTongTien = new JTextField();
		jtfTongTien.setEnabled(false);
		jtfTongTien.setColumns(10);
		jtfTongTien.setBounds(538, 510, 120, 21);
		getContentPane().add(jtfTongTien);
		
		JLabel lblLogo = new JLabel("New label");
		ImageIcon icon =new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\ManHinhChinh\\logo .png");
		Image img = ImageHelper.resize(icon.getImage(), 50, 50);
		ImageIcon resizeIcon = new ImageIcon(img);
		lblLogo.setIcon(resizeIcon);
		//lblLogo.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\ManHinhChinh\\logo .png"));
		lblLogo.setBounds(40, 8, 50, 50);
		getContentPane().add(lblLogo);
		
	}
	
	public void showDataHoaDon(List<HoaDonModel> hdList) {
		List<HoaDonModel> listHoaDon = new ArrayList<>();
		listHoaDon = hdList;
		DefaultTableModel tableModel;
		tbHoaDon.getModel();
		tableModel =(DefaultTableModel)tbHoaDon.getModel();
		tableModel.setRowCount(0);
		listHoaDon.forEach((hoadon)-> {
			tableModel.addRow(new Object[] {
					hoadon.getMaHoaDon(),hoadon.getTongTien(),hoadon.getNhanTuKhach(),hoadon.getTraLaiKhach()
			});
		});
	}
	
	public void showDataChiTietHoaDon(List<HoaDonModel> cthdList) {
		List<HoaDonModel> listHoaDon = new ArrayList<>();
		listHoaDon = cthdList;
		DefaultTableModel tableModel;
		tbChiTietHoaDon.getModel();
		tableModel =(DefaultTableModel)tbChiTietHoaDon.getModel();
		tableModel.setRowCount(0);
		listHoaDon.forEach((cthd)-> {
			tableModel.addRow(new Object[] {
					cthd.getMaSanPham(),cthd.getTenSanPham(),cthd.getSoLuong(),cthd.getGia(),cthd.getGiamGia()
			});
		});
	}
	//from jtable to jtextfield 
	public void showDataChiTietHoaDonByIndex(String Index) {
		List<HoaDonModel> listChiTietHoaDon = new ArrayList<>();
		HoaDonDAO_Impl hd_DAO = new HoaDonDAO_Impl();
		listChiTietHoaDon = hd_DAO.getAllChiTietHoaDonToJtf(Index);
		System.out.println(listChiTietHoaDon);
		jtfMaSanPham.setText(listChiTietHoaDon.get(0).getMaSanPham());
		jtfTenSanPham.setText(listChiTietHoaDon.get(0).getTenSanPham());
		jtfSoLuong.setText(String.valueOf(listChiTietHoaDon.get(0).getSoLuong()));
		jtfGia.setText(String.valueOf(listChiTietHoaDon.get(0).getGia()));
		jtfGiamGia.setText(String.valueOf(listChiTietHoaDon.get(0).getGiamGia()));
	}
	
	public int TongDoanhThu() {
		DecimalFormat x = new DecimalFormat("###,###,###");
		int TongDoanhThu = 0;
		for(int i = 0 ; i<tbHoaDon.getRowCount();i++) {
			TongDoanhThu +=(Integer.parseInt(tbHoaDon.getValueAt(i, 1).toString()));
		}
		
		return TongDoanhThu;
	}
}
