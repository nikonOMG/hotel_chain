package com.example.hotel_8;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangeEmailController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private Button save;

    @FXML
    private Text incorrect;

    @FXML
    void initialize() {
        incorrect.setVisible(false);
        email.setText(Data_work.email);
        password.setText(Data_work.email_pas);

        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try{
                    boolean change =  Data_work.changeEmailHR(email.getText(), password.getText());
                    if(change){
                        Stage stage = (Stage) save.getScene().getWindow();
                        // do what you have to do
                        stage.close();
                    }else{
                        incorrect.setVisible(true);
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
