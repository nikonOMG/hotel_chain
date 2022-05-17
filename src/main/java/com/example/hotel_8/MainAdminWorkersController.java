package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainAdminWorkersController {

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
    private TextField email;

    @FXML
    private Button hotel;

    @FXML
    private Button hotelist;

    @FXML
    private ComboBox<String> hotellist;

    @FXML
    private TextField login;

    @FXML
    private TextField name;

    @FXML
    private TextField passport;

    @FXML
    private TextField password;

    @FXML
    private Button profile;

    @FXML
    private Button profile1;

    @FXML
    private TextField salary;

    @FXML
    private Button save;

    @FXML
    private Text titlename;

    @FXML
    private ComboBox<String> workerlist;

    @FXML
    private AnchorPane workers;

    @FXML
    private Text workertext;

    @FXML
    void initialize() {
        titlename.setText(Data_work.name);

        workerlist.setVisibleRowCount(5);



        workers.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("adminWorkers.fxml"));
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

        hotelist.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

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

        hotellist.setVisibleRowCount(5);
        hotellist.setItems(FXCollections.observableArrayList(Data_work.getHotels()));


        hotellist.setOnAction(event -> {
            name.clear();
            passport.clear();
            salary.clear();
            login.clear();
            password.clear();
            email.clear();



            workerlist.setItems(FXCollections.observableArrayList(Data_work.getWorkers(Integer.parseInt(hotellist.getValue().split(" | ")[0]))));

        });


        workerlist.setOnAction(event -> {

            try {
                ResultSet RSinfo = Data_work.getWorkerInfoAdmin(workerlist.getValue().split(" | ")[0], hotellist.getValue().split(" | ")[0]);
                RSinfo.next();
                name.setText(RSinfo.getString("Fullname"));
                email.setText(RSinfo.getString("Email"));
                passport.setText(RSinfo.getString("Passport"));
                password.setText(RSinfo.getString("Password"));
                login.setText(RSinfo.getString("Login"));
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

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){

                    try {
                        Data_work.changeWorker(Integer.parseInt(workerlist.getValue().split(" ")[0]), name.getText(), passport.getText(), email.getText(), login.getText(), password.getText(), Integer.parseInt(salary.getText()));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {

                }


            }
        });


        hotel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("mainAdminHotelInfo.fxml"));
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

        Logout.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

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



        profile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("mainAdminProfile.fxml"));
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
