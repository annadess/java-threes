package annadess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NameViewControler {

	public String name;
	
    @FXML
    private TextField nameField;

    @FXML
    void setNewName(ActionEvent event) {
    	name = nameField.getText();
    }

    public String getName(){
    	return this.name;
    }
}
