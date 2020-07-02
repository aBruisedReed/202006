package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import service.CommonService;
import service.CommonServiceImpl;
import service.LoginService;
import service.LoginServiceImpl;
import service.SingletonData;

public class AfterLoginController extends Controller implements Initializable {
	// 로그인 한 이후 주문하기 / 주문내역 조회 선택창 controller
	
	Parent root;
	private LoginService loginSrv;
	private CommonService comSrv;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		loginSrv = new LoginServiceImpl();
		comSrv = new CommonServiceImpl();
		
	}
	
	public void orderStart(ActionEvent envet) {
		SingletonData sd = SingletonData.getInstance();
		if(sd.getOrdered()) {
			comSrv.ErrorMsg("이미 주문을 완료했습니다." , "이미 주문을 완료했습니다.", "이미 주문을 완료했습니다.");
			return;
		}
		loginSrv.OrderStart();
	}

	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	public void orderCheck() {
		Stage orderCheck = new Stage();
		comSrv.showWindow(orderCheck, "../view/ShowOrder.fxml");
	}
	
	
}
