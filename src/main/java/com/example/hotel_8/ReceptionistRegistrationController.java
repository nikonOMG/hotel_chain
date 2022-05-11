package com.example.hotel_8;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;


public class ReceptionistRegistrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    LocalDate intime;
    LocalDate outtime;
    String name;
    String passport;
    LocalDate dateofb;
    int days;

    String countr;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CheckBtn;

    @FXML
    private Button Client_list;

    @FXML
    private DatePicker GetInTime;

    @FXML
    private DatePicker GetOutTime;

    @FXML
    private Button Logout;

    @FXML
    private Button Profile;

    @FXML
    private Button Progress;

    @FXML
    private Text title;

    @FXML
    private Button Registration;

    @FXML
    private ComboBox<String> country;

    @FXML
    private ComboBox<String> RoomList;

    @FXML
    private Button SettleBtn;

    @FXML
    private DatePicker getDateofBirth;

    @FXML
    private TextField getName;

    @FXML
    private TextField getPassport;

    @FXML
    private Text setTextPrice;

    @FXML
    private Text incorrect;

    @FXML
    private TextFlow description;

    @FXML
    private CheckBox Child;

    @FXML
    private CheckBox ExtraBed;

    @FXML
    private Button update;



    @FXML
    void initialize() {
        incorrect.setVisible(false);
        title.setText(Data_work.name);
        RoomList.setVisibleRowCount(5);
        RoomList.setItems(FXCollections.observableArrayList(Data_work.get_rooms(ExtraBed.selectedProperty().get(), Child.selectedProperty().get())));


        country.setVisibleRowCount(5);
        country.setItems(FXCollections.observableArrayList(Data_work.get_Counry()));
        new AutoCompleteBox ( country );


        GetInTime.setValue(LocalDate.now());

        ExtraBed.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
                Child.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                                        Boolean old_val, Boolean new_val) {
                        RoomList.setItems(FXCollections.observableArrayList(Data_work.get_rooms(ExtraBed.selectedProperty().get(), Child.selectedProperty().get())));
                    }
                });
                RoomList.setItems(FXCollections.observableArrayList(Data_work.get_rooms(ExtraBed.selectedProperty().get(), Child.selectedProperty().get())));
            }
        });

        Child.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
                ExtraBed.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                                        Boolean old_val, Boolean new_val) {
                        RoomList.setItems(FXCollections.observableArrayList(Data_work.get_rooms(ExtraBed.selectedProperty().get(), Child.selectedProperty().get())));
                    }
                });
                RoomList.setItems(FXCollections.observableArrayList(Data_work.get_rooms(ExtraBed.selectedProperty().get(), Child.selectedProperty().get())));
            }
        });


        CheckBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try {
                    intime = GetInTime.getValue();
                    outtime = GetOutTime.getValue();
                    name = getName.getText();
                    passport = getPassport.getText();
                    dateofb = getDateofBirth.getValue();
                    countr = country.getValue();


                    days = (int) ChronoUnit.DAYS.between(intime, outtime);
                    System.out.println(days);
                    int Room_cost = Data_work.getCost(RoomList.getValue());
                    System.out.println(Room_cost);
                    setTextPrice.setText("Price:");
                    setTextPrice.setText(setTextPrice.getText() + Room_cost * days);
                    incorrect.setVisible(false);
                    SettleBtn.setDisable(false);

                } catch (Exception e) {
                    incorrect.setVisible(true);
                }

            }
        });

        update.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try {
                    Data_work.update_rooms();
                    RoomList.getItems().removeAll();
                    RoomList.setItems(FXCollections.observableArrayList(Data_work.get_rooms(ExtraBed.selectedProperty().get(), Child.selectedProperty().get())));

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });


        SettleBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try {
                    Data_work.addClient(name, passport, dateofb, intime, outtime, RoomList.getValue(), countr);
                    description.getChildren().clear();
                    getName.clear();
                    getPassport.clear();
                    getDateofBirth.setValue(null);
                    GetOutTime.setValue(null);
                    country.setValue(null);
                    RoomList.setItems(FXCollections.observableArrayList(Data_work.get_rooms(ExtraBed.selectedProperty().get(), Child.selectedProperty().get())));

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        EventHandler<ActionEvent> event =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        if(!(RoomList.getValue() == null)){
                        description.getChildren().clear();
                        Text d = new Text();
                        Text d1 = new Text();
                        d.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
                        d1.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");

                        d.setText(Data_work.getDescriptionS(RoomList.getValue()) + "\n");
                        d1.setText(Data_work.getDescriptionT(RoomList.getValue()));
                        description.getChildren().add(d);
                        description.getChildren().add(d1);
                        description.setTextAlignment(TextAlignment.CENTER);}
                    }
                };

        // Set on action
        RoomList.setOnAction(event);


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

        Client_list.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("receptionistClients.fxml"));
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
