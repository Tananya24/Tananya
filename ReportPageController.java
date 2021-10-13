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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportPageController implements Initializable{

    public TableView<ShowReportUserTableView> tableview;
    public TableColumn<ShowReportUserTableView,String> colUsername;
    public TableColumn<ShowReportUserTableView,String> colName;
    public TableColumn<ShowReportUserTableView,String> colStore;
    public TableColumn<ShowReportUserTableView,String> colRemark;
    public TableColumn<ShowReportUserTableView,String> colTotalLogin;

    private void readData() throws IOException {
        tableview.getSortOrder().clear();
        String fileName = "purchase.csv";
        File file = new File("filecsv","user.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            String Str_Status=data[6];
            if (Str_Status.contentEquals("0")) {
                    ShowReportUserTableView DataUser = new ShowReportUserTableView(data[0],data[1],data[2],data[7],data[8]);
                    tableview.getItems().add(DataUser);
            }
        }
        reader.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colUsername.setCellValueFactory(new PropertyValueFactory<>("UserUsername"));
        colName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        colStore.setCellValueFactory(new PropertyValueFactory<>("UserStore"));
        colRemark.setCellValueFactory(new PropertyValueFactory<>("UserRemark"));
        colTotalLogin.setCellValueFactory(new PropertyValueFactory<>("UserTotalLogin"));

        try {
            readData();
        } catch (FileNotFoundException ex) {
            System.err.println();
        } catch (IOException ex) {
            System.err.println();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println();
        }

//        tableview.setItems(observableList);
    }

    ObservableList<ShowReportUserTableView> observableList= FXCollections.observableArrayList(
            new ShowReportUserTableView("AAA","BBB","CCC","DDD","5")
    );

    @FXML
    public void handleBackMenuAdminBtn(ActionEvent actionEvent) throws IOException {
        Button register = (Button) actionEvent.getSource();
        Stage stage = (Stage) register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/MenuAdmin.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

}
