package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import service.CommonService;
import service.CommonServiceImpl;

public class MenuController extends Controller implements Initializable {
	Parent root;
	CommonService comSrv;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comSrv = new CommonServiceImpl();
	}

	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	public void cancelProc(ActionEvent event) {
		comSrv.WindowClose(event);
	}

}
