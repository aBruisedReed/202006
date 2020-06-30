package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import service.CommonServiceImpl;
import service.SingletonData;

public class PayController extends Controller implements Initializable {
	Parent root;
	boolean flag;
	CommonServiceImpl comSrv;
	
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		flag=true;
		comSrv = new CommonServiceImpl();
	}
	
	
	public void onPay() {
		if(flag==false) {
			return;
		}
		SingletonData sd = SingletonData.getInstance();
		Label total = (Label) root.lookup("#totalPrice");
		total.setText(sd.getTotalPrice());
		
		flag=false;
	}
	
	public void onPayProc() { //결제 버튼
		
	}
	
	public void onCancel(ActionEvent event) { //취소 버튼
		comSrv.WindowClose(event);
	}
	
	public void ch1On() { // 체크 박스 중첩 선택 방지
		CheckBox cb2 = (CheckBox)root.lookup("#ch2");
		cb2.setSelected(false);
	}
	
	public void ch2On() {
		CheckBox cb1 = (CheckBox)root.lookup("#ch1");
		cb1.setSelected(false);
	}
}
