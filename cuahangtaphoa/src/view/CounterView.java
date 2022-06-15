package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CounterController;
import model.CounterModel;

public class CounterView extends JFrame{
	private CounterModel countermodel;
	private JButton jButton_up;
	private JButton jButton_down;
	private JLabel jLabel_value;
	
	public CounterView() {
		this.countermodel = new CounterModel();
		this.init();
		this.setVisible(true);
	}

	public void init() {
		this.setTitle("Couter");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener ac = new CounterController(this);
		
		jButton_up = new JButton("UP");
		jButton_up.addActionListener(ac);
		jButton_down = new JButton("DOWN");
		jButton_down.addActionListener(ac);
		
		jLabel_value =new JLabel(this.countermodel.getValue()+"", JLabel.CENTER);
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jButton_up, BorderLayout.WEST);
		jPanel.add(jLabel_value, BorderLayout.CENTER);
		jPanel.add(jButton_down, BorderLayout.EAST);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel, BorderLayout.CENTER);
		
	}
	public void increment() {
		this.countermodel.increment();
		this.jLabel_value.setText(this.countermodel.getValue()+"");
	}
	
	public void decincrement() {
		this.countermodel.descrement();
		this.jLabel_value.setText(this.countermodel.getValue()+"");
	}
}

