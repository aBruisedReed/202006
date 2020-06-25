package service;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;

public interface CommonService {
	public void WindowClose(ActionEvent event);
	public Parent showWindow(Stage s,String formPath); 
	public void ErrorMsg(String title, String headerStr, String ContentTxt);
	public void ErrorMsg(String headerStr, String ContentTxt);
	public void ErrorMsg(String ContentTxt);
}


