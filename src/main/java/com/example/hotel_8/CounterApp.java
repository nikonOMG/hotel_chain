package com.example.hotel_8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CounterApp extends Application {

    private int count = 0;
    private final Text text = new Text(Integer.toString(count));

    private void incrementCount() {
        count++;
        text.setText(Integer.toString(count));
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.getChildren().add(text);

        Scene scene = new Scene(root, 200, 200);


        final ProgressBar bar = new ProgressBar();
        new Thread(new Runnable() {
            @Override public void run() {
                for (int i = 1; i <= 1000000; i++) {
                    final int counter = i;
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            bar.setProgress(counter / 1000000.0);
                        }
                    });
                }}
            }).start();



        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

