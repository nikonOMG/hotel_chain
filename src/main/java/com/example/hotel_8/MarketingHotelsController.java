package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.application.Platform;
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
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MarketingHotelsController {
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
    private TableColumn<Hotels, Integer> counryclients;

    @FXML
    final NumberAxis xAxis = new NumberAxis();
    @FXML
    final CategoryAxis yAxis = new CategoryAxis();
    @FXML
    private BarChart<Number, String> hotelchart = new BarChart<Number, String>(xAxis,yAxis);

    @FXML
    private TableColumn<Hotels, String> hotelname;

    @FXML
    private Button hotels;

    @FXML
    private TableView<Hotels> list;



    @FXML
    private Button profile;

    @FXML
    private TextField searchText;

    @FXML
    private Text titlename;


    ObservableList<Hotels> oblist = FXCollections.observableArrayList();
    ResultSet rs;

    private void setMaxBarWidth(double maxBarWidth, double minCategoryGap){
        double barWidth=0;
        do{
            double catSpace = yAxis.getCategorySpacing();
            double avilableBarSpace = catSpace - (hotelchart.getCategoryGap() + hotelchart.getBarGap());
            barWidth = (avilableBarSpace / hotelchart.getData().size()) - hotelchart.getBarGap();
            if (barWidth >maxBarWidth){
                avilableBarSpace=(maxBarWidth + hotelchart.getBarGap())* hotelchart.getData().size();
                hotelchart.setCategoryGap(catSpace-avilableBarSpace-hotelchart.getBarGap());
            }
        } while(barWidth>maxBarWidth);

        do{
            double catSpace = yAxis.getCategorySpacing();
            double avilableBarSpace = catSpace - (minCategoryGap + hotelchart.getBarGap());
            barWidth = Math.min(maxBarWidth, (avilableBarSpace / hotelchart.getData().size()) - hotelchart.getBarGap());
            avilableBarSpace=(barWidth + hotelchart.getBarGap())* hotelchart.getData().size();
            hotelchart.setCategoryGap(catSpace-avilableBarSpace-hotelchart.getBarGap());
        } while(barWidth < maxBarWidth && hotelchart.getCategoryGap()>minCategoryGap);
    }

    @FXML
    void initialize() {




        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rs = Data_work.conn.createStatement().executeQuery("select * from Hotels where HotelID != 0");
                    while (rs.next()){
                        oblist.add(new Hotels(rs.getString("Name"), rs.getInt("Clients")));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                hotelname.setCellValueFactory(new PropertyValueFactory<>("name"));
                counryclients.setCellValueFactory(new PropertyValueFactory<>("clients"));

//                list.setItems(oblist);
            }
        }).start();


        FilteredList<Hotels> Filtered = new FilteredList<>(oblist, b -> true);
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
        SortedList<Hotels> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(list.comparatorProperty());
        list.setItems(sortedList);


        Map<String, int[]> con = Data_work.getHotels_chart();





        xAxis.setLabel("Client");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Hotel");

        XYChart.Series<Number, String> dataSeries1 = new XYChart.Series<Number, String>();
        dataSeries1.setName("Rooms");


        XYChart.Series<Number, String> dataSeries2 = new XYChart.Series<Number, String>();
        dataSeries2.setName("Clients");

        XYChart.Series<Number, String> dataSeries3 = new XYChart.Series<Number, String>();
        dataSeries3.setName("Workers");

        con.entrySet().stream()
                .sorted((k1, k2) -> -k2.getKey().compareTo(k1.getKey()))
                .forEach(k -> {
                    dataSeries1.getData().add(new XYChart.Data<Number, String>(k.getValue()[0], k.getKey()));
                    dataSeries2.getData().add(new XYChart.Data<Number, String>(k.getValue()[1], k.getKey()));
                    dataSeries3.getData().add(new XYChart.Data<Number, String>(k.getValue()[2], k.getKey()));
                });






        hotelchart.getData().add(dataSeries1);
        hotelchart.getData().add(dataSeries2);
        hotelchart.getData().add(dataSeries3);


        hotelchart.widthProperty().addListener((obs,b,b1)->{
            Platform.runLater(()->setMaxBarWidth(40, 5));
        });



        clients.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("marketingClients.fxml"));
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
