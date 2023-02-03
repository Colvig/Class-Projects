// Names: Emmiliya Pismenchuk, Haley Cahoon, and Taylor Colbert
// Emails: emmiliyap@outlook.com, haleyanncahoon@gmail.com, and colbert.taylor@gmail.com
// Class: CSC2290 - Section 2 
// Title: MadLibs! (a basic madlibs simulator) Program 5
// Date: 4/26/2022
// “I will practice academic and personal integrity and excellence of character and expect the same from others."

package Program5;

// Importing the necessary libraries.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Modality;

public class Main extends Application {

    // Creating all of the stages that we will be using.
    private static Stage wordStage = null;
    private static Stage finalStage = null;
    private static Stage previousStage = null;
    private static Stage errorStage = null;
    private static Stage errorWStage = null;
    private static Stage errorSStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating the main stage.
        Parent root = FXMLLoader.load(getClass().getResource("madlibs.fxml"));
        primaryStage.setTitle("Mad Libs");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        // Calling all of the other stage's creation methods.
        createWordStage();
        createFinalStage();
        createPreviousStage();
        createErrorStage();
        createErrorWStage();
        createErrorSStage();
    }

    // Creation of the Add Word Stage.
    public void createWordStage() {
        wordStage = new Stage();
        wordStage.initModality(Modality.APPLICATION_MODAL);
        wordStage.setTitle("Word Adder");
    }

    // Creation of the Final Story Stage.
    public void createFinalStage() {
        finalStage = new Stage();
        finalStage.initModality(Modality.APPLICATION_MODAL);
        finalStage.setTitle("The Final Story");
    }

    // Creation of the Previous Finder Stage.
    public void createPreviousStage() {
        previousStage = new Stage();
        previousStage.initModality(Modality.APPLICATION_MODAL);
        previousStage.setTitle("Story Finder");
    }

    // Creation of the Template Error Stage.
    public void createErrorStage() {
        errorStage = new Stage();
        errorStage.initModality(Modality.APPLICATION_MODAL);
        errorStage.setTitle("Error!");
    }

    // Creation of the Word Limit Error Stage.
    public void createErrorWStage() {
        errorWStage = new Stage();
        errorWStage.initModality(Modality.APPLICATION_MODAL);
        errorWStage.setTitle("Error!");
    }

    // Creation of the Story Error Stage.
    public void createErrorSStage() {
        errorSStage = new Stage();
        errorSStage.initModality(Modality.APPLICATION_MODAL);
        errorSStage.setTitle("Error!");
    }

    // Getter for the word stage.
    public static Stage getWordStage() {
        return wordStage;
    }

    // Getter for the final stage.
    public static Stage getFinalStage() {
        return finalStage;
    }

    // Getter for the previous stage.
    public static Stage getPreviousStage() {
        return previousStage;
    }

    // Getter for the error template stage.
    public static Stage getErrorStage() {
        return errorStage;
    }

    // Getter for the error word stage.
    public static Stage getErrorWStage() {
        return errorWStage;
    }

    // Getter for the error story stage.
    public static Stage getErrorSStage() {
        return errorSStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
