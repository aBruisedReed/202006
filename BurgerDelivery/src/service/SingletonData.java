package service;

import javafx.scene.Parent;

public class SingletonData {
	private static SingletonData instance = new SingletonData();
	
	boolean isOrdered;
	String currentUserId;
	String totalPrice;
	Parent window;

	private SingletonData() { 
		isOrdered = false;
	}
	
	public static SingletonData getInstance() {
		return instance;
	}
	public String getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Parent getWindow() {
		return window;
	}
	public void setWindow(Parent window) {
		this.window = window;
	}
	public boolean getOrdered() {
		return isOrdered;
	}
	public void setOrdered(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}
}
