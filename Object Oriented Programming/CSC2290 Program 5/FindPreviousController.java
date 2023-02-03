package Program5;
// Importing the necessary libraries.

import java.io.IOException;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FindPreviousController extends MadlibsController {

    // Grabbing the text field used for input.
    @FXML
    private TextField text;
    // Grabbing the label which will later show our result.
    @FXML
    private Label result;
    // An empty string used to store the search query. 
    String searchQ = "";

    // Method for the enter button located on the scene.
    public void onMouseClick2(MouseEvent mouseEvent) throws IOException {
        // Creating the button object.
        Button button = (Button) mouseEvent.getSource();
        // Gets the text of the button.
        String buttonText = button.getText();
        // Based on the previous text, the method performs the following operation:
        switch (buttonText) {
            case "Enter":
                // Save the search query from the text field.
                searchQ = text.getText();
                // Clear the text field in order to show acceptance of input 
                text.setText("");
                // An emptyy story string.
                String story = "";
                // If a viable index is provided...
                if (Integer.valueOf(searchQ) <= FinalStoryController.getStories().size()) {
                    // Setting the story string to the story at necessary index.
                    story = FinalStoryController.getStories().get(Integer.parseInt(searchQ) - 1);
                    // Set the label to the searched story.
                    result.setText(story);
                } // If an index outside of viable range is given...
                else {
                    // Print an error message.
                    result.setText("No Story Found");
                }
        }
    }
}
