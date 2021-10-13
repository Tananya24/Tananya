package ku.cs.controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ku.cs.service.PurchaseList;
import ku.cs.controllers.purchaser.RegisterController;
import ku.cs.service.DataSource;
import ku.cs.service.RegisterWriteFile;

import java.io.IOException;

public class LoginMainController {

    @FXML  TextField username;
    @FXML  PasswordField password;
    @FXML  Button profileBtn;
    @FXML  Button createAccountBtn;
    @FXML  Button okBtn;
    @FXML  Button LoginBtn;
    private PurchaseList control;
    public  void  setList(PurchaseList control){
        this.control = control;
    }
    private DataSource registerWriteFile;
    @FXML public void initialize(){
        control = new PurchaseList();
        registerWriteFile = new RegisterWriteFile("filecsv","purchase.csv");
        control.setPurchaseArrayList(registerWriteFile.readData().toList());
    }

    // ทำเป็นหน้าถัดไป
    @FXML
    public void handleOkBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/loginForAdmin.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }
    @FXML
    public void handleProfileBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button profile = (Button) actionEvent.getSource();
        Stage stage = (Stage) profile.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/profile1.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }
    @FXML
    public void handleRegisterBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button register = (Button) actionEvent.getSource();
        Stage stage = (Stage) register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/register.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        RegisterController dw = loader.getController();
        stage.show();
        dw.setList(control);
    }
    @FXML
    public void handleLoginBtn(ActionEvent actionEvent) throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/whatYouAre.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }


//
//    @FXML
//    private void registerButton() throws IOException {
//        App.setRoot("register");
//    }

}
