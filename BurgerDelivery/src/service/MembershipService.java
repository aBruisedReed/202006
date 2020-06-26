package service;

import javafx.scene.Parent;

public interface MembershipService {
	public boolean comparePW(String pw, String pwOk);
	public Parent openFindAddress();
}
