package sudoku.ui;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.util.Duration;
import sudoku.dao.*;
import sudoku.domain.*;

public class SudokuUi extends Application {

    private Sudoku sudoku;
    private ArrayList<Square> squares;
    private SudokuDao sudokuDao;
    private ScoreDao scoreDao;
    private Scanner scanner;

    @Override
    public void init() {
        this.squares = new ArrayList<>();
        this.sudokuDao = new SqlSudokuDao();
        this.scoreDao = new SqlScoreDao();
        this.scanner = new Scanner(System.in);
        this.sudoku = new Sudoku(squares, sudokuDao, scoreDao);
        sudoku.newNumbers();
    }

    public static void main(String[] args) {
        launch(SudokuUi.class);
    }

    @Override
    public void start(Stage stage) {

        Button newSudoku = new Button("Uusi sudoku");
        Button reset = new Button("Tyhjennä");
        Button check = new Button("Tarkista");
        Button scores = new Button("Tulokset");
        Label time = new Label(sudoku.getTimer().toString());

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> {
                    sudoku.getTimer().increase();
                    time.setText(sudoku.getTimer().toString());
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.getChildren().addAll(newSudoku, reset, check, scores, time);

        GridPane grid = createGrid();
        sudoku.reset();

        newSudoku.setOnAction((event) -> {
            sudoku.newNumbers();
            sudoku.reset();
            timeline.play();
        });

        reset.setOnAction((event) -> {
            sudoku.reset();
            timeline.play();
        });

        check.setOnAction((event) -> {
            Stage result = new Stage();
            result.initModality(Modality.WINDOW_MODAL);
            result.initOwner(stage);

            if (!sudoku.check()) {
                timeline.stop();
                Label textCorrect = new Label("Oikein!");
                Button saveScore = new Button("Tallenna tulos");
                Button nextSudoku = new Button("Seuraava sudoku");

                textCorrect.setFont(Font.font(30));

                saveScore.setOnAction((e) -> {
                    Label saveLabel = new Label("Syötä nimimerkki (enintään 20 merkkiä)");
                    TextField nameField = new TextField();
                    Button saveButton = new Button("Tallenna");

                    saveButton.setOnAction((ev) -> {
                        sudoku.saveScore(nameField.getCharacters().toString());
                        result.close();
                    });

                    VBox vBoxSave = new VBox();
                    vBoxSave.setPadding(new Insets(10, 10, 10, 10));
                    vBoxSave.getChildren().addAll(saveLabel, nameField, saveButton);
                    Scene saveScene = new Scene(vBoxSave);
                    result.setScene(saveScene);
                });

                nextSudoku.setOnAction((e) -> {
                    newSudoku.fire();
                    result.close();
                });

                VBox vBoxCorrect = new VBox();
                vBoxCorrect.getChildren().addAll(textCorrect, saveScore, nextSudoku);
                vBoxCorrect.setAlignment(Pos.CENTER);
                vBoxCorrect.setPadding(new Insets(10, 30, 10, 30));
                vBoxCorrect.setSpacing(10);
                Scene correct = new Scene(vBoxCorrect);
                result.setScene(correct);

            } else {
                Label textIncorrect = new Label("Ratkaisusi on väärin");
                textIncorrect.setFont(Font.font(20));

                VBox vBoxIncorrect = new VBox();
                vBoxIncorrect.getChildren().add(textIncorrect);
                vBoxIncorrect.setAlignment(Pos.CENTER);
                vBoxIncorrect.setPadding(new Insets(10, 30, 10, 30));
                Scene incorrect = new Scene(vBoxIncorrect);
                result.setScene(incorrect);
            }
            result.show();
        });

        scores.setOnAction((event) -> {
            //tuloslista
        });

        for (Square square : squares) {
            square.getButton().setOnAction((event) -> {
                sudoku.changeNumber(square);
            });
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(flowPane);
        borderPane.setCenter(grid);

        Scene scene = new Scene(borderPane);

        stage.setTitle("Sudoku");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane createGrid() {
        GridPane mainGrid = new GridPane();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(3, 3, 3, 3));
                for (int x2 = 0; x2 < 3; x2++) {
                    for (int y2 = 0; y2 < 3; y2++) {
                        Button button = new Button();
                        button.setFont(Font.font("Monospaced", 30));
                        grid.add(button, x2, y2);
                        Square square = new Square(y * 3 + y2, x * 3 + x2, button);
                        squares.add(square);
                    }
                }
                mainGrid.add(grid, x, y);
            }
        }
        return mainGrid;
    }
}
