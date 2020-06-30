package service;

import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;

public class MenuServiceImpl implements MenuService {

	@Override
	public void AddChoiceBox(Parent form) {
		// TODO Auto-generated method stub
		String[] item1 = {"1개","2개","3개","4개","5개"}; 
		 
		//세트 , 버거 , 음료 , 사이드  <--초이스 박스
		ChoiceBox<String> chSet1 = (ChoiceBox<String>) form.lookup("#chSet1");
		ChoiceBox<String> chSet2 = (ChoiceBox<String>) form.lookup("#chSet2");
		ChoiceBox<String> chSet3 = (ChoiceBox<String>) form.lookup("#chSet3");
		ChoiceBox<String> chSet4 = (ChoiceBox<String>) form.lookup("#chSet4");
		ChoiceBox<String> chSet5 = (ChoiceBox<String>) form.lookup("#chSet5");
		ChoiceBox<String> chSet6 = (ChoiceBox<String>) form.lookup("#chSet6");
		
		ChoiceBox<String> chBuger1 = (ChoiceBox<String>) form.lookup("#chBuger1");
		ChoiceBox<String> chBuger2 = (ChoiceBox<String>) form.lookup("#chBuger2");
		ChoiceBox<String> chBuger3 = (ChoiceBox<String>) form.lookup("#chBuger3");
		ChoiceBox<String> chBuger4 = (ChoiceBox<String>) form.lookup("#chBuger4");
		ChoiceBox<String> chBuger5 = (ChoiceBox<String>) form.lookup("#chBuger5");
		ChoiceBox<String> chBuger6 = (ChoiceBox<String>) form.lookup("#chBuger6");
		ChoiceBox<String> chBuger7 = (ChoiceBox<String>) form.lookup("#chBuger7");
		ChoiceBox<String> chBuger8 = (ChoiceBox<String>) form.lookup("#chBuger8");
		
		ChoiceBox<String> chDrink1 = (ChoiceBox<String>) form.lookup("#chDrink1");
		ChoiceBox<String> chDrink2 = (ChoiceBox<String>) form.lookup("#chDrink2");
		ChoiceBox<String> chDrink3 = (ChoiceBox<String>) form.lookup("#chDrink3");
		ChoiceBox<String> chDrink4 = (ChoiceBox<String>) form.lookup("#chDrink4");
		ChoiceBox<String> chDrink5 = (ChoiceBox<String>) form.lookup("#chDrink5");
		ChoiceBox<String> chDrink6 = (ChoiceBox<String>) form.lookup("#chDrink6");
		ChoiceBox<String> chDrink7 = (ChoiceBox<String>) form.lookup("#chDrink7");
		ChoiceBox<String> chDrink8 = (ChoiceBox<String>) form.lookup("#chDrink8");
		
		
		ChoiceBox<String> chSide1 = (ChoiceBox<String>) form.lookup("#chSide1");
		ChoiceBox<String> chSide2 = (ChoiceBox<String>) form.lookup("#chSide2");
		ChoiceBox<String> chSide3 = (ChoiceBox<String>) form.lookup("#chSide3");
		ChoiceBox<String> chSide4 = (ChoiceBox<String>) form.lookup("#chSide4");
		ChoiceBox<String> chSide5 = (ChoiceBox<String>) form.lookup("#chSide5");
		ChoiceBox<String> chSide6 = (ChoiceBox<String>) form.lookup("#chSide6");
		ChoiceBox<String> chSide7 = (ChoiceBox<String>) form.lookup("#chSide7");
		ChoiceBox<String> chSide8 = (ChoiceBox<String>) form.lookup("#chSide8");
		ChoiceBox<String> chSide9 = (ChoiceBox<String>) form.lookup("#chSide9");
		
		
		chSet1.getItems().addAll(item1);
		chSet2.getItems().addAll(item1);
		chSet3.getItems().addAll(item1);
		chSet4.getItems().addAll(item1);
		chSet5.getItems().addAll(item1);
		chSet6.getItems().addAll(item1);
		
		chBuger1.getItems().addAll(item1);
		chBuger2.getItems().addAll(item1);
		chBuger3.getItems().addAll(item1);
		chBuger4.getItems().addAll(item1);
		chBuger5.getItems().addAll(item1);
		chBuger6.getItems().addAll(item1);
		chBuger7.getItems().addAll(item1);
		chBuger8.getItems().addAll(item1);
		
		chDrink1.getItems().addAll(item1);
		chDrink2.getItems().addAll(item1);
		chDrink3.getItems().addAll(item1);
		chDrink4.getItems().addAll(item1);
		chDrink5.getItems().addAll(item1);
		chDrink6.getItems().addAll(item1);
		chDrink7.getItems().addAll(item1);
		chDrink8.getItems().addAll(item1);
		
		
		chSide1.getItems().addAll(item1);
		chSide2.getItems().addAll(item1);
		chSide3.getItems().addAll(item1);
		chSide4.getItems().addAll(item1);
		chSide5.getItems().addAll(item1);
		chSide6.getItems().addAll(item1);
		chSide7.getItems().addAll(item1);
		chSide8.getItems().addAll(item1);
		chSide9.getItems().addAll(item1);
		
		
	}

}
