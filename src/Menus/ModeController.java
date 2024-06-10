package Menus;
import MAIN.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Window;

import java.io.IOException;

public class ModeController {

    public Button progressiveButton;
    public Button legacyButton;
    public Button twoButton;
    public Button backButton;
    public ComboBox<String> difficultyBox;

    private ObservableList<String> difficultyList = FXCollections.observableArrayList
            ("Letters","Very Easy","Easy","Normal","Hard","Very Hard","Paragraphs","Book");

    public void initialize(){
        difficultyBox.setItems(difficultyList);
    }

    public void establishDifficulty(ActionEvent actionEvent) {
        legacyButton.setDisable(false);
        twoButton.setDisable(false);
        Main.setSelectDifficulty(difficultyBox.getValue());

        switch (difficultyBox.getValue()) {
            case "Letters":
                Main.setGrabDifficulty("123qwerty ");
                break;
            case "Very Easy":
                Main.setGrabDifficulty("abc def 123 456 ");
                break;
            case "Easy":
                Main.setGrabDifficulty("abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ 1 2 3 4 5 6 7 8 9 10 ");
                break;
            case "Normal":
                Main.setGrabDifficulty("Mr Twit didn't even bother to open his mouth wide when he ate. As a result, (and because he never washed) there were always hundreds of bits of old breakfasts and lunches and suppers sticking to the hairs around his face. ");
                break;
            case "Hard":
                Main.setGrabDifficulty("He sat there watching her and smiled. He thought, I'm going to eat this child. Compared with her old Grandmamma She's going to taste like caviar. Then Little Red Riding Hood said, 'But Grandma, what a lovely great big furry coat you have on.' 'That's wrong!' cried Wolf. 'Have you forgot. To tell me what BIG TEETH I've got? Ah well, no matter what you say, I'm going to eat you anyway.' The small girl smiles. One eyelid flickers. She whips a pistol from her knickers. She aims it at the creature's head and BANG BANG BANG, she shoots him dead. ");
                break;
            case "Very Hard":
                Main.setGrabDifficulty("Sophie couldn't sleep. A brilliant moonbeam was slanting through a gap in the curtains. It was shining right on to her pillow. The other children in the dormitory had been asleep for hours. Sophie closed her eyes and lay quite still. She tried very hard to doze off. It was no good. The moonbeam was like a silver blade slicing through the room onto her face. The house was absolutely silent. No voices came up from downstairs. There were no footsteps on the floor above either. The window behind the curtain was wide open, but nobody was walking on the pavement outside. No cars went by on the street. Not the tiniest sound could be heard anywhere. Sophie had never known such a silence. Perhaps, she told herself, this was what they called the witching hour. The witching hour, somebody had once whispered to her, was a special moment in the middle of the night when every child and every grown-up was in a deep deep sleep, and all the dark things came out from hiding and had the world to themselves. ");
                break;
            case "Paragraphs":
                Main.setGrabDifficulty("ALICE was beginning to get very tired of sitting by her sister on the bank and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, 'and what is the use of a book,' thought Alice, 'without pictures or conversations?' So, she was considering, in her own mind (as well as she could, for the hot day made her feel very sleepy and stupid), whether the pleasure of making a daisy-chain would be worth the trouble of getting up and picking the daisies, when suddenly a White Rabbit with pink eyes ran close by her. There was nothing so very remarkable in that; nor did Alice think it so very much out of the way to hear the Rabbit say to itself 'Oh dear! Oh dear! I shall be too late!' (when she thought it over afterwards it occurred to her that she ought to have wondered at this, but at the time it all seemed quite natural); but, when the Rabbit actually took a watch out of its waistcoat-pocket, and looked at it, and then hurried on, Alice started to her feet, for it flashed across her mind that she had never before seen a rabbit with either a waistcoat-pocket, or a watch to take out of it, and burning with curiosity, she ran across the field after it, and was just in time to see it pop down a large rabbit-hole under the hedge. ");
                break;
            case "Book":
                Main.setGrabDifficulty("October arrived, spreading a damp chill over the grounds and into the castle. Madam Pomfrey, the nurse, was kept busy by a sudden spate of colds among the staff and students. Her Pepperup potion worked instantly, though it left the drinker smoking at the ears for several hours afterward. Ginny Weasley, who had been looking pale, was bullied into taking some by Percy. The steam pouring from under her vivid hair gave the impression that her whole head was on fire. Raindrops the size of bullets thundered on the castle windows for days on end; the lake rose, the flower beds turned into muddy streams, and Hagrid's pumpkins swelled to the size of garden sheds. Oliver Wood's enthusiasm for regular training sessions, however, was not dampened, which was why Harry was to be found, late one stormy Saturday afternoon a few days before Halloween, returning to Gryffindor Tower, drenched to the skin and splattered with mud. Even aside from the rain and wind it hadn't been a happy practice session. Fred and George, who had been spying on the Slytherin team, had seen for themselves the speed of those new Nimbus Two Thousand and Ones. They reported that the Slytherin team was no more than seven greenish blurs, shooting through the air like missiles. As Harry squelched along the deserted corridor he came across somebody who looked just as preoccupied as he was. Nearly Headless Nick, the ghost of Gryffindor Tower, was staring morosely out of a window, muttering under his breath, '. . . don't fulfill their requirements . . . half an inch, if that . . .' 'Hello, Nick,' said Harry. 'Hello, hello,' said Nearly Headless Nick, starting and looking round. He wore a dashing, plumed hat on his long curly hair, and a tunic with a ruff, which concealed the fact that his neck was almost completely severed. He was pale as smoke, and Harry could see right through him to the dark sky and torrential rain outside. 'You look troubled, young Potter,' said Nick, folding a transparent letter as he spoke and tucking it inside his doublet. 'So do you,' said Harry. 'Ah,' Nearly Headless Nick waved an elegant hand, 'a matter of no importance. . . . It's not as though I really wanted to join. . . . Thought I'd apply, but apparently I 'don't fulfill requirements' -' In spite of his airy tone, there was a look of great bitterness on his face. 'But you would think, wouldn't you,' he erupted suddenly, pulling the letter back out of his pocket, 'that getting hit forty-five times in the neck with a blunt axe would qualify you to join the Headless Hunt?' 'Oh - yes,' said Harry, who was obviously supposed to agree. 'I mean, nobody wishes more than I do that it had all been quick and clean, and my head had come off properly, I mean, it would have saved me a great deal of pain and ridicule. However -' Nearly Headless Nick shook his letter open and read furiously: ''We can only accept huntsmen whose heads have parted company with their bodies. You will appreciate that it would be impossible otherwise for members to participate in hunt activities such as Horseback Head-Juggling and Head Polo. It is with the greatest regret, therefore, that I must inform you that you do not fulfill our requirements. With very best wishes, Sir Patrick Delaney-Podmore.'' Fuming, Nearly Headless Nick stuffed the letter away. 'Half an inch of skin and sinew holding my neck on, Harry! Most people would think that's good and beheaded, but oh, no, it's not enough for Sir Properly Decapitated-Podmore.' Nearly Headless Nick took several deep breaths and then said, in a far calmer tone, 'So - what's bothering you? Anything I can do?' 'No,' said Harry. 'Not unless you know where we can get seven free Nimbus Two Thousand and Ones for our match against Sly -' ");
                break;
        }
    }

//    This class only opens other FXML pages
    public void openProgressive(ActionEvent actionEvent) throws IOException{
        Window mainWindow = progressiveButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Gameplay/ProgressiveGame.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

    public void openTwoPlay(ActionEvent actionEvent) throws IOException{
        Window mainWindow = legacyButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Gameplay/MainGame.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

    public void openLegacy(ActionEvent actionEvent) throws IOException{
        Window mainWindow = twoButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Gameplay/TwoPlayers.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

    public void backButton(ActionEvent actionEvent) throws IOException {
        Window mainWindow = backButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("../Menus/MainMenu.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

}
