package ba.unsa.etf.rpr.tutorijal8;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    public TextField searchField;
    public Button searchBtn;
    public ListView list;

    private SimpleStringProperty text;
    public Controller() {
        text = new SimpleStringProperty("");
    }

    @FXML
    public void initialize() {
        searchField.textProperty().bindBidirectional(text);
    }

    public void clickOnSearchBtn(ActionEvent actionEvent) {
    }
}
