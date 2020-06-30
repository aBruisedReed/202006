package service;

public class SingletonData {
	private static SingletonData instance = new SingletonData();
	
	String currentUserId;
	String totalPrice;

	private SingletonData() {}
	
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
}
