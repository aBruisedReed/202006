package service;

import java.sql.SQLException;

public interface DatabaseService {
	public void Insert(Member member) throws SQLException; // Member 추가
	public boolean isOverrap(String id); // ID 중복 체크
	public boolean Select(String id, String pw); // Member 정보 가져오기
	public Goods selectGoods(String name);
}
