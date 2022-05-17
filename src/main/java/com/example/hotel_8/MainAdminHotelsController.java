package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class MainAdminHotelsController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddnewHotel;

    @FXML
    private Button Logout;

    @FXML
    private TableColumn<Hotels, String> address;

    @FXML
    private AnchorPane back;

    @FXML
    private TableColumn<Hotels, Integer> clients;

    @FXML
    private TableColumn<Hotels, Integer> finances;

    @FXML
    private Button fuckoff;

    @FXML
    private Button hotel;

    @FXML
    private Button workers1;

    @FXML
    private Button hotelist;

    @FXML
    private TableView<Hotels> list;

    @FXML
    private TableColumn<Hotels, String> name;

    @FXML
    private Button profile;

    @FXML
    private TableColumn<Hotels, Integer> rooms;

    @FXML
    private TextField searchText;

    @FXML
    private TableColumn<Hotels, Integer> stars;

    @FXML
    private Text titlename;

    @FXML
    private TableColumn<Hotels, Integer> workers;

    ObservableList<Hotels> oblist = FXCollections.observableArrayList();

    ResultSet rs;

    @FXML
    void initialize() {
        titlename.setText(Data_work.name);
        fuckoff.setDisable(true);




        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rs = Data_work.conn.createStatement().executeQuery("select * from Hotels where HotelID != 1");
                    while (rs.next()){
                        oblist.add(new Hotels(rs.getString("Name"), rs.getInt("Clients"), rs.getInt("Workers"), rs.getInt("HotelID"),  rs.getInt("Stars"), rs.getInt("Finances"), rs.getString("Address"), rs.getInt("Rooms") ));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                name.setCellValueFactory(new PropertyValueFactory<>("Name"));
                address.setCellValueFactory(new PropertyValueFactory<>("Address"));
                finances.setCellValueFactory(new PropertyValueFactory<>("Finances"));
                workers.setCellValueFactory(new PropertyValueFactory<>("Workers"));
                rooms.setCellValueFactory(new PropertyValueFactory<>("Rooms"));
                clients.setCellValueFactory(new PropertyValueFactory<>("Clients"));
                stars.setCellValueFactory(new PropertyValueFactory<>("Stars"));


            }
        }).start();




        FilteredList<Hotels> Filtered = new FilteredList<>(oblist, b -> true);
        searchText.textProperty().addListener((observable, oldValue,newValue)->{
            Filtered.setPredicate(hotels -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(hotels.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if(hotels.getAddress().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(hotels.getFinances()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(hotels.getWorkers()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(hotels.getRooms()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(hotels.getClients()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if(String.valueOf(hotels.getStars()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else
                    return false;

            });
        });
        SortedList<Hotels> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(list.comparatorProperty());
        list.setItems(sortedList);



        list.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println("bb");
                fuckoff.setDisable(false);
            }else{
                System.out.println("ff");
            }
        });

        back.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e) {
                list.getSelectionModel().clearSelection();
            fuckoff.setDisable(true);

            }
        });


        fuckoff.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("password");
                dialog.setHeaderText("Enter password for confirmation.");

                Optional<String> result = dialog.showAndWait();
                String entered = "";

                if (result.isPresent()) {

                    entered = result.get();
                }

                if(entered.trim().equals(Data_work.password)){
                    Hotels hotels = list.getSelectionModel().getSelectedItem();
                    boolean cash = Data_work.deleteHotel(hotels.getId());
                    if (cash) {
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
                                            rs = Data_work.conn.createStatement().executeQuery("select * from Hotels where HotelID != 1");
                                            while (rs.next()){
                                                oblist.add(new Hotels(rs.getString("Name"), rs.getInt("Clients"), rs.getInt("Workers"), rs.getInt("HotelID"), rs.getInt("Stars"), rs.getInt("Finances"), rs.getString("Address"), rs.getInt("Rooms") ));
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }

                                        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
                                        address.setCellValueFactory(new PropertyValueFactory<>("Address"));
                                        finances.setCellValueFactory(new PropertyValueFactory<>("Finances"));
                                        workers.setCellValueFactory(new PropertyValueFactory<>("Workers"));
                                        rooms.setCellValueFactory(new PropertyValueFactory<>("Rooms"));
                                        clients.setCellValueFactory(new PropertyValueFactory<>("Clients"));
                                        stars.setCellValueFactory(new PropertyValueFactory<>("Stars"));

                                        list.setItems(oblist);
                                    }
                                }).start();
                            }
                        });




                    }
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




        AddnewHotel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addNewHotel.fxml"));
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
                                                rs = Data_work.conn.createStatement().executeQuery("select * from Hotels where HotelID != 1");
                                                while (rs.next()){
                                                    oblist.add(new Hotels(rs.getString("Name"), rs.getInt("Clients"), rs.getInt("Workers"), rs.getInt("HotelID"), rs.getInt("Stars"), rs.getInt("Finances"), rs.getString("Address"), rs.getInt("Rooms") ));
                                                }
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }

                                            name.setCellValueFactory(new PropertyValueFactory<>("Name"));
                                            address.setCellValueFactory(new PropertyValueFactory<>("Address"));
                                            finances.setCellValueFactory(new PropertyValueFactory<>("Finances"));
                                            workers.setCellValueFactory(new PropertyValueFactory<>("Workers"));
                                            rooms.setCellValueFactory(new PropertyValueFactory<>("Rooms"));
                                            clients.setCellValueFactory(new PropertyValueFactory<>("Clients"));
                                            stars.setCellValueFactory(new PropertyValueFactory<>("Stars"));

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



        hotel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("mainAdminHotelInfo.fxml"));
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

        workers1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                try {
                    root = FXMLLoader.load(getClass().getResource("mainAdminWorkers.fxml"));
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
                    root = FXMLLoader.load(getClass().getResource("mainAdminProfile.fxml"));
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
