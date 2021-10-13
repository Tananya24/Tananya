package ku.cs.controllers.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ChangePassAdmin {
    @FXML  Button backToMainBtn;
    @FXML  Button confirmChangePassbtn;
    @FXML  PasswordField oldPassField;
    @FXML  PasswordField newPassField;

    Account account;
    private AccountData accountDataSource;
    public void setAccountData(Account admin) {this.account = admin; }

    Account newAdmin;


    @FXML
    public void initialize() throws IOException {
        account = new Account();
        accountDataSource = new AccountFileData("filecsv", "admin.csv");
        account = accountDataSource.getAccount();
    }

    @FXML
    public void handleComfirmChangePassBtnOnAction(ActionEvent actionEvent) throws IOException {
        Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
        a1.setTitle("Confirm to change password ?");
        a1.setHeaderText(null);
        ButtonType buttonYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        a1.getButtonTypes().setAll(buttonYes, buttonNo);
        Optional<ButtonType> result = a1.showAndWait();
        if (result.get() == buttonYes) {
            newAdmin = account.getAdmin("admin");
            newAdmin.setPassword(newPassField.getText());

            accountDataSource = new AccountFileData("filecsv","admin.csv");
            accountDataSource.setAccountData(account);


            Button ok = (Button) actionEvent.getSource();
            Stage stage = (Stage) ok.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/loginForAdmin.fxml"));
            stage.setScene(new Scene(loader.load(), 800, 600));
            stage.show();
        }

    }
    @FXML
    public void handleBackToMainBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/loginForAdmin.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }




}
