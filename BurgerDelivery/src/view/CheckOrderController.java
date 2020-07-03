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
	
	public void orderCancelProc(ActionEvent event) {
		SingletonData sd = SingletonData.getInstance();
		sd.setOrdered(false);
		comSrv.ErrorMsg("주문 취소", "주문 취소", "주문 취소가 완료됬습니다.");
		comSrv.WindowClose(event);
	}
}
