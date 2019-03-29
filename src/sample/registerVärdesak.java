package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class registerVärdesak {

     static void display(String title){
         Stage window = new Stage();
         window.setMinWidth(400);
         window.setMinHeight(300);
         window.initModality(Modality.APPLICATION_MODAL);
         window.setTitle(title);

         Button okButton = new Button("OK");
         okButton.setOnAction(event -> window.close());
         Button cancelButton = new Button("Cancel");
         cancelButton.setOnAction(event -> window.close());

         VBox layout = new VBox(15);
         layout.getChildren().addAll(okButton, cancelButton);
         Scene scene = new Scene(layout);
         window.setScene(scene);
         window.showAndWait();
     };
}
