package com.example.hotel_8;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ChangeSalaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField salary;

    @FXML
    private Button save;

    @FXML
    private ComboBox<String> workers;

    @FXML
    void initialize() {

        workers.setVisibleRowCount(5);
        workers.setItems(FXCollections.observableArrayList(Data_work.getWorkers()));

        workers.setOnAction(event -> {

            try {
                ResultSet RSinfo = Data_work.getWorkerSalary(workers.getValue().split(" ")[0]);
                RSinfo.next();
                salary.setText(RSinfo.getString("Salary"));


            } catch (SQLException e) {
                System.out.println("bad");
            } catch (NullPointerException e){
                System.out.println("baad");
            }
        });

        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    // ... user chose OK
                    try {
                        Data_work.changeWorkerSalary(Integer.parseInt(workers.getValue().split(" ")[0]), Integer.parseInt(salary.getText()));

                        Stage stage = (Stage) save.getScene().getWindow();
                        // do what you have to do

                        stage.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    // ... user chose CANCEL or closed the dialog
                }


            }
        });

        salary.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    salary.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });




    }

}
