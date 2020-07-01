package service;

import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;

public class PayServiceImpl implements PayService{

	@Override
	public void PayChoiceBox(Parent form) {
		// TODO Auto-generated method stub
		 String[] item1 = {"현금","신용카드"};
		 
		 ChoiceBox<String> money = (ChoiceBox<String>)form.lookup("#payselect");
		 
		 money.getItems().addAll(item1);
	}

}
