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
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextPane;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.table.DefaultTableModel;

import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.beans.PropertyChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class BanHang_View extends JFrame {

	private JPanel contentPane;
	private JTextField jtfTimKiem;
	private JTextField jtfTongCong;
	private JTextField jtfNhanTuKhach;
	private JTextField jtfTraLaiKhach;
	private JButton btnThanhToan;
	private JButton btnXuatEX;
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
	private static int maHD;
	private static String idXoa;
	private JLabel lbHinhAnh;
	private String luuAnh = "";
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

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
		HoaDonDAO_Impl hdDAO = new HoaDonDAO_Impl();
		List<SanPhamModel> listMuaHang = new ArrayList<>();
		final int TongTien;
		maHD = hdDAO.getMaHD() + 1;

		setTitle("CuaHangTapHoa");
		setSize(1119, 645);
		getContentPane().setLayout(null);

		jtfTimKiem = new JTextField();
		jtfTimKiem.setBounds(26, 10, 514, 21);
		getContentPane().add(jtfTimKiem);
		jtfTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tim Kiem");
		btnTimKiem.setBackground(new Color(92,157,242));
		btnTimKiem.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\magnifying-glass.png"));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setTenSP(jtfTimKiem.getText());
				showData(spDAO.getByName(sp));
			}
		});
		btnTimKiem.setBounds(566, 10, 156, 21);
		getContentPane().add(btnTimKiem);

		jtfTongCong = new JTextField();
		jtfTongCong.setColumns(10);
		jtfTongCong.setBounds(893, 408, 153, 19);
		getContentPane().add(jtfTongCong);

		jtfNhanTuKhach = new JTextField();
		jtfNhanTuKhach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int TongTien = Integer.parseInt(jtfTongCong.getText());
				int KhachTra = Integer.parseInt(jtfNhanTuKhach.getText());
				int TraKhach = KhachTra - TongTien;
				jtfTraLaiKhach.setText(String.valueOf(TraKhach));
			}
		});
		jtfNhanTuKhach.addMouseListener(new MouseAdapter() {
		});
		jtfNhanTuKhach.setColumns(10);
		jtfNhanTuKhach.setBounds(893, 437, 153, 19);
		getContentPane().add(jtfNhanTuKhach);

		jtfTraLaiKhach = new JTextField();
		jtfTraLaiKhach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		jtfTraLaiKhach.setColumns(10);
		jtfTraLaiKhach.setBounds(893, 466, 153, 19);
		getContentPane().add(jtfTraLaiKhach);

		btnNewButton_4 = new JButton("Quay l???i");
		btnNewButton_4.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\logout.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu_View tc = new TrangChu_View();
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBackground(new Color(255, 102, 102));
		btnNewButton_4.setBounds(987, 10, 102, 21);
		getContentPane().add(btnNewButton_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 65, 655, 310);
		getContentPane().add(scrollPane);

		tbSanPham = new JTable();
		tbSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layDuLieu();
				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
				String indexHinhAnh = String.valueOf(tbSanPham.getValueAt(tbSanPham.getSelectedRow(), 0));
				luuAnh = sp_DAO.getPathHinhAnhByName(indexHinhAnh);
				ImageIcon icon = new ImageIcon(luuAnh);
				// lbHinhAnh.setIcon(icon);
				Image img = ImageHelper.resize(icon.getImage(), 110, 100);
				ImageIcon resizeIcon = new ImageIcon(img);
				lbHinhAnh.setIcon(resizeIcon);
			}
		});
		tbSanPham.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng",
						"Gi\u00E1", "Gi\u1EA3m Gi\u00E1" }));
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
		lblNewLabel_2.setBounds(748, 467, 94, 15);
		getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("T\u1ED5ng C\u1ED9ng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(748, 409, 94, 15);
		getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Nh\u1EADn t\u1EEB kh\u00E1ch");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(748, 438, 94, 15);
		getContentPane().add(lblNewLabel_4);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(748, 65, 322, 310);
		getContentPane().add(scrollPane_1);

		tbMuaHang = new JTable();
		tbMuaHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idXoa = String.valueOf(tbMuaHang.getValueAt(tbMuaHang.getSelectedRow(), 0));
			}
		});
		tbMuaHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tbMuaHang.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng",
						"Gi\u00E1", "Gi\u1EA3m Gi\u00E1 (%)" }));
		tbMuaHang.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbMuaHang.getColumnModel().getColumn(1).setPreferredWidth(93);
		tbMuaHang.getColumnModel().getColumn(2).setPreferredWidth(53);
		scrollPane_1.setViewportView(tbMuaHang);

		panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(26, 38, 696, 559);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		btnMua = new JButton("Mua");
		btnMua.setBackground(new Color(102, 255, 153));
		btnMua.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\receipt (2).png"));
		btnMua.setBounds(577, 385, 109, 21);
		panel_2.add(btnMua);
		btnMua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setMaSP(jtfMaSP.getText());
				sp.setTenSP(jtfTenSP.getText());
				sp.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
				sp.setGia(Integer.parseInt(jtfGia.getText()));
				sp.setGiamGia(Integer.parseInt(jtfGiamGia.getText()));

				if (jtfSoLuong.getText().equals("0")) {
					JOptionPane.showMessageDialog(null, "S???n ph???m ???? h???t h??ng kh??ng th??? th??m");
				} else {
					spDAO.insertMuaHang(sp, maHD);
					JOptionPane.showMessageDialog(null, "Th??m th??nh c??ng");
				}
				showData_2(spDAO.getAllMuaHang());
				// tinh tien
				Tong();

			}
		});
		btnMua.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnLamMoi = new JButton("L\u00E0m m\u1EDBi");
		btnLamMoi.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\refresh.png"));
		btnLamMoi.setBounds(577, 354, 109, 21);
		panel_2.add(btnLamMoi);
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);

		panel_1 = new JPanel();
		panel_1.setBounds(25, 354, 542, 188);
		panel_2.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setLayout(null);

		lbHinhAnh = new JLabel("");
		lbHinhAnh.setBounds(411, 66, 110, 100);
		panel_1.add(lbHinhAnh);
		lbHinhAnh.setBackground(Color.BLACK);

		jtfMaSP = new JTextField();
		jtfMaSP.setBounds(10, 66, 110, 20);
		panel_1.add(jtfMaSP);
		jtfMaSP.setColumns(10);

		lblMasp = new JLabel("M\u00E3 S\u1EA3n Ph\u1EA9m");
		lblMasp.setBounds(10, 41, 85, 15);
		panel_1.add(lblMasp);
		lblMasp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSoluong = new JLabel("S\u1ED1 L\u01B0\u1EE3ng");
		lblSoluong.setBounds(152, 41, 85, 15);
		panel_1.add(lblSoluong);
		lblSoluong.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblGimGi = new JLabel("Gi\u1EA3m Gi\u00E1");
		lblGimGi.setBounds(273, 41, 85, 15);
		panel_1.add(lblGimGi);
		lblGimGi.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfGiamGia = new JTextField();
		jtfGiamGia.setBounds(273, 66, 110, 20);
		panel_1.add(jtfGiamGia);
		jtfGiamGia.setColumns(10);

		jtfSoLuong = new JTextField();
		jtfSoLuong.setBounds(141, 66, 110, 20);
		panel_1.add(jtfSoLuong);
		jtfSoLuong.setColumns(10);

		jtfGia = new JTextField();
		jtfGia.setBounds(141, 124, 110, 20);
		panel_1.add(jtfGia);
		jtfGia.setColumns(10);

		JLabel lblGia = new JLabel("Gi\u00E1");
		lblGia.setBounds(141, 99, 95, 15);
		panel_1.add(lblGia);
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblTensp = new JLabel("T\u00EAn S\u1EA3n Ph\u1EA9m");
		lblTensp.setBounds(10, 99, 85, 15);
		panel_1.add(lblTensp);
		lblTensp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfTenSP = new JTextField();
		jtfTenSP.setBounds(10, 124, 110, 20);
		panel_1.add(jtfTenSP);
		jtfTenSP.setColumns(10);

		panel = new JPanel();
		panel.setBounds(411, 43, 110, 125);
		panel_1.add(panel);
		panel.setBorder(
				new TitledBorder(null, "H\u00ECnh \u1EA2nh", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Mua H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(735, 38, 354, 559);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JButton btnXoaMH = new JButton("L??m m???i");
		btnXoaMH.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\refresh.png"));
		btnXoaMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
				sp_DAO.deleteMuaHang();
				showData_2(sp_DAO.getAllMuaHang());
				jtfTongCong.setText("");
				jtfNhanTuKhach.setText("");
				jtfTraLaiKhach.setText("");

			}
		});
		btnXoaMH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoaMH.setBackground(Color.LIGHT_GRAY);
		btnXoaMH.setBounds(210, 528, 118, 21);
		panel_3.add(btnXoaMH);

		btnThanhToan = new JButton("Thanh to\u00E1n");
		btnThanhToan.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\payment-method.png"));
		btnThanhToan.setBounds(82, 485, 118, 21);
		panel_3.add(btnThanhToan);
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
				luuHoaDon();
				// tru san pham trong database
				truSanPham();
				showData(sp_DAO.getAll());

			}
		});
		btnThanhToan.setBackground(new Color(255, 255, 153));
		btnThanhToan.setForeground(Color.BLACK);
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 12));

		btnXuatEX = new JButton("Xu\u1EA5t");
		btnXuatEX.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\excel.png"));
		btnXuatEX.setBounds(82, 528, 118, 21);
		panel_3.add(btnXuatEX);
		btnXuatEX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// spDAO.deleteMuaHang();
				// showData_2(spDAO.getAllMuaHang());
//				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
				HoaDonDAO_Impl hd_DAO = new HoaDonDAO_Impl();
				hd_DAO.deleteChiTietHoaDon();
//			     hd_DAO.deleteHoaDon();
//				 sp_DAO.deleteMuaHang();

				List<SanPhamModel> listMuaHang = new ArrayList<>();
				listMuaHang = spDAO.getAllMuaHang();
				try {
					XSSFWorkbook workbook = new XSSFWorkbook();

					XSSFSheet sheet = workbook.createSheet("Danh s??ch mua h??ng");
					XSSFRow row = null;
					Cell cell = null;
					XSSFCellStyle centerStyle = workbook.createCellStyle();
					centerStyle.setAlignment(HorizontalAlignment.CENTER);
					// centerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
					// centerStyle.setsi

					row = sheet.createRow(3);
					cell = row.createCell(0, CellType.STRING);
					cell.setCellValue("So Thu Tu");
					sheet.autoSizeColumn(0);

					cell = row.createCell(1, CellType.STRING);
					cell.setCellValue("Ma San Pham");
					sheet.autoSizeColumn(1);

					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue("Ten San Pham");
					sheet.autoSizeColumn(2);

					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue("So Luong");
					sheet.autoSizeColumn(3);

					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue("Gia");
					cell.setCellStyle(centerStyle);

					cell = row.createCell(5, CellType.STRING);
					cell.setCellValue("Giam Gia");
					sheet.autoSizeColumn(5);

					cell = row.createCell(7, CellType.STRING);
					cell.setCellValue("Tong Cong");
					sheet.autoSizeColumn(7);

					cell = row.createCell(8, CellType.STRING);
					cell.setCellValue("Nhan tu khach");
					sheet.autoSizeColumn(8);

					cell = row.createCell(9, CellType.STRING);
					cell.setCellValue("Tra lai khach");
					sheet.autoSizeColumn(9);

					for (int i = 0; i < listMuaHang.size(); i++) {

						row = sheet.createRow(4 + i);

						cell = row.createCell(0, CellType.STRING);
						cell.setCellValue(i + 1);
						cell.setCellStyle(centerStyle);

						cell = row.createCell(1, CellType.STRING);
						cell.setCellValue(listMuaHang.get(i).getMaSP());

						cell = row.createCell(2, CellType.STRING);
						cell.setCellValue(listMuaHang.get(i).getTenSP());

						cell = row.createCell(3, CellType.STRING);
						cell.setCellValue(listMuaHang.get(i).getSoLuong());
						cell.setCellStyle(centerStyle);

						cell = row.createCell(4, CellType.STRING);
						cell.setCellValue(listMuaHang.get(i).getGia());

						cell = row.createCell(5, CellType.STRING);
						cell.setCellValue(listMuaHang.get(i).getGiamGia());
						cell.setCellStyle(centerStyle);

						if (i == 0) {
							cell = row.createCell(7, CellType.STRING);
							cell.setCellValue(jtfTongCong.getText());

							cell = row.createCell(8, CellType.STRING);
							cell.setCellValue(jtfNhanTuKhach.getText());

							cell = row.createCell(9, CellType.STRING);
							cell.setCellValue(jtfTraLaiKhach.getText());
						}
					}

					File f = new File("E:\\doan\\cuahangtaphoa\\excel\\DanhSachMuaHang.xlsx");
					try {
						FileOutputStream fos = new FileOutputStream(f);
						workbook.write(fos);
						fos.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnXuatEX.setBackground(new Color(102, 255, 102));
		btnXuatEX.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnXoa = new JButton("Xoa");
		btnXoa.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\delete (1).png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamDAO_Impl spDAO = new SanPhamDAO_Impl();
				spDAO.deleteMuaHangByMaSP(idXoa);
				showData_2(spDAO.getAllMuaHang());
				Tong();
			}
		});
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBackground(new Color(255, 102, 102));
		btnXoa.setBounds(210, 485, 118, 21);
		panel_3.add(btnXoa);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfMaSP.setText("");
				jtfTenSP.setText("");
				jtfSoLuong.setText("");
				jtfGia.setText("");
				showData(spDAO.getAll());
			}
		});

		this.setVisible(true);

		showData(spDAO.getAll());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void truSanPham() {
		List<SanPhamModel> listMuaHang = new ArrayList<>();
		List<SanPhamModel> listSanPham = new ArrayList<>();
		SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
		SanPhamModel sp = new SanPhamModel();
		SanPhamModel sp_bd = new SanPhamModel();
		listSanPham = sp_DAO.getAll();
		listMuaHang = sp_DAO.getAllMuaHang();
		for (int i = 0; i < listMuaHang.size(); i++) {
			sp.setMaSP(listMuaHang.get(i).getMaSP());
			sp.setTenSP(listMuaHang.get(i).getTenSP());
			sp.setSoLuong(listMuaHang.get(i).getSoLuong());
			sp.setGia(listMuaHang.get(i).getGia());
			sp.setGiamGia(listMuaHang.get(i).getGiamGia());
			sp_DAO.updateSanPhamSauThanhToan(sp);
		}
	}

	public void luuHoaDon() {
		List<SanPhamModel> listMuaHang = new ArrayList<>();
		HoaDonModel hd = new HoaDonModel();
		SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
		HoaDonDAO_Impl hd_DAO = new HoaDonDAO_Impl();
		listMuaHang = sp_DAO.getAllMuaHang();
		System.out.print(listMuaHang);
		for (int i = 0; i < listMuaHang.size(); i++) {
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
			hd_DAO.insertChiTietHoaDon(hd, maHD);
		}
		maHD++;
	}

	public void showData(List<SanPhamModel> spList) {
		List<SanPhamModel> listSanPham = new ArrayList<>();
		listSanPham = spList;
		DefaultTableModel tableModel;
		tbSanPham.getModel();
		tableModel = (DefaultTableModel) tbSanPham.getModel();
		tableModel.setRowCount(0);
		listSanPham.forEach((sanpham) -> {
			tableModel.addRow(new Object[] { sanpham.getMaSP(), sanpham.getTenSP(), sanpham.getSoLuong(),
					sanpham.getGia(), sanpham.getGiamGia() });
		});
	}

	public void showData_2(List<SanPhamModel> spList) {
		List<SanPhamModel> listSanPham = new ArrayList<>();
		listSanPham = spList;
		DefaultTableModel tableModel;
		tbMuaHang.getModel();
		tableModel = (DefaultTableModel) tbMuaHang.getModel();
		tableModel.setRowCount(0);
		System.out.print(listSanPham);
		listSanPham.forEach((sanpham) -> {
			tableModel.addRow(new Object[] { sanpham.getMaSP(), sanpham.getTenSP(), sanpham.getSoLuong(),
					sanpham.getGia(), sanpham.getGiamGia() });
		});
	}

	public void layDuLieu() {
		DefaultTableModel modelTable = (DefaultTableModel) tbSanPham.getModel();
		int index = tbSanPham.getSelectedRow();
		// SanPhamModel sp = new SanPhamModel();
		jtfMaSP.setText(String.valueOf(modelTable.getValueAt(index, 0)));
		jtfTenSP.setText(String.valueOf(modelTable.getValueAt(index, 1)));
		jtfSoLuong.setText(String.valueOf(modelTable.getValueAt(index, 2)));
		jtfGia.setText(String.valueOf(modelTable.getValueAt(index, 3)));
		jtfGiamGia.setText(String.valueOf(modelTable.getValueAt(index, 4)));
	}

	public int Tong() {
		int Tong = 0;
		for (int i = 0; i < tbMuaHang.getRowCount(); i++) {
			int SoLuong = (int) tbMuaHang.getValueAt(i, 2);
			int Gia = (int) tbMuaHang.getValueAt(i, 3);
			int GiamGia = 100 - (int) tbMuaHang.getValueAt(i, 4);
			Tong += ((SoLuong * Gia) * (GiamGia) / 100);
			System.out.println(((SoLuong * Gia) * (GiamGia) / 100));
		}
		jtfTongCong.setText(String.valueOf(Tong));
		return Tong;
	}
}