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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;



public class UserListPage implements Initializable {

    public TableView<ShowUserTableView> tableview;
    public TableColumn<ShowUserTableView,String> colImage;
    public TableColumn<ShowUserTableView,String> colUsername;
    public TableColumn<ShowUserTableView,String> colName;
    public TableColumn<ShowUserTableView,String> colStore;
    public TableColumn<ShowUserTableView,String> colDate;
    public TableColumn<ShowUserTableView,String> colTime;

    private void readData() throws IOException {
        tableview.getSortOrder().clear();
        String fileName = "purchase.csv";
        File file = new File("filecsv","user.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            ImageView emp0photo = new ImageView(new Image(this.getClass().getResourceAsStream("/Picture/cat.jpg")));
            ShowUserTableView DataUser = new ShowUserTableView(emp0photo,data[1],data[2],data[3],data[4],data[5]);
            tableview.getItems().add(DataUser);

        }
        colDate.setSortType(TableColumn.SortType.DESCENDING);
        tableview.getSortOrder().addAll(colDate);
        colTime.setSortType(TableColumn.SortType.DESCENDING);
        tableview.getSortOrder().addAll(colTime);
        reader.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colImage.setPrefWidth(80);
        colImage.setCellValueFactory(new PropertyValueFactory<>("Userphoto"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("UserUsername"));
        colName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        colStore.setCellValueFactory(new PropertyValueFactory<>("UserStore"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("UserDate"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("UserTime"));

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

//    ObservableList<ShowUserTableView> observableList= FXCollections.observableArrayList(
//            new ShowUserTableView("AAA","BBB","CCC","DDD","27/09/2021","16:01PM")
//    );


    @FXML
    public void handleBackMenuAdminBtn(ActionEvent actionEvent) throws IOException {
        Button register = (Button) actionEvent.getSource();
        Stage stage = (Stage) register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/MenuAdmin.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }
}
