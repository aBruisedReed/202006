package service;


import java.util.Arrays;

import service.DatabaseService;
import service.DatabaseServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginServiceImpl implements LoginService{

	@Override
	public void LoginProc(Parent root) { // DB에서 아이디, 비밀번호를 가져옴
		// TODO Auto-generated method stub
		TextField idTxt = (TextField)root.lookup("#idTxt");
		TextField pwTxt = (TextField)root.lookup("#pwTxt");
		
		DatabaseService db = new DatabaseServiceImpl();
		boolean login = db.Select(idTxt.getText(), pwTxt.getText());
		CommonService com = new CommonServiceImpl();
		if(login) {
			com.ErrorMsg("로그인 되었습니다.");
			System.out.println("ID : " + idTxt.getText() +  ", PW : " 
					+ pwTxt.getText() + " 가 입력 되었습니다");
		} else {
			com.ErrorMsg("아이디 패스워드가 틀립니다.");
		}
				
	}

	@Override
	public Parent OpenLoginForm() { // 로그인 창을 열어줌
		// TODO Auto-generated method stub
		CommonService comSrv = new CommonServiceImpl();
		Stage loginForm = new Stage();
		Parent form = comSrv.showWindow(loginForm, "../view/Login.fxml");
		
		return form;
	}

	@Override
	public Parent OpenJoinForm() { // 회원가입 창을 열어줌
		// TODO Auto-generated method stub
		CommonService comSrv = new CommonServiceImpl();
		Stage joinForm = new Stage();
		Parent form = comSrv.showWindow(joinForm, "../view/Join.fxml");
		
		return form;
	}

}












