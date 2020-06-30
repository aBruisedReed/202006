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
		loginSrv.OrderStart();
	}

	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	public void orderCheck() {
		Stage orderCheck = new Stage();
		comSrv.showWindow(orderCheck, "../view/CheckOrder.fxml");
	}
}
