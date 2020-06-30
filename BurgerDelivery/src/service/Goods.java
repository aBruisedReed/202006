package service;
/*
 * DB 간의 상품 데이터 전달 용이를 위해 만든 데이터 클래스
 * 
create table goods {
	category varchar(20),
	name varchar(20),
	price integer,
	kcal integer
}
 */
public class Goods { 
	String name;
	String price;
	int amount;
	
	public Goods() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
