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
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u1EECA H\u00C0NG T\u1EA0P H\u00D3A 3AE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(169, 49, 420, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TrangChu_View.class.getResource("/img/logo (1) (1).png")));
		lblNewLabel_1.setBounds(93, 0, 108, 129);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Danh m\u1EE5c qu\u1EA3n l\u00FD");
		lblNewLabel_2.setBounds(33, 150, 124, 25);
		contentPane.add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(137, 139, 108, 179);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(291, 150, 111, 24);
		contentPane.add(mnNewMenu);
	}
}
