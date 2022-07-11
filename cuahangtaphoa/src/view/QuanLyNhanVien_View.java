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

import model.NhanVienModel;
import model.NhanVienModel;
import DAO.DBConnect;
import DAO.NhanVienDAO_Impl;
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
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class QuanLyNhanVien_View extends JFrame {

	private JPanel contentPane;
	private JTextField jtfTimKiem;
	private JTextField jtfDiaChi;
	private JButton btnDangXuat;
	private static JTable tableNhanVien;
	private JLabel lblNewLabel_1;
	private JLabel lblMasp;
	private JTextField jtfMaNhanVien;
	private JTextField jtfTenNhaVien;
	private JTextField jtfNgaySinh;
	private JTextField jtfQueQuan;
	private byte[] sanphamImage;
	private String luuAnh = "";
	private JTextField jtfThoiGianVao;
	private Date ngaySinh;
	private Date thoiGianVaoLam;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhanVien_View frame = new QuanLyNhanVien_View();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyNhanVien_View() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		getContentPane().setBackground(Color.WHITE);

		NhanVienDAO_Impl nvDAO = new NhanVienDAO_Impl();
		List<NhanVienModel> listMuaHang = new ArrayList<>();

		JLabel lblmage = new JLabel("");
		lblmage.setBounds(10, 15, 190, 160);

		lblmage.setBackground(Color.GRAY);

		setTitle("CuaHangTapHoa");
		setSize(1024, 665);
		getContentPane().setLayout(null);

		jtfTimKiem = new JTextField();
		jtfTimKiem.setBounds(20, 18, 388, 19);
		getContentPane().add(jtfTimKiem);
		jtfTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\magnifying-glass.png"));
		btnTimKiem.setBackground(new Color(0, 153, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienModel nv = new NhanVienModel();
				nv.setTenNhanVien(jtfTimKiem.getText());
				showData(nvDAO.getByName(nv));
			}
		});
		btnTimKiem.setBounds(418, 18, 108, 19);
		getContentPane().add(btnTimKiem);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\refresh.png"));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfMaNhanVien.setText("");
				jtfTenNhaVien.setText("");
				jtfNgaySinh.setText("");
				jtfQueQuan.setText("");
				jtfDiaChi.setText("");
				sanphamImage = null;
				ImageIcon icon = new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\dialogue.png");
				Image img = ImageHelper.resize(icon.getImage(), 190, 160);
				ImageIcon resizeIcon = new ImageIcon(img);
				lblmage.setIcon(resizeIcon);
				showData(nvDAO.getAll());
			}
		});

		btnLamMoi.setBounds(536, 18, 100, 19);
		getContentPane().add(btnLamMoi);

		btnDangXuat = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu_View tc = new TrangChu_View();
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangXuat.setForeground(Color.BLACK);
		btnDangXuat.setBackground(new Color(255, 102, 102));
		btnDangXuat.setBounds(905, 16, 95, 19);
		getContentPane().add(btnDangXuat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 62, 616, 524);
		getContentPane().add(scrollPane);

		tableNhanVien = new JTable();
		tableNhanVien.addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e) {
				layDuLieu();
				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
				String indexHinhAnh = String.valueOf(tableNhanVien.getValueAt(tableNhanVien.getSelectedRow(), 0));
				luuAnh = nvDAO.getPathHinhAnhByName(indexHinhAnh);
				System.out.println(luuAnh);
				ImageIcon icon = new ImageIcon(luuAnh);
				//lblmage.setIcon(icon);
				//System.out.println(String.valueOf(icon));
				Image img = ImageHelper.resize(icon.getImage(), 190, 160);
				ImageIcon resizeIcon = new ImageIcon(img);
				lblmage.setIcon(resizeIcon);

			}
		});
		tableNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "Ng\u00E0y Sinh", "Qu\u00EA Qu\u00E1n", "\u0110\u1ECBa Ch\u1EC9", "Ng\u00E0y V\u00E0o L\u00E0m"
			}
		));
		tableNhanVien.getColumnModel().getColumn(0).setPreferredWidth(52);
		tableNhanVien.getColumnModel().getColumn(1).setPreferredWidth(111);
		tableNhanVien.getColumnModel().getColumn(2).setPreferredWidth(59);
		tableNhanVien.getColumnModel().getColumn(3).setPreferredWidth(92);
		tableNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableNhanVien);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi Ti\u1EBFt S\u1EA3n Ph\u1EA9m", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(647, 62, 353, 524);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\floppy-disk.png"));
		btnLuu.setBounds(21, 477, 85, 21);
		panel.add(btnLuu);
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(jtfNgaySinh.getText());
				} catch (ParseException e1) {

					e1.printStackTrace();
				}
				try {
					thoiGianVaoLam = new SimpleDateFormat("dd/MM/yyyy").parse(jtfThoiGianVao.getText());
				} catch (ParseException e1) {

					e1.printStackTrace();
				}
				NhanVienModel nv = new NhanVienModel();
				nv.setMaNhanVien(jtfMaNhanVien.getText());
				nv.setTenNhanVien(jtfTenNhaVien.getText());
				nv.setNgaySinh(ngaySinh);
				nv.setQueQuan(jtfQueQuan.getText());
				nv.setDiaChi(jtfDiaChi.getText());
				nv.setThoiGianVao(thoiGianVaoLam);
				nv.setHinhAnh(luuAnh);
				nvDAO.insert(nv);
				JOptionPane.showMessageDialog(null, "Save Success");
				showData(nvDAO.getAll());
				jtfMaNhanVien.setText("");
				jtfTenNhaVien.setText("");
				jtfNgaySinh.setText("");
				jtfQueQuan.setText("");
				jtfDiaChi.setText("");
				jtfThoiGianVao.setText("");

			}
		});
		btnLuu.setForeground(Color.BLACK);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLuu.setBackground(Color.BLUE);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\refresh (1).png"));
		btnCapNhat.setBounds(123, 477, 108, 21);
		panel.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienModel nv = new NhanVienModel();
				nv.setMaNhanVien(jtfMaNhanVien.getText());
				nv.setTenNhanVien(jtfTenNhaVien.getText());
				try {
					ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(jtfNgaySinh.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					thoiGianVaoLam =new SimpleDateFormat("dd/MM/yyyy").parse(jtfThoiGianVao.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}	
				nv.setNgaySinh(ngaySinh);
				nv.setThoiGianVao(thoiGianVaoLam);
				nv.setQueQuan(jtfQueQuan.getText());
				nv.setDiaChi(jtfDiaChi.getText());
				nv.setHinhAnh(luuAnh);
				System.out.println(nv.getHinhAnh());
				nvDAO.update(nv);
				JOptionPane.showMessageDialog(null, "Save Success");
				showData(nvDAO.getAll());
			}
		});
		btnCapNhat.setForeground(Color.BLACK);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCapNhat.setBackground(Color.YELLOW);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\delete (1).png"));
		btnXoa.setBounds(241, 477, 100, 21);
		panel.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienModel nv = new NhanVienModel();
				nv.setMaNhanVien(jtfMaNhanVien.getText());
				nvDAO.delete(nv);
				showData(nvDAO.getAll());
			}
		});
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBackground(new Color(255, 153, 153));

		JButton btnChonAnh = new JButton("Chọn");
		btnChonAnh.setBounds(21, 369, 85, 21);
		panel.add(btnChonAnh);
		btnChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(new File("E:\\doan\\cuahangtaphoa\\src\\img\\NhanVien"));
				chooser.setFileFilter(new FileFilter() {

					@Override
					public String getDescription() {

						return "Image File (*.jpg)";
					}

					@Override
					public boolean accept(File f) {
						if (f.isDirectory()) {
							return true;
						} else {
							return f.getName().toLowerCase().endsWith(".jpg");
						}
					}
				});
				;
				if (chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) {
					return;
				}
				File file = chooser.getSelectedFile();
				luuAnh = file.getPath();
				System.out.println(luuAnh);
				try {
					ImageIcon icon = new ImageIcon(file.getPath());
					Image img = ImageHelper.resize(icon.getImage(), 190, 160);
					ImageIcon resizeIcon = new ImageIcon(img);
					lblmage.setIcon(resizeIcon);

					sanphamImage = ImageHelper.toByteArray(img, "jpg");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnChonAnh.setForeground(Color.BLACK);
		btnChonAnh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnChonAnh.setBackground(Color.BLUE);

		jtfTenNhaVien = new JTextField();
		jtfTenNhaVien.setBounds(149, 68, 160, 19);
		panel.add(jtfTenNhaVien);
		jtfTenNhaVien.setColumns(10);
		JLabel lblTensp = new JLabel("Tên Nhân Viên ");
		lblTensp.setBounds(21, 64, 108, 24);
		panel.add(lblTensp);
		lblTensp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfNgaySinh = new JTextField();
		jtfNgaySinh.setBounds(149, 113, 160, 19);
		panel.add(jtfNgaySinh);
		jtfNgaySinh.setColumns(10);

		JLabel lblSoluong = new JLabel("Ngày Sinh");
		lblSoluong.setBounds(21, 109, 85, 25);
		panel.add(lblSoluong);
		lblSoluong.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfQueQuan = new JTextField();
		jtfQueQuan.setBounds(149, 156, 160, 19);
		panel.add(jtfQueQuan);
		jtfQueQuan.setColumns(10);

		JLabel lblGia = new JLabel("Quê Quán ");
		lblGia.setBounds(21, 152, 85, 24);
		panel.add(lblGia);
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblNewLabel_1 = new JLabel("Địa Chỉ ");
		lblNewLabel_1.setBounds(21, 188, 108, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfDiaChi = new JTextField();
		jtfDiaChi.setBounds(149, 192, 160, 19);
		panel.add(jtfDiaChi);
		jtfDiaChi.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u00ECnh \u1EA2nh", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(125, 270, 210, 185);
		panel.add(panel_1);
		panel_1.setLayout(null);

		panel_1.add(lblmage);

		lblMasp = new JLabel("Mã Nhân Viên");
		lblMasp.setBounds(21, 25, 95, 24);
		panel.add(lblMasp);
		lblMasp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfMaNhanVien = new JTextField();
		jtfMaNhanVien.setBounds(149, 29, 160, 19);
		panel.add(jtfMaNhanVien);
		jtfMaNhanVien.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Ngày Vào Làm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(21, 233, 108, 24);
		panel.add(lblNewLabel_1_1);

		jtfThoiGianVao = new JTextField();
		jtfThoiGianVao.setColumns(10);
		jtfThoiGianVao.setBounds(149, 237, 160, 19);
		panel.add(jtfThoiGianVao);

		this.setVisible(true);

		showData(nvDAO.getAll());
	}

	public void showData(List<NhanVienModel> spList) {
		List<NhanVienModel> listNhanVien = new ArrayList<>();
		listNhanVien = spList;
		DefaultTableModel tableModel;
		tableNhanVien.getModel();
		tableModel = (DefaultTableModel) tableNhanVien.getModel();
		tableModel.setRowCount(0);
		listNhanVien.forEach((nhanvien) -> {
			tableModel.addRow(new Object[] 
					{ 
					nhanvien.getMaNhanVien(), 
					nhanvien.getTenNhanVien(),
					nhanvien.getNgaySinh(), 
					nhanvien.getQueQuan(), 
					nhanvien.getDiaChi(), 
					nhanvien.getThoiGianVao() 
					});
		});
	}

	public void layDuLieu() {
		DefaultTableModel modelTable = (DefaultTableModel) tableNhanVien.getModel();
		int index = tableNhanVien.getSelectedRow();
		jtfMaNhanVien.setText(String.valueOf(modelTable.getValueAt(index, 0)));
		jtfTenNhaVien.setText(String.valueOf(modelTable.getValueAt(index, 1)));
		jtfNgaySinh.setText(String.valueOf(modelTable.getValueAt(index, 2)));
		jtfQueQuan.setText(String.valueOf(modelTable.getValueAt(index, 3)));
		jtfDiaChi.setText(String.valueOf(modelTable.getValueAt(index, 4)));
		jtfThoiGianVao.setText(String.valueOf(modelTable.getValueAt(index, 5)));
	}
}
