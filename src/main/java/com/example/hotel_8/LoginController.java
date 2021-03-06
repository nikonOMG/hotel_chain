package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
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
import javafx.scene.text.Text;
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
    private Text wait;

    @FXML
    private TextField idLogin;

    @FXML
    private PasswordField idPassword;

    public static boolean ch;


    @FXML
    void initialize() {
        wait.setVisible(false);
        idHotels.setItems(FXCollections.observableArrayList(Data_work.get_hotels()));
        idHotels.setVisibleRowCount(5);
        new AutoCompleteBox ( idHotels );



        
        SignInBut.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                try{



                    String login = idLogin.getText();
                    String password = idPassword.getText();
                    String hotel = idHotels.getValue();
                    ch = Data_work.sign_in(login.trim(), password.trim(), hotel);

                    if(ch){
                        System.out.println("okkkk");

                        String job = Data_work.post;
                        System.out.println(job);
                        if(job.equals("Receptionist")){
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

                        } else if(job.equals("Admin")){
                            try {
                                System.out.println("test");
                                root = FXMLLoader.load(getClass().getResource("adminHotel.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            scene.getStylesheets().add("style.css");
                            stage.setScene(scene);
                            stage.show();

                    } else if(job.equals("Marketing")){
                        try {
                            System.out.println("test");
                            root = FXMLLoader.load(getClass().getResource("marketingHotels.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        scene.getStylesheets().add("style.css");
                        stage.setScene(scene);
                        stage.show();

                    } else if(job.equals("Main Admin")){
                            try {
                                System.out.println("test");
                                root = FXMLLoader.load(getClass().getResource("mainAdminHotels.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            scene.getStylesheets().add("style.css");
                            stage.setScene(scene);
                            stage.show();
                        }else if(job.equals("Owner")){
                            try {
                                System.out.println("test");
                                root = FXMLLoader.load(getClass().getResource("ownerHotels.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            scene.getStylesheets().add("style.css");
                            stage.setScene(scene);
                            stage.show();}
                        else if(job.equals("Maid")){
                            try {
                                System.out.println("test");
                                root = FXMLLoader.load(getClass().getResource("cleanerProfile.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            scene.getStylesheets().add("style.css");
                            stage.setScene(scene);
                            stage.show();

                        }else if(job.equals("Main Maid")){
                            try {
                                System.out.println("test");
                                root = FXMLLoader.load(getClass().getResource("mainCleanerProfile.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            scene.getStylesheets().add("style.css");
                            stage.setScene(scene);
                            stage.show();

                        }else if(job.equals("Cook")){
                            try {
                                System.out.println("test");
                                root = FXMLLoader.load(getClass().getResource("AsCookProfile.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            scene.getStylesheets().add("style.css");
                            stage.setScene(scene);
                            stage.show();

                        }else if(job.equals("Chef Cook")){
                            try {
                                System.out.println("test");
                                root = FXMLLoader.load(getClass().getResource("povar11.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            scene.getStylesheets().add("style.css");
                            stage.setScene(scene);
                            stage.show();

                        }
                    }else{
                        idPassword.setText("");
                        wait.setVisible(true);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        idLogin.textProperty().addListener((observable, oldValue, newValue) -> {
            wait.setVisible(false);
        });

        idPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            wait.setVisible(false);
        });

    }

}
