package com.example.hotel_8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AdminHotelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Logout;

    @FXML
    private Button addroom;

    @FXML
    private Spinner<?> finances;

    @FXML
    private TextField hoteladdress;

    @FXML
    private Button hotelinfo;

    @FXML
    private TextField hotelname;

    @FXML
    private Button profile;

    @FXML
    private Text roomtext;

    @FXML
    private Button save;

    @FXML
    private Spinner<?> stars;

    @FXML
    private Text titlename;

    @FXML
    private Button workerinfo;

    @FXML
    private Button workers;

    @FXML
    private Text workerscount;

    @FXML
    void initialize() {

    }

}
