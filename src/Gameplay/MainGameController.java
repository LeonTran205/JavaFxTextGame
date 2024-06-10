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

public class MainGameController {
    public TextField baseTF;
    public TextArea textA;
    public Button endButton;
    public Button leaveButton;
    public Label levelNum;
    public Label extractName;
    public Label score;
    public Label accuracy;
    public Label deTimer;
    private double accuracyPlus;
    private double accuracyPresses;
    private int scoreNum;
    private int endGame = 0;

    public void initialize() {
        levelNum.setText(Main.getSelectDifficulty());
        textA.setText(Main.getGrabDifficulty());
    }

    public void mainText(KeyEvent keyEvent) throws IOException {
        String stringHolder;

//        This would make the stringHolder get the text from baseTF.
        stringHolder = baseTF.getText();
        baseTF.clear();

        double accuracyTotal;

        accuracyPresses = accuracyPresses + 1;

//        This code allows the user to remove a piece of text when the user types in the correct character.
//        Score will be added when the user gets the correct character and lose score when wrong character is inputted.
//        User will also have an accuracy metre that shows the percentage of correct keys typed compared to overall presses.
        if (stringHolder.equals(textA.getText().substring(0,1))){
            textA.deleteNextChar();
            scoreNum = scoreNum + 10;
            score.setText(""+scoreNum);
            accuracyPlus = accuracyPlus + 1;

            //        This is the Special Reader - it would read the specific keys and if the user inputs it correctly it would give the user an extra 5 points also there are 20 special keys used.
            switch (stringHolder) {
                case "!":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "£":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "$":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "%":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "^":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "&":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "*":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "(":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case ")":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "_":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "+":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "{":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "}":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case ":":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "@":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "~":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "<":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case ">":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "?":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
                case "¬":
                    scoreNum = scoreNum + 5;
                    score.setText(""+scoreNum);
                    break;
            }
        }

//        This subtracts score and accuracy from user when the user creates a typo.
        else if (!stringHolder.equals(textA.getText().substring(0,1))){
            scoreNum = scoreNum - 1;
            score.setText(""+scoreNum);
        }

        accuracyTotal = (accuracyPlus/(accuracyPresses)) * 100;
        accuracy.setText(accuracyTotal + "%");


//        This method allows the game to end
        if (textA.getText().equals("")){
            baseTF.setDisable(true);
            baseTF.setText("Game Over");
            endGame = endGame + 1;
        }

//        When the user finishes the game it should display the end game button that will take the user to the end screen or automatically take the user to the end game screen.
        if (endGame == 1){
            Main.setOverAllScore("" + scoreNum);
            Main.setOverAllAccuracy("" + accuracyTotal);
            endButton.setVisible(true);
        }

    }

    //    This code is here to punish the user if they're to edit the Text Area : However, this should close the game with a pop up because it breaks the Text Area.
    public void stopCheating(KeyEvent keyEvent) {
        System.out.println("You have been caught cheating! Anytime you type in this area you will lose 9 million points");
        scoreNum = scoreNum - 9999999;
        score.setText("" + scoreNum);
        Platform.exit();
    }

//    Button that will take user to the end of the game.
    public void openEndGame(ActionEvent actionEvent) throws IOException {
        Window mainWindow = endButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("BaseEndGame.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

    //    This code is to allow the user to go back to the main menu but this also means the user forfeits their record.
    public void leave(ActionEvent actionEvent) throws IOException {
        Window mainWindow = leaveButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Menus/MainMenu.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

}