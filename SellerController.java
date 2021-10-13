package ku.cs.controllers.seller;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ku.cs.models.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
//import com.github.saacsos.FXRouter;

public class SellerController implements Initializable {

    @FXML private TextField nameTextField;
    @FXML private TextField descriptionTextField;
    @FXML private TextField priceTextField;
    @FXML private TextField stockTextField;
    @FXML private TableView<Product> shopTable;
    @FXML private TableColumn<Product, String> nameColume;
    @FXML private TableColumn<Product, String> descriptionColume;
    @FXML private TableColumn<Product, Integer> priceColume;
    @FXML private TableColumn<Product, Integer> stockColume;
    @FXML private Button handleAddButton;
    @FXML private Button handleUpdateButton;
    @FXML private Button handleRemoveButton;

    private Product selectedProduct;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        nameColume.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        descriptionColume.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        priceColume.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        stockColume.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());

        shopTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showSelectedProduct(newValue);
            }
        });
    }

    @FXML
    void handleAddButton(ActionEvent event) {
        Product product = new Product();
        product.setName(nameTextField.getText());
        product.setDescription(descriptionTextField.getText());
        product.setPrice(Integer.parseInt(priceTextField.getText()));
        product.setStock(Integer.parseInt(stockTextField.getText()));
        shopTable.getItems().add(product);
        nameTextField.clear();
        descriptionTextField.clear();
        priceTextField.clear();
        stockTextField.clear();
    }

    private void showSelectedProduct(Product product) {
        selectedProduct = product;
        nameTextField.setText(product.getName());
        descriptionTextField.setText(product.getDescription());
        priceTextField.setText(String.valueOf(product.getPrice()));
        stockTextField.setText(String.valueOf(product.getStock()));
        handleUpdateButton.setDisable(false);
    }

    private void clearSelectedProduct() {
        selectedProduct = null;
        nameTextField.clear();
        descriptionTextField.clear();
        priceTextField.setText("");
        stockTextField.setText("");
        handleUpdateButton.setDisable(true);
    }

    @FXML
    void handleUpdateButton(ActionEvent event) {
        selectedProduct.setName(nameTextField.getText().trim());
        selectedProduct.setDescription(descriptionTextField.getText().trim());
        selectedProduct.setPrice(Integer.parseInt(priceTextField.getText().trim()));
        selectedProduct.setStock(Integer.parseInt(stockTextField.getText().trim()));
        clearSelectedProduct();
        shopTable.refresh();
        shopTable.getSelectionModel().clearSelection();
    }

    @FXML
    void handleRemoveButton(ActionEvent event) {
        ObservableList<Product> productSelected, allProducts;
        allProducts = shopTable.getItems();
        productSelected = shopTable.getSelectionModel().getSelectedItems();
        nameTextField.clear();
        descriptionTextField.clear();
        priceTextField.clear();
        stockTextField.clear();

        productSelected.forEach(allProducts::remove);
    }

    @FXML
    void handleBackToMarketButton(ActionEvent event) throws IOException {
        Button setBtn = (Button) event.getSource();
        Stage stage = (Stage) setBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/loginMain.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
//        try {
//            FXRouter.goTo("home");
//        } catch (IOException e) {
//            System.err.println("ไปที่หน้า marketplace ไม่ได้");
//            System.err.println("ให้ตรวจสอบการกำหนด route");
//        }
    }
}
