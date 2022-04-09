package com.example.hotel_8;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class FullCalendarView {

    private static int WorkerID;

    private ArrayList<AnchorPaneNode> allCalendarDays = new ArrayList<>(42);
    private VBox view;
    private Text calendarTitle;
    private YearMonth currentYearMonth;

    /**
     * Create a calendar view
     * @param yearMonth year month to create the calendar of
     */
    public FullCalendarView(YearMonth yearMonth) {
        currentYearMonth = yearMonth;
        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setPrefSize(450, 350);
        calendar.setGridLinesVisible(true);
        // Create rows and columns with anchor panes for the calendar
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                AnchorPaneNode ap = new AnchorPaneNode();
                ap.setPrefSize(200,69);
                calendar.add(ap,j,i);
                allCalendarDays.add(ap);
            }
        }
        // Days of the week labels
        Text[] dayNames = new Text[]{ new Text("      Sun"), new Text("      Mon"), new Text("      Tue"),
                                        new Text("      Wed"), new Text("      Thu"), new Text("      Fri"),
                                        new Text("      Sat") };
        GridPane dayLabels = new GridPane();
        dayLabels.setPrefWidth(450);
        Integer col = 0;
        for (Text txt : dayNames) {
            AnchorPane ap = new AnchorPane();
            ap.setPrefSize(200, 10);
            ap.setBottomAnchor(txt, 5.0);
            ap.getChildren().add(txt);
            dayLabels.add(ap, col++, 0);
        }
        // Create calendarTitle and buttons to change current month
        calendarTitle = new Text();
        Button previousMonth = new Button("<<");
        previousMonth.setOnAction(e -> previousMonth());
        Button nextMonth = new Button(">>");
        nextMonth.setOnAction(e -> nextMonth());
        HBox titleBar = new HBox(previousMonth, calendarTitle, nextMonth);
        titleBar.setAlignment(Pos.BASELINE_CENTER);
        // Populate calendar with the appropriate day numbers
        populateCalendar(yearMonth);
        // Create the calendar view
        view = new VBox(titleBar, dayLabels, calendar);
    }

    public FullCalendarView(YearMonth yearMonth, int id) {
        WorkerID = id;
        currentYearMonth = yearMonth;
        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setPrefSize(450, 350);
        calendar.setGridLinesVisible(true);
        // Create rows and columns with anchor panes for the calendar
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                AnchorPaneNode ap = new AnchorPaneNode();
                ap.setPrefSize(200,69);
                calendar.add(ap,j,i);
                allCalendarDays.add(ap);
            }
        }
        // Days of the week labels
        Text[] dayNames = new Text[]{ new Text("      Sun"), new Text("      Mon"), new Text("      Tue"),
                new Text("      Wed"), new Text("      Thu"), new Text("      Fri"),
                new Text("      Sat") };
        GridPane dayLabels = new GridPane();
        dayLabels.setPrefWidth(450);
        Integer col = 0;
        for (Text txt : dayNames) {
            AnchorPane ap = new AnchorPane();
            ap.setPrefSize(200, 10);
            ap.setBottomAnchor(txt, 5.0);
            ap.getChildren().add(txt);
            dayLabels.add(ap, col++, 0);
        }
        // Create calendarTitle and buttons to change current month
        calendarTitle = new Text();
        Button previousMonth = new Button("<<");
        previousMonth.setOnAction(e -> previousMonth());
        Button nextMonth = new Button(">>");
        nextMonth.setOnAction(e -> nextMonth());
        HBox titleBar = new HBox(previousMonth, calendarTitle, nextMonth);
        titleBar.setAlignment(Pos.BASELINE_CENTER);
        // Populate calendar with the appropriate day numbers
        populateCalendar(yearMonth, id);
        // Create the calendar view
        view = new VBox(titleBar, dayLabels, calendar);
    }

    public void populateCalendar(YearMonth yearMonth, int id) {
        boolean begin = false;
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        Map<String, String> days = Data_work.getMonth(yearMonth.getMonth().toString(), id);
        System.out.println(days);
        String[] m31 = {"January", "March", "May", "Juli", "August", "October", "December"};
        String[] m30 = {"April", "June", "September", "November"};
        int max = 1;
        for (AnchorPaneNode ap : allCalendarDays) {
            while (ap.getChildren().size() != 0) {
                ap.getChildren().remove(0);
            }

//            System.out.println(Data_work.getMonths(yearMonth.getMonth().toString()));
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));

            if(String.valueOf(calendarDate.getDayOfMonth()).equals("1")){
                begin = true;}


            if (days != null) {
                if (begin) {
                    int max1 = calendarDate.getDayOfMonth();
//                    System.out.println(max1 + max);
                    if(max1 >= max){
                        max = max1;
                        String color = days.get(String.valueOf(calendarDate.getDayOfMonth()));
                        if(color != null){
//                            char s = color.charAt(0);
//                            if(s == 'w' && color.length() == 1) {
                            if(color.equals("here")){
                                ap.setStyle("-fx-background-color: #ffffff");
                                txt.setStyle("-fx-font: 24 arial;");
                                txt.setText("  " + txt.getText());
                                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                                ap.setTopAnchor(txt, 5.0);
                                ap.setLeftAnchor(txt, 5.0);
                                ap.getChildren().add(txt);
                            }
                            else if(color.equals("holiday")){
                                System.out.println("holiday");
                                ap.setStyle("-fx-background-color: #43cffa");
                                txt.setStyle("-fx-font: 24 arial;");
                                txt.setText("  " + txt.getText());
                                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                                ap.setTopAnchor(txt, 5.0);
                                ap.setLeftAnchor(txt, 5.0);
                                ap.getChildren().add(txt);
                            }
//                            if(s == 'n') {
                            else if(color.equals("not here")){
                                ap.setStyle("-fx-background-color: #fd1c4d");
                                txt.setStyle("-fx-font: 24 arial;");
                                txt.setText("  " + txt.getText());
                                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                                ap.setTopAnchor(txt, 5.0);
                                ap.setLeftAnchor(txt, 5.0);
                                ap.getChildren().add(txt);
                            }
                            else if(color.equals("sick")){
                                System.out.println("sick");
                                ap.setStyle("-fx-background-color: #50ff0f");
                                txt.setStyle("-fx-font: 24 arial;");
                                txt.setText("  " + txt.getText());
                                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                                ap.setTopAnchor(txt, 5.0);
                                ap.setLeftAnchor(txt, 5.0);
                                ap.getChildren().add(txt);
                            } else{
//                            begin = false;
                                ap.setStyle("-fx-background-color: rgba(0, 100, 100, 0);");
//                                ap.setBackground(Background.EMPTY);
                                txt.setStyle("-fx-font: 24 arial;");
                                txt.setText("  " + txt.getText());
                                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                                ap.setTopAnchor(txt, 5.0);
                                ap.setLeftAnchor(txt, 5.0);
                                ap.getChildren().add(txt);
                            }

                        } else{
//                            begin = false;
//                        ap.setStyle("-fx-background-color: transpent");
//                            ap.setBackground(Background.EMPTY);
                            ap.setStyle("-fx-background-color: rgba(0, 100, 100, 0);");

                            txt.setStyle("-fx-font: 24 arial;");
                            txt.setText("  " + txt.getText());
                            ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                            ap.setTopAnchor(txt, 5.0);
                            ap.setLeftAnchor(txt, 5.0);
                            ap.getChildren().add(txt);
                        }
                    }
                    else {
                            begin = false;
                        ap.setStyle("-fx-background-color: rgba(0, 100, 100, 0);");
//                                ap.setBackground(Background.EMPTY);
                        txt.setStyle("-fx-font: 24 arial;");
                        txt.setText("  " + txt.getText());
                        ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                        ap.setTopAnchor(txt, 5.0);
                        ap.setLeftAnchor(txt, 5.0);
                        ap.getChildren().add(txt);
                    }
                } else {
//                            begin = false;
                    ap.setStyle("-fx-background-color: rgba(0, 100, 100, 0);");
//                                ap.setBackground(Background.EMPTY);
                    txt.setStyle("-fx-font: 24 arial;");
                    txt.setText("  " + txt.getText());
                    ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                    ap.setTopAnchor(txt, 5.0);
                    ap.setLeftAnchor(txt, 5.0);
                    ap.getChildren().add(txt);
                }
            }


//            if((String.valueOf(calendarDate.getDayOfMonth()).equals("31"))
//                    || (String.valueOf(calendarDate.getDayOfMonth()).equals("30")))
//                begin = false;
            if(calendarDate.getDayOfMonth() == days.size()){
                begin = false;
            }


            calendarDate = calendarDate.plusDays(1);

        }
        // Change the title of the calendar
        calendarTitle.setText(yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear()));
    }


    /**
     * Set the days of the calendar to correspond to the appropriate date
     * @param yearMonth year and month of month to render
     */
    public void populateCalendar(YearMonth yearMonth) {
        boolean begin = false;
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        Map<String, String> days = Data_work.getMonth(yearMonth.getMonth().toString());
        System.out.println(days);
        String[] m31 = {"January", "March", "May", "Juli", "August", "October", "December"};
        String[] m30 = {"April", "June", "September", "November"};
        int max = 1;
        for (AnchorPaneNode ap : allCalendarDays) {
            while (ap.getChildren().size() != 0) {
                ap.getChildren().remove(0);
            }
//            System.out.println(Data_work.getMonths(yearMonth.getMonth().toString()));
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));

            if(String.valueOf(calendarDate.getDayOfMonth()).equals("1")){
                begin = true;}


            if (days != null) {
                if (days.containsKey(String.valueOf(calendarDate.getDayOfMonth())) && begin) {
                    int max1 = calendarDate.getDayOfMonth();
                    if(max1 >= max){
                        max = max1;
                        String color = days.get(String.valueOf(calendarDate.getDayOfMonth()));
                        if(color != null){
                            char s = color.charAt(0);
                            if(s == 'w' && color.length() == 1) {
                                ap.setStyle("-fx-background-color: #ffffff");
                                txt.setStyle("-fx-font: 24 arial;");
                                txt.setText("  " + txt.getText());
                                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                                ap.setTopAnchor(txt, 5.0);
                                ap.setLeftAnchor(txt, 5.0);
                                ap.getChildren().add(txt);
                            }
                            else if(s == 'w' && color.length() > 1){
                                ap.setStyle("-fx-background-color: #ffffff;");
                                txt.setStyle("-fx-font: 24 arial;");
                                txt.setText("  " + txt.getText());
                                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                                ap.setTopAnchor(txt, 7.0);
                                ap.setLeftAnchor(txt, 7.0);
                                ap.getChildren().add(txt);
                                Text t = new Text(color.substring(2));
                                t.setStyle("-fx-font: 10 arial;");
                                ap.setTopAnchor(t, 35.0);
                                ap.setLeftAnchor(t, 5.0);
                                ap.getChildren().add(t);
                            }
                            if(s == 'h') {
                                ap.setStyle("-fx-background-color: #43cffa");
                                txt.setStyle("-fx-font: 24 arial;");
                                txt.setText("  " + txt.getText());
                                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                                ap.setTopAnchor(txt, 5.0);
                                ap.setLeftAnchor(txt, 5.0);
                                ap.getChildren().add(txt);
                            }
                            if(s == 'n') {
                                ap.setStyle("-fx-background-color: #fd1c4d");
                                txt.setStyle("-fx-font: 24 arial;");
                                txt.setText("  " + txt.getText());
                                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                                ap.setTopAnchor(txt, 5.0);
                                ap.setLeftAnchor(txt, 5.0);
                                ap.getChildren().add(txt);
                            }
                        }
                    }else{
                        begin = false;
                        ap.setStyle("-fx-background-color: transpent");
                        txt.setStyle("-fx-font: 24 arial;");
                        txt.setText("  " + txt.getText());
                        ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                        ap.setTopAnchor(txt, 5.0);
                        ap.setLeftAnchor(txt, 5.0);
                        ap.getChildren().add(txt);
                    }
                }else{
                    ap.setStyle("-fx-background-color: transpent");
                    txt.setStyle("-fx-font: 24 arial;");
                    txt.setText("  " + txt.getText());
                    ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                    ap.setTopAnchor(txt, 5.0);
                    ap.setLeftAnchor(txt, 5.0);
                    ap.getChildren().add(txt);
                }
            }
            else{
                ap.setStyle("-fx-background-color: transpent");
                txt.setStyle("-fx-font: 24 arial;");
                txt.setText("  " + txt.getText());
                ap.setDate(calendarDate);
//            ap.setStyle("-fx-background-color: #ffffff");
                ap.setTopAnchor(txt, 5.0);
                ap.setLeftAnchor(txt, 5.0);
                ap.getChildren().add(txt);
            }

            if((String.valueOf(calendarDate.getDayOfMonth()).equals("31") && Arrays.stream(m31).anyMatch(yearMonth.getMonth().toString()::equals))
            || (String.valueOf(calendarDate.getDayOfMonth()).equals("30") && Arrays.stream(m30).anyMatch(yearMonth.getMonth().toString()::equals)))
                begin = false;


            calendarDate = calendarDate.plusDays(1);

        }
        // Change the title of the calendar
        calendarTitle.setText(yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear()));
    }

    /**
     * Move the month back by one. Repopulate the calendar with the correct dates.
     */
    private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        AttendanceController.yearMonth = currentYearMonth;
        populateCalendar(currentYearMonth, WorkerID);
    }

    /**
     * Move the month forward by one. Repopulate the calendar with the correct dates.
     */
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        AttendanceController.yearMonth = currentYearMonth;
        populateCalendar(currentYearMonth, WorkerID);
    }

    public VBox getView() {
        return view;
    }

    public ArrayList<AnchorPaneNode> getAllCalendarDays() {
        return allCalendarDays;
    }

    public void setAllCalendarDays(ArrayList<AnchorPaneNode> allCalendarDays) {
        this.allCalendarDays = allCalendarDays;
    }
}
