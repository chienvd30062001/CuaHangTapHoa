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
import javax.swing.border.TitledBorder;

public class KhoHang_View extends JFrame {

	private JPanel contentPane;
	private JTextField jtfTimKiem;
	private JTextField jtfGiamGia;
	private JButton btnNewButton_4;
	private static JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblMasp;
	// private JLabel lblmage;
	private JTextField jtfMaSP;
	private JTextField jtfTenSP;
	private JTextField jtfSoLuong;
	private JTextField jtfGia;
	private byte[] sanphamImage;
	private String luuAnh = "";
	private String parentLuuAnh = "";
	// private JLabel lblmage;

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

		JLabel lblmage = new JLabel("");
		lblmage.setBounds(10, 38, 140, 120);

		lblmage.setBackground(Color.GRAY);

		setTitle("CuaHangTapHoa");
		setSize(1024, 599);
		getContentPane().setLayout(null);

		jtfTimKiem = new JTextField();
		jtfTimKiem.setBounds(20, 18, 388, 19);
		getContentPane().add(jtfTimKiem);
		jtfTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBackground(new Color(0, 153, 255));
		btnTimKiem.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\magnifying-glass.png"));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setTenSP(jtfTimKiem.getText());
				showData(spDAO.getByName(sp));
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
				jtfMaSP.setText("");
				jtfTenSP.setText("");
				jtfSoLuong.setText("");
				jtfGia.setText("");
				jtfGiamGia.setText("");
				sanphamImage = null;
				ImageIcon icon = new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\dialogue.png");
				Image img = ImageHelper.resize(icon.getImage(), 160, 140);
				ImageIcon resizeIcon = new ImageIcon(img);
				lblmage.setIcon(resizeIcon);
				showData(spDAO.getAll());
			}
		});

		btnLamMoi.setBounds(536, 18, 100, 19);
		getContentPane().add(btnLamMoi);

		btnNewButton_4 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_4.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\logout.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu_View tc = new TrangChu_View();
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBackground(new Color(255, 102, 102));
		btnNewButton_4.setBounds(892, 16, 108, 19);
		getContentPane().add(btnNewButton_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 62, 616, 493);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layDuLieu();
				SanPhamDAO_Impl sp_DAO = new SanPhamDAO_Impl();
				String indexHinhAnh = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
				luuAnh = sp_DAO.getPathHinhAnhByName(indexHinhAnh);
				ImageIcon icon = new ImageIcon(luuAnh);
				Image img = ImageHelper.resize(icon.getImage(), 160, 140);
				ImageIcon resizeIcon = new ImageIcon(img);
				lblmage.setIcon(resizeIcon);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, "", null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng",
						"Gi\u00E1", "Gi\u1EA3m gi\u00E1 (%)" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(111);
		table.getColumnModel().getColumn(2).setPreferredWidth(59);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(647, 62, 353, 493);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_2_1 = new JButton("Lưu");
		btnNewButton_2_1.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\floppy-disk.png"));
		btnNewButton_2_1.setBounds(10, 447, 100, 21);
		panel.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamModel sp = new SanPhamModel();
				sp.setMaSP(jtfMaSP.getText());
				sp.setTenSP(jtfTenSP.getText());
				sp.setSoLuong(Integer.parseInt(jtfSoLuong.getText()));
				sp.setGia(Integer.parseInt(jtfGia.getText()));
				sp.setGiamGia(Integer.parseInt(jtfGiamGia.getText()));
				sp.setHinhAnh(luuAnh);
				// String imgPath = lblmage.getText();
				// sp.setHinhAnh(String.valueOf(sanphamImage));
				spDAO.insert(sp);
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
				showData(spDAO.getAll());
				jtfMaSP.setText("");
				jtfTenSP.setText("");
				jtfSoLuong.setText("");
				jtfGia.setText("");
				jtfGiamGia.setText("");

			}
		});
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2_1.setBackground(new Color(0, 153, 255));

		JButton btnNewButton_2_3 = new JButton("Cập nhật");
		btnNewButton_2_3.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\refresh (1).png"));
		btnNewButton_2_3.setBounds(123, 447, 108, 21);
		panel.add(btnNewButton_2_3);
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
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				showData(spDAO.getAll());
			}
		});
		btnNewButton_2_3.setForeground(Color.BLACK);
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2_3.setBackground(new Color(255, 255, 153));

		JButton btnNewButton_2_2 = new JButton("Xóa");
		btnNewButton_2_2.setIcon(new ImageIcon("E:\\doan\\cuahangtaphoa\\src\\img\\BanHang\\delete (1).png"));
		btnNewButton_2_2.setBounds(241, 447, 100, 21);
		panel.add(btnNewButton_2_2);
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
		btnNewButton_2_2.setBackground(new Color(255, 102, 102));

		JButton btnNewButton_2_1_1 = new JButton("Chọn");
		btnNewButton_2_1_1.setBounds(21, 331, 100, 21);
		panel.add(btnNewButton_2_1_1);
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
						if (f.isDirectory()) {
							return true;
						} else {
							return f.getName().toLowerCase().endsWith(".png");
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
					Image img = ImageHelper.resize(icon.getImage(), 140, 120);
					ImageIcon resizeIcon = new ImageIcon(img);
					lblmage.setIcon(resizeIcon);

					sanphamImage = ImageHelper.toByteArray(img, "png");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2_1_1.setBackground(Color.BLUE);

		jtfTenSP = new JTextField();
		jtfTenSP.setBounds(149, 68, 160, 19);
		panel.add(jtfTenSP);
		jtfTenSP.setColumns(10);
		JLabel lblTensp = new JLabel("Tên Sản Phẩm");
		lblTensp.setBounds(21, 64, 108, 24);
		panel.add(lblTensp);
		lblTensp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfSoLuong = new JTextField();
		jtfSoLuong.setBounds(149, 113, 160, 19);
		panel.add(jtfSoLuong);
		jtfSoLuong.setColumns(10);

		JLabel lblSoluong = new JLabel("Số Lượng");
		lblSoluong.setBounds(21, 109, 85, 25);
		panel.add(lblSoluong);
		lblSoluong.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfGia = new JTextField();
		jtfGia.setBounds(149, 156, 160, 19);
		panel.add(jtfGia);
		jtfGia.setColumns(10);

		JLabel lblGia = new JLabel("Giá");
		lblGia.setBounds(21, 152, 85, 24);
		panel.add(lblGia);
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblNewLabel_1 = new JLabel("Giảm giá (%)");
		lblNewLabel_1.setBounds(21, 199, 108, 24);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfGiamGia = new JTextField();
		jtfGiamGia.setBounds(149, 203, 160, 19);
		panel.add(jtfGiamGia);
		jtfGiamGia.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "H\u00ECnh \u1EA2nh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(149, 252, 160, 166);
		panel.add(panel_1);
		panel_1.setLayout(null);

		panel_1.add(lblmage);

		lblMasp = new JLabel("Mã Sản Phẩm");
		lblMasp.setBounds(21, 25, 95, 24);
		panel.add(lblMasp);
		lblMasp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfMaSP = new JTextField();
		jtfMaSP.setBounds(149, 29, 160, 19);
		panel.add(jtfMaSP);
		jtfMaSP.setColumns(10);

		this.setVisible(true);

		showData(spDAO.getAll());

	}

	public void showData(List<SanPhamModel> spList) {
		List<SanPhamModel> listSanPham = new ArrayList<>();
		listSanPham = spList;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		listSanPham.forEach((sanpham) -> {
			tableModel.addRow(new Object[] { sanpham.getMaSP(), sanpham.getTenSP(), sanpham.getSoLuong(),
					sanpham.getGia(), sanpham.getGiamGia() });
		});
	}

	public void layDuLieu() {
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		int index = table.getSelectedRow();
		jtfMaSP.setText(String.valueOf(modelTable.getValueAt(index, 0)));
		jtfTenSP.setText(String.valueOf(modelTable.getValueAt(index, 1)));
		jtfSoLuong.setText(String.valueOf(modelTable.getValueAt(index, 2)));
		jtfGia.setText(String.valueOf(modelTable.getValueAt(index, 3)));
		jtfGiamGia.setText(String.valueOf(modelTable.getValueAt(index, 4)));
		// lblmage.setText(String.valueOf(modelTable.getValueAt(index, 5)));
	}
}
