package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DirectorHotelController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Client_list;

    @FXML
    private Button Logout;

    @FXML
    private BarChart<String, Number> clients;

    @FXML
    private LineChart<String, Number> finances;

    @FXML
    private Text financescount;

    @FXML
    private Button hotelinfo;

    @FXML
    private Text titlename;

    @FXML
    private Button workerinfo;

    @FXML
    private Button workers;

    @FXML
    private Button update;


    @FXML
    private ProgressBar financesload;

    @FXML
    private Text workerscount;

    @FXML
    private Button profile;


    private static XYChart.Series series1 = new XYChart.Series();
    private static XYChart.Series series2 = new XYChart.Series();

    @FXML
    void initialize() {

        financesload.setVisible(false);

        update.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                financesload.setVisible(true);
                series1.setName("Loss");
                series2.setName("Profit");
                finances.setAnimated(false);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        String[] monthss = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                        Date d = new Date();
                        int[] test = {4, 5, 4, 3, 23, 5, 4, 6, 8, 3, 2, 4};
                        int now = d.getMonth();
                        double point = 1.0 / 13;
                        double percent = 0;
                        for (int i = now + 1; i != now; i++) {
                            if (i == 12)
                                i = 0;
                            series2.getData().add(new XYChart.Data(monthss[i], Data_work.getProfit(monthss[i])));
                            series1.getData().add(new XYChart.Data(monthss[i], Data_work.getLoss(monthss[i])));
                            percent += point;
                            financesload.setProgress(percent);
                        }

                        finances.getData().addAll(series1, series2);
                        financesload.setVisible(false);
                    }
                });




            }
        });



        financescount.setText(financescount.getText() + Data_work.finances);
        workerscount.setText(workerscount.getText() + Data_work.workers_count);






        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
        dataSeries1.setName("Rooms");

        XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<String, Number>();
        dataSeries2.setName("Clients");


        dataSeries1.getData().add(new XYChart.Data<String, Number>("", Data_work.getCountRooms()));
        // Series 2 - Data of 2015
        dataSeries2.getData().add(new XYChart.Data<String, Number>("", Data_work.getCountClients()));


        clients.getData().add(dataSeries1);
        clients.getData().add(dataSeries2);



        workers.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("directorWorkers.fxml"));
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

//        workerinfo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent event) {
////                                    SignInBut.getScene().getWindow().hide();
//                try {
//                    root = FXMLLoader.load(getClass().getResource("adminWorkerInfo.fxml"));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                scene.getStylesheets().add("style.css");
//                stage.setScene(scene);
//                stage.show();
//
//
//            }
//        });

        Client_list.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("directorClients.fxml"));
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
