package model;

public class CounterModel {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CounterModel() {
		this.value = 0;
	}
	public void increment() {
		this.value++;
	}
	public void descrement() {
		this.value--;
	}
	public void reset() {
		this.value = 0;
	}
}
