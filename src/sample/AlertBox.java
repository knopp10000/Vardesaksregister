package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AlertBox {

    public static void display(String title, String message){
        Stage window = new Stage();
        window.setMinWidth(250);
        window.setMinHeight(250);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label = new Label();
        label.setText(message);
        Button button = new Button("OK");
        button.setOnAction(event -> window.close());

        VBox layout = new VBox(15);
        layout.getChildren().addAll(label, button);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
