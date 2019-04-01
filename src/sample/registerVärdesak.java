package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class registerVärdesak {

    static void smycke(){

    }

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

         HBox bottom = new HBox(15);
         bottom.setAlignment(Pos.CENTER);
         bottom.setPadding(new Insets(10));
         bottom.getChildren().addAll(okButton, cancelButton);

         BorderPane borderPane = new BorderPane();
         borderPane.setBottom(bottom);
         Scene scene = new Scene(borderPane);
         window.setScene(scene);
         window.showAndWait();
     };
}
