package Program5;
//Importing the necessary libraries.

import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FinalStoryController extends MadlibsController {

    // Grabbing the label which will then display our result.
    @FXML
    private Label result;
    // Creating an array list of stories.
    private static ArrayList<String> stories = new ArrayList<>();

    // A getter for the stories array list.
    public static ArrayList<String> getStories() {
        return stories;
    }

    public String printStory(ArrayList<String> noun_wordbank, ArrayList<String> adjective_wordbank, ArrayList<String> verb_wordbank, int chosenTemp, ArrayList<String> prev_stories) {
        // Random Seeds
        Random n = new Random();
        Random a = new Random();
        Random v = new Random();
        // Shuffles the ArrayList of words with the respective Random object
        Collections.shuffle(noun_wordbank, n);
        Collections.shuffle(adjective_wordbank, a);
        Collections.shuffle(verb_wordbank, v);
        // Chooses the appropriate template.
        switch (chosenTemp) {
            // If the user chose the first template...
            case 1:
                // Create an empty string...
                String s = "";
                // Add the formated template with words at particular indexes.
                s += String.format("YOUR CHOSEN THEME - COLLEGE TOUR\n");
                s += String.format("Welcome to the University of %s. Our %s campus was founded by %s and built in 1806. \n", noun_wordbank.get(0), adjective_wordbank.get(0), noun_wordbank.get(1));
                s += String.format("We begin at our %s building. This building houses %s classrooms. To your left, the %s dormitory \n", noun_wordbank.get(2), noun_wordbank.get(3), adjective_wordbank.get(1));
                s += String.format("is visible just beyond the %s. Our students come from all over the %s because we %s accept anyone \n", noun_wordbank.get(4), noun_wordbank.get(5), verb_wordbank.get(0));
                s += String.format("who applies. We will end out tour here at %s hall which houses the Computer Science majors.Here we find \n", noun_wordbank.get(6));
                s += String.format("Dr. Cazalas, who is a %s. Feel free to %s an application. Here comes the %s marching band! \n", noun_wordbank.get(7), verb_wordbank.get(1), adjective_wordbank.get(2));
                s += String.format("They are practicing our Alma Mater %s. Notice how they march in a %s formation, it is the signature \n", noun_wordbank.get(8), adjective_wordbank.get(3));
                s += String.format("move of our Univeristy. Financial aid is available to all %s applicants. More information is available \n", adjective_wordbank.get(4));
                s += String.format("on our website, %s.com. Thank you for %s with us today. Become a Moc!*clap**clap**hiss*!", noun_wordbank.get(9), verb_wordbank.get(2));
                // Sets the label to the finished story.
                result.setText(s);
                // Adds the story to the story archives (ArrayList).
                stories.add(s);
                return s;
            // If the user chose the second template...
            case 2:
                // Create an empty string...
                String s1 = "";
                // Add the formated template with words at particular indexes.
                s1 += String.format("YOUR CHOSEN THEME - WATCHING TV\n"
                        + "Only %s minutes left till the class is over, and when it does, I am so out of here!\n "
                        + "It is impossible to %s on Object-Oriented Programming when I could be home watching shows like \n"
                        + "The %s Thornberrys on %s-toons. Seriously, right now the only thing standing between me, %s Arnold! \n"
                        + "and an ice-%s juice is Dr.Cazalaz! O-M-G %s! What if my roommates make it home before I do? They totally \n"
                        + "will %s the remote, and I'd rather eat my own %s than miss an episode of Ren & %s or The %s Beavers.\n "
                        + "And do they actually think they can just %s my Fruit by the %s and keep me from watching %s Power? As if! \n"
                        + "They may be bossy like Angelica from Rug-%s, but I've got Anne Kerr's number on speed dial!", noun_wordbank.get(0), verb_wordbank.get(1), adjective_wordbank.get(0), noun_wordbank.get(1), noun_wordbank.get(2), verb_wordbank.get(2), noun_wordbank.get(3), verb_wordbank.get(3), noun_wordbank.get(4), adjective_wordbank.get(1), adjective_wordbank.get(2), adjective_wordbank.get(3), verb_wordbank.get(3), noun_wordbank.get(5), adjective_wordbank.get(4), noun_wordbank.get(6));
                // Sets the label to the finished story.
                result.setText(s1);
                // Adds the story to the story archives (ArrayList).
                stories.add(s1);
                return s1;
            // If the user chose the third template...
            case 3:
                // Create an empty string...
                String s2 = "";
                // Add the formated template with words at particular indexes.
                s2 += String.format("THEME – TECHNOLOGY \n"
                        + "Every student has a computer small enough to fit into their %s. They can solve\n"
                        + "any math problem by simply pushing the computer's little %s.\n"
                        + "Computers can add, multiply, divide, and %s.\n"
                        + "They can also %s better than a human. Some computers \n"
                        + "are %s. Others have a %s screen that shows all \n"
                        + "kinds of %s.", noun_wordbank.get(0), noun_wordbank.get(1), verb_wordbank.get(0), verb_wordbank.get(1), adjective_wordbank.get(0), adjective_wordbank.get(1), noun_wordbank.get(3));
                // Sets the label to the finished story.
                result.setText(s2);
                // Adds the story to the story archives (ArrayList).
                stories.add(s2);
                return s2;
            default:
                break;
        }
        // In case (somehow) the user managed to get through without selecting a template or adding words.
        return null;
    }

}
