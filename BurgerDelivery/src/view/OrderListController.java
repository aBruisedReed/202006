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
import service.CommonServiceImpl;
import service.Goods;
import service.PayService;
import service.PayServiceImpl;
import service.SingletonData;

public class OrderListController extends Controller implements Initializable {
	Parent root;
	ArrayList<String> goods;
	boolean flag;
	int total;
	CommonServiceImpl comSrv;
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		flag = true;
		comSrv = new CommonServiceImpl();
	}
	
	public void orderOn() {
		total = 0;
		if(flag==false) {
			return;
		}
		
		goods = (ArrayList<String>)root.getUserData();
		
		SingletonData sd = SingletonData.getInstance();
		
		
		TableView<Goods> tv = (TableView<Goods>) root.lookup("#orderTable");

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
		Label totalLabel = (Label) root.lookup("#total");
		totalLabel.setText("합계 금액 : "+formatter.format(total)+" 원");
		sd.setTotalPrice(formatter.format(total)+" 원");
		sd.setGoods(goods);
		
		flag = false;
	}
	
	public void payBtnProc(ActionEvent event) {
		PayService pSvr = new PayServiceImpl();
		comSrv.WindowClose(event);
		Stage pay = new Stage();
		Parent form = comSrv.showWindow(pay, "../view/Pay.fxml"); 
		pSvr.PayChoiceBox(form);
		return;
	}
}
