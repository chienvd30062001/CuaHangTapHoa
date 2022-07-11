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
import model.TaiKhoanModel;
import DAO.DBConnect;
import DAO.SanPhamDAO;
import DAO.SanPhamDAO_Impl;
import DAO.TaiKhoanDAO_Impl;
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

public class PhanQuyen_View extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_4;
	private static JTable table;
	private JLabel lblMasp;
	// private JLabel lblmage;
	private JTextField jtfTenDangNhap;
	private JTextField jtfQuyen;
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
					PhanQuyen_View frame = new PhanQuyen_View();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PhanQuyen_View() {
		getContentPane().setBackground(Color.WHITE);

		TaiKhoanDAO_Impl tkDAO = new TaiKhoanDAO_Impl();
		List<SanPhamModel> listMuaHang = new ArrayList<>();

		setTitle("CuaHangTapHoa");
		setSize(977, 333);
		getContentPane().setLayout(null);

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
		btnNewButton_4.setBackground(new Color(255, 102, 102));
		btnNewButton_4.setBounds(841, 10, 95, 19);
		getContentPane().add(btnNewButton_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 39, 526, 239);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layDuLieu();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn \u0110\u0103ng Nh\u1EADp", "Quy\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(111);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(583, 39, 353, 239);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_2_3 = new JButton("Cập nhật");
		btnNewButton_2_3.setBounds(149, 161, 100, 21);
		panel.add(btnNewButton_2_3);
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoanModel tk = new TaiKhoanModel();
				tk.setTenDangNhap(jtfTenDangNhap.getText());
				tk.setQuyen(Boolean.valueOf(jtfQuyen.getText()));
				tkDAO.update(tk);
				JOptionPane.showMessageDialog(null, "Save Success");
				showData(tkDAO.getAll());
			}
		});
		btnNewButton_2_3.setForeground(Color.BLACK);
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2_3.setBackground(new Color(255, 255, 153));

		jtfQuyen = new JTextField();
		jtfQuyen.setBounds(149, 68, 160, 19);
		panel.add(jtfQuyen);
		jtfQuyen.setColumns(10);
		JLabel lblTensp = new JLabel("Quyên");
		lblTensp.setBounds(21, 64, 108, 24);
		panel.add(lblTensp);
		lblTensp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblMasp = new JLabel("Tên Đăng Nhập");
		lblMasp.setBounds(21, 25, 95, 24);
		panel.add(lblMasp);
		lblMasp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		jtfTenDangNhap = new JTextField();
		jtfTenDangNhap.setBounds(149, 29, 160, 19);
		panel.add(jtfTenDangNhap);
		jtfTenDangNhap.setColumns(10);

		this.setVisible(true);

		showData(tkDAO.getAll());

	}

	public void showData(List<TaiKhoanModel> tkList) {
		List<TaiKhoanModel> listTaiKhoan = new ArrayList<>();
		listTaiKhoan = tkList;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		listTaiKhoan.forEach((taikhoan) -> {
			tableModel.addRow(new Object[] { taikhoan.getTenDangNhap(), taikhoan.isQuyen()});
		});
	}

	public void layDuLieu() {
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		int index = table.getSelectedRow();
		jtfTenDangNhap.setText(String.valueOf(modelTable.getValueAt(index, 0)));
		jtfQuyen.setText(String.valueOf(modelTable.getValueAt(index, 1)));
	}
}
