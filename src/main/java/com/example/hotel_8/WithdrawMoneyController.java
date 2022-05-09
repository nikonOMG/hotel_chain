package com.example.hotel_8;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class WithdrawMoneyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker date;

    @FXML
    private TextArea descpription;

    @FXML
    private Text finances;

    @FXML
    private Text des;

    @FXML
    private Text max;

    @FXML
    private Button save;

    @FXML
    private Spinner<Integer> sum;


    @FXML
    void initialize() {
        max.setStyle("-fx-fill: #C33C43");
        descpription.textProperty().addListener((obs,old,niu)->{
            if(descpription.getText().length() > 200){
                descpription.setText(old);
            }
            if(descpription.getText().length() > 0){
                max.setStyle("-fx-fill: #4baead");
            }
            else{
                max.setStyle("-fx-fill: #C33C43");
            }
            max.setText(descpription.getText().length() + " / 200");
            // TODO here
        });

        date.setValue(LocalDate.now());
        date.setEditable(false);
        finances.setText(finances.getText() + " " + Data_work.getFinances());

//        SpinnerValueFactory<Integer> valueFactory = //
//                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Data_work.finances, 0 , 100);
//
//        sum.setValueFactory(valueFactory);
//        sum.getValueFactory().setValue(Data_work.getFinances() - 1);
        sum.setEditable(true);

        NumberFormat format = NumberFormat.getIntegerInstance();
        UnaryOperator<TextFormatter.Change> filter = c -> {
            if (c.isContentChange()) {
                ParsePosition parsePosition = new ParsePosition(0);
                // NumberFormat evaluates the beginning of the text
                format.parse(c.getControlNewText(), parsePosition);
                if (parsePosition.getIndex() == 0 || parsePosition.getIndex() == 9 ||
                        parsePosition.getIndex() < c.getControlNewText().length()) {
                    // reject parsing the complete text failed
                    return null;
                }
            }
            return c;
        };
        TextFormatter<Integer> priceFormatter = new TextFormatter<Integer>(
                new IntegerStringConverter(), 100, filter);

        sum.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
                0, Data_work.finances, Integer.parseInt("100"), 100));
        sum.setEditable(true);
        sum.getEditor().setTextFormatter(priceFormatter);


        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(descpription.getText().isEmpty() == false){


                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("password");
                dialog.setHeaderText("Enter password for confirmation.");

                Optional<String> result = dialog.showAndWait();
                String entered = "";

                if (result.isPresent()) {

                    entered = result.get();
                }

                if(entered.trim().equals(Data_work.password)){
                    boolean cash = Data_work.withdraw(descpription.getText(), Date.valueOf(date.getValue()), sum.getValue());
                    if (cash) {
                        Stage stage = (Stage) save.getScene().getWindow();
                        // do what you have to do

                        stage.close();
                    }
                }

                }
                else {
                    max.setStyle("-fx-fill: #C33C43");
                }



            }
        });









    }

}
