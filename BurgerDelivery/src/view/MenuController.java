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
		ChoiceBox<String> bug1 = (ChoiceBox<String>)root.lookup("#chBuger1");
		ChoiceBox<String> bug2 = (ChoiceBox<String>)root.lookup("#chBuger2");
		ChoiceBox<String> bug3 = (ChoiceBox<String>)root.lookup("#chBuger3");
		ChoiceBox<String> bug4 = (ChoiceBox<String>)root.lookup("#chBuger4");
		ChoiceBox<String> bug5 = (ChoiceBox<String>)root.lookup("#chBuger5");
		ChoiceBox<String> bug6 = (ChoiceBox<String>)root.lookup("#chBuger6");
		ChoiceBox<String> bug7 = (ChoiceBox<String>)root.lookup("#chBuger7");
		ChoiceBox<String> bug8 = (ChoiceBox<String>)root.lookup("#chBuger8");
		ChoiceBox<String> dr1 = (ChoiceBox<String>)root.lookup("#chDrink1");
		ChoiceBox<String> dr2 = (ChoiceBox<String>)root.lookup("#chDrink2");
		ChoiceBox<String> dr3 = (ChoiceBox<String>)root.lookup("#chDrink3");
		ChoiceBox<String> dr4 = (ChoiceBox<String>)root.lookup("#chDrink4");
		ChoiceBox<String> dr5 = (ChoiceBox<String>)root.lookup("#chDrink5");
		ChoiceBox<String> dr6 = (ChoiceBox<String>)root.lookup("#chDrink6");
		ChoiceBox<String> dr7 = (ChoiceBox<String>)root.lookup("#chDrink7");
		ChoiceBox<String> dr8 = (ChoiceBox<String>)root.lookup("#chDrink8");
		ChoiceBox<String> side1 = (ChoiceBox<String>)root.lookup("#chSide1");
		ChoiceBox<String> side2 = (ChoiceBox<String>)root.lookup("#chSide2");
		ChoiceBox<String> side3 = (ChoiceBox<String>)root.lookup("#chSide3");
		ChoiceBox<String> side4 = (ChoiceBox<String>)root.lookup("#chSide4");
		ChoiceBox<String> side5 = (ChoiceBox<String>)root.lookup("#chSide5");
		ChoiceBox<String> side6 = (ChoiceBox<String>)root.lookup("#chSide6");
		ChoiceBox<String> side7 = (ChoiceBox<String>)root.lookup("#chSide7");
		ChoiceBox<String> side8 = (ChoiceBox<String>)root.lookup("#chSide8");
		ChoiceBox<String> side9 = (ChoiceBox<String>)root.lookup("#chSide9");


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
			goods.add("맥딜리버리 빅맥ⓡ 싱글팩,11000,"+set6.getValue().substring(0, 1));
		}
		if(bug1.getValue() != null) {
			goods.add("트리플 치즈버거,6300,"+bug1.getValue().substring(0, 1));
		}
		if(bug2.getValue() != null) {
			goods.add("맥치킨 모짜렐라,5400,"+bug2.getValue().substring(0, 1));
		}
		if(bug3.getValue() != null) {
			goods.add("맥스파이시 상하이버거,5200,"+bug3.getValue().substring(0, 1));
		}
		if(bug4.getValue() != null) {
			goods.add("베이컨 토마토 디럭스,6000,"+bug4.getValue().substring(0, 1));
		}
		if(bug5.getValue() != null) {
			goods.add("빅맥,5200,"+bug5.getValue().substring(0, 1));
		}
		if(bug6.getValue() != null) {
			goods.add("슈슈버거,5000,"+bug6.getValue().substring(0, 1));
		}
		if(bug7.getValue() != null) {
			goods.add("불고기버거,2700,"+bug7.getValue().substring(0, 1));
		}
		if(bug8.getValue() != null) {
			goods.add("맥 치킨,4000,"+bug8.getValue().substring(0, 1));
		}
		if(dr1.getValue() != null) {
			goods.add("딸기 칠러,3200,"+dr1.getValue().substring(0, 1));
		}
		if(dr2.getValue() != null) {
			goods.add("배 칠러,3200,"+dr2.getValue().substring(0, 1));
		}
		if(dr3.getValue() != null) {
			goods.add("자두 칠러,3200,"+dr3.getValue().substring(0, 1));
		}
		if(dr4.getValue() != null) {
			goods.add("바닐라 쉐이크,3200,"+dr4.getValue().substring(0, 1));
		}
		if(dr5.getValue() != null) {
			goods.add("아메리카노,2700,"+dr5.getValue().substring(0, 1));
		}
		if(dr6.getValue() != null) {
			goods.add("카페 라떼,3200,"+dr6.getValue().substring(0, 1));
		}
		if(dr7.getValue() != null) {
			goods.add("코카콜라,2000,"+dr7.getValue().substring(0, 1));
		}
		if(dr8.getValue() != null) {
			goods.add("스프라이트,5400,"+dr8.getValue().substring(0, 1));
		}
		if(side1.getValue() != null) {
			goods.add("맥윙™ 2조각,3400,"+side1.getValue().substring(0, 1));
		}
		if(side2.getValue() != null) {
			goods.add("스트링치즈,2300,"+side2.getValue().substring(0, 1));
		}
		if(side3.getValue() != null) {
			goods.add("골든 모짜렐라 치즈스틱 4조각,4600,"+side3.getValue().substring(0, 1));
		}
		if(side4.getValue() != null) {
			goods.add("상하이 치킨 스낵랩,2700,"+side4.getValue().substring(0, 1));
		}
		if(side5.getValue() != null) {
			goods.add("후렌치 후라이,2300,"+side5.getValue().substring(0, 1));
		}
		if(side6.getValue() != null) {
			goods.add("애플파이,1700,"+side6.getValue().substring(0, 1));
		}
		if(side7.getValue() != null) {
			goods.add("오레오 맥플러리,3200,"+side7.getValue().substring(0, 1));
		}
		if(side8.getValue() != null) {
			goods.add("카라멜 선데이 아이스크림,2200,"+side8.getValue().substring(0, 1));
		}
		if(side9.getValue() != null) {
			goods.add("바닐라 선데이 아이스크림,2200,"+side9.getValue().substring(0, 1));
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
