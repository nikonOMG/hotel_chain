package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignInBut;

    @FXML
    private ComboBox<String> idHotels;

    @FXML
    private TextField idLogin;

    @FXML
    private PasswordField idPassword;

    @FXML
    private ProgressIndicator load;

    @FXML
    void initialize() {
        idHotels.setItems(FXCollections.observableArrayList(Data_work.get_hotels()));
        idHotels.setVisibleRowCount(5);

        
        SignInBut.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try{



                    String login = idLogin.getText();
                    String password = idPassword.getText();
                    String hotel = idHotels.getValue();

                    if(Data_work.sign_in(login.trim(), password.trim(), hotel)){
                        System.out.println("okkkk");
                        String job = Data_work.getJob(login, hotel);
                        System.out.println(job);
                        if(login.equals("admin")){
                            System.out.println("gg");
                            SignInBut.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                                @Override
                                public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("adminHome.fxml"));
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
                        else if(job.equals("Receptionist")){
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

                        } else if(job.equals("HRmanager")){
                            try {
                                System.out.println("test");
                                root = FXMLLoader.load(getClass().getResource("HRapplications.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            scene.getStylesheets().add("style.css");
                            stage.setScene(scene);
                            stage.show();

                        } else if(job.equals("Director")){
                        try {
                            System.out.println("test");
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
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
