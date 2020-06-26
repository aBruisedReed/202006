package view;

import java.net.URL;
import java.sql.SQLException;
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
import service.Member;
import service.MembershipService;
import service.MembershipServiceImpl;

public class MembershipController extends Controller implements Initializable {
	private Parent root;
	private CommonService comSrv;
	private MembershipService membershipServ;
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comSrv = new CommonServiceImpl();
		membershipServ = new MembershipServiceImpl();
	}
	public void cancelProc(ActionEvent event) {
		comSrv.WindowClose(event);
	}
	
	private boolean isCheck(Map<String, TextField> txtFldMap, String[] txtFldArr, String[] list) {
		if(comSrv.isEmpty(txtFldMap, txtFldArr, list)) {
			//System.out.println("비어 있습니다.");
			return false;
		}
		
		String pw = txtFldMap.get(txtFldArr[2]).getText();
		String pwOk= txtFldMap.get(txtFldArr[3]).getText();
		
		if(!membershipServ.comparePW(pw, pwOk)) {
			comSrv.ErrorMsg("패스워드가 다릅니다.");
			txtFldMap.get(txtFldArr[2]).clear();
			txtFldMap.get(txtFldArr[2]).requestFocus();
			txtFldMap.get(txtFldArr[3]).clear();
			
			return false;
		}
		
		return true;
	}
	
	public void MembershipProc() throws SQLException { 
		String []txtFldArr = {"#txtName","#txtID","#txtPw","#txtPwOk","#txtNumber","#txtAddress",};
		String []list = {"이름","아이디","암호","암호 확인", "전화번호","주소",  };
		Map<String, TextField> txtFldMap = comSrv.getTextFieldInfo(root, txtFldArr);
		
		if(!isCheck(txtFldMap, txtFldArr, list)) {
			return;
		}
		
		if (comSrv.isEmpty(txtFldMap, txtFldArr, list)) {
			//System.out.println("비어있습니다.");
			return;
		}
		
				
		Member member = new Member();
		
		member.setName(txtFldMap.get(txtFldArr[0]).getText());
		member.setId(txtFldMap.get(txtFldArr[1]).getText());
		member.setPw(txtFldMap.get(txtFldArr[2]).getText());
		member.setAddress(txtFldMap.get(txtFldArr[5]).getText());
		member.setPhone(txtFldMap.get(txtFldArr[4]).getText());
		
		System.out.println("이름 : "+" "+member.getName());
		System.out.println("ID : "+" "+member.getId());
		System.out.println("Pw : "+" "+member.getPw());
		
		System.out.println("전화번호 : "+" "+member.getPhone());
		System.out.println("주소 : "+" "+member.getAddress());
		//DatabaseService db = new DatabaseServiceImpl();
		
		//db.Insert(member);
		comSrv.ErrorMsg("가입","가입 성공!","가입이 완료 되었습니다.");
		Stage s = (Stage) root.getScene().getWindow();
		s.close();
		
	}
	
	public void openFindAddress() {
		membershipServ.openFindAddress();
	}
}
