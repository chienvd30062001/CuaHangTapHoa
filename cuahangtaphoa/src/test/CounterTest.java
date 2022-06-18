package test;

import javax.swing.UIManager;

import model.CounterModel;
import view.CounterView;
import view.Nv_view;

public class CounterTest {
	public static void main(String[] args) {
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new Nv_view();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
