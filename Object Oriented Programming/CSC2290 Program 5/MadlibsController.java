package Program5;
// Importing the necessary libraries.

import java.io.IOException;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MadlibsController {

    // Creating all of the needed int values.
    private int chosenTemp;
    private int bankCategory;
    private int numOfStories;
    // Creating all of the Array Lists.
    private static ArrayList<String> noun_wordbank = new ArrayList<>();
    private static ArrayList<String> adjective_wordbank = new ArrayList<>();
    private static ArrayList<String> verb_wordbank = new ArrayList<>();
    private static ArrayList<String> prev_stories = new ArrayList<>();
    // Creating a temporary String.
    private static String temp;

    // A getter for the temp String.
    public static String getWord() {
        return temp;
    }

    // A setter for the temp String.
    public static void setWord(String temp) {
        MadlibsController.temp = temp;
    }

    // A method which opens and operates the add word function.
    public void openAddWords() throws IOException {
        try {
            // Creates the stage.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addwords.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Main.getWordStage().setScene(new Scene(root1));
            Main.getWordStage().setResizable(false);
            // Shows the stage.
            Main.getWordStage().show();
            // If the category is noun...
            if (bankCategory == 1) {
                // Add the word to the noun list.
                noun_wordbank.add(temp);
            }
            // If the category is adjective...
            if (bankCategory == 2) {
                // Add the word to the adjective list.
                adjective_wordbank.add(temp);
            }
            // If the category is verb...
            if (bankCategory == 3) {
                // Add the word to the verb list.
                verb_wordbank.add(temp);
            }
        } // Prints an error if the stage couldn't initiate.
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    // A method which opens and operates the final story function.
    public void openFinalStory() throws IOException {
        try {
            // Creates the stage.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("finalstory.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Main.getFinalStage().setScene(new Scene(root1));
            // Grabs the controller for the stage.
            FinalStoryController finalController = fxmlLoader.getController();
            // Shows the stage.
            Main.getFinalStage().show();
            Main.getFinalStage().setResizable(false);
            // Adds the final story product to the previous story archive Array List.
            prev_stories.add(finalController.printStory(noun_wordbank, adjective_wordbank, verb_wordbank, chosenTemp, prev_stories));
        } // Prints an error if the stage couldn't initiate.
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    // A method which opens and operates the previous story function.
    public void openPreviousFinder() throws IOException {
        try {
            // Creates the stage.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("findprevious.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Main.getPreviousStage().setScene(new Scene(root1));
            // Shows the stage.
            Main.getPreviousStage().show();
            Main.getPreviousStage().setResizable(false);
        } // Prints an error if the stage couldn't initiate.
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    // A method which opens the template-based error.
    public void openErrorTemp() throws IOException {
        try {
            // Creates the stage.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Main.getErrorStage().setScene(new Scene(root1));
            // Shows the stage.
            Main.getErrorStage().show();
            Main.getErrorStage().setResizable(false);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    // A method which opens the word-based error.
    public void openErrorWord() throws IOException {
        try {
            // Creates the stage.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error2.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Main.getErrorWStage().setScene(new Scene(root1));
            // Shows the stage.
            Main.getErrorWStage().show();
            Main.getErrorWStage().setResizable(false);
        } // Prints an error if the stage couldn't initiate.
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    // A method which opens the story-based error.
    public void openErrorStory() throws IOException {
        try {
            // Creates the stage.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error3.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Main.getErrorSStage().setScene(new Scene(root1));
            // Shows the stage.
            Main.getErrorSStage().show();
            Main.getErrorSStage().setResizable(false);
        } // Prints an error if the stage couldn't initiate.
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    // Method for the various buttons located on the scene. 
    public void onMouseClick(MouseEvent mouseEvent) throws IOException {
        // Creating the button object.
        Button button = (Button) mouseEvent.getSource();
        // Gets the text of the button.
        String buttonText = button.getText();
        // Based on the previous text, the method performs the following operation:
        switch (buttonText) {
            case "Template: \n" + "College\n" + "Tour":
                // Sets the template to the first option.
                chosenTemp = 1;
                break;
            case "Template: \n" + "Watching\n" + "TV":
                // Sets the template to the second option.
                chosenTemp = 2;
                break;
            case "Template: \n" + "Computer":
                // Sets the template to the third option.
                chosenTemp = 3;
                break;
            case "Add Nouns":
                // Sets the category to the nouns section.
                bankCategory = 1;
                // If there is no template selected...
                if (chosenTemp == 0) {
                    // Show a template-based error.
                    openErrorTemp();
                } // If there is a template chosen...
                else {
                    // Initiates the add word method.
                    openAddWords();
                }
                break;
            case "Add Adjectives":
                // Sets the category to the adjective section.
                bankCategory = 2;
                // If there is no template selected...
                if (chosenTemp == 0) {
                    // Show a template-based error.
                    openErrorTemp();
                } // Show a template-based error.
                else {
                    // Initiates the add word method.
                    openAddWords();
                }
                break;
            case "Add Verbs":
                // Sets the category to the verb section.
                bankCategory = 3;
                // If there is no template selected...
                if (chosenTemp == 0) {
                    // Show a template-based error.
                    openErrorTemp();
                } // Show a template-based error.
                else {
                    // Initiates the add word method.
                    openAddWords();
                }
                break;
            case "Process Story":
                // If there is no template selected...
                if (chosenTemp == 0) {
                    // Show a template-based error.
                    openErrorTemp();
                }
                // If the list of nouns is empty or bellow 10 words...
                if (noun_wordbank.isEmpty() || noun_wordbank.size() == 1 || noun_wordbank.size() == 2 || noun_wordbank.size() == 3 || noun_wordbank.size() == 4
                        || noun_wordbank.size() == 5 || noun_wordbank.size() == 6 || noun_wordbank.size() == 7 || noun_wordbank.size() == 8 || noun_wordbank.size() == 9) {
                    // Show a word-based error.
                    openErrorWord();
                }
                // If the list of adjective is empty or bellow 10 words...
                if (adjective_wordbank.isEmpty() || adjective_wordbank.size() == 1 || adjective_wordbank.size() == 2 || adjective_wordbank.size() == 3
                        || adjective_wordbank.size() == 4 || adjective_wordbank.size() == 5 || adjective_wordbank.size() == 6 || adjective_wordbank.size() == 7 || adjective_wordbank.size() == 8 || adjective_wordbank.size() == 9) {
                    // Show a word-based error.
                    openErrorWord();
                }
                // If the list of verbs is empty or bellow 10 words...
                if (verb_wordbank.isEmpty() || verb_wordbank.size() == 1 || verb_wordbank.size() == 2 || verb_wordbank.size() == 3
                        || verb_wordbank.size() == 4 || verb_wordbank.size() == 5 || verb_wordbank.size() == 6 || verb_wordbank.size() == 7 || verb_wordbank.size() == 8 || verb_wordbank.size() == 9) {
                    // Show a word-based error.
                    openErrorWord();
                } // If there are enough words in all categories...
                else {
                    // Initiate the final story method.
                    openFinalStory();
                    // Add 1 to the number of stories.
                    numOfStories++;
                }
                break;
            case "Search Previous Stories":
                // If there are no stories processed...
                if (numOfStories == 0) {
                    // Show a story-based error.
                    openErrorStory();
                } // If there is at least one story processed...
                else {
                    // Initiate the previous story finder method.
                    openPreviousFinder();
                }
                break;
        }
    }
}
