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
    Button button1, button2, button3;
    TextArea textArea;
    Label label, title;
    BorderPane borderPane;
    VBox right;
    HBox top, bottom;
    ComboBox comboBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        primaryStage.setTitle("Värdesaksregister");
        textArea = new TextArea();
        label = new Label();
        label.setText("Rawrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        button1 = new Button("Go to scene 2!");
        button1.setOnAction(e -> window.setScene(scene2));
        button2 = new Button("Go to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));
        button3 = new Button();
        button3.setOnAction(event -> AlertBox.display("test","This is a test!"));


        right = new VBox(15);
        ToggleGroup group = new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("Namn");
        radioButton1.setToggleGroup(group);
        radioButton1.setSelected(true);
        RadioButton radioButton2 = new RadioButton("Värde");
        radioButton2.setToggleGroup(group);
        right.getChildren().addAll(radioButton1, radioButton2);

        top = new HBox(15);
        title = new Label();
        title.setText("Värdesaker");
        top.getChildren().add(title);

        bottom = new HBox(15);
        comboBox = new ComboBox();
        comboBox.getItems().addAll("Smycke", "Aktie", "Apparat");
        bottom.getChildren().add(comboBox);

        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(label, button1);
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(button2, button3);

        borderPane = new BorderPane();
        borderPane.setCenter(textArea);
        borderPane.setRight(right);
        borderPane.setTop(top);
        borderPane.setBottom(bottom);

        scene1 = new Scene(borderPane, 300, 250);
        scene2 = new Scene(layout2, 300, 250);
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
