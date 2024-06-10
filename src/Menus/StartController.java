package Menus;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class StartController {
    public Button startButton;

    public void startGame(ActionEvent event) throws IOException {
        Window mainWindow = startButton.getScene().getWindow();

        Parent newRoot = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

        mainWindow.getScene().setRoot(newRoot);
    }
}