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

//        LocalDate last = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
//        if(LocalDate.now().equals(last)){
//            Data_work.update_finances();
//        }else{
//            System.out.println("wait" + last +" " +  LocalDate.now());
//        }


        update.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                financescount.setText("Finances: " + Data_work.getFinances());
                finances.getData().clear();
//                finances.setAnimated(true);
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



//        Data_work.setLoss(String.valueOf(LocalDate.now().getMonth()));
//        Data_work.setProfit(String.valueOf(LocalDate.now().getMonth()));

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
//                                    SignInBut.getScene().getWindow().hide();
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


        // в будущем отчеты
//        generate.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent event) {
////                                    SignInBut.getScene().getWindow().hide();
//                Document document = new Document();
//                try
//                {
//                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(".\\Documents\\AddTableExample.pdf"));
//                    document.open();
//
//                    PdfPTable table = new PdfPTable(3); // 3 columns.
//                    table.setWidthPercentage(100); //Width 100%
//                    table.setSpacingBefore(10f); //Space before table
//                    table.setSpacingAfter(10f); //Space after table
//
//                    //Set Column widths
//                    float[] columnWidths = {1f, 1f, 1f};
//                    table.setWidths(columnWidths);
//
//                    PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
//                    cell1.setBorderColor(BaseColor.BLUE);
//                    cell1.setPaddingLeft(10);
//                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//                    PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
//                    cell2.setBorderColor(BaseColor.GREEN);
//                    cell2.setPaddingLeft(10);
//                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//                    PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
//                    cell3.setBorderColor(BaseColor.RED);
//                    cell3.setPaddingLeft(10);
//                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//                    //To avoid having the cell border and the content overlap, if you are having thick cell borders
//                    //cell1.setUserBorderPadding(true);
//                    //cell2.setUserBorderPadding(true);
//                    //cell3.setUserBorderPadding(true);
//
//                    table.addCell(cell1);
//                    table.addCell(cell2);
//                    table.addCell(cell3);
//
//                    document.add(table);
//
//                    document.close();
//                    writer.close();
//                } catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//
//
//            }
//        });


        Client_list.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
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
//                                    SignInBut.getScene().getWindow().hide();
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
//                                    SignInBut.getScene().getWindow().hide();
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
