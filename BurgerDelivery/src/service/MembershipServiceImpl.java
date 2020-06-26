package service;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class MembershipServiceImpl implements MembershipService {

	@Override
	public boolean comparePW(String pw, String pwOk) {
		// TODO Auto-generated method stub
		return pw.contentEquals(pwOk);
	}

	@Override
	public Parent openFindAddress() {
		// TODO Auto-generated method stub
		CommonService comSrv = new CommonServiceImpl();
		Stage findAddress = new Stage();
		Parent form = comSrv.showWindow(findAddress, "../view/Address.fxml");
		
		return form;
	}
	
}
