package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Goods;

public class OrderListController extends Controller implements Initializable {
	Parent root;
	ArrayList<String> goods;
	boolean flag;
	
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		flag = true;
	}
	
	public void orderOn() {
		if(flag==false) {
			return;
		}
		
		goods = (ArrayList<String>)root.getUserData();
		TableView<Goods> tv = (TableView<Goods>) root.lookup("#orderTable");

		TableColumn nameColumn = new TableColumn("상품명");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn priceColumn = new TableColumn("가격");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		TableColumn amountColumn = new TableColumn("수량");
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		
		nameColumn.setPrefWidth(340);
		tv.getColumns().addAll(nameColumn, priceColumn, amountColumn);
		
		
		for(String good : goods) {
			String[] goodDetail = good.split(",");
			Goods goods = new Goods();
			goods.setName(goodDetail[0]);
			goods.setPrice(goodDetail[1]);
			goods.setAmount(Integer.parseInt(goodDetail[2]));
			tv.getItems().add(goods);
		}
		
		flag = false;
	}
}
