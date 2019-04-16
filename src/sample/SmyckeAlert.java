package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SmyckeAlert extends Alert {
    private TextField nameField = new TextField();
    private TextField antalStenarField = new TextField("0");
    private CheckBox checkBox = new CheckBox("Av Guld");

    public SmyckeAlert() {
        super(AlertType.CONFIRMATION);
        setTitle("Nytt smycke");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(10);
        grid.addRow(0, new Label("Namn:"), nameField);
        grid.addRow(1, new Label("Stenar:"), antalStenarField);
        grid.addRow(2, checkBox);
        setHeaderText(null);
        getDialogPane().setContent(grid);
    }
    public String getNamn() {
        return nameField.getText();
    }
    public int getAntalStenar() {
        return Integer.parseInt(antalStenarField.getText());
    }
    public boolean isGuld(){
        return checkBox.isSelected();
    }

    private void showErrorMessage() {
        Alert msg = new Alert(Alert.AlertType.ERROR, "Felaktig inmating!");
        msg.setTitle("Fel!");
        msg.setHeaderText("");
        msg.showAndWait();
    }
}
