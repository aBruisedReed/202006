package view;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.CommonService;
import service.CommonServiceImpl;
import service.Goods;
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
		Parent form = comSrv.showWindow(orderCheck, "../view/ShowOrder.fxml");
		
		SingletonData sd = SingletonData.getInstance();
		
		Label paidPrice = (Label) form.lookup("#paidPrice");
		Label paidHow = (Label) form.lookup("#paidHow");
		
		paidPrice.setText("합계금액 : "+sd.getTotalPrice());
		paidHow.setText("결제수단 : "+sd.getPaidHow());
		
		ArrayList<String> goodsList = (ArrayList<String>) sd.getGoods();
		
		TableView<Goods> tv = (TableView<Goods>) form.lookup("#orderTableView");

		TableColumn nameColumn = new TableColumn("상품명");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn priceColumn = new TableColumn("가격");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		TableColumn amountColumn = new TableColumn("수량");
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		nameColumn.setPrefWidth(340);
		tv.getColumns().addAll(nameColumn, priceColumn, amountColumn);
		
		DecimalFormat formatter = new DecimalFormat("###,###");
		for(String good : goodsList) {
			String[] goodDetail = good.split(",");
			Goods goods = new Goods();
			goods.setName(goodDetail[0]);
			goods.setPrice(formatter.format(Integer.parseInt(goodDetail[1])));
			goods.setAmount(Integer.parseInt(goodDetail[2]));
			tv.getItems().add(goods);
		}
	}
}
