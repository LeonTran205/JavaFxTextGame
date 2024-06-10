package MAIN;

import Gameplay.GameStrings;
import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

public class Main extends Application {
    private static String selectDifficulty;
    private static String grabDifficulty;
    private static String overAllScore;
    private static String overAllAccuracy;
    private static String overAllScorePlayer2;
    private static String overAllAccuracyPlayer2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Menus/StartScreen.fxml"));
        primaryStage.setTitle("Text Typer v1.0");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static String getSelectDifficulty() {
        return selectDifficulty;
    }

    public static void setSelectDifficulty(String selectDifficulty) {
        Main.selectDifficulty = selectDifficulty;
    }

    public static String getGrabDifficulty() {
        return grabDifficulty;
    }

    public static void setGrabDifficulty(String getDifficulty) {
        Main.grabDifficulty = getDifficulty;
    }

    public static String getOverAllScore() {
        return overAllScore;
    }

    public static void setOverAllScore(String overAllScore) {
        Main.overAllScore = overAllScore;
    }

    public static String getOverAllAccuracy() {
        return overAllAccuracy;
    }

    public static void setOverAllAccuracy(String overAllAccuracy) {
        Main.overAllAccuracy = overAllAccuracy;
    }

    public static String getOverAllScorePlayer2() {
        return overAllScorePlayer2;
    }

    public static void setOverAllScorePlayer2(String overAllScorePlayer2) {
        Main.overAllScorePlayer2 = overAllScorePlayer2;
    }

    public static String getOverAllAccuracyPlayer2() {
        return overAllAccuracyPlayer2;
    }

    public static void setOverAllAccuracyPlayer2(String overAllAccuracyPlayer2) {
        Main.overAllAccuracyPlayer2 = overAllAccuracyPlayer2;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
