package com.example.hotel_8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsCookPostTable implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<cktable, String> IDColm;

    @FXML
    private Button Logout;

    @FXML
    private AnchorPane btnDate;

    @FXML
    private TableColumn<cktable, String> hourcolomn;

    @FXML
    private TableColumn<cktable, String> namecolomn;

    @FXML
    private TableColumn<cktable, String> postcolomn;

    @FXML
    private Button povarprofile;

    @FXML
    private Button progress;

    @FXML
    private TableView<cktable> table;

    @FXML
    private Text title;


    public void table()
    {
        Connect();
        ObservableList<cktable> cktble = FXCollections.observableArrayList();
        try
        {
            pst = con.prepareStatement("select id,post,name,hour from posttable");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    cktable st = new cktable();
                    st.setId(rs.getString("id"));
                    st.setPost(rs.getString("post"));
                    st.setName(rs.getString("name"));
                    st.setHour(rs.getString("hour"));
                    cktble.add(st);
                }
            }
            table.setItems(cktble);
            IDColm.setCellValueFactory(f -> f.getValue().idProperty());
            postcolomn.setCellValueFactory(f -> f.getValue().postProperty());
            namecolomn.setCellValueFactory(f -> f.getValue().nameProperty());
            hourcolomn.setCellValueFactory(f -> f.getValue().hourProperty());



        }

        catch (SQLException ex)
        {
            Logger.getLogger(AsCookPostTable.class.getName()).log(Level.SEVERE, null, ex);
        }




    }

    public void Connect(){
        con =Data_work.conn;
    }

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setText(Data_work.name);
        Connect();
        table();

        progress.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("AsCookProgres.fxml"));
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

        povarprofile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("AsCookProfile.fxml"));
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

}}

