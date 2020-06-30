package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import service.SingletonData;

public class PayController extends Controller implements Initializable {
	Parent root;
	boolean flag;
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		flag=true;
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
	
	public void onCancel() { //취소 버튼
		
	}
}
