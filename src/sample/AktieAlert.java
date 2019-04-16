package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AktieAlert extends Alert {
    private TextField namnField = new TextField();
    private TextField antalField = new TextField();
    private TextField kursField = new TextField();

    public AktieAlert() {
        super(AlertType.CONFIRMATION);
        setTitle("Ny aktie");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(10);
        grid.addRow(0, new Label("Namn:"), namnField);
        grid.addRow(1, new Label("Antal:"), antalField);
        grid.addRow(2, new Label("Kurs:"), kursField);
        setHeaderText(null);
        getDialogPane().setContent(grid);
    }
    public String getNamn() {
        return namnField.getText();
    }
    public int getAntal() {
        return Integer.parseInt(antalField.getText());
    }
    public int getKurs(){
        return Integer.parseInt(kursField.getText());
    }

}
