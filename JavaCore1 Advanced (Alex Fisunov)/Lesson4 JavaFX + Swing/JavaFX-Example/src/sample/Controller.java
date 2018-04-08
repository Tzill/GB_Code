package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    TextField mainTextField;

    @FXML
    TextArea textArea;

    @FXML
    HBox testHBox;

    @FXML
    Button btnAddText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 1; i <= 3; i++) {
            Button btn = new Button("Button #" + i);
            testHBox.getChildren().add(btn);
        }
        btnAddText.setEffect(new DropShadow(5, 3, 3, Color.BLACK));
    }

    public void oneOfThreeButtonClick(ActionEvent actionEvent) {
        mainTextField.setText(((Button)actionEvent.getSource()).getText());
        mainTextField.requestFocus();
        mainTextField.selectEnd();
    }

    public void addTextToArea(ActionEvent actionEvent) {
        textArea.appendText("1\n");
    }
}
