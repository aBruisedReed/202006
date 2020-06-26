package service;

import javafx.scene.Parent;

public interface LoginService {
	// 로그인과 관련된 기능
	public void LoginProc(Parent root);
	public Parent OpenLoginForm();
	public Parent OpenJoinForm();
}
