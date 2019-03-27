package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;


public class Main extends Application {

    Stage window;
    Scene scene1, scene2;
    Button button1, button2, button3;
    TextArea textArea;
    Label label;

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

        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(label, button1);
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(textArea, button2, button3);

        scene1 = new Scene(layout1, 300, 250);
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
