package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import service.AddressData;
import service.CommonService;
import service.FindAddress;
//import service.CommonServiceImpl;

public class AddressController extends Controller implements Initializable {
	private Parent root;
	private CommonService comSrv;
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-comSrv = new CommonServiceImpl();
	}
	
	public void findButtonOnClick() {
		String s = ((TextField) root.lookup("#findTextField")).getText();
		ArrayList<AddressData> aDataList = FindAddress.find(s, 1); // find 두번째 인자로 50개 이상일 경우 페이지 구현해야함
		
		ListView<String> listView = (ListView<String>) root.lookup("#listView");
		listView.getItems().clear();
		for(AddressData aData : aDataList) {
			listView.getItems().add(aData.getZipNo()+" "+aData.getLnmAdres()+"("+aData.getRnAdres()+")");
		}
		
//		System.out.println(addressList.get(0).toString());
	}
}
