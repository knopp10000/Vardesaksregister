package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RegisterVärdesak {

    Register register = new Register();
    Stage window;

    void apparat(){
        GridPane input = new GridPane();
        input.setAlignment(Pos.CENTER_LEFT);
        input.setPadding(new Insets(10));

        Label namnLabel = new Label("Namn: ");
        TextField namnTextField = new TextField();
        Label prisLabel = new Label("Pris: ");
        TextField prisTextField = new TextField();
        Label skickLabel = new Label("Skick:");
        TextField skickTextField = new TextField();

        input.addRow(0, namnLabel, namnTextField);
        input.addRow(1, prisLabel, prisTextField);
        input.addRow(2, skickLabel, skickTextField);

        //input.getChildren().addAll(namnLabel, namnTextField, prisLabel, prisTextField, skickLabel, skickTextField);

        display("Ny Apparat", input, 350, 175, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                String namn = namnTextField.getText();
                int inköpspris = Integer.valueOf(prisTextField.getText());
                int slitage = Integer.valueOf(skickTextField.getText());
                Apparat apparat = new Apparat(namn, inköpspris, slitage);
                System.out.println(apparat.toString());
                Register.registerVärdesak(apparat);
                window.close();
            }
        });
    }

    void aktie(){
        GridPane input = new GridPane();
        input.setHgap(5);
        input.setVgap(5);
        input.setPadding(new Insets(10));
        //input.setAlignment(Pos.CENTER_LEFT);
        //input.setPadding(new Insets(10));

        Label namnLabel = new Label("Namn: ");
        TextField namnTextField = new TextField();
        Label antalLabel = new Label("Antal:");
        TextField antalTextField = new TextField();
        Label prisLabel = new Label("Pris: ");
        TextField prisTextField = new TextField();

        input.addRow(0, namnLabel, namnTextField);
        input.addRow(1, antalLabel, antalTextField);
        input.addRow(2, prisLabel, prisTextField);
        //input.getChildren().addAll(namnLabel, namnTextField, antalLabel, antalTextField, prisLabel, prisTextField);
        display("Ny aktie", input, 350, 175, e -> {
                String namn = namnTextField.getText();
                int antal = Integer.valueOf(antalTextField.getText());
                int kurs = Integer.valueOf(prisTextField.getText()); //Är Kurs priset??
                Aktie aktie = new Aktie(namn, antal, kurs);
                System.out.println(aktie.toString());
                Register.registerVärdesak(aktie);
                window.close();
        });
    }

    void smycke(){
        FlowPane input = new FlowPane();
        //input.setHgap(5);
        //input.setVgap(5);
        input.setPadding(new Insets(10));
        input.setAlignment(Pos.CENTER_LEFT);

        Label namnLabel = new Label("Namn: ");
        TextField namnTextField = new TextField();
        Label stenarLabel = new Label("Stenar:");
        TextField stenarTextField = new TextField();
        CheckBox checkBox = new CheckBox("Av Guld");

        input.getChildren().addAll(namnLabel, namnTextField, stenarLabel, stenarTextField, checkBox);

        display("Nytt Smycke", input, 300, 225, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent){
                String namn = namnTextField.getText();
                int antalStenar = Integer.valueOf(stenarTextField.getText());
                Boolean avGuld = checkBox.isSelected();
                Smycke smycke = new Smycke(namn, antalStenar,avGuld);
                System.out.println(smycke.toString());
                Register.registerVärdesak(smycke);
                window.close();
            }
        });
    }

     private void display(String title, Pane input, int width, int height, EventHandler<ActionEvent> actionListener){
         window = new Stage();
         window.setResizable(true);
         window.initModality(Modality.APPLICATION_MODAL);
         window.setTitle(title);

         Button okButton = new Button("OK");
         okButton.setOnAction(actionListener);
         Button cancelButton = new Button("Cancel");
         cancelButton.setOnAction(event -> window.close());

         HBox bottom = new HBox(15);
         bottom.setAlignment(Pos.CENTER);
         bottom.setPadding(new Insets(10));
         bottom.getChildren().addAll(okButton, cancelButton);

         BorderPane borderPane = new BorderPane();
         borderPane.setCenter(input);
         borderPane.setBottom(bottom);

         VBox left = new VBox(15);
         left.setAlignment(Pos.CENTER);
         left.setPadding(new Insets(20));
         try {
             FileInputStream question = new FileInputStream("C:\\Users\\knopp10000\\Desktop\\Programming\\Vardesaksregister\\question.png");
             Image questionImage = new Image(question);
             ImageView questionImageView = new ImageView(questionImage);
             left.getChildren().add(questionImageView);

         } catch (FileNotFoundException e) {e.printStackTrace();}
         borderPane.setLeft(left);

         Scene scene = new Scene(borderPane, width, height);
         window.setScene(scene);
         window.showAndWait();
     };
}
