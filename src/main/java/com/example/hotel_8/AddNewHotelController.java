package com.example.hotel_8;

import java.net.URL;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class AddNewHotelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private TextField address;

    @FXML
    private Text bank;

    @FXML
    private Spinner<Integer> finances;

    @FXML
    private TextField name;

    @FXML
    private Spinner<Integer> stars;

    @FXML
    void initialize() {
        bank.setText(bank.getText() + " " + Data_work.getFinances());

        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);

        stars.setValueFactory(valueFactory);
        stars.setEditable(false);


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

        finances.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
                0, Data_work.getFinances(), Integer.parseInt("100"), 100));
        finances.setEditable(true);
        finances.getEditor().setTextFormatter(priceFormatter);


        add.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(name.getText().isEmpty() == false && address.getText().isEmpty() == false){


                    TextInputDialog dialog = new TextInputDialog("");
                    dialog.setTitle("password");
                    dialog.setHeaderText("Enter password for confirmation.");

                    Optional<String> result = dialog.showAndWait();
                    String entered = "";

                    if (result.isPresent()) {

                        entered = result.get();
                    }

                    if(entered.trim().equals(Data_work.password)){
                        boolean cash = Data_work.addNewHotel(name.getText(), address.getText(), stars.getValue(), finances.getValue());
                        if (cash) {
                            Stage stage = (Stage) add.getScene().getWindow();
                            // do what you have to do

                            stage.close();
                        }
                    }

                }
                else {
                    bank.setStyle("-fx-fill: #C33C43");
                }



            }
        });


    }



}
