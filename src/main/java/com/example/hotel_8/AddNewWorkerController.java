package com.example.hotel_8;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddNewWorkerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField email;

    @FXML
    private TextField login;

    @FXML
    private TextField name;

    @FXML
    private TextField passport;

    @FXML
    private TextField password;

    @FXML
    private ComboBox<String> post;

    @FXML
    private Spinner<Integer> salary;

    @FXML
    private Button save;

    @FXML
    void initialize() {
        post.setVisibleRowCount(5);
        post.setItems(FXCollections.observableArrayList("Receptionist", "HRmanager", "Director", "Maid", "Admin", "Main Maid", "Chef Cook", "Cook"));


        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(100, Data_work.finances);

        salary.setValueFactory(valueFactory);
        salary.setEditable(true);
        System.out.println();

        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if(!name.getText().equals("") && !email.getText().equals("") && !login.getText().equals("") && !password.getText().equals("") && !post.getValue().equals("") && !passport.getText().equals("")) {
                    try {
                        boolean add = Data_work.addNewWorker(name.getText(), passport.getText(), email.getText(), login.getText(), password.getText(), post.getValue(), salary.getValue());

                        if (add) {
                            Stage stage = (Stage) save.getScene().getWindow();


                            stage.close();
                        } else {
                            System.out.println("error");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        });



    }

}
