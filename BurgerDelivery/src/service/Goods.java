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
	String category;
	String name;
	int price;
	int kcal;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
