package ku.cs.controllers.seller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TheShopController {
    @FXML
    Button addBtn,setBtn,outBtn;

    public void handleOkBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button addBtn = (Button) actionEvent.getSource();
        Stage stage = (Stage) addBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/detailProduct.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    public void handleOkBtn(ActionEvent actionEvent) throws IOException {
        Button setBtn = (Button) actionEvent.getSource();
        Stage stage = (Stage) setBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/marketPlace.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }
    public void handleLoginBtn(ActionEvent actionEvent) throws IOException {
        Button outBtn = (Button) actionEvent.getSource();
        Stage stage = (Stage) outBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/whatYouAre.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }




}
