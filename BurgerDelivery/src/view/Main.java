package view;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.CommonService;
import service.CommonServiceImpl;
import service.SingletonData;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		// TODO Auto-generated method stub
		CommonService comServ = new CommonServiceImpl();
		Parent form = comServ.showWindow(primaryStage, "../view/Main.fxml"); // comServ의 경로를 기준으로 상대경로 설정;
		
		ImageView imageView1 = (ImageView) form.lookup("#imageView1");
		
		TranslateTransition tt = new TranslateTransition();
		tt.setNode(imageView1);
		tt.setDuration(new Duration(20000));
		
		tt.setFromX(0); 
		tt.setToX(-640);
		tt.setAutoReverse(true);
		tt.setCycleCount(50);
		tt.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
