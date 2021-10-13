package ku.cs.controllers.purchaser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ErrorMessageController {
    @FXML
    Button okBtn;
    @FXML
    public void handleOkBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/register.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

}
