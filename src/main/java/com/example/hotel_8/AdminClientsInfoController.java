package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

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

public class AdminClientsInfoController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Client_list;

    @FXML
    private Button Logout;

    @FXML
    private DatePicker checkin;

    @FXML
    private DatePicker checkout;

    @FXML
    private DatePicker dateofbirth;

    @FXML
    private Button hotelinfo;

    @FXML
    private TextField name;

    @FXML
    private TextField passport;

    @FXML
    private Button profile;

    @FXML
    private ComboBox<String> rooms;

    @FXML
    private Button save;

    @FXML
    private Text titlename;

    @FXML
    private Button workerinfo;

    @FXML
    private ComboBox<String> workerlist;

    @FXML
    private Button workers;

    @FXML
    void initialize() {
        titlename.setText(Data_work.name);
        workerlist.setVisibleRowCount(5);
        workerlist.setItems(FXCollections.observableArrayList(Data_work.getClients()));

        workerlist.setOnAction(event -> {

            try {
                ResultSet RSinfo = Data_work.getClientInfo(workerlist.getValue().split(" ")[0]);
                RSinfo.next();
                name.setText(RSinfo.getString("Fullname"));
                dateofbirth.setValue(LocalDate.parse(RSinfo.getString("DateOfBirth")));
                passport.setText(RSinfo.getString("Passport"));
                checkin.setValue(LocalDate.parse(RSinfo.getString("CheckInTime")));
                checkout.setValue(LocalDate.parse(RSinfo.getString("CheckOutTime")));
                rooms.getSelectionModel().clearSelection();
                ObservableList room = FXCollections.observableArrayList(Data_work.get_rooms(false, false));
                room.add(RSinfo.getString("Name"));
                rooms.setItems(room);
                rooms.getSelectionModel().selectLast();


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
                        Data_work.changeClient(Integer.parseInt(workerlist.getValue().split(" ")[0]), name.getText(), passport.getText(), Integer.parseInt(rooms.getValue().split(" ")[0]), checkin.getValue(), checkout.getValue(), dateofbirth.getValue());
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

        Logout.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("log-in.fxml"));
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

        hotelinfo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("adminHotel.fxml"));
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

        workers.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("adminWorkers.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e){
                    System.out.println("baddd");
                }
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add("style.css");
                stage.setScene(scene);
                stage.show();


            }
        });

        workerinfo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("adminWorkerInfo.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e){
                    System.out.println("baddd");
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
                    root = FXMLLoader.load(getClass().getResource("adminProfile.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e){
                    System.out.println("baddd");
                }
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add("style.css");
                stage.setScene(scene);
                stage.show();


            }
        });



    }

}
