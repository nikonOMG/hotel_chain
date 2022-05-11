package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class MainAdminHotelInfoController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Logout;

    @FXML
    private TextField address;

    @FXML
    private Spinner<Integer > clients;

    @FXML
    private TextField finances;

    @FXML
    private Button hotel;

    @FXML
    private Button hotelist;

    @FXML
    private ComboBox<String> hotellist;

    @FXML
    private TextField name;

    @FXML
    private Button profile;

    @FXML
    private Button workers1;

    @FXML
    private Spinner<Integer> rooms;

    @FXML
    private Button save;

    @FXML
    private Spinner<Integer> stars;

    @FXML
    private Text titlename;

    @FXML
    private Spinner<Integer> workers;



    @FXML
    void initialize() {
        titlename.setText(Data_work.name);

        hotellist.setVisibleRowCount(5);
        hotellist.setItems(FXCollections.observableArrayList(Data_work.getHotels()));


        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);

        stars.setValueFactory(valueFactory);
        stars.setEditable(false);

        SpinnerValueFactory<Integer> valueFactory1 = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 50000);

        workers.setValueFactory(valueFactory1);
        workers.setEditable(false);

        SpinnerValueFactory<Integer> valueFactory2 = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50000);

        clients.setValueFactory(valueFactory2);
        clients.setEditable(false);

        SpinnerValueFactory<Integer> valueFactory3 = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50000);

        rooms.setValueFactory(valueFactory3);
        rooms.setEditable(false);







        hotellist.setOnAction(event -> {

            try {
                ResultSet RSinfo = Data_work.getHotelInfo(hotellist.getValue().split(" | ")[0]);
                RSinfo.next();
                name.setText(RSinfo.getString("Name"));
                address.setText(RSinfo.getString("Address"));
                clients.getValueFactory().setValue(RSinfo.getInt("Clients"));
                finances.setText(RSinfo.getString("Finances"));
                workers.getValueFactory().setValue(RSinfo.getInt("Workers"));
                rooms.getValueFactory().setValue(RSinfo.getInt("Rooms"));
                stars.getValueFactory().setValue(RSinfo.getInt("Stars"));


            } catch (SQLException e) {
                System.out.println("bad");
            } catch (NullPointerException e){
                System.out.println("baad");
            }
        });




        hotelist.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("mainAdminHotels.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add("style.css");
                stage.setScene(scene);
                stage.show();


            }
        });

        workers1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("mainAdminWorkers.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add("style.css");
                stage.setScene(scene);
                stage.show();


            }
        });

        profile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("mainAdminProfile.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add("style.css");
                stage.setScene(scene);
                stage.show();


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
                        Data_work.changeHotelAdmin(Integer.parseInt(hotellist.getValue().split(" | ")[0]), name.getText(), address.getText(), Integer.parseInt(finances.getText()), rooms.getValue(), clients.getValue(), workers.getValue(), stars.getValue());
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


    }

}
