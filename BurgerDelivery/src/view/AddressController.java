package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import service.AddressData;
import service.CommonService;
import service.CommonServiceImpl;
import service.FindAddress;
import service.StringContainer;
//import service.CommonServiceImpl;

public class AddressController extends Controller implements Initializable {
	private Parent root;
	private CommonService comSrv;
	private StringContainer string;
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-
		comSrv = new CommonServiceImpl();
	}
	
	public void findButtonOnClick() {
		if(((TextField)root.lookup("#findTextField")).getText().isEmpty()) {
			comSrv.ErrorMsg("Error", "주소를 입력하세요.");
			((TextField)root.lookup("#findTextField")).requestFocus();
		}
		else {
		string = (StringContainer) root.getUserData();
		String s = ((TextField) root.lookup("#findTextField")).getText();
		ArrayList<AddressData> aDataList = FindAddress.find(s, 1); // find 두번째 인자로 50개 이상일 경우 페이지 구현해야함
		ListView<String> listView = (ListView<String>) root.lookup("#listView");
		listView.getItems().clear();
		
		if(aDataList.isEmpty()) {
			listView.getItems().add("검색 결과가 없습니다.");
			string.setData(null);
			return;
		}
		
		listView.getItems().clear();
		for(AddressData aData : aDataList) {
			listView.getItems().add(aData.getZipNo()+" "+aData.getLnmAdres()+"("+aData.getRnAdres()+")");
		}
		
		listView.setOnMouseClicked((MouseEvent) -> { // 리스트뷰 항목 선택 이벤트
			Object obj = listView.getSelectionModel().getSelectedItem();
			if(obj.toString()!="검색 결과가 없습니다.") {
				string.setData(obj.toString());
				System.out.println("selected:"+string.getData());
			} else {
				string.setData(null);
			}
		});
		}
	}
	
	public void okProc(ActionEvent event) {
		if(string.getData() == null) {
			comSrv.ErrorMsg("주소를 선택하세요", "주소를 선택하세요.", "선택된 항목이 없습니다.");
		} else {
			comSrv.WindowClose(event);
		}
	}
}
