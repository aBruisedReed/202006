package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import service.CommonService;
import service.CommonServiceImpl;
import service.SingletonData;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		// TODO Auto-generated method stub
		CommonService comServ = new CommonServiceImpl();
		comServ.showWindow(primaryStage, "../view/Main.fxml"); // comServ의 경로를 기준으로 상대경로 설정
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
