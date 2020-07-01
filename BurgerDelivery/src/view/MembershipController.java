package view;

import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.AddressData;
import service.CommonService;
import service.CommonServiceImpl;
import service.DatabaseService;
import service.DatabaseServiceImpl;
import service.Member;
import service.MembershipService;
import service.MembershipServiceImpl;
import service.StringContainer;

public class MembershipController extends Controller implements Initializable {
	private Parent root;
	private CommonService comSrv;
	private MembershipService membershipServ;
	DatabaseService db;
	StringContainer string;
	boolean flag;
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
		db = new DatabaseServiceImpl();
		string = new StringContainer();
		flag = true;
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
		
		db.Insert(member);
		comSrv.ErrorMsg("가입","가입 성공!","가입이 완료 되었습니다.");
		Stage s = (Stage) root.getScene().getWindow();
		s.close();
		
	}
	
	public void idCheckProc() {
		if(((TextField)root.lookup("#txtID")).getText().isEmpty()) {
			comSrv.ErrorMsg("Error", "아이디를 입력하세요.");
			((TextField)root.lookup("#txtID")).requestFocus();
		}
		else {
			String id = ((TextField)root.lookup("#txtID")).getText();
			if(db.isOverrap(id)) {
				comSrv.ErrorMsg("중복된 ID","중복된 ID","이미 존재하는 ID입니다.");
			} else {
				comSrv.ErrorMsg("사용 가능한 ID","사용 가능한 ID","사용 가능한 ID입니다.");
			}
		}
	}
	
	public void openFindAddress() {
		flag=true;
		TextField tf = (TextField)root.lookup("#txtAddress");
		Stage findAddress = new Stage();
		comSrv.showWindow(findAddress, "../view/Address.fxml", string);
		
		root.setOnMouseMoved(e -> {
//			System.out.println(string.getData());
			if(flag) {
				tf.setText(string.getData());
				flag=!flag;
			}
		});
	}
}
