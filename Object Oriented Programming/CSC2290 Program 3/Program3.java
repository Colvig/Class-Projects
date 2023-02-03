// Name: Haley Cahoon
// Date: 03/22/2022
// Email: haleyanncahoon@gmail.com
// Course Number: CSC2290-002
// Mario Kart eSports Tournament (Version 2:
// FSC Honor Code: I will practice academic and personal integrity and
// excellence of character and expect the same from others.

import java.util.*; // importing everything needed for this program

public class Program3 {

    public static String[] karts = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser", "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "BiddyBuggy", "Landship", "Sneeker", "Sports Coupe", "Gold Standard"};
    public static String[] bikes = {"Standard Bike", "Comet", "Sports Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty", "Jet Bike", "Yoshi Bike"};
    public static String[] ATVs = {"Standard ATV", "Wild Wiggler", "Teddy Buggy"};
    public static String[] chars = {"Mario", "Luigi", "Peach", "Yoshi", "Bowser", "Donkey Kong", "Toad", "Koopa Troopa", "Daisy", "Shy Guy", "Wario", "Waluigi", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy"};
    public static String[] tracks = {"Sunshine Airport", "Dolphin Shoals", "Electrodrome", "Mount Wario"};
    public static int[] recordTimes = {115, 117, 115, 100};
    public static boolean[] timeTrialPerformed = new boolean[4];

    // this method displays the main menu
    public static void displayMenu() {
        System.out.print("\n---------------------------------------------------------------------\n"
                + "|                FSC eSports - Mario Kart Tournament                |\n"
                + "---------------------------------------------------------------------\n"
                + "| Please choose from the following menu:                            |\n"
                + "|     1. Register a new competitor                                  |\n"
                + "|     2. Search for a competitor by ID number                       |\n"
                + "|     3. Search for a competitor by name                            |\n"
                + "|     4. Perform Time Trial                                         |\n"
                + "|     5. Display Leaderboard                                        |\n"
                + "|     6. Display all competitors                                    |\n"
                + "|     7. Display statistics                                         |\n"
                + "|     8. Erase all competitor times and reset Leaderboard           |\n"
                + "|     9. Quit                                                       |\n"
                + "---------------------------------------------------------------------\n"
                + "Enter your choice: ");
    }

    // this method handles the reading and verifying of the users input, returns the chosen input
    // if valid, or lets the user know that their choice is not a valid selection
    public static int readAndVerifyChoice(Scanner in, int numChoices) {
        String userChoice;
        int userChoiceInt;

        while (true) {
            userChoice = in.nextLine();

            if ((userChoice.length() == 1 || userChoice.length() == 2) && containsOnlyDigits(userChoice)) {
                userChoiceInt = Integer.parseInt(userChoice);

                if (userChoiceInt >= 1 && userChoiceInt <= numChoices) {
                    return userChoiceInt;
                } else {
                    System.out.printf("\nInvalid selection. Your choice must be a number between 1 and %d.\n", numChoices);
                    System.out.println("Please try again.\n");
                    System.out.print("Enter your choice: ");
                }
            } else {
                System.out.printf("\nInvalid selection. Your choice must be a number between 1 and %d.\n", numChoices);
                System.out.println("Please try again.\n");
                System.out.print("Enter your choice: ");
            }
        }
    }
    
    public static int readAndVerifyTT(Scanner in, int numChoices) {
        String userChoice;
        int userChoiceInt;

        System.out.println("---------------------------------------------------------------------\n" +
"|                   Track Selection for Time Trial                  |\n" +
"---------------------------------------------------------------------\n" +
"| Please select the track for the time trial:                       |\n" +
"|     1. Sunshine Airport                                           |\n" +
"|     2. Dolphin Shoals                                             |\n" +
"|     3. Electrodrome                                               |\n" +
"|     4. Mount Wario                                                |\n" +
"---------------------------------------------------------------------");
        System.out.print("Enter your choice: ");
        while (true) {
            userChoice = in.nextLine();

            if ((userChoice.length() == 1 || userChoice.length() == 2) && containsOnlyDigits(userChoice)) {
                userChoiceInt = Integer.parseInt(userChoice);

                if (userChoiceInt >= 1 && userChoiceInt <= numChoices) {
                    return userChoiceInt;
                } else {
                    System.out.printf("\nInvalid selection. Your choice must be a number between 1 and %d.\n", numChoices);
                    System.out.println("Please try again.\n");
                    System.out.print("Enter your choice: ");
                }
            } else {
                System.out.printf("\nInvalid selection. Your choice must be a number between 1 and %d.\n", numChoices);
                System.out.println("Please try again.\n");
                System.out.print("Enter your choice: ");
            }
        }
    }

    // this method validates the users input as being a valid ID that contains 7 digits, or lets the usert know
    // that their input is an invalid ID
    public static int readAndVerifyID(Scanner in) {
        String id;
        System.out.print("\nEnter the ID of the competitor: ");
        while (true) {

            id = in.nextLine();

            if (id.length() == 7 && containsOnlyDigits(id) == true) {
                return Integer.parseInt(id);
            } else {
                System.out.println("\nInvalid entry. Please try again.\n");
                System.out.print("Enter the ID of the competitor: ");
            }
        }
    }

    // this method receives a single String parameter and checks if all characters of the string are digits
    public static boolean containsOnlyDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyNameChars(String s) {
        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(Character.isLetter(c) || c == ' ' || c == '-')) {
                return false;
            }
        }
        return true;
    }

    // This method verifys if the first and last name the competitor inputs is valid by checking if the name is between 2
    // and 20 characters and contains only letters, spaces, or dashes. If not valid an appropriate output is printed
    public static String readAndVerifyName(Scanner in, String type) {
        String name;
        System.out.printf("Enter the %s name of the competitor: ", type);
        while (true) {
            name = in.nextLine();

            if (name.length() > 1 && name.length() < 21 && containsOnlyNameChars(name)) {
                return name;
            } else {
                System.out.println("\nInvalid entry. Name must be between 2 and 20 characters and");
                System.out.println("may only contain letters, spaces, or dashes. Please try again.\n");
                System.out.printf("Enter the %s name of the competitor: ", type);
            }
        }
    }

    public static String selectVehicle(Scanner in) {
        int category, vehicleSelection;

        System.out.print("\n---------------------------------------------------------------------\n"
                + "|                         Vehicle Category                          |\n"
                + "---------------------------------------------------------------------\n"
                + "| Please choose your category of vehicle:                           |\n"
                + "|     1. Kart                                                       |\n"
                + "|     2. Bike                                                       |\n"
                + "|     3. ATV                                                        |\n"
                + "---------------------------------------------------------------------\n"
                + "Enter your choice: ");

        category = readAndVerifyChoice(in, 3);

        switch (category) {
            case 1:
                System.out.println("\n---------------------------------------------------------------------\n"
                        + "|                          Kart Selection                           |\n"
                        + "---------------------------------------------------------------------\n"
                        + "| Please choose your Kart:                                          |");
                for (int i = 0; i < karts.length; i++) {
                    System.out.printf("|     %-4s%-58s|\n", (i + 1) + ".", karts[i]);
                }
                System.out.print("---------------------------------------------------------------------\n"
                        + "Enter your choice: ");
                vehicleSelection = readAndVerifyChoice(in, karts.length);
                return karts[vehicleSelection - 1];
            case 2:
                System.out.println("\n---------------------------------------------------------------------\n"
                        + "|                          Bike Selection                           |\n"
                        + "---------------------------------------------------------------------\n"
                        + "| Please choose your Bike:                                          |");
                for (int i = 0; i < bikes.length; i++) {
                    System.out.printf("|     %-3s%-59s|\n", (i + 1) + ".", bikes[i]);
                }
                System.out.print("---------------------------------------------------------------------\n"
                        + "Enter your choice: ");
                vehicleSelection = readAndVerifyChoice(in, bikes.length);
                return bikes[vehicleSelection - 1];
            default:
                System.out.println("\n---------------------------------------------------------------------\n"
                        + "|                          ATV Selection                            |\n"
                        + "---------------------------------------------------------------------\n"
                        + "| Please choose your ATV:                                           |");
                for (int i = 0; i < ATVs.length; i++) {
                    System.out.printf("|     %-3s%-59s|\n", (i + 1) + ".", ATVs[i]);
                }
                System.out.print("---------------------------------------------------------------------\n"
                        + "Enter your choice: ");
                vehicleSelection = readAndVerifyChoice(in, ATVs.length);
                return ATVs[vehicleSelection - 1];
        }
    }

    public static String selectCharacter(Scanner in) {
        int characterSelection;

        System.out.println("\n---------------------------------------------------------------------\n"
                + "|                        Character Selection                        |\n"
                + "---------------------------------------------------------------------\n"
                + "| Please choose your character:                                     |");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("|     %-4s%-58s|\n", (i + 1) + ".", chars[i]);
        }
        System.out.print("---------------------------------------------------------------------\n"
                + "Enter your choice: ");

        characterSelection = readAndVerifyChoice(in, chars.length);
        return chars[characterSelection - 1];
    }

    // This method registers a new competitor by scanning the ID, first name, and last name from the user from
    // the verify methods.
    public static void registerCompetitor(Competitor[] competitors, Scanner in) {
        int id = readAndVerifyID(in);
        String firstName = readAndVerifyName(in, "first");
        String lastName = readAndVerifyName(in, "last");
        String character = selectCharacter(in);
        String vehicle = selectVehicle(in);

        System.out.println("");
        System.out.println("You have successfully registered the following competitor:");
        System.out.printf("   %s %s (ID: %d)\n", firstName, lastName, id);
        System.out.printf("   Character: %s\n", character);
        System.out.printf("   Vehicle:   %s\n", vehicle);
        System.out.println("   ***Best Times***");
        System.out.println("      Sunshine Airport: no time recorded");
        System.out.println("      Dolphin Shoals:   no time recorded");
        System.out.println("      Electrodrome:     no time recorded");
        System.out.println("      Mount Wario:      no time recorded");

        Competitor player = new Competitor(id, firstName, lastName, character, vehicle);
        competitors[Competitor.getNumCompetitors()] = player;

        // THIS IS THE PART WHERE I NEED TO SORT MY ARRAY OF STUFF BUT I DECIDED TO WAIT ON DOPING THIS SO I CAN DO OTHER STUFF BUT I DON"T WANT TO FORGET TO DO THIS
        Competitor.setNumCompetitors(Competitor.getNumCompetitors() + 1);
    }

    public static void searchByID(Competitor[] competitors, Scanner in) {
        int idSearch = readAndVerifyID(in);
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            if (competitors[i].getId() == idSearch) {
                System.out.println("");
                System.out.println("Competitor was successfully found!");
                System.out.printf("   %s %s (ID: %d)\n", competitors[i].getFirstName(), competitors[i].getLastName(), competitors[i].getId());
                System.out.printf("   Character: %s\n", competitors[i].getCharacter());
                System.out.printf("   Vehicle:   %s\n", competitors[i].getVehicle());
                System.out.println("   ***Best Times***");
                if (competitors[i].getBestTimes(0) == 0) {
                    System.out.printf("      Sunshine Airport: no time recorded\n");
                } else {
                    int time = competitors[i].getBestTimes(0);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Sunshine Airport: %d'%02d\"\n", timeInMin, timeInSec);
                }
                if (competitors[i].getBestTimes(1) == 0) {
                    System.out.println("      Dolphin Shoals:   no time recorded");
                } else {
                    int time = competitors[i].getBestTimes(1);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Dolphin Shoals:   %d'%02d\"\n", timeInMin, timeInSec);
                }
                if (competitors[i].getBestTimes(2) == 0) {
                    System.out.println("      Electrodrome:     no time recorded");
                } else {
                    int time = competitors[i].getBestTimes(2);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Electrodrome:     %d'%02d\"\n", timeInMin, timeInSec);
                }
                if (competitors[i].getBestTimes(3) == 0) {
                    System.out.println("      Mount Wario:      no time recorded");
                } else {
                    int time = competitors[i].getBestTimes(3);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Mount Wario:      %d'%02d\"\n", timeInMin, timeInSec);
                }
                System.out.println("");
                return;
            }

        }
    }

    // this method scans a first name and last name to search for, if found the competitor details are printed
    // if there is no matching competitor, an appropriate output is printed
    public static void searchByName(Competitor[] competitors, Scanner in) {
        String first = readAndVerifyName(in, "first");
        String last = readAndVerifyName(in, "last");
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            if (competitors[i].getFirstName().equalsIgnoreCase(first) && competitors[i].getLastName().equalsIgnoreCase(last)) {
                System.out.println("");
                System.out.println("Competitor was successfully found!");
                System.out.printf("   %s %s (ID: %d)\n", competitors[i].getFirstName(), competitors[i].getLastName(), competitors[i].getId());
                System.out.printf("   Character: %s\n", competitors[i].getCharacter());
                System.out.printf("   Vehicle:   %s\n", competitors[i].getVehicle());
                System.out.println("   ***Best Times***");
                if (competitors[i].getBestTimes(0) == 0) {
                    System.out.printf("      Sunshine Airport: no time recorded\n");
                } else {
                    int time = competitors[i].getBestTimes(0);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Sunshine Airport: %d'%02d\"\n", timeInMin, timeInSec);
                }
                if (competitors[i].getBestTimes(1) == 0) {
                    System.out.println("      Dolphin Shoals:   no time recorded");
                } else {
                    int time = competitors[i].getBestTimes(1);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Dolphin Shoals:   %d'%02d\"\n", timeInMin, timeInSec);
                }
                if (competitors[i].getBestTimes(2) == 0) {
                    System.out.println("      Electrodrome:     no time recorded");
                } else {
                    int time = competitors[i].getBestTimes(2);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Electrodrome:     %d'%02d\"\n", timeInMin, timeInSec);
                }
                if (competitors[i].getBestTimes(3) == 0) {
                    System.out.println("      Mount Wario:      no time recorded");
                } else {
                    int time = competitors[i].getBestTimes(3);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Mount Wario:      %d'%02d\"\n", timeInMin, timeInSec);
                }
                System.out.println("");
                return;
            }
        }
        System.out.printf("Competitor \"%s %s\" was not found in the system.\n", first, last);
        System.out.println("");
    }

    // this method creates the time trials for the registered competitors on a selected track. the method asks the user
    // to select a track for the time trial, the user input is then checked by the readAndVerify method to make sure that the
    // input is valid. if valid a loop is used to assign new times for each competitor. the newly assigned times are generated
    // randomly by taking the current world record for the track and randomly adding up to 29 seconds to it for each competitor.
    public static void performTimeTrial(Competitor[] competitors, Scanner in, Random rng) {
        int trackChoice = readAndVerifyTT(in, 4);
            if (trackChoice == 1) {
                for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                    int num = rng.nextInt(30);
                    competitors[i].setBestTimes(0, recordTimes[0] + num);                    
                }
                System.out.println("\nAll competitors have new times recorded for Sunshine Airport.");
            } else if (trackChoice == 2) {
                for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                    int num = rng.nextInt(30);
                    competitors[i].setBestTimes(1, recordTimes[1] + num);              
                }
                System.out.println("\nAll competitors have new times recorded for Dolphin Shoals.");
            } else if (trackChoice == 3) {
                for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                    int num = rng.nextInt(30);
                    competitors[i].setBestTimes(2, recordTimes[2] + num);
                }
                System.out.println("\nAll competitors have new times recorded for Electrodrome.");
            } else {
                for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                    int num = rng.nextInt(30);
                    competitors[i].setBestTimes(3, recordTimes[3] + num);                
                }
                System.out.println("\nAll competitors have new times recorded for Mount Wario.");
            }
        
        
    }

    // this method displays the leader board. It determines the best recorded recorded time for each track and displays the user
    // who set that record
    // if the track does not have a time trial recorded yet, the method will print an appropriate output
    public static void displayLeaderBoard(Competitor[] competitors) {
        int fastestSunshine = Integer.MAX_VALUE;
        int fastestDolphin = Integer.MAX_VALUE;
        int fastestElectrodome = Integer.MAX_VALUE;
        int fastestMount = Integer.MAX_VALUE;
        int indexSunshine = -1;
        int indexDolphin = -1;
        int indexElectrodome = -1;
        int indexMount = -1;
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            if (competitors[i].getBestTimes(0) < fastestSunshine && competitors[i].getBestTimes(0) != 0) {
                fastestSunshine = competitors[i].getBestTimes(0);
                indexSunshine = i;
            }
            if (competitors[i].getBestTimes(1) < fastestDolphin && competitors[i].getBestTimes(1) != 0) {
                fastestDolphin = competitors[i].getBestTimes(1);
                indexDolphin = i;
            }
            if (competitors[i].getBestTimes(2) < fastestElectrodome && competitors[i].getBestTimes(2) != 0) {
                fastestElectrodome = competitors[i].getBestTimes(2);
                indexElectrodome = i;
            }
            if (competitors[i].getBestTimes(4) < fastestMount && competitors[i].getBestTimes(4) != 0) {
                fastestMount = competitors[i].getBestTimes(3);
                indexMount = i;
            }
        }
        if (fastestSunshine == Integer.MAX_VALUE){
            System.out.println("   Sunshine Airport");
            System.out.println("      no time trials recorded");
        }
        else{
            System.out.printf("   Sunshine Airport\n");
            System.out.printf("      %s %s (ID: %d)\n", competitors[indexSunshine].getFirstName(), competitors[indexSunshine].getLastName(), competitors[indexSunshine].getId());
            System.out.printf("      Character: %s\n", competitors[indexSunshine].getCharacter());
            System.out.printf("      Vehicle:   %s\n", competitors[indexSunshine].getVehicle());
            int time = competitors[indexSunshine].getBestTimes(0);
            int timeInMin = time / 60;
            int timeInSec = time % 60;
            System.out.printf("      Time:      %d'%02d\"\n", timeInMin, timeInSec);
        }
       
        if (fastestDolphin == Integer.MAX_VALUE){
            System.out.println("   Dolphin Shoals");
            System.out.println("      no time trials recorded");
        }
        else{
            System.out.printf("   Dolphin Shoals\n");
            System.out.printf("      %s %s (ID: %d)\n", competitors[indexDolphin].getFirstName(), competitors[indexDolphin].getLastName(),  competitors[indexDolphin].getId());
            System.out.printf("      Character: %s\n", competitors[indexDolphin].getCharacter());
            System.out.printf("      Vehicle:   %s\n", competitors[indexDolphin].getVehicle());
            int time = competitors[indexDolphin].getBestTimes(1);
            int timeInMin = time / 60;
            int timeInSec = time % 60;
            System.out.printf("      Time:      %d'%02d\"\n", timeInMin, timeInSec);
        }
       
        if (fastestElectrodome == Integer.MAX_VALUE){
            System.out.println("   Electrodrome");
            System.out.println("      no time trials recorded");
        }
        else{
            System.out.printf("   Electrodrome\n");
            System.out.printf("      %s %s (ID: %d)\n", competitors[indexElectrodome].getFirstName(), competitors[indexElectrodome].getLastName(), competitors[indexElectrodome].getId());
            System.out.printf("      Character: %s\n", competitors[indexElectrodome].getCharacter());
            System.out.printf("      Vehicle:   %s\n",competitors[indexElectrodome].getVehicle());
            int time = competitors[indexElectrodome].getBestTimes(2);
            int timeInMin = time / 60;
            int timeInSec = time % 60;
            System.out.printf("      Time:      %d'%02d\"\n", timeInMin, timeInSec);
        }
       
        if (fastestMount == Integer.MAX_VALUE){
            System.out.println("   Mount Wario");
            System.out.println("      no time trials recorded");
        }
        else{
            System.out.printf("   Mount Wario\n");
            System.out.printf("      %s %s (ID: %d)\n", competitors[indexMount].getFirstName(), competitors[indexMount].getLastName(), competitors[indexMount].getId());
            System.out.printf("      Character: %s\n", competitors[indexMount].getCharacter());
            System.out.printf("      Vehicle:   %s\n", competitors[indexMount].getVehicle());
            int time = competitors[indexMount].getBestTimes(3);
            int timeInMin = time / 60;
            int timeInSec = time % 60;
            System.out.printf("      Time:      %d'%02d\"\n", timeInMin, timeInSec);
        }
    }

    // this method loops over all competitors and prints their information, and if there are no registered competitors, an appropriate
    // output is printed
    public static void displayAllCompetitors(Competitor[] competitors) {
        if (Competitor.getNumCompetitors() == 0) {
            System.out.println("There are no competitors currently registered in the system.");
            System.out.println("");
        } else {
            System.out.println("Competitors registered in the system:");
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                System.out.printf("   %s %s (ID: %d)\n", competitors[i].getFirstName(), competitors[i].getLastName(), competitors[i].getId());
                System.out.printf("    Character: %s\n", competitors[i].getCharacter());
                System.out.printf("    Vehicle:   %s\n", competitors[i].getVehicle());
                System.out.println("   ***Best Times***");
                if (competitors[i].getBestTimes(0) == 0) {
                    System.out.printf("      Sunshine Airport: no time recorded\n");
                } else {
                    int time = competitors[i].getBestTimes(0);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Sunshine Airport: %d'%02d\"\n", timeInMin, timeInSec);
                }
                if (competitors[i].getBestTimes(1) == 0) {
                    System.out.println("      Dolphin Shoals:   no time recorded");
                } else {
                    int time = competitors[i].getBestTimes(1);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Dolphin Shoals:   %d'%02d\"\n", timeInMin, timeInSec);
                }
                if (competitors[i].getBestTimes(2) == 0) {
                    System.out.println("      Electrodrome:     no time recorded");
                } else {
                    int time = competitors[i].getBestTimes(2);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Electrodrome:     %d'%02d\"\n", timeInMin, timeInSec);
                }
                if (competitors[i].getBestTimes(3) == 0) {
                    System.out.println("      Mount Wario:      no time recorded");
                } else {
                    int time = competitors[i].getBestTimes(3);
                    int timeInMin = time / 60;
                    int timeInSec = time % 60;
                    System.out.printf("      Mount Wario:      %d'%02d\"\n", timeInMin, timeInSec);
                }
                System.out.println("");
            }
        }
    }

    // this method calculates the average time trial for each track. That time is then displayed
    // if there are no time trials recorded, an appropriate output is printed
    public static void displayStatistics(Competitor[] competitors) {
        if (Competitor.getNumCompetitors() == 0) {
            System.out.println("There are no statistics recorded, as there are no\n"
                    + "competitors currently registered in the system.");
            System.out.println("");
            return;
        }
        int sumSunshine = 0;
        int sumDolphin = 0;
        int sumElectrodome = 0;
        int sumMount = 0;
        int countSunshine = 0;
        int countDolphin = 0;
        int countElectrodome = 0;
        int countMount = 0;
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            if (competitors[i].getBestTimes(0) != 0) {
                sumSunshine += competitors[i].getBestTimes(0);
                countSunshine++;
            }
            if (competitors[i].getBestTimes(1) != 0) {
                sumDolphin += competitors[i].getBestTimes(1);
                countDolphin++;
            }
            if (competitors[i].getBestTimes(2) != 0) {
                sumElectrodome += competitors[i].getBestTimes(2);
                countElectrodome++;
            }
            if (competitors[i].getBestTimes(3) != 0) {
                sumMount += competitors[i].getBestTimes(3);
                countMount++;
            }
        }
        System.out.println("Statistics of Completed Time Trials - Average Time per Track");
        if (countSunshine == 0) {
            System.out.println("      Sunshine Airport: no time trials recorded");
        } else {
            int time = sumSunshine / countSunshine;
            int timeInMin = time / 60;
            int timeInSec = time % 60;
            System.out.printf("      Sunshine Airport: %d'%02d\"\n", timeInMin, timeInSec);
        }

        if (countDolphin == 0) {
            System.out.println("      Dolphin Shoals:   no time trials recorded");
        } else {
            int time = sumDolphin / countDolphin;
            int timeInMin = time / 60;
            int timeInSec = time % 60;
            System.out.printf("      Dolphin Shoals:   %d'%02d\"\n", timeInMin, timeInSec);
        }

        if (countElectrodome == 0) {
            System.out.println("      Electrodrome:     no time trials recorded");
        } else {
            int time = sumElectrodome / countElectrodome;
            int timeInMin = time / 60;
            int timeInSec = time % 60;
            System.out.printf("      Electrodrome:     %d'%02d\"\n", timeInMin, timeInSec);
        }

        if (countMount == 0) {
            System.out.println("      Mount Wario:      no time trials recorded");
        } else {
            int time = sumMount / countMount;
            int timeInMin = time / 60;
            int timeInSec = time % 60;
            System.out.printf("      Mount Wario:      %d'%02d\"\n", timeInMin, timeInSec);
        }
        System.out.println("");
}

    // this method erases the saved times for each competitor
    public static void eraseAndReset(Competitor[] competitors) {
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            competitors[i].setBestTimes(0,0);
            competitors[i].setBestTimes(1,0);
            competitors[i].setBestTimes(2,0);
            competitors[i].setBestTimes(3,0);
        }
        System.out.println("");
        System.out.println("All competitors times have been cleared, and the Leaderboard has been reset.");
    }

    public static void main(String[] args) {
        // Variables used in program
        Scanner in = new Scanner(System.in);
        Random rng;               // Random Number Generator
        int maxCompetitors;       // value read from user and used to create arrays
        int seed;                 // value read from user and used to seed the RNG
        int userChoice;           // value read from user as their main menu selection
        Competitor[] competitors; // array to store the competitor object references

        // Scan seed used for random
        System.out.print("Enter the seed for the random number generator: ");
        seed = Integer.parseInt(in.nextLine());
        rng = new Random(seed);

        // Scan max number of competitors
        System.out.print("Enter the maximum number of competitors: ");
        maxCompetitors = Integer.parseInt(in.nextLine());

        // Create the new array of Competitor references
        competitors = new Competitor[maxCompetitors];
        // This is an array of Competitor object REFERENCES
        // Each reference currently points to "null" (no objects have been created yet)

        OUTER:
        while (true) {
            displayMenu();
            userChoice = readAndVerifyChoice(in, 9);
            switch (userChoice) {
                case 1:
                    registerCompetitor(competitors, in);
                    break;
                case 2:
                    searchByID(competitors, in);
                    break;
                case 3:
                    searchByName(competitors, in);
                    break;
                case 4:
                    performTimeTrial(competitors, in, rng);
                    break;
                case 5:
                    displayLeaderBoard(competitors);
                    break;
                case 6:
                    displayAllCompetitors(competitors);
                    break;
                case 7:
                    displayStatistics(competitors);
                    break;
                case 8:
                    eraseAndReset(competitors);
                    break;
                default:
                    // if (userChoice == 8) {
                    System.out.println("\nGoodbye!");
                    break OUTER;
            } // end switch
        } // end while (true)
    } // end main()
}
