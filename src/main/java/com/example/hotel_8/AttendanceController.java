package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AttendanceController {
    public static YearMonth yearMonth = YearMonth.now();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker attendance;

    @FXML
    private Text atttext;

    @FXML
    private Pane calendarPane;

    @FXML
    private RadioButton here;

    @FXML
    private RadioButton nothere;

    @FXML
    private Button saveatt;

    @FXML
    private RadioButton sick;

    @FXML
    private RadioButton holiday;

    @FXML
    private ComboBox<String> workerlist;

    @FXML
    private Button next;

    @FXML
    private Button prev;

    @FXML
    void initialize() {
        workerlist.setVisibleRowCount(5);
        workerlist.setItems(FXCollections.observableArrayList(Data_work.getWorkers()));

        final ToggleGroup group = new ToggleGroup();
        here.setToggleGroup(group);
        here.setSelected(true);
        nothere.setToggleGroup(group);
        sick.setToggleGroup(group);
        holiday.setToggleGroup(group);


        attendance.setValue(LocalDate.now());
        workerlist.getSelectionModel().selectFirst();
        calendarPane.getChildren().add(new FullCalendarView(YearMonth.now(), Integer.parseInt(workerlist.getValue().split(" ")[0])).getView());


        workerlist.setOnAction(event -> {
            calendarPane.getChildren().clear();
            System.out.println("idd" + Integer.parseInt(workerlist.getValue().split(" ")[0]));

            calendarPane.getChildren().add(new FullCalendarView(YearMonth.now(), Integer.parseInt(workerlist.getValue().split(" ")[0])).getView());
        });


        saveatt.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try{

                    Data_work.update_attendance(Integer.parseInt(workerlist.getValue().split(" ")[0]), Date.valueOf(attendance.getValue()), ((RadioButton) group.getSelectedToggle()).getText());
                    calendarPane.getChildren().clear();
                    System.out.println("idd" + Integer.parseInt(workerlist.getValue().split(" ")[0]));
                    calendarPane.getChildren().add(new FullCalendarView(yearMonth, Integer.parseInt(workerlist.getValue().split(" ")[0])).getView());
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });

        prev.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                attendance.setValue(attendance.getValue().minusDays(1));


            }
        });

        next.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                attendance.setValue(attendance.getValue().plusDays(1));


            }
        });
    }

}
