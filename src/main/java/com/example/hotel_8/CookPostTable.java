package com.example.hotel_8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class CookPostTable implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<cktable, String> IDColm;

    @FXML
    private AnchorPane btnDate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnadd;

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

    @FXML
    private ComboBox<String> txtHour;

    @FXML
    private TextField txtName;

    @FXML
    private ComboBox<String> txtPost;

    @FXML
    private Button Logout;

    @FXML
    void Add(ActionEvent event) {
        String post,stname,hour;
        post = txtPost.getValue();
        stname = txtName.getText();
        hour = txtHour.getValue();
        try
        {
            pst = con.prepareStatement("insert into posttable(post,name,hour)values(?,?,?)");
            pst.setString(1, post);
            pst.setString(2, stname);
            pst.setString(3, hour);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cook Registation");

            alert.setHeaderText("Cook Registation");
            alert.setContentText("Record Addedddd!");

            alert.showAndWait();

            table();

            txtName.setText("");
            txtPost.setValue("");
            txtHour.setValue("");
            txtName.requestFocus();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CookPostTable.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

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
            Logger.getLogger(CookPostTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<cktable> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                    txtPost.setValue(table.getItems().get(myIndex).getPost());
                    txtName.setText(table.getItems().get(myIndex).getName());
                    txtHour.setValue(table.getItems().get(myIndex).getHour());



                }
            });
            return myRow;
        });


    }

    @FXML
    void Delete(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));


        try
        {
            pst = con.prepareStatement("delete from posttable where id = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cook Registationn");

            alert.setHeaderText("Cook Registation");
            alert.setContentText("Deletedd!");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CookPostTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @FXML
    void Update(ActionEvent event) {
        String stname,post,hour;

        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

        post = (String) txtPost.getValue();
        stname = txtName.getText();
        hour = (String) txtHour.getValue();
        try
        {
            pst = con.prepareStatement("update posttable set post = ? ,name = ?,hour = ? where id = ? ");
            pst.setString(1, post);
            pst.setString(2, stname);
            pst.setString(3, hour);
            pst.setInt(4, id);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cook Registationn");

            alert.setHeaderText("Cook Registation");
            alert.setContentText("Updateddd!");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CookPostTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;

    public void Connect(){
        con =Data_work.conn;
    }

    /*public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bcalydbu3z2fxht2xnnd-mysql.services.clever-cloud.com:3306/bcalydbu3z2fxht2xnnd","uy0pllhi16asmquc","aiMfsx2EM5VcOUR1TFS3");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setText(Data_work.name);
        Connect();
        table();

        ObservableList<String> houru= FXCollections.observableArrayList("8:30 - 20:30","7:00 - 19:30","6:30 - 19:00","8:00 -20:00 ");
        txtHour.setItems(houru);

        ObservableList<String> idd = FXCollections.observableArrayList("chief-cook","cook","assistant cook");
        txtPost.setItems(idd);




        progress.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("povar11.fxml"));
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
                    root = FXMLLoader.load(getClass().getResource("povar13.fxml"));
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
