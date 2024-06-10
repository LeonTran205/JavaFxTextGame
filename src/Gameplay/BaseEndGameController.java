package Gameplay;

import MAIN.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;

import java.io.IOException;

public class BaseEndGameController{
    public Label finalScore;
    public Label finalAccuracy;

    public Label player2Label;
    public Label player2ScoreLabel;
    public Label player2AccuracyLabel;
    public Label finalScoreP2;
    public Label finalAccuracyP2;

    public Button leaveButton;

    public void initialize(){
        finalScore.setText(Main.getOverAllScore());
        finalAccuracy.setText(Main.getOverAllAccuracy());

        finalScoreP2.setText(Main.getOverAllScorePlayer2());
        finalAccuracyP2.setText(Main.getOverAllAccuracyPlayer2());

        if (Main.getOverAllScorePlayer2().equals("")){
            player2Label.setVisible(false);
            player2ScoreLabel.setVisible(false);
            player2AccuracyLabel.setVisible(false);
            finalScoreP2.setVisible(false);
            finalAccuracyP2.setVisible(false);
        }
    }

    public void backButton(ActionEvent actionEvent) throws IOException {
//        This empties the player 2 string so that it would not be visible on single player mode.
        Main.setOverAllScorePlayer2("");

        Window mainWindow = leaveButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Menus/MainMenu.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }
}
