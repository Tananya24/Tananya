package ku.cs.controllers.purchaser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WhatAreYouController {
    @FXML
    Button LogoutBtn;

    @FXML
    public void handleLogoutBtn(ActionEvent actionEvent) throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/loginMain.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleConsumerBtn(ActionEvent actionEvent) throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/marketPlace.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleSellerBtn(ActionEvent actionEvent) throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/theShop.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }
}
