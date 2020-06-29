package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * 사용할 테이블
 * 
create table member {
	name varchar(20),
	id varchar(20),
	pw varchar(20),
	address varchar(20),
	phone varchar(20)
}

create table goods {
	category varchar(20),
	name varchar(20),
	price integer,
	kcal integer
}
 */

public class DatabaseServiceImpl implements DatabaseService{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public void Insert(Member member) throws SQLException {
		// TODO Auto-generated method stub
		try {
			con = DBConnection.getConnection();
			String sql = "insert into member values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,member.getId());
			ps.setString(2,member.getPw());
			ps.setString(3, member.getName());
			ps.setString(4, member.getAddress());
			ps.setString(5, member.getPhone());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isOverrap(String id) {
		// TODO Auto-generated method stub
		try {
			con = DBConnection.getConnection();
			String sql = "select * from member where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()==true) {
				return true;
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public boolean Select(String id, String pw) {
		// TODO Auto-generated method stub
		try {
			con = DBConnection.getConnection();
			String sql = "select * from member where id=? and pw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,pw);
			rs = ps.executeQuery();	

			if(rs.next()==false) {
				return false;
			}
			
			rs.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public Goods selectGoods(String name) {
		Goods goods = new Goods();
		try {
			con = DBConnection.getConnection();
			String sql = "select * from member where name=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			rs = ps.executeQuery();	

			if(!rs.next()) { //받은 데이터가 없다면
				System.out.println("일치하는 데이터 없음");
				return goods=null;
			}
			goods.setCategory(rs.getString("category"));
			goods.setName(rs.getString("name"));
			goods.setName(rs.getString("name"));
			goods.setPrice(rs.getInt("price"));
			goods.setKcal(rs.getInt("kcal"));
			rs.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return goods;
	}
}
