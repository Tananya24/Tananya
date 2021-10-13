package ku.cs.controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ku.cs.controllers.admin.Account;
import ku.cs.controllers.admin.AccountData;
import ku.cs.controllers.admin.AccountFileData;

import java.io.IOException;

public class LoginForAdminController {
    @FXML  TextField usernameAdminbtn;
    @FXML  PasswordField passwordAdminbtn;
    @FXML  Button backToMainBtn;
    @FXML  Button loginAdminbtn;
    @FXML  Button changeAdminPasswordbtn;

    // ยังไม่จัดหน้าให้ถูกต้อง

    Account adminAccount;
    private AccountData accountDataSource;
    public void setAccountData(Account admin) {this.adminAccount = admin; }


    @FXML
    public void initialize() throws IOException {
        adminAccount = new Account();
        accountDataSource = new AccountFileData("filecsv", "admin.csv");
        adminAccount = accountDataSource.getAccount();
    }


    @FXML
    public void handleBackToMainBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button register = (Button) actionEvent.getSource();
        Stage stage = (Stage) register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/loginMain.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

    @FXML
    public void handleLoginAdminBtnOnAction(ActionEvent actionEvent) throws IOException {
        if (adminAccount.checkAdminLogin(usernameAdminbtn.getText(),passwordAdminbtn.getText())) {
            Button register = (Button) actionEvent.getSource();
            Stage stage = (Stage) register.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/MenuAdmin.fxml"));
            stage.setScene(new Scene(loader.load(), 800, 600));
            stage.show();
        }
    }

    @FXML
    public void handleChangeAdminPassBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button register = (Button) actionEvent.getSource();
        Stage stage = (Stage) register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/changePassAdmin.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

}
