package com.example.hotel_8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.ResourceBundle;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.application.Platform;
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
    private Text workerscount;

    @FXML
    private Button generate;

    @FXML
    private Button profile;


    private static XYChart.Series series1 = new XYChart.Series();
    private static XYChart.Series series2 = new XYChart.Series();

    @FXML
    void initialize() {
        titlename.setText(Data_work.name);

        LocalDate last = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        if(LocalDate.now().equals(last)){
            Data_work.update_finances();
        }else{
            System.out.println("wait" + last +" " +  LocalDate.now());
        }


        update.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                series1.setName("Loss");
                series2.setName("Profit");
                finances.setAnimated(false);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        String[] monthss = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                        Date d = new Date();
                        int[] test = {4, 5, 4, 3, 23, 5, 4, 6, 8, 3, 2, 4};
                        int now = d.getMonth() + 1;
                        double point = 1.0 / 13;
                        double percent = 0;
                        for (int i = now + 1; i != now; i++) {
                            if (i == 12)
                                i = 0;
                            series2.getData().add(new XYChart.Data(monthss[i], Data_work.getProfit(monthss[i])));
                            series1.getData().add(new XYChart.Data(monthss[i], Data_work.getLoss(monthss[i])));
                            percent += point;
                        }

                        finances.getData().addAll(series1, series2);
                    }
                });




            }
        });



        Data_work.setLoss(String.valueOf(LocalDate.now().getMonth()));
        Data_work.setProfit(String.valueOf(LocalDate.now().getMonth()));

        financescount.setText(financescount.getText() + Data_work.getFinances());
        workerscount.setText(workerscount.getText() + Data_work.workers_count);

        System.out.println("date");

        System.out.println(LocalDate.now().withDayOfMonth(1));
        System.out.println(LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()));





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


        generate.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                Document document = new Document();
                try
                {
                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(".\\Documents\\AddTableExample.pdf"));
                    document.open();

                    PdfPTable table = new PdfPTable(3); // 3 columns.
                    table.setWidthPercentage(100); //Width 100%
                    table.setSpacingBefore(10f); //Space before table
                    table.setSpacingAfter(10f); //Space after table

                    //Set Column widths
                    float[] columnWidths = {1f, 1f, 1f};
                    table.setWidths(columnWidths);

                    PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
                    cell1.setBorderColor(BaseColor.BLUE);
                    cell1.setPaddingLeft(10);
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
                    cell2.setBorderColor(BaseColor.GREEN);
                    cell2.setPaddingLeft(10);
                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
                    cell3.setBorderColor(BaseColor.RED);
                    cell3.setPaddingLeft(10);
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    //To avoid having the cell border and the content overlap, if you are having thick cell borders
                    //cell1.setUserBorderPadding(true);
                    //cell2.setUserBorderPadding(true);
                    //cell3.setUserBorderPadding(true);

                    table.addCell(cell1);
                    table.addCell(cell2);
                    table.addCell(cell3);

                    document.add(table);

                    document.close();
                    writer.close();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }


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

        profile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("directorProfile.fxml"));
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
