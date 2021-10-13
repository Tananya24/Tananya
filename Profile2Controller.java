package ku.cs.controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Profile2Controller {
    @FXML Button nextBtn;
    @FXML
    public void handleNextBtnOnAction(ActionEvent actionEvent)throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/advice.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }
}
