package Menus;

import Gameplay.GameStrings;
import MAIN.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MenuController {
//    This creates an array list that will be used for the settings up the difficulty.
    private ObservableList<String> difficultyList = FXCollections.observableArrayList
            ("Letters","Very Easy","Easy","Normal","Hard","Very Hard","Paragraphs");
    @FXML
    public Button playButton;
    public Button modesButton;
    public Button helpButton;
    public ComboBox<String> difficultyBox;

//    This initialize establishes the "ObservableList" into the difficulty ComboBox.
    public void initialize() {
        difficultyBox.setItems(difficultyList);
        Main.setOverAllScorePlayer2("");
    }
    public void establishDifficulty(ActionEvent event) {
        GameStrings gs = new GameStrings();
        playButton.setDisable(false);
        Main.setSelectDifficulty(difficultyBox.getValue());

        //    This would be the data that other FXML classes would use to change text so that most of the text is not hard coded into each FXML programs
        switch (difficultyBox.getValue()) {
            case "Letters":
                Main.setGrabDifficulty(gs.randonLevel1().toString());
                break;
            case "Very Easy":
                Main.setGrabDifficulty(gs.randonLevel2().toString());
                break;
            case "Easy":
                Main.setGrabDifficulty(gs.randonLevel3().toString());
                break;
            case "Normal":
                Main.setGrabDifficulty(gs.randonLevel4().toString());
                break;
            case "Hard":
                Main.setGrabDifficulty(gs.randonLevel5().toString());
                break;
            case "Very Hard":
                Main.setGrabDifficulty(gs.randonLevel6().toString());
                break;
            case "Paragraphs":
                Main.setGrabDifficulty(gs.randonLevel7().toString());
                break;
        }
    }

//    The methods here is used to open the different pages of the game.
    public void startGame(ActionEvent actionEvent) throws IOException {
//        The Main.setSelect... is a piece of code that would get the difficulty and set it into the Main game.
        Window mainWindow = playButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Gameplay/MainGame.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

    public void openGameModes(ActionEvent actionEvent) throws IOException {
        Window mainWindow = modesButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Menus/Modes.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

    public void openHelp(ActionEvent actionEvent) throws IOException {
        Window mainWindow = helpButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Menus/Help.fxml"));
        mainWindow.getScene().setRoot(newRoot);
        }

//        Exits Game
    public void exitGame(ActionEvent actionEvent) {

        Platform.exit();

    }

}