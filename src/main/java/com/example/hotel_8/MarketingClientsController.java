package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.animation.FadeTransition;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MarketingClientsController implements Initializable {
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
    private Button clients;

    @FXML
    private Button hotels;

    @FXML
    private TableView<Countries> list;

    @FXML
    private TableColumn<Clients, Integer> counryclients;

    @FXML
    private TableColumn<Clients, String> countryname;


    @FXML
    private PieChart pie;

    @FXML
    private TextField textField;

    @FXML
    private Button profile;

    @FXML
    private TextField searchText;

    @FXML
    private Text titlename1;

    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

    ObservableList<Countries> oblist = FXCollections.observableArrayList();
    ResultSet rs;


    private void resetTextField() {
        FadeTransition ft = new FadeTransition(
                Duration.millis(1000), textField);
        ft.setToValue(0.0);
        ft.playFromStart();
        ft.setOnFinished(event -> {
            textField.setTranslateX(0);
            textField.setTranslateY(0);
        });
    }

    private void setupAnimation() {
        pieChartData.stream().forEach(pieData -> {
            pieData.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {

                if(event.isPrimaryButtonDown()) {
                    textField.setTranslateX(event.getSceneX() - textField.getLayoutX());
                    textField.setTranslateY(event.getSceneY() - textField.getLayoutY());
                    textField.setText(String.valueOf(pieData.getPieValue()));
                    textField.setOpacity(1.0);
                } else{
                    resetTextField();
                }

            });
        });
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rs = Data_work.conn.createStatement().executeQuery("select * from Countries where clients != 0");
                    while (rs.next()){
                        oblist.add(new Countries(rs.getString("name"), rs.getInt("clients")));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                countryname.setCellValueFactory(new PropertyValueFactory<>("name"));
                counryclients.setCellValueFactory(new PropertyValueFactory<>("clients"));


            }
        }).start();


        FilteredList<Countries> Filtered = new FilteredList<>(oblist, b -> true);
        searchText.textProperty().addListener((observable, oldValue,newValue)->{
            Filtered.setPredicate(countries -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(countries.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if(String.valueOf(countries.getClients()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else
                    return false;

            });
        });
        SortedList<Countries> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(list.comparatorProperty());
        list.setItems(sortedList);




        Map<String, Integer> con = Data_work.getCountry();

        con.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> pieChartData.add(new PieChart.Data(k.getKey(), k.getValue())));

















        pie.setData(pieChartData);
        pie.setTitle("Clients");
        textField.setEditable(false);
        setupAnimation();

        hotels.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("marketingHotels.fxml"));
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

                try {
                    root = FXMLLoader.load(getClass().getResource("marketingProfile.fxml"));
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
