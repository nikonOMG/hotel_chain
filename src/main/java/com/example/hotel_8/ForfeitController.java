package com.example.hotel_8;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class ForfeitController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker date;

    @FXML
    private Text des;

    @FXML
    private TextArea descpription;

    @FXML
    private ComboBox<String> list;

    @FXML
    private Text max;

    @FXML
    private Button save;

    @FXML
    private Spinner<Integer> sum;

    @FXML
    void initialize() {
        list.setVisibleRowCount(5);

        if(Data_work.post.equals("Main Maid")){
            list.setItems(FXCollections.observableArrayList(Data_work.getMaids()));
        }else if(Data_work.post.equals("Chef Cook")){
            list.setItems(FXCollections.observableArrayList(Data_work.getCooks()));
        }else
            list.setItems(FXCollections.observableArrayList(Data_work.getWorkers()));
        new AutoCompleteBox( list);


        max.setStyle("-fx-fill: #C33C43");
        descpription.textProperty().addListener((obs,old,niu)->{
            if(descpription.getText().length() > 100){
                descpription.setText(old);
            }
            if(descpription.getText().length() > 0){
                max.setStyle("-fx-fill: #4baead");
            }
            else{
                max.setStyle("-fx-fill: #C33C43");
            }
            max.setText(descpription.getText().length() + " / 100");
            // TODO here
        });

        date.setValue(LocalDate.now());
        date.setEditable(false);

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
                0, 1000000, Integer.parseInt("100"), 100));
        sum.setEditable(true);
        sum.getEditor().setTextFormatter(priceFormatter);


        save.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(descpription.getText().isEmpty() == false){


                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Are you ok with this?");

                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.get() == ButtonType.OK){
                        Data_work.ForfeitWorker(Integer.parseInt(list.getValue().split(" ")[0]), descpription.getText(), Date.valueOf(date.getValue()), sum.getValue());

                        Stage stage = (Stage) save.getScene().getWindow();
                        // do what you have to do

                        stage.close();



//                    workerlist.setItems(FXCollections.observableArrayList(Data_work.getWorkers()));
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }

                }
                else {
                    max.setStyle("-fx-fill: #C33C43");
                }



            }
        });
    }

}
