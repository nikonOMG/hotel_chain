package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
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
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DirectorWorkersController {
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
    private TableColumn<Workers, String> email;

    @FXML
    private Button hotelinfo;

    @FXML
    private Button AddnewWorker;

    @FXML
    private TableView<Workers> list;

    @FXML
    private TableColumn<Workers, String> name;

    @FXML
    private TableColumn<Workers, String> passport;

    @FXML
    private TableColumn<Workers, String> post;

    @FXML
    private TableColumn<Workers, String> salary;


    @FXML
    private Button changesalary;

    @FXML
    private Button fuckoff;

    @FXML
    private TextField searchText;

    @FXML
    private Text titlename;


    @FXML
    private Button workers;

    @FXML
    private Button forfeit;



    @FXML
    private Button attendance;

    @FXML
    private Button profile;



    @FXML
    private AnchorPane back;

    ObservableList<Workers> oblist = FXCollections.observableArrayList();

    ResultSet rs;

    @FXML
    void initialize() {
        titlename.setText(Data_work.name);

        fuckoff.setVisible(false);




         new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Post != 'Director' and Post != 'Owner' and  Workers.HotelID = " + Data_work.hotelID);
                    while (rs.next()){
                        oblist.add(new Workers(rs.getInt("WorkerID"), rs.getString("Fullname"), rs.getString("Passport"), rs.getInt("Salary"), rs.getString("Post"), rs.getString("Email") ));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                post.setCellValueFactory(new PropertyValueFactory<>("post"));
                email.setCellValueFactory(new PropertyValueFactory<>("email"));


            }
        }).start();




        FilteredList<Workers> Filtered = new FilteredList<>(oblist, b -> true);
        searchText.textProperty().addListener((observable, oldValue,newValue)->{
            Filtered.setPredicate(workers -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(workers.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if(workers.getPassport().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(workers.getEmail()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(workers.getPost()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(workers.getSalary()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<Workers> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(list.comparatorProperty());
        list.setItems(sortedList);

        attendance.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

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


        forfeit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

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



        list.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("bb");

                fuckoff.setVisible(true);


            }else{
                System.out.println("ff");
                fuckoff.setVisible(false);
            }
        });

        back.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent e) {
            list.getSelectionModel().clearSelection();

            fuckoff.setVisible(false);

        }
        });


        fuckoff.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you ok with this?");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK){
                    Workers worker = list.getSelectionModel().getSelectedItem();
                    Data_work.deleteWorker(String.valueOf(worker.getId()));

                    list.getItems().removeAll();
                    list.getSelectionModel().clearSelection();
                    fuckoff.setDisable(true);
                    oblist.clear();

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Post != 'Director' and Post != 'Owner' and  Workers.HotelID = " + Data_work.hotelID);
                                while (rs.next()){
                                    oblist.add(new Workers(rs.getInt("WorkerID"), rs.getString("Fullname"), rs.getString("Passport"), rs.getInt("Salary"), rs.getString("Post"), rs.getString("Email") ));
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            name.setCellValueFactory(new PropertyValueFactory<>("name"));
                            passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                            salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                            post.setCellValueFactory(new PropertyValueFactory<>("post"));
                            email.setCellValueFactory(new PropertyValueFactory<>("email"));

                            list.setItems(oblist);
                        }
                    });



                } else {

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

        Client_list.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

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


        hotelinfo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("directorHotel.fxml"));
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























        AddnewWorker.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addnewWorker.fxml"));
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
                                    list.getItems().removeAll();
                                    list.getSelectionModel().clearSelection();
                                    fuckoff.setDisable(true);
                                    oblist.clear();

                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Post != 'Director' and Post != 'Owner' and  Workers.HotelID = " + Data_work.hotelID);
                                                while (rs.next()){
                                                    oblist.add(new Workers(rs.getInt("WorkerID"), rs.getString("Fullname"), rs.getString("Passport"), rs.getInt("Salary"), rs.getString("Post"), rs.getString("Email") ));
                                                }
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }

                                            name.setCellValueFactory(new PropertyValueFactory<>("name"));
                                            passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                                            salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                                            post.setCellValueFactory(new PropertyValueFactory<>("post"));
                                            email.setCellValueFactory(new PropertyValueFactory<>("email"));

                                            list.setItems(oblist);
                                        }
                                    }).start();
                                }
                            });
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        changesalary.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("changeSalary.fxml"));
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
                                    list.getItems().removeAll();
                                    list.getSelectionModel().clearSelection();
                                    fuckoff.setDisable(true);
                                    oblist.clear();

                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Post != 'Director' and Post != 'Owner' and  Workers.HotelID = " + Data_work.hotelID);
                                                while (rs.next()){
                                                    oblist.add(new Workers(rs.getInt("WorkerID"), rs.getString("Fullname"), rs.getString("Passport"), rs.getInt("Salary"), rs.getString("Post"), rs.getString("Email") ));
                                                }
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }

                                            name.setCellValueFactory(new PropertyValueFactory<>("name"));
                                            passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                                            salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                                            post.setCellValueFactory(new PropertyValueFactory<>("post"));
                                            email.setCellValueFactory(new PropertyValueFactory<>("email"));

                                            list.setItems(oblist);
                                        }
                                    }).start();
                                }
                            });
                        }
                    });

                } catch (IOException e) {
                    System.out.println("gggg");
                }


            }
        });

        profile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

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

    }

    }




