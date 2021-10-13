package ku.cs.controllers.purchaser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ku.cs.service.PurchaseList;
import ku.cs.models.Purchase;
import ku.cs.service.DataSource;
import ku.cs.service.RegisterWriteFile;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

public class RegisterController {
    @FXML
    Label labelName;
    @FXML
    Button okBtn, backButton, uploadBtn;
    @FXML
    TextField username, name;
    @FXML
    PasswordField password, confirmPassword;
    @FXML
    private ImageView image;
    private PurchaseList control;
    private Purchase purchase;
    private DataSource write = new RegisterWriteFile("filecsv", "purchase.csv");

    public void setList(PurchaseList control) {
        this.control = control;
    }

    public void initialize() {
        String path = getClass().getResource("/picture/cat.jpg").toExternalForm();
        image.setImage(new Image(path));
    }

    @FXML
    public void handleOkBtnOnAction(ActionEvent actionEvent) throws IOException {
        System.out.println(control.toList());
        if (UserCheck()) {
            labelName.setText("USERNAME ALREADY TAKEN");
        } else if (CheckPassword()) {
            labelName.setText("PASSWORD IS NOT MATCH");
        } else {
            Button ok = (Button) actionEvent.getSource();
            Stage stage = (Stage) ok.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/marketPlace.fxml"));
            stage.setScene(new Scene(loader.load(), 800, 600));
            Purchase p = new Purchase(name.getText(), username.getText(), password.getText());
            control.addCustomer(p);
            write.writeData(control);
            stage.show();
        }
    }

    @FXML
    public void handleBackBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/loginMain.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }


    public Boolean UserCheck() {
        for (Purchase p : control.toList()) {
            if (username.getText().equals(p.getUserName())) {
                return true;
            }
        }
        return false;
    }

    public Boolean CheckPassword() {
        if (!password.getText().equals(confirmPassword.getText())) {
            return true;
        }
        return false;
    }

    @FXML
    public void handleUploadButton(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        // SET FILECHOOSER INITIAL DIRECTORY
        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        // DEFINE ACCEPTABLE FILE EXTENSION
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("images PNG JPG", "*.png", "*.jpg", "*.jpeg"));
        // GET FILE FROM FILECHOOSER WITH JAVAFX COMPONENT WINDOW
        Node source = (Node) event.getSource();
        File file = chooser.showOpenDialog(source.getScene().getWindow());
        if (file != null) {
            try {
                // CREATE FOLDER IF NOT EXIST
                File destDir = new File("picture");
                if (!destDir.exists()) destDir.mkdirs();
                // RENAME FILE
                String[] fileSplit = file.getName().split("\\.");
                String filename = LocalDate.now() + "_" + System.currentTimeMillis() + "."
                        + fileSplit[fileSplit.length - 1];
                Path target = FileSystems.getDefault().getPath(
                        destDir.getAbsolutePath() + System.getProperty("file.separator") + filename
                );
                // COPY WITH FLAG REPLACE FILE IF FILE IS EXIST
                Files.copy(file.toPath(), target, StandardCopyOption.REPLACE_EXISTING);
                // SET NEW FILE PATH TO IMAGE
                image.setImage(new Image(target.toUri().toString()));
//                purchase.setImagePath(destDir + "/" + filename);
                write.writeData(control);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

