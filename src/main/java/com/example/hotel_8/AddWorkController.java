package com.example.hotel_8;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddWorkController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text des;

    @FXML
    private TextArea descpription;

    @FXML
    private DatePicker end;

    @FXML
    private ComboBox<String> list;

    @FXML
    private Text max;

    @FXML
    private Button save;

    @FXML
    private DatePicker stars;

    @FXML
    void initialize() {
        list.setVisibleRowCount(5);
        list.setItems(FXCollections.observableArrayList(Data_work.getMaids()));
        new AutoCompleteBox( list);


        max.setStyle("-fx-fill: #C33C43");
        descpription.textProperty().addListener((obs,old,niu)->{
            if(descpription.getText().length() > 100){
                descpription.setText(old);
            }
            if(descpription.getText().length() > 0){
                max.setStyle("-fx-fill: #4baead");
            }
            else{
                max.setStyle("-fx-fill: #C33C43");
            }
            max.setText(descpription.getText().length() + " / 100");

        });

        stars.setValue(LocalDate.now());
        stars.setEditable(false);

        end.setValue(LocalDate.now());
        end.setEditable(false);


        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(descpription.getText().isEmpty() == false){


                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Are you ok with this?");

                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.get() == ButtonType.OK){
                        Data_work.addWorkMaid(Integer.parseInt(list.getValue().split(" ")[0]), descpription.getText(), Date.valueOf(stars.getValue()), Date.valueOf(end.getValue()));

                        Stage stage = (Stage) save.getScene().getWindow();


                        stage.close();




                    } else {

                    }

                }
                else {
                    max.setStyle("-fx-fill: #C33C43");
                }



            }
        });

    }

}
