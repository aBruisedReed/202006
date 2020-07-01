package view;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.CommonService;
import service.CommonServiceImpl;
import service.DatabaseService;
import service.DatabaseServiceImpl;
import service.LoginService;
import service.LoginServiceImpl;
import service.MembershipService;
import service.MembershipServiceImpl;
import service.SingletonData;

public class LoginController extends Controller implements Initializable {
	private Parent root;
	private LoginService loginSrv;
	private CommonService comSrv;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		loginSrv = new LoginServiceImpl();
		comSrv = new CommonServiceImpl();
		
	}

	public void cancelProc(ActionEvent event) {
		comSrv.WindowClose(event);
	}
	
	public void loginProc(ActionEvent event) {
		String txtFldArr[] = { "#LoginID1", "#PassID1" };
		Map<String, TextField> txtFldMap = comSrv.getTextFieldInfo(root, txtFldArr);
		
		if(comSrv.isEmpty(txtFldMap, txtFldArr)) {
			comSrv.ErrorMsg("Error", "빈칸이 존재합니다.");
//			System.out.println("비어있습니다.");
			return;
		}
		else {
			TextField idTxt = (TextField)root.lookup("#LoginID1");
			TextField pwTxt = (TextField)root.lookup("#PassID1");
			
			DatabaseService db = new DatabaseServiceImpl();
			boolean login = db.Select(idTxt.getText(), pwTxt.getText());
			CommonService com = new CommonServiceImpl();
			if(login) {
//				com.ErrorMsg("로그인 되었습니다.");
				comSrv.WindowClose(event);
				SingletonData sd = SingletonData.getInstance(); //현재 로그인한 회원 정보 기록용
				sd.setCurrentUserId(idTxt.getText());
				
				loginSrv.AfterLogin();
			} else {
				com.ErrorMsg("아이디 패스워드가 틀립니다.");
			}
		}
	}
	
	
	public void joinProc(ActionEvent event) {
		loginSrv.OpenJoinForm();
	}
	
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}

}
