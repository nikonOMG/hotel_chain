package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainCleanerWorkersController {
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
    private Button Profile;

    @FXML
    private Button Progress;

    @FXML
    private Button Work;

    @FXML
    private Button addwork;

    @FXML
    private Button forfeit;

    @FXML
    private Button attendance;

    @FXML
    private TableColumn<Cleaner, String> description;

    @FXML
    private TableColumn<Cleaner, String> end;

    @FXML
    private TableColumn<Cleaner, String> worker;

    @FXML
    private Button fuckoff;

    @FXML
    private TableView<Cleaner> list;

    @FXML
    private TextField searchText;

    @FXML
    private AnchorPane back;

    @FXML
    private TableColumn<Cleaner, String> start;

    ObservableList<Cleaner> oblist = FXCollections.observableArrayList();

    ResultSet rs;
    ResultSet rs1;

    @FXML
    void initialize() {
        fuckoff.setDisable(true);


        try {
            Date date = Date.valueOf(LocalDate.now());
            rs = Data_work.conn.createStatement().executeQuery("select * from Cleaners where HotelID = " + Data_work.hotelID);
            while (rs.next()){

                rs1 = Data_work.conn.createStatement().executeQuery("select Fullname from Workers where WorkerID = " + rs.getInt("WorkerID"));
                rs1.next();
                oblist.add(new Cleaner(rs.getDate("Start"), rs.getDate("End"), rs.getString("Description"),rs.getInt("id"), rs1.getString("FullName") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        start.setCellValueFactory(new PropertyValueFactory<>("Start"));
        end.setCellValueFactory(new PropertyValueFactory<>("End"));
        description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        worker.setCellValueFactory(new PropertyValueFactory<>("name"));

        list.setItems(oblist);

        list.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("bb");
                fuckoff.setDisable(false);
//                changesalary.setDisable(false);
//                list.getSelectionModel().clearSelection();
            }else{
                System.out.println("ff");
                fuckoff.setDisable(true);
            }
        });

        back.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                list.getSelectionModel().clearSelection();
            fuckoff.setDisable(true);
//                fuckoff.setVisible(false);
//            changesalary.setDisable(true);
            }
        });







        Profile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("mainCleanerProfile.fxml"));
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

        attendance.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("attendance.fxml"));
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



        Progress.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("mainCleanerProgress.fxml"));
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

        FilteredList<Cleaner> Filtered = new FilteredList<>(oblist, b -> true);
        searchText.textProperty().addListener((observable, oldValue,newValue)->{
            Filtered.setPredicate(cleaner -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(String.valueOf(cleaner.getStart()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(cleaner.getEnd()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if(cleaner.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;

                }else if(cleaner.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                return true;

            }else
                    return false;

            });
        });
        SortedList<Cleaner> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(list.comparatorProperty());
        list.setItems(sortedList);

        forfeit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("forfeit.fxml"));
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


        addwork.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addWork.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    Scene scen = new Scene(root1);
                    stage.setTitle("ABC");
                    scen.getStylesheets().add("style.css");
                    stage.setScene(scen);
                    stage.show();


                    stage.setOnHiding(new EventHandler<WindowEvent>() {

                        @Override
                        public void handle(WindowEvent event) {
                            Platform.runLater(new Runnable() {

                                @Override
                                public void run() {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            list.getItems().removeAll();
                                            list.getSelectionModel().clearSelection();
                                            fuckoff.setDisable(true);
                                            oblist.clear();

                                            try {
                                                Date date = Date.valueOf(LocalDate.now());
                                                rs = Data_work.conn.createStatement().executeQuery("select * from Cleaners where HotelID = " + Data_work.hotelID);
                                                while (rs.next()){

                                                    rs1 = Data_work.conn.createStatement().executeQuery("select Fullname from Workers where WorkerID = " + rs.getInt("WorkerID"));
                                                    rs1.next();
                                                    oblist.add(new Cleaner(rs.getDate("Start"), rs.getDate("End"), rs.getString("Description"),rs.getInt("id"), rs1.getString("FullName") ));
                                                }
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }

                                            start.setCellValueFactory(new PropertyValueFactory<>("Start"));
                                            end.setCellValueFactory(new PropertyValueFactory<>("End"));
                                            description.setCellValueFactory(new PropertyValueFactory<>("Description"));
                                            worker.setCellValueFactory(new PropertyValueFactory<>("name"));

                                            list.setItems(oblist);
                                        }
                                    });
                                }
                            });
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        fuckoff.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK){
                    Cleaner cleaner = list.getSelectionModel().getSelectedItem();
                    System.out.println(cleaner.getId());
                    Data_work.deleteCleaners(String.valueOf(cleaner.getId()));

                    list.getItems().removeAll();
                    list.getSelectionModel().clearSelection();
                    fuckoff.setDisable(true);
                    oblist.clear();

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Date date = Date.valueOf(LocalDate.now());
                                rs = Data_work.conn.createStatement().executeQuery("select * from Cleaners where HotelID = " + Data_work.hotelID);
                                while (rs.next()){

                                    rs1 = Data_work.conn.createStatement().executeQuery("select Fullname from Workers where WorkerID = " + rs.getInt("WorkerID"));
                                    rs1.next();
                                    oblist.add(new Cleaner(rs.getDate("Start"), rs.getDate("End"), rs.getString("Description"),rs.getInt("id"), rs1.getString("FullName") ));
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            start.setCellValueFactory(new PropertyValueFactory<>("Start"));
                            end.setCellValueFactory(new PropertyValueFactory<>("End"));
                            description.setCellValueFactory(new PropertyValueFactory<>("Description"));
                            worker.setCellValueFactory(new PropertyValueFactory<>("name"));

                            list.setItems(oblist);
                        }
                    });


//                    workerlist.setItems(FXCollections.observableArrayList(Data_work.getWorkers()));
                } else {
                    // ... user chose CANCEL or closed the dialog
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
