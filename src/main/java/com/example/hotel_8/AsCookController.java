package com.example.hotel_8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;

public class AsCookController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button foodtable;

    @FXML
    private Label lbDate;

    @FXML
    private Pane calendarPane;

    @FXML
    private Button povarprofile;

    @FXML
    private Button FINE;

    @FXML
    private TableColumn<Monetary, String> date;

    @FXML
    private TableColumn<Monetary, String> description;

    @FXML
    private TableView<Monetary> monetaryFine;

    @FXML
    private TableColumn<Monetary, Integer> price;

    @FXML
    private Button Logout;

    @FXML
    private Text title;

    ObservableList<Monetary> oblist = FXCollections.observableArrayList();

    ResultSet rs;



    @FXML
    void initialize() {
        title.setText(Data_work.name);

        try {
            String query = "select * from monetary_fine where month(Date) =  '" + LocalDate.now().getMonth().getValue() +"'   and monetary_fine.WorkerID = " + Data_work.id;
            System.out.println(query);
            rs = Data_work.conn.createStatement().executeQuery(query);
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
        Label empty = new Label("You are the best employee!\n :)");
        empty.setFont(new Font("VAG.ttf", 30));
        monetaryFine.setPlaceholder(empty);



        calendarPane.getChildren().add(new FullCalendarView(YearMonth.now(), Data_work.id).getView());

        /*povarprofile.setOnAction(event -> {
            povarprofile.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("povar13.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        foodtable.setOnAction(event -> {
            foodtable.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("povar12.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });*/



        foodtable.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("AsCookTable.fxml"));
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

        povarprofile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("AsCookProfile.fxml"));
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


    }




}
