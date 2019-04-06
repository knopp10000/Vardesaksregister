package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ApparatAlert extends Alert {
    private TextField nameField = new TextField();
    private TextField prisField = new TextField();
    private TextField skickField = new TextField();

    public ApparatAlert() {
        super(AlertType.CONFIRMATION);
        setTitle("Ny apparat");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(10);
        grid.addRow(0, new Label("Name:"), nameField);
        grid.addRow(1, new Label("Pris::"), prisField);
        grid.addRow(2, new Label("Skick:"), skickField);
        setHeaderText(null);
        getDialogPane().setContent(grid);
    }
    public String getName() {
        return nameField.getText();
    }
    public int getPris(){
        return Integer.parseInt(prisField.getText());
    }
    public int getSkick() {
        return Integer.parseInt(skickField.getText());
    }

}
