package sudoku.ui;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SudokuUi extends Application {

    public static void main(String[] args) {
        launch(SudokuUi.class);
    }

    @Override
    public void start(Stage stage) {

        Button newSudoku = new Button("Uusi sudoku");
        Button resetSudoku = new Button("Tyhjennä");
        Button check = new Button("Tarkista");
        Button ranking = new Button("Pisteet");

        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.getChildren().addAll(newSudoku, resetSudoku, check, ranking);

        VBox vbox = new VBox();
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox row3 = new HBox();
        ArrayList<HBox> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        vbox.getChildren().addAll(rows);

        ArrayList<Button> buttonList = new ArrayList<>();

        for (HBox row : rows) {
            for (int i = 0; i < 3; i++) {
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(3, 3, 3, 3));
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        Button button = new Button(" ");
                        button.setFont(Font.font("Monospaced", 30));
                        grid.add(button, j, k);
                        buttonList.add(button);
                    }
                }
                row.getChildren().add(grid);
            }
        }
        for (Button button : buttonList) {
            button.setOnAction((event) -> {
                if (button.getText().equals(" ")) {
                    button.setText("1");
                } else if (button.getText().equals("9")) {
                    button.setText("1");
                } else {
                    button.setText("" + (Integer.valueOf(button.getText()) + 1));
                }
            });
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(flowPane);
        borderPane.setCenter(vbox);

        Scene scene = new Scene(borderPane);

        stage.setTitle("Sudoku");
        stage.setScene(scene);
        stage.show();
    }
}
