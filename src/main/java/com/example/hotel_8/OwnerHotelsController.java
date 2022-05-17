package com.example.hotel_8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class OwnerHotelsController {
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
    private LineChart<String, Number> finances;

    @FXML
    private Text financescount;

    @FXML
    private Text clientscount;

    @FXML
    private Text roomcount;

    @FXML
    private Button hotelinfo;

    @FXML
    private Text titlename;


    @FXML
    private Button workers;

    @FXML
    private Button withdraw;

    @FXML
    private Button update;



    @FXML
    private Text workerscount;

    @FXML
    private Button generate;


    @FXML
    private Button profile;



    private static XYChart.Series<String, Number> series1 = new XYChart.Series();
    private static XYChart.Series<String, Number> series2 = new XYChart.Series();





    @FXML
    void initialize() {
        titlename.setText(Data_work.name);









        update.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                financescount.setText("Finances: " + Data_work.getFinances());
                finances.getData().clear();

                series1.getData().clear();
                series2.getData().clear();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        String[] monthss = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                        HashMap<String, Integer> profit = Data_work.getProfitOwner();
                        System.out.println("gg" + profit);
                        HashMap<String, Integer> loss = Data_work.getLossOwner();
                        Date d = new Date();
                        int now = d.getMonth() + 1;
                        double point = 1.0 / 13;
                        double percent = 0;
                        for (int i = now + 1; i != now; i++) {
                            if (i == 12)
                                i = 0;
                            var data1 = new XYChart.Data<String, Number>(monthss[i], profit.get(monthss[i]));
                            data1.setNode(new HoveredThresholdNodea(monthss[i], profit.get(monthss[i])));
                            var data2 = new XYChart.Data<String, Number>(monthss[i], loss.get(monthss[i]));
                            data2.setNode(new HoveredThresholdNodea(monthss[i], loss.get(monthss[i])));
                            series2.getData().add(data1);
                            series1.getData().add(data2);
                            percent += point;
                        }

                        finances.getData().addAll(series1, series2);
                    }
                });




            }
        });


        series1.setName("Loss");
        series2.setName("Profit");
        finances.setAnimated(false);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String[] monthss = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                HashMap<String, Integer> profit = Data_work.getProfitOwner();
                System.out.println("gg" + profit);
                HashMap<String, Integer> loss = Data_work.getLossOwner();
                Date d = new Date();
                int now = d.getMonth() + 1;
                double point = 1.0 / 13;
                double percent = 0;
                for (int i = now + 1; i != now; i++) {
                    if (i == 12)
                        i = 0;
                    var data1 = new XYChart.Data<String, Number>(monthss[i], profit.get(monthss[i]));
                    data1.setNode(new HoveredThresholdNodea(monthss[i], profit.get(monthss[i])));
                    var data2 = new XYChart.Data<String, Number>(monthss[i], loss.get(monthss[i]));
                    data2.setNode(new HoveredThresholdNodea(monthss[i], loss.get(monthss[i])));
                    series2.getData().add(data1);
                    series1.getData().add(data2);
                    percent += point;
                }

                finances.getData().addAll(series1, series2);
            }
        });






        financescount.setText(financescount.getText() + Data_work.getFinances());
        workerscount.setText(workerscount.getText() + " " + Data_work.getCountWorkers());
        roomcount.setText(roomcount.getText() + Data_work.getCountRoomsOwner());
        clientscount.setText(clientscount.getText() + Data_work.getCountClientsOwner());

        System.out.println("date");

        System.out.println(LocalDate.now().withDayOfMonth(1));
        System.out.println(LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()));










        workers.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("ownerWorkers.fxml"));
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

                try {
                    root = FXMLLoader.load(getClass().getResource("ownerClients.fxml"));
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
                    root = FXMLLoader.load(getClass().getResource("ownerProfile.fxml"));
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


        withdraw.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("withdrawMoney.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    Scene scen = new Scene(root1);
                    stage.setTitle("ABC");
                    scen.getStylesheets().add("style.css");
                    stage.setScene(scen);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


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
