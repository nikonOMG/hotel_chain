package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainCleanerProgressController {
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
    private Button Progress;

    @FXML
    private Button Work;

    @FXML
    private Pane calendarPane;

    @FXML
    private TableColumn<Monetary, String> date;

    @FXML
    private TableColumn<Monetary, String> description;

    @FXML
    private TableView<Monetary> monetaryFine;

    @FXML
    private TableColumn<Monetary, Integer> price;
    ObservableList<Monetary> oblist = FXCollections.observableArrayList();

    ResultSet rs;

    @FXML
    void initialize() {


        try {
            rs = Data_work.conn.createStatement().executeQuery("select * from monetary_fine where monetary_fine.WorkerID = " + Data_work.id);
            while (rs.next()) {
                oblist.add(new Monetary(rs.getDate("Date"), rs.getString("Description"), rs.getInt("Price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        description.setCellValueFactory(new PropertyValueFactory<>("des"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        monetaryFine.setItems(oblist);


        calendarPane.getChildren().add(new FullCalendarView(YearMonth.now(), Data_work.id).getView());


        Profile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("mainCleanerProfile.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add("style.css");
                stage.setScene(scene);
                stage.show();


            }
        });
        Work.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("mainCleanerWorkers.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add("style.css");
                stage.setScene(scene);
                stage.show();


            }
        });

    }
}

