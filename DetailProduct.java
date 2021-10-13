package ku.cs.controllers.seller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailProduct {
    @FXML public Label nameProduct;
    @FXML public Label detailProduct;
    @FXML public Label priceProduct;
    @FXML public Label remainAmount;
    @FXML public Button okBtn;

    @FXML public void handleOkBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button ok = (Button) actionEvent.getSource();
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/theShop.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
//        Product p = new Product(name.getText(),detailProduct.getText(),priceProduct.getText(),remainAmount.getText());
//        productDataSource = new ProductFileData("filecsv", "product.csv");
//        stage.show();
    }
}
