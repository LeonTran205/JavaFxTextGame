package Gameplay;

import MAIN.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;

public class TwoPlayersController {

//    FXML bases
    public TextField baseTF;
    public TextArea textA;
    public Label levelNum;
    public Label extractName;
    public Button endButton;
    public Button leaveButton;

    //    Player 1 Labels
    public Label score;
    public Label accuracy;

//    Player 2 Labels
    public Label scoreP2;
    public Label accuracyP2;

//    Player 1 Scores and Accuracy
    private double p1AccuracyPlus;
    private double p1AccuracyPresses;
    private double p1AccuracyTotal;
    private int p1ScoreNum;
    private String p1Enable = "yes";

//    Player 2 Scores and Accuracy
    private double p2AccuracyPlus;
    private double p2AccuracyPresses;
    private double p2AccuracyTotal;
    private int p2ScoreNum;
    private String p2Enable = "no";

    //    End Game switch
    private int endGame = 0;

    public void initialize() {
        levelNum.setText(Main.getSelectDifficulty());
        textA.setText(Main.getGrabDifficulty());
    }

    public void mainText(KeyEvent keyEvent) throws IOException {
//        string Holder is mainly for windows as it does not detect the shift key. stringHolder is there to get any characters that would appear on baseTF.
//        When the user types to keep things tidy baseTF would clear each time a user types.
        String stringHolder;

        stringHolder = baseTF.getText();
        baseTF.clear();

        double accuracyTotal;

//        This code allows the user to remove a piece of text when the user types in the correct character.
//        Score will be added when the user gets the correct character and lose score when wrong character is inputted.
//        User will also have an accuracy metre that shows the percentage of correct keys typed compared to overall presses.

//            Player 1 plus Scores
        if (stringHolder.equals(textA.getText().substring(0,1)) && p1Enable.equals("yes")){
                textA.deleteNextChar();
                p1ScoreNum = p1ScoreNum + 10;
                score.setText(""+p1ScoreNum);
                p1AccuracyPresses = p1AccuracyPresses + 1;
                p1AccuracyPlus = p1AccuracyPlus + 1;
            }
//            Player 2 plus Scores
        if (stringHolder.equals(textA.getText().substring(0,1)) && p2Enable.equals("yes")){
                textA.deleteNextChar();
                p2ScoreNum = p2ScoreNum + 10;
                scoreP2.setText(""+p2ScoreNum);
                p2AccuracyPresses = p2AccuracyPresses + 1;
                p2AccuracyPlus = p2AccuracyPlus + 1;

            }
        if ((!stringHolder.equals(textA.getText().substring(0,1))) && (p1Enable.equals("yes"))){
                p1ScoreNum = p1ScoreNum - 1;
                score.setText(""+p1ScoreNum);
                p1AccuracyPresses = p1AccuracyPresses + 1;
            }
//            Player 2 minus Scores
        if ((!stringHolder.equals(textA.getText().substring(0,1))) && (p2Enable.equals("yes"))){
                p2ScoreNum = p2ScoreNum - 1;
                scoreP2.setText(""+p2ScoreNum);
                p2AccuracyPresses = p2AccuracyPresses + 1;
            }
        if (p1Enable.equals("yes")){
            p1AccuracyTotal = ((p1AccuracyPlus/p1AccuracyPresses)*100);
            accuracy.setText("" + p1AccuracyPresses);
            }

        else
        p2AccuracyTotal = ((p2AccuracyPlus/p2AccuracyPresses)*100);
        accuracyP2.setText("" + p2AccuracyTotal);

//        This method allows the game to end
        if (textA.getLength() == 1){
            p1Enable = "no";
            p2Enable = "yes";
            endGame = endGame + 1;
            if (endGame == 1){
                textA.setText(Main.getGrabDifficulty());
            }
//            This enables the end game button.
            if (endGame == 2){
                textA.setDisable(true);
                baseTF.setDisable(true);
                baseTF.setText("Game Over");
                endButton.setVisible(true);
                Main.setOverAllScore("" + p1ScoreNum);
                Main.setOverAllAccuracy("" + p1AccuracyTotal);

                Main.setOverAllScorePlayer2("" + p2ScoreNum);
                Main.setOverAllAccuracyPlayer2("" + p2AccuracyTotal);
            }
        }
    }

    public void openEndGame(ActionEvent actionEvent) throws IOException {

        Window mainWindow = endButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("BaseEndGame.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

    //    This code is here to punish the user if they're to edit the Text Area : However, this should close the game with a pop up because it breaks the Text Area.
    public void stopCheating(KeyEvent keyEvent) {
        Platform.exit();
    }

    //    This code is to allow the user to go back to the main menu but this also means the user forfeits their record.
    public void leave(ActionEvent actionEvent) throws IOException {
        Window mainWindow = leaveButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Menus/MainMenu.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

}