package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Locale;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class OwnerWorkersController {
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
    private AnchorPane back;

    @FXML
    private Button changesalary;

    @FXML
    private TableColumn<Workers, String> email;

    @FXML
    private Button forfeit;

    @FXML
    private Button fuckoff;

    @FXML
    private TableColumn<Workers, String> hotel;

    @FXML
    private Button hotelinfo;

    @FXML
    private TableView<Workers> list;

    @FXML
    private TableColumn<Workers, String> name;

    @FXML
    private TableColumn<Workers, String> passport;

    @FXML
    private TableColumn<Workers, String> post;

    @FXML
    private Button profile;

    @FXML
    private TableColumn<Workers, Integer> salary;

    @FXML
    private TextField searchText;

    @FXML
    private Text titlename;

    @FXML
    private Button workers;

    ObservableList<Workers> oblist = FXCollections.observableArrayList();

    ResultSet rs;
    ResultSet rs1;



    @FXML
    void initialize() {

        titlename.setText(Data_work.name);
//        fuckoff.setDisable(true);
        fuckoff.setVisible(false);
//        changesalary.setDisable(true);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Post != 'Owner'");
                    while (rs.next()){

                        String query = "select Name from Hotels WHERE HotelID = " + rs.getInt("HotelID");
                        rs1 = Data_work.conn.createStatement().executeQuery(query);
                        rs1.next();






                        oblist.add(new Workers(rs.getInt("WorkerID"), rs.getString("Fullname"), rs.getString("Passport"), rs.getInt("Salary"), rs.getString("Post"), rs.getString("Email"), rs1.getString("Name")) );

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                post.setCellValueFactory(new PropertyValueFactory<>("post"));
                email.setCellValueFactory(new PropertyValueFactory<>("email"));
                hotel.setCellValueFactory(new PropertyValueFactory<>("Hotel"));

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
                        }else if(workers.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1){
                            return true;
                        }else if(workers.getPost().toLowerCase().indexOf(lowerCaseFilter) != -1){
                            return true;
                        }else if(String.valueOf(workers.getSalary()).indexOf(lowerCaseFilter) != -1){
                            return true;
                        }else if(workers.getHotel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                            return true;
                        }else
                            return false;

                    });
                });
                SortedList<Workers> sortedList = new SortedList<>(Filtered);
                sortedList.comparatorProperty().bind(list.comparatorProperty());
                list.setItems(sortedList);

            }
        }).start();

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


        list.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("bb");
//                fuckoff.setDisable(false);
                fuckoff.setVisible(true);
//                changesalary.setDisable(false);
//                list.getSelectionModel().clearSelection();
            }else{
                System.out.println("ff");
                fuckoff.setVisible(false);
            }
        });

        back.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                list.getSelectionModel().clearSelection();
//            fuckoff.setDisable(true);
                fuckoff.setVisible(false);
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

                    list.getItems().removeAll();
                    list.getSelectionModel().clearSelection();
                    fuckoff.setDisable(true);
                    oblist.clear();

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Post != 'Owner'");
                                while (rs.next()){

                                    String query = "select Name from Hotels WHERE HotelID = " + rs.getInt("HotelID");
                                    rs1 = Data_work.conn.createStatement().executeQuery(query);
                                    rs1.next();






                                    oblist.add(new Workers(rs.getInt("WorkerID"), rs.getString("Fullname"), rs.getString("Passport"), rs.getInt("Salary"), rs.getString("Post"), rs.getString("Email"), rs1.getString("Name")) );

                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }


                            name.setCellValueFactory(new PropertyValueFactory<>("name"));
                            passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                            salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                            post.setCellValueFactory(new PropertyValueFactory<>("post"));
                            email.setCellValueFactory(new PropertyValueFactory<>("email"));
                            hotel.setCellValueFactory(new PropertyValueFactory<>("Hotel"));

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
                                    }else if(workers.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1){
                                        return true;
                                    }else if(workers.getPost().toLowerCase().indexOf(lowerCaseFilter) != -1){
                                        return true;
                                    }else if(String.valueOf(workers.getSalary()).indexOf(lowerCaseFilter) != -1){
                                        return true;
                                    }else if(workers.getHotel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                                        return true;
                                    }else
                                        return false;

                                });
                            });
                            SortedList<Workers> sortedList = new SortedList<>(Filtered);
                            sortedList.comparatorProperty().bind(list.comparatorProperty());
                            list.setItems(sortedList);

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


        hotelinfo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("ownerHotels.fxml"));
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







        changesalary.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
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
                                                rs = Data_work.conn.createStatement().executeQuery("select * from Workers where Post != 'Owner'");
                                                while (rs.next()){

                                                    String query = "select Name from Hotels WHERE HotelID = " + rs.getInt("HotelID");
                                                    rs1 = Data_work.conn.createStatement().executeQuery(query);
                                                    rs1.next();






                                                    oblist.add(new Workers(rs.getInt("WorkerID"), rs.getString("Fullname"), rs.getString("Passport"), rs.getInt("Salary"), rs.getString("Post"), rs.getString("Email"), rs1.getString("Name")) );

                                                }
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }


                                            name.setCellValueFactory(new PropertyValueFactory<>("name"));
                                            passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
                                            salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
                                            post.setCellValueFactory(new PropertyValueFactory<>("post"));
                                            email.setCellValueFactory(new PropertyValueFactory<>("email"));
                                            hotel.setCellValueFactory(new PropertyValueFactory<>("Hotel"));

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
                                                    }else if(workers.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1){
                                                        return true;
                                                    }else if(workers.getPost().toLowerCase().indexOf(lowerCaseFilter) != -1){
                                                        return true;
                                                    }else if(String.valueOf(workers.getSalary()).indexOf(lowerCaseFilter) != -1){
                                                        return true;
                                                    }else if(workers.getHotel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                                                        return true;
                                                    }else
                                                        return false;

                                                });
                                            });
                                            SortedList<Workers> sortedList = new SortedList<>(Filtered);
                                            sortedList.comparatorProperty().bind(list.comparatorProperty());
                                            list.setItems(sortedList);

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







    }

}
