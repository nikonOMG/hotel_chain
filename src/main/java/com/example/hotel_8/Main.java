package com.example.hotel_8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.YearMonth;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Full Calendar Example");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
