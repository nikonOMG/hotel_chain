package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HRWorkersController {
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
    private Button Profile;

    @FXML
    private Button Workers;

    @FXML
    private Button applications;

    @FXML
    private TableColumn<?, ?> email;

    @FXML
    private TableView<Workers> list;

    @FXML
    private TableColumn<Workers, String> name;

    @FXML
    private TableColumn<Workers, String> passport;


    @FXML
    private TableColumn<Workers, String> post;

    @FXML
    private TableColumn<Workers, Integer> salary;

    @FXML
    private Button search;

    @FXML
    private TextField searchText;

    @FXML
    private Text titlename;

    ObservableList<Workers> oblist = FXCollections.observableArrayList();

    ResultSet rs;

    @FXML
    void initialize() {
        titlename.setText(Data_work.name);



        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(searchText.getText().equals(""))
                        rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.HotelID = " + Data_work.hotelID);
                    else
                        rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.Fullname = '" + searchText.getText() + "' and Workers.HotelID = " + Data_work.hotelID);
                    while (rs.next()){
                        oblist.add(new Workers(rs.getInt("WorkerID"), rs.getString("Fullname"), rs.getString("Passport"), rs.getInt("Salary"), rs.getString("Post"), rs.getString("Email") ));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                post.setCellValueFactory(new PropertyValueFactory<>("post"));
                email.setCellValueFactory(new PropertyValueFactory<>("email"));

                list.setItems(oblist);
            }
        }).start();

        search.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                list.getItems().clear();
//                                    SignInBut.getScene().getWindow().hide();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if(searchText.getText().equals(""))
                                rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.HotelID = " + Data_work.hotelID);
                            else
                                rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.Fullname = '" + searchText.getText() + "' and Workers.HotelID = " + Data_work.hotelID);
                            while(rs.next()){
                                oblist.add(new Workers(rs.getInt("WorkerID"), rs.getString("Fullname"), rs.getString("Passport"), rs.getInt("Salary"), rs.getString("Post"), rs.getString("Email") ));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        name.setCellValueFactory(new PropertyValueFactory<>("name"));
                        passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                        post.setCellValueFactory(new PropertyValueFactory<>("post"));
                        email.setCellValueFactory(new PropertyValueFactory<>("email"));

                        list.setItems(oblist);
                    }
                }).start();


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

        applications.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("HRapplications.fxml"));
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
                    root = FXMLLoader.load(getClass().getResource("HRprofile.fxml"));
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
