package ku.cs.controllers.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAdminController {

    @FXML
    public void handleUserListPageBtn(ActionEvent actionEvent) throws IOException {
        Button register = (Button) actionEvent.getSource();
        Stage stage = (Stage) register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/userListPage.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleReportPageBtn(ActionEvent actionEvent) throws IOException {
        Button register = (Button) actionEvent.getSource();
        Stage stage = (Stage) register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/ReportPage.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleCatagoryPageBtn(ActionEvent actionEvent) throws IOException {
        Button register = (Button) actionEvent.getSource();
        Stage stage = (Stage) register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/CatagoryPage.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

}
