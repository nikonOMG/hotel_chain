package com.example.hotel_8;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddNewRoomController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox child;

    @FXML
    private CheckBox extrabed;

    @FXML
    private Text number;

    @FXML
    private Spinner<Integer> price;

    @FXML
    private Button save;

    @FXML
    private ComboBox<String> size;

    @FXML
    private ComboBox<String> type;

    @FXML
    private ComboBox<String> view;

    @FXML
    void initialize() {

        view.setVisibleRowCount(5);
        view.setItems(FXCollections.observableArrayList(Data_work.getView()));

        size.setVisibleRowCount(5);
        size.setItems(FXCollections.observableArrayList(Data_work.getSize()));

        type.setVisibleRowCount(5);
        type.setItems(FXCollections.observableArrayList(Data_work.getType()));

        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1000, 999999999);

        price.setValueFactory(valueFactory);
        price.setEditable(true);

        number.setText(number.getText() + " " + (Data_work.getCountRooms() + 1));


        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                if(!(size.getValue() == null) && !(view.getValue() == null) && !(type.getValue() == null)) {
                    try {
                        System.out.println(extrabed.isSelected());
                        boolean add = Data_work.addNewRoom((Data_work.getCountRooms() + 1), price.getValue() ,size.getValue(), view.getValue(), type.getValue(), extrabed.isSelected(), child.isSelected());

                        if (add) {
                            Stage stage = (Stage) save.getScene().getWindow();
                            // do what you have to do

                            stage.close();
                        } else {
                            System.out.println("error");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        });

    }

}
