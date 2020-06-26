package service;

import java.util.Map;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public interface CommonService {
	public void WindowClose(ActionEvent event);
	public Parent showWindow(Stage s,String formPath);
	public Parent showWindow(Stage s,String formPath, Object obj); //유저 데이터까지 전달 
	public void ErrorMsg(String title, String headerStr, String ContentTxt);
	public void ErrorMsg(String headerStr, String ContentTxt);
	public void ErrorMsg(String ContentTxt);
	
	public Map<String, TextField> getTextFieldInfo(Parent root, String[] txtFldArr);
	public boolean isEmpty(Map<String, TextField> txtFldMap, String[] txtFldArr, String[] list);
}


