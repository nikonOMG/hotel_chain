package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DirectorClientsController {
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
    private Button hotelinfo;

    @FXML
    private TableView<Clients> list;

    @FXML
    private TableColumn<Clients, String> checkin;

    @FXML
    private TableColumn<Clients, String> checkout;

    @FXML
    private TableColumn<Clients, String> dateofB;

    @FXML
    private TableColumn<Clients, String> name;

    @FXML
    private TableColumn<Clients, String> passport;

    @FXML
    private TableColumn<Clients, Integer> room;

    @FXML
    private Button profile;


    @FXML
    private Button search;

    @FXML
    private TextField searchText;

    @FXML
    private Text titlename;

    @FXML
    private Button workerinfo;

    @FXML
    private Button workers;

    ObservableList<Clients> oblist = FXCollections.observableArrayList();

    ResultSet rs;


    @FXML
    void initialize() {
        titlename.setText(Data_work.name);

        try {
            Date date = Date.valueOf(LocalDate.now());
            if(searchText.getText().equals("")) {
                rs = Data_work.conn.createStatement().executeQuery("select * from Clients where '" + date + "' between Clients.CheckInTime and Clients.CheckOutTime");
            }else
                rs = Data_work.conn.createStatement().executeQuery("select * from Clients where Clients.Fullname = '" + searchText.getText() + "' and '" + date + "' between Clients.CheckInTime and Clients.CheckOutTime");
            while (rs.next()){
                oblist.add(new Clients(rs.getInt("Name"), rs.getString("Fullname"), rs.getDate("DateOfBirth"), rs.getDate("CheckInTime"), rs.getDate("CheckOutTime"), rs.getString("Passport") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        room.setCellValueFactory(new PropertyValueFactory<>("room"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
        dateofB.setCellValueFactory(new PropertyValueFactory<>("birth"));
        checkin.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        checkout.setCellValueFactory(new PropertyValueFactory<>("checkout"));

        list.setItems(oblist);

        search.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                list.getItems().clear();
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    Date date = Date.valueOf(LocalDate.now());
                    if(searchText.getText().equals("")) {
                        rs = Data_work.conn.createStatement().executeQuery("select * from Clients where '" + date + "' between Clients.CheckInTime and Clients.CheckOutTime");
                    }else
                        rs = Data_work.conn.createStatement().executeQuery("select * from Clients where Clients.Fullname = '" + searchText.getText() + "' and '" + date + "' between Clients.CheckInTime and Clients.CheckOutTime");
                    while (rs.next()){
                        oblist.add(new Clients(rs.getInt("Name"), rs.getString("Fullname"), rs.getDate("DateOfBirth"), rs.getDate("CheckInTime"), rs.getDate("CheckOutTime"), rs.getString("Passport") ));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                room.setCellValueFactory(new PropertyValueFactory<>("room"));
                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                dateofB.setCellValueFactory(new PropertyValueFactory<>("birth"));
                checkin.setCellValueFactory(new PropertyValueFactory<>("checkin"));
                checkout.setCellValueFactory(new PropertyValueFactory<>("checkout"));

                list.setItems(oblist);


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
                    root = FXMLLoader.load(getClass().getResource("directorHotel.fxml"));
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

//        workerinfo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent event) {
////                                    SignInBut.getScene().getWindow().hide();
//                try {
//                    root = FXMLLoader.load(getClass().getResource("adminWorkerInfo.fxml"));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                scene.getStylesheets().add("style.css");
//                stage.setScene(scene);
//                stage.show();
//
//
//            }
//        });

        workers.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("directorWorkers.fxml"));
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
                    root = FXMLLoader.load(getClass().getResource("directorProfile.fxml"));
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
    }

}
