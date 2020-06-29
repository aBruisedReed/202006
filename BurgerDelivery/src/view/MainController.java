package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import service.CommonService;
import service.CommonServiceImpl;
import service.LoginService;
import service.LoginServiceImpl;

// 메인 페이지 메소드
public class MainController extends Controller implements Initializable {
	private Parent root;
	private LoginService loginSrv;
	private CommonService comSrv;
	private boolean flag;
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		loginSrv = new LoginServiceImpl();
		comSrv = new CommonServiceImpl();
		flag=true;
	}
	
	public void paneProc() {
		if(flag) {
			animMain();
			flag=false;
		}
	}
	
	public void animMain() {
		ImageView imageView1 = (ImageView) root.lookup("#imageView1");
		
		TranslateTransition tt = new TranslateTransition();
		tt.setNode(imageView1);
		tt.setDuration(new Duration(20000));
		
		tt.setFromX(0); 
		tt.setToX(-640);
		tt.setAutoReverse(true);
		tt.setCycleCount(50);
		tt.play();
	}
	
	public void loginStart() {
		Parent form = loginSrv.OpenLoginForm();
	}
	
	public void joinStart() {
		Parent form = loginSrv.OpenJoinForm();
	}

}
