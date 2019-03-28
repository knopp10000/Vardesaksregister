package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Scene scene1, scene2;
    Button button1, button2, button3, btVisa, börskrasch;
    TextArea textArea;
    Label label, title, rLabel;
    BorderPane borderPane, top;
    VBox right;
    HBox bottom;
    ComboBox comboBox;

    final int MIN_HEIGHT = 400;
    final int MIN_WIDTH = 600;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setMinHeight(MIN_HEIGHT);
        window.setMinWidth(MIN_WIDTH);
        window.setTitle("Värdesaksregister");

        /*
        label = new Label();
        label.setText("Rawrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        button1 = new Button("Go to scene 2!");
        button1.setOnAction(e -> window.setScene(scene2));
        button2 = new Button("Go to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));
        button3 = new Button();
        button3.setOnAction(event -> AlertBox.display("test","This is a test!"));

        scene2 = new Scene(layout2, 300, 250);
        */

        right = new VBox(15);
        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Namn");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Värde");
        rb2.setToggleGroup(group);
        rLabel = new Label();
        rLabel.setText("Sortering");
        right.getChildren().addAll(rLabel, rb1, rb2);

        top = new BorderPane();
        title = new Label();
        title.setText("Värdesaker");
        top.setCenter(title);

        bottom = new HBox(15);
        comboBox = new ComboBox();
        comboBox.getItems().addAll("Smycke", "Aktie", "Apparat");
        comboBox.setValue("Välj Värdesak");
        btVisa = new Button("Visa");
        börskrasch = new Button("Börskrasch");
        bottom.getChildren().addAll(comboBox, btVisa, börskrasch);

 //       StackPane layout1 = new StackPane();
//        layout1.getChildren().addAll(label, button1);
//        StackPane layout2 = new StackPane();
//        layout2.getChildren().addAll(button2, button3);

        borderPane = new BorderPane();
        textArea = new TextArea();
        borderPane.setCenter(textArea);
        borderPane.setRight(right);
        borderPane.setTop(top);
        borderPane.setBottom(bottom);

        scene1 = new Scene(borderPane, 300, 250);

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

/*    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button){
            System.out.println("WOW!");
        }else{
            System.out.println("Meh!");
        }

    }*/

    public static void main(String[] args) {
        launch(args);
    }
}
