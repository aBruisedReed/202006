package view;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.CommonService;
import service.CommonServiceImpl;
import service.Goods;
import service.SingletonData;

public class CheckOrderController extends Controller implements Initializable{
	Parent root;
	CommonService comSrv;
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comSrv = new CommonServiceImpl();
	}
	public void cancelProc(ActionEvent event) {
		comSrv.WindowClose(event);
	}
	
	public void onCheckOrder() { //삭제
//		SingletonData sd = SingletonData.getInstance();
//		
//		Label paidPrice = (Label) root.lookup("#paidPrice");
//		Label paidHow = (Label) root.lookup("#paidHow");
//		
//		paidPrice.setText("합계금액 : "+sd.getTotalPrice());
//		paidHow.setText("결제수단 : "+sd.getPaidHow());
//		
//		ArrayList<String> goodsList = (ArrayList<String>) sd.getGoods();
//		
//		TableView<Goods> tv = (TableView<Goods>) root.lookup("#orderTableView");
//
//		TableColumn nameColumn = new TableColumn("상품명");
//		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//		TableColumn priceColumn = new TableColumn("가격");
//		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//		TableColumn amountColumn = new TableColumn("수량");
//		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
//		
//		nameColumn.setPrefWidth(340);
//		tv.getColumns().addAll(nameColumn, priceColumn, amountColumn);
//		
//		DecimalFormat formatter = new DecimalFormat("###,###");
//		for(String good : goodsList) {
//			String[] goodDetail = good.split(",");
//			Goods goods = new Goods();
//			goods.setName(goodDetail[0]);
//			goods.setPrice(formatter.format(Integer.parseInt(goodDetail[1])));
//			goods.setAmount(Integer.parseInt(goodDetail[2]));
//			tv.getItems().add(goods);
//		}
	}
}
