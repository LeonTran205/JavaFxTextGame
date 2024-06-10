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

public class ProgressiveController {
    public TextField baseTF;
    public TextArea textA;
    public Label levelNum;
    public Label extractName;
    public Label score;
    public Label accuracy;
    public Button endButton;
    public Button leaveButton;
    private double accuracyPlus;
    private double accuracyPresses;
    private double accuracyTotal;
    private int scoreNum;
    private int nextLevel = 0;
    private int endGame = 0;

    public void mainText(KeyEvent keyEvent) {
//        Mainly for windows as it does not detect the shift key. stringHolder is there to get any characters that would appear on baseTF
//        When the user types to keep things tidy baseTF would clear each time a user types.
        String stringHolder;

        stringHolder = baseTF.getText();
        baseTF.clear();

        accuracyPresses = accuracyPresses + 1;
// This would be the if statements that would allow the user to progress to the next difficulty level each time they're done with a section.
        if(nextLevel == 1){
            textA.setText("fast type this in quickly");
            nextLevel = nextLevel + 1;
            levelNum.setText("Level 2 - Easy");
            extractName.setText("Easy Steps");

        }
        else if (nextLevel == 3){
            textA.setText("Mr Twit didn't even bother to open his mouth wide when he ate. As a result, (and because he never washed) there were always hundreds of bits of old breakfasts and lunches and suppers sticking to the hairs around his face.");
            nextLevel = nextLevel + 1;
            levelNum.setText("Level 3 - Normal");
            extractName.setText("Extract: Twits by Roald Dahl");
        }
        else if (nextLevel == 5){
            textA.setText("He sat there watching her and smiled. He thought, I'm going to eat this child. Compared with her old Grandmamma She's going to taste like caviar. Then Little Red Riding Hood said, 'But Grandma, what a lovely great big furry coat you have on.' 'That's wrong!' cried Wolf. 'Have you forgot. To tell me what BIG TEETH I've got? Ah well, no matter what you say, I'm going to eat you anyway.' The small girl smiles. One eyelid flickers. She whips a pistol from her knickers. She aims it at the creature's head and BANG BANG BANG, she shoots him dead.");
            nextLevel = nextLevel + 1;
            levelNum.setText("Level 4 - Hard");
            extractName.setText("Extract: Little Red Riding by Roald Dahl");
        }
        else if (nextLevel == 7){
            textA.setText("Sophie couldn't sleep. A brilliant moonbeam was slanting through a gap in the curtains. It was shining right on to her pillow. The other children in the dormitory had been asleep for hours. Sophie closed her eyes and lay quite still. She tried very hard to doze off. It was no good. The moonbeam was like a silver blade slicing through the room onto her face. The house was absolutely silent. No voices came up from downstairs. There were no footsteps on the floor above either. The window behind the curtain was wide open, but nobody was walking on the pavement outside. No cars went by on the street. Not the tiniest sound could be heard anywhere. Sophie had never known such a silence. Perhaps, she told herself, this was what they called the witching hour. The witching hour, somebody had once whispered to her, was a special moment in the middle of the night when every child and every grown-up was in a deep deep sleep, and all the dark things came out from hiding and had the world to themselves.");
            nextLevel = nextLevel + 1;
            levelNum.setText("Level 5 - Very Hard");
            extractName.setText("Extract: BFG by Roald Dahl");
        }
        else if (nextLevel == 9){
            textA.setText("ALICE was beginning to get very tired of sitting by her sister on the bank and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, ‘and what is the use of a book,’ thought Alice, ‘without pictures or conversations? So, she was considering, in her own mind (as well as she could, for the hot day made her feel very sleepy and stupid), whether the pleasure of making a daisy-chain would be worth the trouble of getting up and picking the daisies, when suddenly a White Rabbit with pink eyes ran close by her. There was nothing so very remarkable in that; nor did Alice think it so very much out of the way to hear the Rabbit say to itself ‘Oh dear! Oh dear! I shall be too late!’ (when she thought it over afterwards it occurred to her that she ought to have wondered at this, but at the time it all seemed quite natural); but, when the Rabbit actually took a watch out of its waistcoat-pocket, and looked at it, and then hurried on, Alice started to her feet, for it flashed across her mind that she had never before seen a rabbit with either a waistcoat-pocket, or a watch to take out of it, and burning with curiosity, she ran across the field after it, and was just in time to see it pop down a large rabbit-hole under the hedge.");
            nextLevel = nextLevel + 1;
            levelNum.setText("Final Level - Book");
            extractName.setText("Extract: Alice in Wonderland by Lewis Carroll");
        }

        else if (nextLevel == 11) {
            textA.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            nextLevel = nextLevel + 1;
            levelNum.setText("Final Level - Book");
            extractName.setText("Extract: Alice in Wonderland by Lewis Carroll");
        }

        else if (nextLevel == 13){
            baseTF.setText("Game Over");
            baseTF.setDisable(true);
            levelNum.setText("Game");
            extractName.setText("Over");
            endGame = endGame + 1;
        }

        if (textA.getLength() == 1){
            nextLevel = nextLevel + 1;
        }

        if (endGame == 1){
            Main.setOverAllScore("" + scoreNum);
            Main.setOverAllAccuracy("" + accuracyTotal);
            endButton.setVisible(true);
        }

//        When the user finishes the game it should display the end game button that will take the user to the end screen or automatically take the user to the end game screen.

//        This code allows the user to remove a piece of text when the user types in the correct character.
//        Score will be added when the user gets the correct character and lose score when wrong character is inputted.
//        User will also have an accuracy metre that shows the percentage of correct keys typed compared to overall presses.
        if (stringHolder.equals(textA.getText().substring(0,1))){
            textA.deleteNextChar();
            scoreNum = scoreNum + 10;
            score.setText(""+scoreNum);
            accuracyPlus = accuracyPlus + 1;
        }
        else if (!stringHolder.equals(textA.getText().substring(0,1))){
            scoreNum = scoreNum - 1;
            score.setText(""+scoreNum);
        }

        accuracyTotal = (accuracyPlus/(accuracyPresses)) * 100;
        accuracy.setText(accuracyTotal + "%");
    }

//    This code is here to punish the user if they're to edit the Text Area also game will close because Text Area has been edited.
    public void stopCheating(KeyEvent keyEvent) {
        System.out.println("You have been caught cheating! Anytime you type in this area you will lose 9 Million points also game will now close!");
        scoreNum = scoreNum - 9999999;
        score.setText("" + scoreNum);
        Platform.exit();
    }

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