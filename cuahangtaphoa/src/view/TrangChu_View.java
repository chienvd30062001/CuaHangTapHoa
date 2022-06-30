package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrangChu_View extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu_View frame = new TrangChu_View();
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
	public TrangChu_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 440);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u1EECA H\u00C0NG T\u1EA0P H\u00D3A 3AE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(210, 47, 420, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TrangChu_View.class.getResource("/img/logo (1) (1).png")));
		lblNewLabel_1.setBounds(93, 0, 108, 129);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DANH M\u1EE4C QU\u1EA2N L\u00DD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(271, 141, 234, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhoHang_View kh = new KhoHang_View();
				kh.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setIcon(new ImageIcon(TrangChu_View.class.getResource("/img/warehouse.png")));
		btnNewButton_1.setBounds(250, 204, 125, 90);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyHoaDon_View ql= new QuanLyHoaDon_View();
				ql.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setSelectedIcon(new ImageIcon(TrangChu_View.class.getResource("/img/grocery-cart (2).png")));
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon(TrangChu_View.class.getResource("/img/receipt.png")));
		btnNewButton_2.setBounds(411, 204, 125, 90);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(TrangChu_View.class.getResource("/img/dialogue.png")));
		btnNewButton_3.setBackground(SystemColor.menu);
		btnNewButton_3.setBounds(574, 204, 125, 90);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u0110\u0103ng Xu\u1EA5t");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap_View dn = new DangNhap_View();
				dn.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_4.setBounds(679, 372, 97, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BanHang_View bh = new BanHang_View();
				bh.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setIcon(new ImageIcon(TrangChu_View.class.getResource("/img/grocery-cart.png")));
		btnNewButton.setBounds(93, 204, 125, 90);
		contentPane.add(btnNewButton);
	}
}
