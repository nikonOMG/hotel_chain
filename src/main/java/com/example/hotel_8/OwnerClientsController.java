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

public class OwnerClientsController {
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
    private TableColumn<Clients, String> room;

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
    ResultSet rs1;


    @FXML
    void initialize() {
        titlename.setText(Data_work.name);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Date date = Date.valueOf(LocalDate.now());
                    rs = Data_work.conn.createStatement().executeQuery("select * from Clients where '" + date + "' between Clients.CheckInTime and Clients.CheckOutTime");
                    while (rs.next()){

                        String query = "select Name from Hotels WHERE HotelID = " + rs.getInt("HotelID");
                        rs1 = Data_work.conn.createStatement().executeQuery(query);
                        rs1.next();





                        oblist.add(new Clients(rs.getString("FullName"),  rs.getDate("DateOfBirth"), rs.getDate("CheckInTime"), rs.getDate("CheckOutTime"), rs.getString("Passport"), rs1.getString("Name") ));

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                room.setCellValueFactory(new PropertyValueFactory<>("hotel"));
                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                dateofB.setCellValueFactory(new PropertyValueFactory<>("birth"));
                checkin.setCellValueFactory(new PropertyValueFactory<>("checkin"));
                checkout.setCellValueFactory(new PropertyValueFactory<>("checkout"));

                FilteredList<Clients> Filtered = new FilteredList<>(oblist, b -> true);
                searchText.textProperty().addListener((observable, oldValue,newValue)->{
                    Filtered.setPredicate(clients -> {
                        if(newValue == null || newValue.isEmpty()){
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if(clients.getHotel().toLowerCase().indexOf(lowerCaseFilter) != -1){
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
        }).start();







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
                    root = FXMLLoader.load(getClass().getResource("ownerHotels.fxml"));
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
                    root = FXMLLoader.load(getClass().getResource("ownerWorkers.fxml"));
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
                    root = FXMLLoader.load(getClass().getResource("ownerProfile.fxml"));
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
