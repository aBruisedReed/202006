package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import service.CommonService;
import service.CommonServiceImpl;

public class MenuController extends Controller implements Initializable {
	Parent root;
	CommonService comSrv;
	ArrayList<String> goods;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comSrv = new CommonServiceImpl();
		goods = new ArrayList<String>();
	}

	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	public void cancelProc(ActionEvent event) {
		comSrv.WindowClose(event);
	}
	
	public void selectProc() {
		goods.clear(); //비우기
		
		ChoiceBox<String> set1 = (ChoiceBox<String>)root.lookup("#chSet1");
		ChoiceBox<String> set2 = (ChoiceBox<String>)root.lookup("#chSet2");
		ChoiceBox<String> set3 = (ChoiceBox<String>)root.lookup("#chSet3");
		ChoiceBox<String> set4 = (ChoiceBox<String>)root.lookup("#chSet4");
		ChoiceBox<String> set5 = (ChoiceBox<String>)root.lookup("#chSet5");
		ChoiceBox<String> set6 = (ChoiceBox<String>)root.lookup("#chSet6");
		//나머지 메뉴까지 추가해야함
		if(set1.getValue() != null) {
			goods.add("맥딜리버리 치킨 스낵팩,11000,"+set1.getValue().substring(0, 1));
		}
		if(set2.getValue() != null) {
			goods.add("트리플 치즈버거 세트,7900,"+set2.getValue().substring(0, 1));
		}
		if(set3.getValue() != null) {
			goods.add("맥딜리버리 상하이 버거 싱글팩,11000,"+set3.getValue().substring(0, 1));
		}
		if(set4.getValue() != null) {
			goods.add("맥치킨ⓡ 모짜렐라,6900,"+set4.getValue().substring(0, 1));
		}
		if(set5.getValue() != null) {
			goods.add("1955 버거™,8000,"+set5.getValue().substring(0, 1));
		}
		if(set6.getValue() != null) {
			goods.add("맥딜리버리 빅맥ⓡ 싱글팩,11000,"+set2.getValue().substring(0, 1));
		}
		
		if(goods.isEmpty()) { //선택 안되면 오더리스트가 아예 안뜨게해서 OrderEmpty가 굳이 필요 없을 듯
			comSrv.ErrorMsg("선택된 상품이 없습니다.", "선택된 상품이 없습니다.", "선택된 상품이 없습니다.");
			return;
		}
		
		Stage orderList = new Stage();
		comSrv.showWindow(orderList, "../view/OrderList.fxml", goods);
		
// 		이벤트 처리 제대로하려면 이벤트 핸들러를 붙이거나 미리 데이터 넣고 show로 띄워야함
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderList.fxml"));
//		Parent root = null;
//		try {
//			root = loader.load();
//			orderList.setScene(new Scene(root));
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
////		root.setUserData(goods);
//		TableView<String> tableView = (TableView<String>)root.lookup("#orderTable"); //String?
//		Controller ctrler = loader.getController();
//		ctrler.setRoot(root);
//		orderList.show();
	}
}
