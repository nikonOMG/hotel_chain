package com.example.hotel_8;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChangePasswordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ConNewPas;

    @FXML
    private TextField currentPas;

    @FXML
    private TextField newPas;

    @FXML
    private Button save;

    @FXML
    void initialize() {
        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try{
                    boolean change =  Data_work.changePassword(currentPas.getText(), newPas.getText(), ConNewPas.getText());
                    if(change){
                        Stage stage = (Stage) save.getScene().getWindow();
                        // do what you have to do
                        stage.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}
