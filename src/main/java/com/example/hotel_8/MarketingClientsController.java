package com.example.hotel_8;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MarketingClientsController {
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
    private Button profile;

    @FXML
    private TextField searchText;

    @FXML
    private Text titlename1;

    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

    ObservableList<Countries> oblist = FXCollections.observableArrayList();
    ResultSet rs;


    @FXML
    void initialize() {


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

//                list.setItems(oblist);
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


        for (Map.Entry<String, Integer> entry : con.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }


        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " amount: ", data.pieValueProperty()
                        )
                )
        );

        pie.getData().addAll(pieChartData);










    }

}
