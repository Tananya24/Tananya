package ku.cs.controllers.seller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MarketPlace {
    @FXML public Label name;
    @FXML public Label price;
    @FXML public Label remainAmount;
    @FXML public Button p1in,p1de,p2in,p2de,p3in,p3de,p4in,p4de,p5in,p5de,p6in,p6de;

    @FXML public void handleOkBtnOnAction(ActionEvent actionEvent) throws IOException {
        Button okBtn = (Button) actionEvent.getSource();
        Stage stage = (Stage) okBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ku/cs/marketPlace.fxml"));
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.show();
    }

//    Login = seller
//    ปุ่ม เพิ่มจำนวน
//    public void stock() throws IOException {
//        amountp1 >= 0; amountp1++
//                p1in = input ;
//                amountp1 += p1in;
//                return amountp1
//
//        amountp2 >= 0; amountp2++//
//                p2in = input ;
//                amountp1 += p2in;
//                return amountp2
//
//        amountp2 >= 0; amountp2++
//                p2in = input ;
//                amountp1 += p2in;
//                return amountp2
//
//        amountp3 >= 0; amountp3++
//                p2in = input ;
//                amountp1 += p2in;
//                return amountp3
//
//        amountp4 >= 0; amountp4++
//                p2in = input ;
//                amountp1 += p2in;
//                return amountp4
//
//        amountp5 >= 0; amountp5++
//                p2in = input ;
//                amountp1 += p2in;
//                return amountp6
//
//        amountp6 >= 0; amountp6++
//                p2in = input ;
//                amountp1 += p2in;
//                return amountp6
//
//
//    }



}