package com.example.hotel_8;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangeRoomController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox child;

    @FXML
    private CheckBox extrabed;

    @FXML
    private Text un;

    @FXML
    private ComboBox<String> list;

    @FXML
    private Spinner<Integer> number;

    @FXML
    private Spinner<Integer> price;

    @FXML
    private Button save;

    @FXML
    private Button delete;

    @FXML
    private ComboBox<String> size;

    @FXML
    private ComboBox<String> type;

    @FXML
    private ComboBox<String> view;

    @FXML
    void initialize() {
        un.setVisible(false);
        delete.setVisible(false);
        view.setVisibleRowCount(5);
        view.setItems(FXCollections.observableArrayList(Data_work.getView()));

        size.setVisibleRowCount(5);
        size.setItems(FXCollections.observableArrayList(Data_work.getSize()));

        type.setVisibleRowCount(5);
        type.setItems(FXCollections.observableArrayList(Data_work.getType()));

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1000, 999999999);

        SpinnerValueFactory<Integer> valueFactory1 =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999999999);

        price.setValueFactory(valueFactory);
        price.setEditable(true);

        number.setValueFactory(valueFactory1);
        number.setEditable(true);

        list.setVisibleRowCount(5);
        list.setItems(FXCollections.observableArrayList(Data_work.getRooms()));
        new AutoCompleteBox ( list );


        list.setOnAction(event -> {

            try {
                ResultSet RSinfo = Data_work.getRoomInfo(list.getValue().split(" | ")[0]);
                RSinfo.next();
                price.getValueFactory().setValue(RSinfo.getInt("Price"));
                type.setValue(RSinfo.getString("Type"));
                size.setValue(RSinfo.getString("Size"));
                number.getValueFactory().setValue(RSinfo.getInt("Name"));
                view.setValue(RSinfo.getString("View"));
                if(RSinfo.getBoolean("Child")){
                    child.setSelected(true);
                } else{
                    child.setSelected(false);
                }
                if(RSinfo.getBoolean("Extra_bed")){
                    extrabed.setSelected(true);
                } else{
                    extrabed.setSelected(false);
                }
                if(Data_work.isAvailable(Integer.parseInt(list.getValue().split(" | ")[0])))
                    delete.setVisible(true);
                else{
                    delete.setVisible(false);
                }



            } catch (SQLException e) {
                System.out.println("bad");
            } catch (NullPointerException e){
                System.out.println("baad");
            }
        });

        number.valueProperty().addListener((obs, oldValue, newValue) -> {
            boolean contains = Data_work.getRoomsNumber(Integer.parseInt(list.getValue().split(" | ")[0])).contains(number.getValue());
            System.out.println(contains);
            if (contains) {
                un.setVisible(true);
                save.setDisable(true);
            } else {
                un.setVisible(false);
                save.setDisable(false);
            }
        });


        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if(!(size.getValue() == null) && !(view.getValue() == null) && !(type.getValue() == null)) {
                    try {
                        boolean add = Data_work.changeRoom(Integer.parseInt(list.getValue().split(" | ")[0]) , number.getValue(), price.getValue() ,size.getValue(), view.getValue(), type.getValue(), extrabed.isSelected(), child.isSelected());

                        if (add) {
                            Stage stage = (Stage) save.getScene().getWindow();


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


        delete.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if(!(size.getValue() == null) && !(view.getValue() == null) && !(type.getValue() == null)) {
                    try {
                        boolean add = Data_work.deleteRoom(Integer.parseInt(list.getValue().split(" | ")[0]));

                        if (add) {
                            Stage stage = (Stage) save.getScene().getWindow();


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
