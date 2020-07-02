package service;
/*
 * 사용 테이블 
create table member (
	name varchar(20),
	id varchar(20),
	pw varchar(20),
	phone varchar(200);
	address varchar(200),
)
 */
public class Member {
	private String name;
	private String id;
	private String pw;
	private String address;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
