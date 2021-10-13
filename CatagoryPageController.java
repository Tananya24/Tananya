package ku.cs.controllers.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ku.cs.service.PurchaseList;
import ku.cs.service.DataSource;
import ku.cs.service.RegisterWriteFile;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.FileWriter;

public class CatagoryPageController implements Initializable {

    @FXML
    TextField txtcategory, txtdata1,txtdata2;
    private PurchaseList control;
    private DataSource write = new RegisterWriteFile("filecsv","CatagoryProduct.csv");

    public TableView<ShowCategoryTableView> tableview;
    public TableColumn<ShowCategoryTableView,String> colCatName;
    public TableColumn<ShowCategoryTableView,String> colData1;
    public TableColumn<ShowCategoryTableView,String> colData2;

    private void readData() throws IOException {
        tableview.getItems().clear();

        File file = new File("filecsv","CatagoryProduct.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            ShowCategoryTableView DataUser = new ShowCategoryTableView(data[0],data[1],data[2]);
            tableview.getItems().add(DataUser);
        }
        reader.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCatName.setCellValueFactory(new PropertyValueFactory<>("categoryDataName"));
        colData1.setCellValueFactory(new PropertyValueFactory<>("categoryData1"));
        colData2.setCellValueFactory(new PropertyValueFactory<>("categoryData2"));
        try {
            readData();
        } catch (FileNotFoundException ex) {
            System.err.println();
        } catch (IOException ex) {
            System.err.println();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println();
        }
    }

    ObservableList<ShowCategoryTableView> observableList= FXCollections.observableArrayList(
            new ShowCategoryTableView("AAA","BBB","CCC")
    );

    @FXML
    public void handleOkBtnOnAction(ActionEvent actionEvent) throws IOException {

        File file = new File("filecsv","CatagoryProduct.csv");
        PrintWriter writer = null;
        try {
            FileWriter fw = new FileWriter(file,true);
            writer=new PrintWriter(fw);
            writer.println(txtcategory.getText() + "," + txtdata1.getText() + "," + txtdata2.getText());

            writer.close();
        } catch (IOException e) {

        }
        try {
            readData();
        } catch (FileNotFoundException ex) {
            System.err.println();
        } catch (IOException ex) {
            System.err.println();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println();
        }
    }


    @FXML
    public void handleBackMenuAdminBtn(ActionEvent actionEvent) throws IOException {
        Button register = (Button) actionEvent.getSource();
        Stage stage = (Stage) register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/MenuAdmin.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }
}
