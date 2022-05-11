package com.example.hotel_8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReceptionistClientsController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Clients> list;

    @FXML
    private Button Logout;

    @FXML
    private Button Profile;

    @FXML
    private Button Progress;

    @FXML
    private Button Registration;

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
    private Button search;

    @FXML
    private TextField searchText;

    @FXML
    private Text title;

    ObservableList<Clients> oblist = FXCollections.observableArrayList();

    ResultSet rs;





    @FXML
    void initialize() {
        title.setText(Data_work.name);




        try {
            Date date = Date.valueOf(LocalDate.now());
            if(searchText.getText().equals("")) {
                rs = Data_work.conn.createStatement().executeQuery("select * from Clients where '" + date + "' between Clients.CheckInTime and Clients.CheckOutTime  and HotelID = " + Data_work.hotelID);
            }else
                rs = Data_work.conn.createStatement().executeQuery("select * from Clients where Clients.Fullname = '" + searchText.getText() + "' and '" + date + "' between Clients.CheckInTime and Clients.CheckOutTime  and HotelID = " + Data_work.hotelID);
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




        Registration.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("receptionistRegistration.fxml"));
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


        Profile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("receptionistProfile.fxml"));
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

        Progress.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("receptionistProgress.fxml"));
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

        FilteredList<Clients> Filtered = new FilteredList<>(oblist, b -> true);
        searchText.textProperty().addListener((observable, oldValue,newValue)->{
            Filtered.setPredicate(clients -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(String.valueOf(clients.getRoom()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(clients.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if(clients.getPassport().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(clients.getBirth()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(clients.getCheckin()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(clients.getCheckout()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<Clients> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(list.comparatorProperty());
        list.setItems(sortedList);

    }

}
