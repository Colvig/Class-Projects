package Program5;
// Importing the libraries.

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddWordsController extends MadlibsController {

    // Grabbing the text field within the addwords scene.
    @FXML
    private TextField word;
    // Creating an empty string for the final word.
    private String wordFin = "";

    // A getter for the final word.
    public String getWordFin() {
        return wordFin;
    }

    // Method for the enter button located on the scene.
    public void onMouseClick1(MouseEvent mouseEvent) throws IOException {
        // Creating the button object.
        Button button = (Button) mouseEvent.getSource();
        // Gets the text of the button.
        String buttonText = button.getText();
        // Based on the previous text, the method performs the following operation:
        switch (buttonText) {
            case "Enter":
                // Sets the final word to the text within the text field.
                wordFin = word.getText();
                // Clears the text field to signify the recognition of the input.
                word.setText("");
                // Sets the word within the Madlibs Controller to the final word.
                MadlibsController.setWord(wordFin);
                // Closes the stage.
                Main.getWordStage().close();
        }
    }
}
