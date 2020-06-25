package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				return false;
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
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

}
