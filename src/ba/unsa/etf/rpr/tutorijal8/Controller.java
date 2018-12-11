package ba.unsa.etf.rpr.tutorijal8;

import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    public SimpleStringProperty text;
    public SimpleListProperty<String> lista;
    public TextField searchField;
    public Button searchBtn;
    public ListView list;
    public List<String> result;

    public Controller() {
        text = new SimpleStringProperty("");
        lista = new SimpleListProperty<>();
        result = Collections.synchronizedList(new ArrayList<>());
    }

    @FXML
    public void initialize() {
        searchField.textProperty().bindBidirectional(text);
        list.itemsProperty().bindBidirectional(lista);
        lista.set(FXCollections.observableArrayList(result));
    }

    public void dajFajloveKojiSePodudaraju(File f) {
        try {
            File[] files = f.listFiles();
            if (files == null) return;
            for (File file : files) {
                if (file.isDirectory()) {
                    dajFajloveKojiSePodudaraju(file);
                } else {
                    if (file.getCanonicalPath().toLowerCase().contains(searchField.getText().toLowerCase())) {
                        String result = file.getCanonicalPath();
                        Platform.runLater(() -> list.getItems().add(result));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickOnSearchBtn(ActionEvent actionEvent) {
    }
}
