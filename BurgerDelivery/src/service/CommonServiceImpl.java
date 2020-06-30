package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import view.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService {

	@Override
	public void WindowClose(ActionEvent event) {
		// TODO Auto-generated method stub
		Parent root = (Parent)event.getSource();
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

	@Override
	public Parent showWindow(Stage s, String formPath) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		Parent root = null;
		
		try {
			root = loader.load();
			s.setScene(new Scene(root));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		Controller ctrler = loader.getController();
		ctrler.setRoot(root);
		
		s.show();
		
		return root;
	}
	
	public Parent showWindow(Stage s, String formPath, StringContainer string) { //폼 간의 데이터 전달 가능
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		Parent root = null;
		
		try {
			root = loader.load();
			s.setScene(new Scene(root));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		root.setUserData(string);
		Controller ctrler = loader.getController();
		ctrler.setRoot(root);
		
		s.show();
		
		return root;
	}
	
	public Parent showWindow(Stage s, String formPath, ArrayList<String> goods) { //폼 간의 데이터 전달 가능
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		Parent root = null;
		
		try {
			root = loader.load();
			s.setScene(new Scene(root));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		root.setUserData(goods);
		Controller ctrler = loader.getController();
		ctrler.setRoot(root);
		
		s.show();
		
		return root;
	}

	@Override
	public void ErrorMsg(String title, String headerStr, String ContentTxt) {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerStr);
		alert.setContentText(ContentTxt);
		alert.show();
	}

	@Override
	public void ErrorMsg(String headerStr, String ContentTxt) {
		// TODO Auto-generated method stub
		ErrorMsg("error", headerStr, ContentTxt);
	}

	@Override
	public void ErrorMsg(String ContentTxt) {
		// TODO Auto-generated method stub
		ErrorMsg("error", "error header", ContentTxt);
	}

	@Override
	public Map<String, TextField> getTextFieldInfo(Parent root, String[] txtFldArr) {
		// TODO Auto-generated method stub
     Map<String, TextField> txtFldMap = new HashMap<String, TextField>();
		
		for(String txtFldId : txtFldArr) {
			TextField txtFld = (TextField)root.lookup(txtFldId);
			txtFldMap.put(txtFldId, txtFld);
		}
		return txtFldMap;
	}

	@Override
	public boolean isEmpty(Map<String, TextField> txtFldMap, String[] txtFldArr, String[] list) {
		// TODO Auto-generated method stub
		CommonService comSrv = new CommonServiceImpl();
		int cnt = 0;
		for(String txtFldId : txtFldArr) {
			TextField txtFld = txtFldMap.get(txtFldId);
			
			if(txtFld.getText().isEmpty()) {
				txtFld.requestFocus();
				comSrv.ErrorMsg(list[cnt]+"이(가) 비었습니다.");
				return true;
			}
			cnt++;
		}
		return false;
	}

}
