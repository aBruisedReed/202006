package view;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.CommonService;
import service.CommonServiceImpl;
import service.Goods;
import service.SingletonData;

public class MenuController extends Controller implements Initializable {
	Parent root;
	CommonService comSrv;
	ArrayList<String> goods;
	int total;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comSrv = new CommonServiceImpl();
		goods = new ArrayList<String>();
	}

	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stubG
		this.root = root;
	}
	
	public void cancelProc(ActionEvent event) {
		comSrv.WindowClose(event);
	}
	
	public void fadeAnim(Button btn) {
		FadeTransition ft = new FadeTransition(new Duration(500), btn);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.play();
		ft.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
				btn.setVisible(false);
		    }
		});
	}
	
	public void minusFunc(Label label) {
		int num = Integer.parseInt(label.getText());
		if(num<=0) {
			return;
		} else {
			label.setText(""+(num-1));
		}
	}
	
	public void plusFunc(Label label) {
		int num = Integer.parseInt(label.getText());
		label.setText(""+(num+1));
	}
	
	public void setSel1() {
		Button btn = (Button)root.lookup("#setSelBtn1");
		fadeAnim(btn);
	}
	public void setMinus1() {
		Label label = (Label)root.lookup("#setNum1");
		minusFunc(label);
	}
	public void setPlus1() {
		Label label = (Label)root.lookup("#setNum1");
		plusFunc(label);
	}
	public void setSel2() {
		Button btn = (Button)root.lookup("#setSelBtn2");
		fadeAnim(btn);
	}
	public void setMinus2() {
		Label label = (Label)root.lookup("#setNum2");
		minusFunc(label);
	}
	public void setPlus2() {
		Label label = (Label)root.lookup("#setNum2");
		plusFunc(label);
	}
	public void setSel3() {
		Button btn = (Button)root.lookup("#setSelBtn3");
		fadeAnim(btn);
	}
	public void setMinus3() {
		Label label = (Label)root.lookup("#setNum3");
		minusFunc(label);
	}
	public void setPlus3() {
		Label label = (Label)root.lookup("#setNum3");
		plusFunc(label);
	}
	public void setSel4() {
		Button btn = (Button)root.lookup("#setSelBtn4");
		fadeAnim(btn);
	}
	public void setMinus4() {
		Label label = (Label)root.lookup("#setNum4");
		minusFunc(label);
	}
	public void setPlus4() {
		Label label = (Label)root.lookup("#setNum4");
		plusFunc(label);
	}
	public void setSel5() {
		Button btn = (Button)root.lookup("#setSelBtn5");
		fadeAnim(btn);
	}
	public void setMinus5() {
		Label label = (Label)root.lookup("#setNum5");
		minusFunc(label);
	}
	public void setPlus5() {
		Label label = (Label)root.lookup("#setNum5");
		plusFunc(label);
	}
	public void setSel6() {
		Button btn = (Button)root.lookup("#setSelBtn6");
		fadeAnim(btn);
	}
	public void setMinus6() {
		Label label = (Label)root.lookup("#setNum6");
		minusFunc(label);
	}
	public void setPlus6() {
		Label label = (Label)root.lookup("#setNum6");
		plusFunc(label);
	}
	
	public void sinSel1() {
		Button btn = (Button)root.lookup("#sinSelBtn1");
		fadeAnim(btn);
	}
	public void sinMinus1() {
		Label label = (Label)root.lookup("#sinNum1");
		minusFunc(label);
	}
	public void sinPlus1() {
		Label label = (Label)root.lookup("#sinNum1");
		plusFunc(label);
	}
	public void sinSel2() {
		Button btn = (Button)root.lookup("#sinSelBtn2");
		fadeAnim(btn);
	}
	public void sinMinus2() {
		Label label = (Label)root.lookup("#sinNum2");
		minusFunc(label);
	}
	public void sinPlus2() {
		Label label = (Label)root.lookup("#sinNum2");
		plusFunc(label);
	}
	public void sinSel3() {
		Button btn = (Button)root.lookup("#sinSelBtn3");
		fadeAnim(btn);
	}
	public void sinMinus3() {
		Label label = (Label)root.lookup("#sinNum3");
		minusFunc(label);
	}
	public void sinPlus3() {
		Label label = (Label)root.lookup("#sinNum3");
		plusFunc(label);
	}
	public void sinSel4() {
		Button btn = (Button)root.lookup("#sinSelBtn4");
		fadeAnim(btn);
	}
	public void sinMinus4() {
		Label label = (Label)root.lookup("#sinNum4");
		minusFunc(label);
	}
	public void sinPlus4() {
		Label label = (Label)root.lookup("#sinNum4");
		plusFunc(label);
	}
	public void sinSel5() {
		Button btn = (Button)root.lookup("#sinSelBtn5");
		fadeAnim(btn);
	}
	public void sinMinus5() {
		Label label = (Label)root.lookup("#sinNum5");
		minusFunc(label);
	}
	public void sinPlus5() {
		Label label = (Label)root.lookup("#sinNum5");
		plusFunc(label);
	}
	public void sinSel6() {
		Button btn = (Button)root.lookup("#sinSelBtn6");
		fadeAnim(btn);
	}
	public void sinMinus6() {
		Label label = (Label)root.lookup("#sinNum6");
		minusFunc(label);
	}
	public void sinPlus6() {
		Label label = (Label)root.lookup("#sinNum6");
		plusFunc(label);
	}
	public void sinSel7() {
		Button btn = (Button)root.lookup("#sinSelBtn7");
		fadeAnim(btn);
	}
	public void sinMinus7() {
		Label label = (Label)root.lookup("#sinNum7");
		minusFunc(label);
	}
	public void sinPlus7() {
		Label label = (Label)root.lookup("#sinNum7");
		plusFunc(label);
	}
	public void sinSel8() {
		Button btn = (Button)root.lookup("#sinSelBtn8");
		fadeAnim(btn);
	}
	public void sinMinus8() {
		Label label = (Label)root.lookup("#sinNum8");
		minusFunc(label);
	}
	public void sinPlus8() {
		Label label = (Label)root.lookup("#sinNum8");
		plusFunc(label);
	}
	
	public void bevSel1() {
		Button btn = (Button)root.lookup("#bevSelBtn1");
		fadeAnim(btn);
	}
	public void bevMinus1() {
		Label label = (Label)root.lookup("#bevNum1");
		minusFunc(label);
	}
	public void bevPlus1() {
		Label label = (Label)root.lookup("#bevNum1");
		plusFunc(label);
	}
	public void bevSel2() {
		Button btn = (Button)root.lookup("#bevSelBtn2");
		fadeAnim(btn);
	}
	public void bevMinus2() {
		Label label = (Label)root.lookup("#bevNum2");
		minusFunc(label);
	}
	public void bevPlus2() {
		Label label = (Label)root.lookup("#bevNum2");
		plusFunc(label);
	}
	public void bevSel3() {
		Button btn = (Button)root.lookup("#bevSelBtn3");
		fadeAnim(btn);
	}
	public void bevMinus3() {
		Label label = (Label)root.lookup("#bevNum3");
		minusFunc(label);
	}
	public void bevPlus3() {
		Label label = (Label)root.lookup("#bevNum3");
		plusFunc(label);
	}
	public void bevSel4() {
		Button btn = (Button)root.lookup("#bevSelBtn4");
		fadeAnim(btn);
	}
	public void bevMinus4() {
		Label label = (Label)root.lookup("#bevNum4");
		minusFunc(label);
	}
	public void bevPlus4() {
		Label label = (Label)root.lookup("#bevNum4");
		plusFunc(label);
	}
	public void bevSel5() {
		Button btn = (Button)root.lookup("#bevSelBtn5");
		fadeAnim(btn);
	}
	public void bevMinus5() {
		Label label = (Label)root.lookup("#bevNum5");
		minusFunc(label);
	}
	public void bevPlus5() {
		Label label = (Label)root.lookup("#bevNum5");
		plusFunc(label);
	}
	public void bevSel6() {
		Button btn = (Button)root.lookup("#bevSelBtn6");
		fadeAnim(btn);
	}
	public void bevMinus6() {
		Label label = (Label)root.lookup("#bevNum6");
		minusFunc(label);
	}
	public void bevPlus6() {
		Label label = (Label)root.lookup("#bevNum6");
		plusFunc(label);
	}
	public void bevSel7() {
		Button btn = (Button)root.lookup("#bevSelBtn7");
		fadeAnim(btn);
	}
	public void bevMinus7() {
		Label label = (Label)root.lookup("#bevNum7");
		minusFunc(label);
	}
	public void bevPlus7() {
		Label label = (Label)root.lookup("#bevNum7");
		plusFunc(label);
	}
	public void bevSel8() {
		Button btn = (Button)root.lookup("#bevSelBtn8");
		fadeAnim(btn);
	}
	public void bevMinus8() {
		Label label = (Label)root.lookup("#bevNum8");
		minusFunc(label);
	}
	public void bevPlus8() {
		Label label = (Label)root.lookup("#bevNum8");
		plusFunc(label);
	}
	
	public void sidSel1() {
		Button btn = (Button)root.lookup("#sidSelBtn1");
		fadeAnim(btn);
	}
	public void sidMinus1() {
		Label label = (Label)root.lookup("#sidNum1");
		minusFunc(label);
	}
	public void sidPlus1() {
		Label label = (Label)root.lookup("#sidNum1");
		plusFunc(label);
	}
	public void sidSel2() {
		Button btn = (Button)root.lookup("#sidSelBtn2");
		fadeAnim(btn);
	}
	public void sidMinus2() {
		Label label = (Label)root.lookup("#sidNum2");
		minusFunc(label);
	}
	public void sidPlus2() {
		Label label = (Label)root.lookup("#sidNum2");
		plusFunc(label);
	}
	public void sidSel3() {
		Button btn = (Button)root.lookup("#sidSelBtn3");
		fadeAnim(btn);
	}
	public void sidMinus3() {
		Label label = (Label)root.lookup("#sidNum3");
		minusFunc(label);
	}
	public void sidPlus3() {
		Label label = (Label)root.lookup("#sidNum3");
		plusFunc(label);
	}
	public void sidSel4() {
		Button btn = (Button)root.lookup("#sidSelBtn4");
		fadeAnim(btn);
	}
	public void sidMinus4() {
		Label label = (Label)root.lookup("#sidNum4");
		minusFunc(label);
	}
	public void sidPlus4() {
		Label label = (Label)root.lookup("#sidNum4");
		plusFunc(label);
	}
	public void sidSel5() {
		Button btn = (Button)root.lookup("#sidSelBtn5");
		fadeAnim(btn);
	}
	public void sidMinus5() {
		Label label = (Label)root.lookup("#sidNum5");
		minusFunc(label);
	}
	public void sidPlus5() {
		Label label = (Label)root.lookup("#sidNum5");
		plusFunc(label);
	}
	public void sidSel6() {
		Button btn = (Button)root.lookup("#sidSelBtn6");
		fadeAnim(btn);
	}
	public void sidMinus6() {
		Label label = (Label)root.lookup("#sidNum6");
		minusFunc(label);
	}
	public void sidPlus6() {
		Label label = (Label)root.lookup("#sidNum6");
		plusFunc(label);
	}
	public void sidSel7() {
		Button btn = (Button)root.lookup("#sidSelBtn7");
		fadeAnim(btn);
	}
	public void sidMinus7() {
		Label label = (Label)root.lookup("#sidNum7");
		minusFunc(label);
	}
	public void sidPlus7() {
		Label label = (Label)root.lookup("#sidNum7");
		plusFunc(label);
	}
	public void sidSel8() {
		Button btn = (Button)root.lookup("#sidSelBtn8");
		fadeAnim(btn);
	}
	public void sidMinus8() {
		Label label = (Label)root.lookup("#sidNum8");
		minusFunc(label);
	}
	public void sidPlus8() {
		Label label = (Label)root.lookup("#sidNum8");
		plusFunc(label);
	}
	public void sidSel9() {
		Button btn = (Button)root.lookup("#sidSelBtn9");
		fadeAnim(btn);
	}
	public void sidMinus9() {
		Label label = (Label)root.lookup("#sidNum9");
		minusFunc(label);
	}
	public void sidPlus9() {
		Label label = (Label)root.lookup("#sidNum9");
		plusFunc(label);
	}
	
	public void selectProc() {
		SingletonData sd = SingletonData.getInstance();
		sd.setWindow(root);
		goods.clear();
		Label setLabel1 = (Label)root.lookup("#setNum1");
		Label setLabel2 = (Label)root.lookup("#setNum2");
		Label setLabel3 = (Label)root.lookup("#setNum3");
		Label setLabel4 = (Label)root.lookup("#setNum4");
		Label setLabel5 = (Label)root.lookup("#setNum5");
		Label setLabel6 = (Label)root.lookup("#setNum6");
		Label sinLabel1 = (Label)root.lookup("#sinNum1");
		Label sinLabel2 = (Label)root.lookup("#sinNum2");
		Label sinLabel3 = (Label)root.lookup("#sinNum3");
		Label sinLabel4 = (Label)root.lookup("#sinNum4");
		Label sinLabel5 = (Label)root.lookup("#sinNum5");
		Label sinLabel6 = (Label)root.lookup("#sinNum6");
		Label sinLabel7 = (Label)root.lookup("#sinNum7");
		Label sinLabel8 = (Label)root.lookup("#sinNum8");
		Label bevLabel1 = (Label)root.lookup("#bevNum1");
		Label bevLabel2 = (Label)root.lookup("#bevNum2");
		Label bevLabel3 = (Label)root.lookup("#bevNum3");
		Label bevLabel4 = (Label)root.lookup("#bevNum4");
		Label bevLabel5 = (Label)root.lookup("#bevNum5");
		Label bevLabel6 = (Label)root.lookup("#bevNum6");
		Label bevLabel7 = (Label)root.lookup("#bevNum7");
		Label bevLabel8 = (Label)root.lookup("#bevNum8");
		Label sidLabel1 = (Label)root.lookup("#sidNum1");
		Label sidLabel2 = (Label)root.lookup("#sidNum2");
		Label sidLabel3 = (Label)root.lookup("#sidNum3");
		Label sidLabel4 = (Label)root.lookup("#sidNum4");
		Label sidLabel5 = (Label)root.lookup("#sidNum5");
		Label sidLabel6 = (Label)root.lookup("#sidNum6");
		Label sidLabel7 = (Label)root.lookup("#sidNum7");
		Label sidLabel8 = (Label)root.lookup("#sidNum8");
		Label sidLabel9 = (Label)root.lookup("#sidNum9");
		
		if(!setLabel1.getText().equals("0")) {
			goods.add("맥딜리버리 치킨 스낵팩,11000,"+setLabel1.getText());
		}
		if(!setLabel2.getText().equals("0")) {
			goods.add("트리플 치즈버거 세트,7900,"+setLabel2.getText());
		}
		if(!setLabel3.getText().equals("0")) {
			goods.add("맥딜리버리 상하이 버거 싱글팩,11000,"+setLabel3.getText());
		}
		if(!setLabel4.getText().equals("0")) {
			goods.add("맥치킨ⓡ 모짜렐라,6900,"+setLabel4.getText());
		}
		if(!setLabel5.getText().equals("0")) {
			goods.add("맥치킨ⓡ 모짜렐라,6900,"+setLabel5.getText());
		}
		if(!setLabel5.getText().equals("0")) {
			goods.add("맥치킨ⓡ 모짜렐라,6900,"+setLabel5.getText());
		}
		if(!setLabel6.getText().equals("0")) {
			goods.add("맥딜리버리 빅맥ⓡ 싱글팩,11000,"+setLabel6.getText());
		}
		
		if(!sinLabel1.getText().equals("0")) {
			goods.add("트리플 치즈버거,6300,"+sinLabel1.getText());
		}
		if(!sinLabel2.getText().equals("0")) {
			goods.add("맥치킨 모짜렐라,5400,"+sinLabel2.getText());
		}
		if(!sinLabel3.getText().equals("0")) {
			goods.add("맥스파이시 상하이버거,5200,"+sinLabel3.getText());
		}
		if(!sinLabel4.getText().equals("0")) {
			goods.add("베이컨 토마토 디럭스,6000,"+sinLabel4.getText());
		}
		if(!sinLabel5.getText().equals("0")) {
			goods.add("빅맥,5200,"+sinLabel5.getText());
		}
		if(!sinLabel6.getText().equals("0")) {
			goods.add("슈슈버거,5000,"+sinLabel6.getText());
		}
		if(!sinLabel7.getText().equals("0")) {
			goods.add("불고기버거,2700,"+sinLabel7.getText());
		}
		if(!sinLabel8.getText().equals("0")) {
			goods.add("맥 치킨,4000,"+sinLabel8.getText());
		}
		if(!bevLabel1.getText().equals("0")) {
			goods.add("딸기 칠러,3200,"+bevLabel1.getText());
		}
		if(!bevLabel2.getText().equals("0")) {
			goods.add("맥 치킨,4000,"+bevLabel2.getText());
		}
		if(!bevLabel3.getText().equals("0")) {
			goods.add("자두 칠러,3200,"+bevLabel3.getText());
		}
		if(!bevLabel4.getText().equals("0")) {
			goods.add("바닐라 쉐이크,3200,"+bevLabel4.getText());
		}
		if(!bevLabel5.getText().equals("0")) {
			goods.add("아메리카노,2700,"+bevLabel5.getText());
		}
		if(!bevLabel6.getText().equals("0")) {
			goods.add("카페 라떼,3200,"+bevLabel6.getText());
		}
		if(!bevLabel7.getText().equals("0")) {
			goods.add("코카콜라,2000,"+bevLabel7.getText());
		}	
		if(!bevLabel8.getText().equals("0")) {
			goods.add("스프라이트,5400,"+bevLabel8.getText());
		}
		if(!sidLabel1.getText().equals("0")) {
			goods.add("맥윙™ 2조각,3400,"+sidLabel1.getText());
		}
		if(!sidLabel2.getText().equals("0")) {
			goods.add("스트링치즈,2300,"+sidLabel2.getText());
		}
		if(!sidLabel3.getText().equals("0")) {
			goods.add("골든 모짜렐라 치즈스틱 4조각,4600,"+sidLabel3.getText());
		}
		if(!sidLabel4.getText().equals("0")) {
			goods.add("상하이 치킨 스낵랩,2700,"+sidLabel4.getText());
		}
		if(!sidLabel5.getText().equals("0")) {
			goods.add("후렌치 후라이,2300,"+sidLabel5.getText());
		}
		if(!sidLabel6.getText().equals("0")) {
			goods.add("애플파이,1700,"+sidLabel6.getText());
		}
		if(!sidLabel7.getText().equals("0")) {
			goods.add("오레오 맥플러리,3200,"+sidLabel7.getText());
		}
		if(!sidLabel8.getText().equals("0")) {
			goods.add("카라멜 선데이 아이스크림,2200,"+sidLabel8.getText());
		}
		if(!sidLabel9.getText().equals("0")) {
			goods.add("바닐라 선데이 아이스크림,2200,"+sidLabel9.getText());
		}
		
		if(goods.isEmpty()) { //선택 안되면 오더리스트가 아예 안뜨게해서 OrderEmpty가 굳이 필요 없을 듯
			comSrv.ErrorMsg("선택된 상품이 없습니다.", "선택된 상품이 없습니다.", "선택된 상품이 없습니다.");
			return;
		}
		
		System.out.println(goods.size());
		
		Stage orderList = new Stage();
		Parent form = comSrv.showWindow(orderList, "../view/OrderList.fxml", goods);
		
		total = 0;
		
		goods = (ArrayList<String>)form.getUserData();
		
		TableView<Goods> tv = (TableView<Goods>) form.lookup("#orderTable");

		TableColumn nameColumn = new TableColumn("상품명");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn priceColumn = new TableColumn("가격");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		TableColumn amountColumn = new TableColumn("수량");
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		nameColumn.setPrefWidth(340);
		tv.getColumns().addAll(nameColumn, priceColumn, amountColumn);
		
		DecimalFormat formatter = new DecimalFormat("###,###");
		for(String good : goods) {
			String[] goodDetail = good.split(",");
			Goods goods = new Goods();
			goods.setName(goodDetail[0]);
			goods.setPrice(formatter.format(Integer.parseInt(goodDetail[1])));
			goods.setAmount(Integer.parseInt(goodDetail[2]));
			total += Integer.parseInt(goodDetail[1])*goods.getAmount();
			tv.getItems().add(goods);
		}
		Label totalLabel = (Label) form.lookup("#total");
		totalLabel.setText("합계 금액 : "+formatter.format(total)+" 원");
		sd.setTotalPrice(formatter.format(total)+" 원");
		sd.setGoods(goods);
	}
}
