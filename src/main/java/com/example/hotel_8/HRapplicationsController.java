package com.example.hotel_8;


//import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.HostServices;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.search.FlagTerm;

public class HRapplicationsController {
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
    private Button Workers;

    @FXML
    private Button loadTable;

    @FXML
    private Button applications;

    @FXML
    private ProgressBar load;

    @FXML
    private TableColumn<Applications, String> date;

    @FXML
    private TableColumn<Applications, String> email;

    @FXML
    private TableColumn<Applications, Integer> id;

    @FXML
    private TableView<Applications> list;

    @FXML
    private Button settings;

    @FXML
    private Text titlename;


    @FXML
    private Button link;


    @FXML
    private TableColumn<Applications, String> titlea;

//    static ObservableList<Applications> oblist = FXCollections.observableArrayList();

    private ObservableList<Applications> check(String host, String storeType, String user, String password) {
        try {
            ObservableList<Applications> oblist = FXCollections.observableArrayList();
            // create properties
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.imap.ssl.trust", host);

            Session emailSession = Session.getDefaultInstance(properties);

            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            // create the inbox object and open it
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), true));
            System.out.println("messages.length---" + messages.length);
            double percent = 1.f/ messages.length;
            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println(i);
//                message.setFlag(Flag.SEEN, true);
//                System.out.println("---------------------------------");
//                System.out.println("Email Number " + (i + 1));
//                System.out.println("Subject: " + message.getSubject());
//                System.out.println("From: " + message.getFrom()[0]);
//                MimeMultipart body = (MimeMultipart) message.getContent();
//                BodyPart textPart = body.getBodyPart(0);
//                String text = (String) textPart.getContent();
//                System.out.println("Text: " + text);
//                System.out.println(message.getSentDate());
//                System.out.println(message.getMessageNumber());

                oblist.add(new Applications((int) message.getMessageNumber(), message.getFrom()[0].toString(), message.getSubject(), message.getSentDate().toString()));
                System.out.println((i + 1) * percent);
                load.setProgress((i + 1) * percent);

            }


            inbox.close(false);
            store.close();
            return oblist;
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    @FXML
    void initialize() {
        titlename.setText(Data_work.name);
        load.setVisible(false);
//        link.setOnAction(e -> Application.getHostServices.showDocument("https://mail.google.com/mail/u/0/#inbox"));


        loadTable.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                load.setVisible(true);
                load.setProgress(0);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        list.getItems().clear();
                        ObservableList<Applications> oblist = check("imap.gmail.com", "imap", Data_work.email, Data_work.email_pas);

                        System.out.println(oblist);
                        id.setCellValueFactory(new PropertyValueFactory<>("id"));
                        email.setCellValueFactory(new PropertyValueFactory<>("email"));
                        titlea.setCellValueFactory(new PropertyValueFactory<>("title"));
                        date.setCellValueFactory(new PropertyValueFactory<>("date"));

                        list.setItems(oblist);

                        load.setVisible(false);
                    }
                }).start();



            }
        });

        settings.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("changeEmail.fxml"));
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

        Workers.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("HRworkers.fxml"));
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

        Profile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
//                                    SignInBut.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("HRprofile.fxml"));
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
