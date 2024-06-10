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

public class HelpController {
    public Button backButton;
    public void backButton(ActionEvent actionEvent) throws IOException {
        Window mainWindow = backButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Menus/MainMenu.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }
}
