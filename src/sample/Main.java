package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;


public class Main extends Application{

    Stage window;
    Scene scene1, scene2;
    Button button1, button2, button3, btVisa, börskrasch;
    TextArea textArea;
    Label label, title, rLabel;
    BorderPane borderPane, top;
    VBox right;
    HBox bottom;
    MenuButton menuButton;
    RadioButton rb1, rb2;

    final int MIN_HEIGHT = 400;
    final int MIN_WIDTH = 600;

    ArrayList<Värdesak> värdesaker = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setMinHeight(MIN_HEIGHT);
        window.setMinWidth(MIN_WIDTH);
        window.setTitle("Värdesaksregister");

        right = new VBox(15);
        right.setPadding(new Insets(10));
        ToggleGroup group = new ToggleGroup();
        rb1 = new RadioButton("Namn");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        rb2 = new RadioButton("Värde");
        rb2.setToggleGroup(group);
        rLabel = new Label();
        rLabel.setText("Sortering");
        right.getChildren().addAll(rLabel, rb1, rb2);

        top = new BorderPane();
        title = new Label();
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        title.setText("Värdesaker");
        top.setCenter(title);


        bottom = new HBox(15);
        menuButton = new MenuButton("Välj Värdesak");
        MenuItem smyckeItem = new MenuItem("Smycke          ");
        MenuItem aktieItem = new MenuItem("Aktie            ");
        MenuItem apparatItem = new MenuItem("Apparat            ");

        smyckeItem.setOnAction(event -> registerSmycke());
        aktieItem.setOnAction(event -> registerAktie());
        apparatItem.setOnAction(event -> registerApparat());
        menuButton.getItems().addAll(smyckeItem, aktieItem, apparatItem);

        btVisa = new Button("Visa");
        btVisa.setOnAction(e -> updateTextArea());

        börskrasch = new Button("Börskrasch");

        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10));
        bottom.getChildren().addAll(menuButton, btVisa, börskrasch);

        borderPane = new BorderPane();
        textArea = new TextArea();
        textArea.setEditable(false);
        borderPane.setCenter(textArea);
        borderPane.setRight(right);
        borderPane.setTop(top);
        borderPane.setBottom(bottom);

        scene1 = new Scene(borderPane, 300, 250);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    private void registerSmycke(){
        try {
            SmyckeAlert alert = new SmyckeAlert();
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                värdesaker.add(
                        new Smycke(
                                alert.getName(),
                                alert.getAntalStenar(),
                                alert.isGuld()
                        ));
            }
        } catch (NumberFormatException e) {
            showErrorMessage();
        }
    }
    private void registerAktie(){
        try {
            AktieAlert alert = new AktieAlert();
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                värdesaker.add(
                        new Aktie(
                                alert.getName(),
                                alert.getAntal(),
                                alert.getPris()
                        ));
            }
        } catch (NumberFormatException e) {
            showErrorMessage();
        }
    }
    private void registerApparat(){
        try {
            ApparatAlert alert = new ApparatAlert();
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                värdesaker.add(
                        new Apparat(
                                alert.getName(),
                                alert.getPris(),
                                alert.getSkick()
                        ));
            }
        } catch (NumberFormatException e) {
            showErrorMessage();
        }
    }

    private void showErrorMessage() {
        Alert msg = new Alert(Alert.AlertType.ERROR, "Felaktig inmating!");
        msg.setTitle("Fel!");
        msg.setHeaderText("");
        msg.showAndWait();
    }

    private void updateTextArea() {
        if (isSortingByName()){
            sortByName();
        }else{
            sortByVärde();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Värdesak värdesak: värdesaker) {
            stringBuilder.append(värdesak.toString()).append("\n");
        }
        textArea.setText(stringBuilder.toString());
    }

    public boolean isSortingByName(){
        return rb1.isSelected();
    }

    private void sortByVärde() {
        värdesaker.sort((Värdesak värdesak1, Värdesak värdesak2) -> {
            if (värdesak1.getValue() > värdesak2.getValue()){
                return -1;
            } else if (värdesak1.getValue() < värdesak2.getValue()){
                return 1;
            }else return 0;
        });
    }
    private void sortByName() {
        värdesaker.sort((Värdesak värdesak1, Värdesak värdesak2) -> {
            int comparison = värdesak1.getName().compareTo(värdesak2.getName());
            if (comparison > 0){
                return 1;
            } else if (comparison < 0){
                return -1;
            }else return 0;
        });
    }
}
