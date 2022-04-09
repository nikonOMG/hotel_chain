package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Button search;

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
    private Button attendance;

    @FXML
    private Button profile;

    private BooleanBinding gt600;

    @FXML
    private AnchorPane back;

    ObservableList<Workers> oblist = FXCollections.observableArrayList();

    ResultSet rs;

    @FXML
    void initialize() {
        fuckoff.setDisable(true);
//        changesalary.setDisable(true);



        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if(searchText.getText().equals(""))
                        rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.HotelID = " + Data_work.hotelID);
                    else
                        rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.Fullname = '" + searchText.getText() + "' and Workers.HotelID = " + Data_work.hotelID);
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

        search.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                list.getItems().clear();
//                                    SignInBut.getScene().getWindow().hide();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if(searchText.getText().equals(""))
                                rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.HotelID = " + Data_work.hotelID);
                            else
                                rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.Fullname = '" + searchText.getText() + "' and Workers.HotelID = " + Data_work.hotelID);
                            while(rs.next()){
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

        attendance.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("attendance.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("ABC");
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });



        list.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("bb");
                fuckoff.setDisable(false);
//                changesalary.setDisable(false);
//                list.getSelectionModel().clearSelection();
            }else{
                System.out.println("ff");
            }
        });

        back.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent e) {
            list.getSelectionModel().clearSelection();
            fuckoff.setDisable(true);
//            changesalary.setDisable(true);
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
                    Workers worker = list.getSelectionModel().getSelectedItem();
                    Data_work.deleteWorker(String.valueOf(worker.getId()));

                    list.getItems().clear();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if(searchText.getText().equals(""))
                                    rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.HotelID = " + Data_work.hotelID);
                                else
                                    rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.Fullname = '" + searchText.getText() + "' and Workers.HotelID = " + Data_work.hotelID);
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


        hotelinfo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
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


        AddnewWorker.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addnewWorker.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("ABC");
                    stage.setScene(new Scene(root1));
                    stage.show();

                    stage.setOnHiding(new EventHandler<WindowEvent>() {

                        @Override
                        public void handle(WindowEvent event) {
                            Platform.runLater(new Runnable() {

                                @Override
                                public void run() {
                                    list.getItems().clear();

                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                if(searchText.getText().equals(""))
                                                    rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.HotelID = " + Data_work.hotelID);
                                                else
                                                    rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.Fullname = '" + searchText.getText() + "' and Workers.HotelID = " + Data_work.hotelID);
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
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("changeSalary.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("ABC");
                    stage.setScene(new Scene(root1));
                    stage.show();

                    stage.setOnHiding(new EventHandler<WindowEvent>() {

                        @Override
                        public void handle(WindowEvent event) {
                            Platform.runLater(new Runnable() {

                                @Override
                                public void run() {
                                    list.getItems().clear();

                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                if(searchText.getText().equals(""))
                                                    rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.HotelID = " + Data_work.hotelID);
                                                else
                                                    rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Workers.Fullname = '" + searchText.getText() + "' and Workers.HotelID = " + Data_work.hotelID);
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

    }

    }




