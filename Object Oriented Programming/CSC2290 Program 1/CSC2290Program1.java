// Name: Haley Cahoon
// Date: 2/9/2022
// Email: haleyanncahoon@gmail.com 
// Course Number: CSC2290-002
// Are You Smarter Than A Third Grader
// FSC Honor Code: I will practice academic and personal integrity and
// excellence of character and expect the same from others.

import java.util.*; // importing everything needed for this program

public class CSC2290Program1 {
    public static long timeInMathPractice = 0; // global variable created for math practice timer
    public static void main(String[] args) {     // creating main method
        long runTime = System.currentTimeMillis(); // creating a timer to keep track of entire programs run time 
        Scanner in = new Scanner(System.in); // creating a scanner
        Random rng = new Random(777); // Seeding random object with the seed 777
        // Setting scores equal to -1 to keep track of if race to the finish(+, -, *, or /) is run
        int additionScore = -1; 
        int subtractionScore = -1;
        int multiplicationScore = -1;
        int divisionScore = -1;
        float guessScore = -1f; // setting guess score = -1 to see if number guessing game gets run
        
        while (true) {
            showMainMenu(); // display main menu
            int mainChoice = readAndVerifyChoice(in, 7); // calling readAndVerifyChoice
            if (mainChoice == 1) { // if choice on main menu = 1, run math practice
                mathPractice(in, rng); // calling mathPractice method
            } else if (mainChoice == 2) { // if choice on main menu = 2, run race to the finish addition
                int count = raceToTheFinish(in, rng, "+"); // calling raceToTheFinish method for addition
                if (additionScore == -1) {
                    System.out.println("");
                    // if first attemnt, print that it was users first attempt and format print the number of correct questions answered
                    System.out.println("This was your first time playing. As such, your");
                    System.out.printf("%d questions answered in 10 seconds is currently the best!\n", count);
                    additionScore = count;
                    System.out.println("");
                } else {
                    System.out.println("");
                    if (count > additionScore) {
                        
                        // format printing the number of correct questions answered
                        System.out.printf("Your score of %d questions answered just beat the previous best score of %d. Awesome job!\n", count, additionScore); 
                        additionScore = count;
                        System.out.println("");
                    } else {
                        System.out.println("Good effort, but you'll have to try harder to beat");
                        System.out.printf("your best score of %d questions answered.\n", additionScore);
                        System.out.println("");
                    }
                }
            } else if (mainChoice == 3) { // if choice on main menu = 3, run race to the finish subtraction
                int count = raceToTheFinish(in, rng, "-"); // calling raceToTheFinish method for subtraction
                if (subtractionScore == -1) {
                    System.out.println("");
                    
                    // printing users first attempt and then format printing users first score 
                    System.out.println("This was your first time playing. As such, your");
                    System.out.printf("%d questions answered in 10 seconds is currently the best!\n", count);
                    subtractionScore = count;
                    System.out.println("");
                } else {
                    System.out.println("");
                    if (count > subtractionScore) {
                        
                        // format printing the new personal best of user
                        System.out.printf("Your score of %d questions answered just beat the previous best score of %d. Awesome job!\n", count, subtractionScore);
                        subtractionScore = count;
                        System.out.println("");
                    } else { // if the users score is not a new high, print try harder message and format print the high score to beat
                        System.out.println("Good effort, but you'll have to try harder to beat");
                        System.out.printf("your best score of %d questions answered.\n", subtractionScore); 
                        System.out.println("");
                    }
                }
            } else if (mainChoice == 4) { // if choice on main menu = 4, run race to the finish multiplication
                int count = raceToTheFinish(in, rng, "*"); // calling raceToTheFinish method for multiplication
                if (multiplicationScore == -1) {
                    System.out.println("");
                    // printing users first attempt and then format printing users first score 
                    System.out.println("This was your first time playing. As such, your");
                    System.out.printf("%d questions answered in 10 seconds is currently the best!\n", count);
                    multiplicationScore = count;
                    System.out.println("");
                } else {
                    System.out.println("");
                    if (count > multiplicationScore) { // if users new score beats the old score format pring new high score and congradulations
                        System.out.printf("Your score of %d questions answered just beat the previous best score of %d. Awesome job!\n", count, multiplicationScore);
                        multiplicationScore = count;
                        System.out.println("");
                    } else { // if the users score is not a new high, print try harder message and format print the high score to beat
                        System.out.println("Good effort, but you'll have to try harder to beat");
                        System.out.printf("your best score of %d questions answered.\n", multiplicationScore);
                        System.out.println("");
                    }
                }
            } else if (mainChoice == 5) { // if choice on main menu = 5, run race to the finish division
                int count = raceToTheFinish(in, rng, "/"); // calling raceToTheFinish method for division 
                if (divisionScore == -1) {
                    System.out.println("");
                    // printing users first attempt and then format printing users first score 
                    System.out.println("This was your first time playing. As such, your");
                    System.out.printf("%d questions answered in 10 seconds is currently the best!\n", count);
                    divisionScore = count;
                    System.out.println("");
                } else {
                    System.out.println("");
                    if (count > divisionScore) {
                        // if users new score beats the old score format pring new high score and congradulations 
                        System.out.printf("Your score of %d questions answered just beat the previous best score of %d. Awesome job!\n", count, divisionScore);
                        divisionScore = count;
                        System.out.println("");
                    } else {
                        // if the users score is not a new high, print try harder message and format print the high score to beat
                        System.out.println("Good effort, but you'll have to try harder to beat");
                        System.out.printf("your best score of %d questions answered.\n", divisionScore);
                        System.out.println("");
                    }
                }
            } else if (mainChoice == 6) { // if choice on main menu = 6, run numebr guesing game
                float guessTime = numberGuessingGame(in, rng);
                if (guessScore == -1f) {
                    System.out.printf("This was your first time playing. As such, your time of %.1f seconds is the current best time!\n", guessTime);
                    System.out.println("");
                    guessScore = guessTime;
                } else if (guessScore > guessTime) {
                    // if users new score beats the old score format pring new high score and congradulations
                    System.out.printf("You just beat your previous best time of %.1f seconds!\n", guessTime);
                    System.out.printf("The new best time is now %.1f secoonds.\n", guessTime);
                    System.out.println("");
                    guessScore = guessTime;
                } else { // if the users score is not a new high, print try harder message and format print the high score to beat
                    System.out.printf("Good effort, but you'll have to try harder to beat your best time of %.1f seconds.\n", guessScore);
                    System.out.println("");
                }

            } else if (mainChoice == 7) {
                long totalRunTime = (System.currentTimeMillis() - runTime); // getting the run time in milliseconds
                long totalRunTimeMinutes = ((totalRunTime/1000)/60); // coverting milliseconds to minutes // integer division
                long totalRunTimeSeconds = ((totalRunTime/1000)%60); // converting milliseconds to seconds // remainder division
                String stats;
                System.out.print(" Do you want to see stats from the app today (yes/no): "); // asking user if they want to see their stats from the programs run
                stats = in.nextLine();
                System.out.println("");

                // if user chooses yes, display stats from the run
                if (stats.equals("yes")) { // if the user selects yes, display stats 
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Stats from your visit today:");
                    System.out.println("");
                    if (timeInMathPractice == 0) {
                        System.out.printf("1. Time spent on Math Practice: not attempted\n\n");  
                    } else {
                        long mathMinutes = ((timeInMathPractice/1000)/60); // converting time in math practice from milliseconds to minutes
                        long mathSeconds = ((timeInMathPractice/1000)%60); // converting time in math practice from milliseconds to minutes
                        System.out.printf("1. Time spent on Math Practice: %d minute(s) and %d second(s)\n\n", mathMinutes, mathSeconds); // format printing time spent in math practice in minute/second form
                    }

                    System.out.println("2. Most questions answered in 10 seconds:");
                    if (additionScore == -1) {
                        System.out.println("   Addition:       not attempted");
                    } else {
                        System.out.println("   Addition:       " + additionScore);
                    }

                    if (subtractionScore == -1) {
                        System.out.println("   Subtraction:    not attempted");
                    } else {
                        System.out.println("   Subtraction:    " + subtractionScore);
                    }

                    if (multiplicationScore == -1) {
                        System.out.println("   Multiplication: not attempted");
                    } else {
                        System.out.println("   Multiplication: " + multiplicationScore);
                    }

                    if (divisionScore == -1) {
                        System.out.println("   Division:       not attempted");
                    } else {
                        System.out.println("   Division:       " + divisionScore);
                    }
                    System.out.println("");

                    if (guessScore == -1) {
                        System.out.println("3. Best time for guessing the secret number: not attempted\n");
                    } else {
                        System.out.printf("3. Best time for guessing the secret number: %.1f seconds\n", guessScore); ; // format printing users best score in guess the number
                        System.out.println("");
                    }
                    System.out.printf("Total time spent using app: %d minute(s) and %d second(s)\n", totalRunTimeMinutes, totalRunTimeSeconds); // format printing the total time the user spent using the program
                    System.out.println("");
                    System.out.println("Hope this was fun!"); // nice message at end 

                } else { // if user does not want to view stats, print nice ending message
                    System.out.println("\n Hope this was fun!\n");
                    System.out.println("");
                }
                break;
            }
        }
    }

    // This method displays the main menu options
    public static void showMainMenu() {
        System.out.println("-----------------------------------------------------\n"
                + "|       Are You Smarter Than a Third Grader       | \n"
                + "|-------------------------------------------------| \n"
                + "|  1. Math Practice                               | \n"
                + "|  2. Race to the Finish (Addition)               | \n"
                + "|  3. Race to the Finish (Subtraction)            | \n"
                + "|  4. Race to the Finish (Multiplication)         | \n"
                + "|  5. Race to the Finish (Division)               | \n"
                + "|  6. Guess the Number                            | \n"
                + "|  7. Exit                                        | \n"
                + "--------------------------------------------------- ");
    }

    // This method displays the math practice menu options
    public static void showMathPracticeMenu() {
        System.out.println("-----------------------------------------------------\n"
                + "|       Let's Practice Some Math Questions        | \n"
                + "|-------------------------------------------------| \n"
                + "|  1. Addition                                    | \n"
                + "|  2. Subtraction                                 | \n"
                + "|  3. Multiplication                              | \n"
                + "|  4. Division                                    | \n"
                + "|  5. Return to Main Menu                         | \n"
                + "--------------------------------------------------- ");
    }

    // This method uses a loop to repeatedly scan the users choice. 
    public static int readAndVerifyChoice(Scanner in, int numChoices) {
        
        // this block of code handles the reading and verifying of the main menu
        if (numChoices == 7) { // reading and verifying for the main menu
            while (true) {
                System.out.print("Enter your choice: ");
                String choiceMainMenu = in.nextLine();
                System.out.println("");
                if (choiceMainMenu.equals("1")) {
                    return 1; // returning user choice to main method
                } else if (choiceMainMenu.equals("2")) {
                    return 2; // returning user choice to main method
                } else if (choiceMainMenu.equals("3")) {
                    return 3; // returning user choice to main method
                } else if (choiceMainMenu.equals("4")) {
                    return 4; // returning user choice to main method
                } else if (choiceMainMenu.equals("5")) {
                    return 5; // returning user choice to main method
                } else if (choiceMainMenu.equals("6")) {
                    return 6; // returning user choice to main method
                } else if (choiceMainMenu.equals("7")) {
                    return 7; // returning user choice to main method
                } else { // case for if user does not choose an available option
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("");
                }
            }
        } 
        // this block of code handles the reading and verifying of the math practice
        // menu.
        else if (numChoices == 5) { // reading and verifying for the math practice menu
            while (true) {
                System.out.print("Enter your choice: ");
                String choiceMathPracticeMenu = in.nextLine();
                System.out.println("");
                if (choiceMathPracticeMenu.equals("1")) {
                    return 1; // returning user choice to main method
                } else if (choiceMathPracticeMenu.equals("2")) {
                    return 2; // returning user choice to main method
                } else if (choiceMathPracticeMenu.equals("3")) {
                    return 3; // returning user choice to main method
                } else if (choiceMathPracticeMenu.equals("4")) {
                    return 4; // returning user choice to main method
                } else if (choiceMathPracticeMenu.equals("5")) {
                    return 5; // returning user choice to main method
                } else { // case for if user does not choose an available option
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("");
                }
            }
        }
        return 1;
    }

    // this method receives a single String parameter and checks if all characters of the 
    // string are digits
    public static boolean containsOnlyDigits(String userInput) {
        if (userInput.equals("")) {
            return false;
        }
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) { // if user input does not contain digit return false 
                return false;
            }
        }
        return true;
    }

    // This method checks the users input and verifies if it is a integer
    public static int readAndVerifyInt(Scanner in, int num1, int num2, String op) {
        while (true) {
            String input = in.nextLine();
            boolean ans = containsOnlyDigits(input);
            if (ans) {
                return Integer.parseInt(input); // converting string to int
            } else {
                System.out.println("\nInvalid entry. Please try again."); // if user answer contains anything other than digits 
                System.out.println("");
                System.out.printf("%d %s %d = ", num1, op, num2);
            }

        }
    }

    // this method contains all the code to run math practice
    public static void mathPractice(Scanner in, Random rng) {
        while (true) {
            showMathPracticeMenu();
            int count = 0; // creating a counter to keep track of number of correct answers
            long mathTime = System.currentTimeMillis();
            int mathPracticeChoice = readAndVerifyChoice(in, 5);
            if (mathPracticeChoice == 1) {
                System.out.println("Here are five Addition questions to practice:");
                System.out.println("");
                for (int i = 1; i <= 5; i++) {
                    int num1 = rng.nextInt(12) + 1; // generating a random int between 1 and 12
                    int num2 = rng.nextInt(12) + 1; // generating a random int between 1 and 12
                    int additionAnswer = (num1 + num2);

                    System.out.printf("%d. %d + %d = ", i, num1, num2); // format printing the equation
                    int userResult = readAndVerifyInt(in, num1, num2, "+");
                    if (userResult != num1 + num2) {
                        System.out.println("    Incorrect. The correct answer is:");
                        System.out.println("    " + num1 + " + " + num2 + " = " + additionAnswer); // printing equation with correct answer
                        System.out.println("");
                    } else if (userResult == num1 + num2) {
                        System.out.println("   Correct!\n");
                        count += 1; // incramenting the count to keep track of correct answers
                    } else {
                        System.out.println("");
                        System.out.println("\nInvalid entry. Please try again."); // if user answer contains anything other than digits 
                    }
                }
            } else if (mathPracticeChoice == 2) {
                System.out.println("Here are five Subtraction questions to practice:");
                System.out.println("");
                for (int i = 1; i <= 5; i++) {
                    int num1 = rng.nextInt(12) + 1; // generating a random int between 1 and 12
                    int num2 = rng.nextInt(12) + 1; // generating a random int between 1 and 12
                    if (num2 > num1) {
                        int temp = num1;
                        num1 = num2;
                        num2 = temp;
                    }
                    int subtractionAnswer = (num1 - num2);
                    System.out.printf("%d. %d - %d = ", i, num1, num2); // format printing the equation
                    int userResult = readAndVerifyInt(in, num1, num2, "-");
                    if (userResult != num1 - num2) {
                        System.out.println("    Incorrect. The correct answer is:");
                        System.out.println("    " + num1 + " - " + num2 + " = " + subtractionAnswer); // printing equation with correct answer
                        System.out.println("");
                    } else if (userResult == num1 - num2) {
                        System.out.println("   Correct!\n");
                        count += 1; // incramenting the count to keep track of correct answers
                    } else {
                        System.out.println("");
                        System.out.println("\nInvalid entry. Please try again."); // if user answer contains anything other than digits 
                    } 

                }
            } else if (mathPracticeChoice == 3) {
                System.out.println(" Here are five Multiplication questions to practice:");
                System.out.println("");
                for (int i = 1; i <= 5; i++) {
                    int num1 = rng.nextInt(12) + 1; // generating a random int between 1 and 12
                    int num2 = rng.nextInt(12) + 1; // generating a random int between 1 and 12
                    int multiplicationAnswer = (num1 * num2);
                    System.out.printf("%d. %d x %d = ", i, num1, num2); // format printing the equation
                    int userResult = readAndVerifyInt(in, num1, num2, "*");
                    if (userResult != num1 * num2) {
                        System.out.println("    Incorrect. The correct answer is:");
                        System.out.println("    " + num1 + " x " + num2 + " = " + multiplicationAnswer); // printing equation with correct answer
                        System.out.println("");
                    } else if (userResult == num1 * num2) {
                        System.out.println("   Correct!\n");
                        count += 1; // incramenting the count to keep track of correct answers
                    } else {
                        System.out.println("");
                        System.out.println("\nInvalid entry. Please try again."); // if user answer contains anything other than digits 
                    }
                }
            } else if (mathPracticeChoice == 4) {
                System.out.println("Here are five Division questions to practice:");
                System.out.println("");
                for (int i = 1; i <= 5; i++) {
                    int num1 = rng.nextInt(12) + 1; // generating a random int between 1 and 12
                    int num2 = rng.nextInt(12) + 1; // generating a random int between 1 and 12
                    int num3 = num1 * num2; // making sure the first number is perfectly divisible by the second
                    int divisionAnswer = (num3 / num1);
                    System.out.printf("%d. %d / %d = ", i, num3, num1); // format printing the equation
                    int userResult = readAndVerifyInt(in, num3, num1, "/");
                    if (userResult != num3 / num1) {
                        System.out.println("    Incorrect. The correct answer is:");
                        System.out.println("    " + num3 + " / " + num1 + " = " + divisionAnswer); // printing equation with correct answer
                        System.out.println("");
                    } else if (userResult == num3 / num1) {
                        System.out.println("   Correct!\n");
                        count += 1; // incramenting the count to keep track of correct answers
                    } else {
                        System.out.println("");
                        System.out.println("\nInvalid entry. Please try again."); // if user answer contains anything other than digits 
                    }
                }
            } else if (mathPracticeChoice == 5) {
                timeInMathPractice += (System.currentTimeMillis() - mathTime); // getting the time spent in math practice
                
                break;
            }
            System.out.println("You got " + count + " out of 5 correct.");
            System.out.println("You can now practice some more or return to the Main Menu.");
            System.out.println("");
        }
    }

    // this method displays the race to the finish rules depenidng on the operator sign
    public static void displayRaceToTheFinishMenu(String op) {
        if (op.equals("+")) { // menu for + operator 
            System.out.println("-----------------------------------------------------\n"
                    + " | Race to the Finish                              | \n"
                    + " |-------------------------------------------------| \n"
                    + " | You have 10 seconds to answer as many           | \n"
                    + " | addition questions as possible.                 | \n"
                    + " | Both the Questions and the Timer will start     | \n"
                    + " | once you type anything and click \"Enter\".     | \n"
                    + " ---------------------------------------------------");
        } else if (op.equals("-")) { // menu for - operator 
            System.out.println("-----------------------------------------------------\n"
                    + " | Race to the Finish                              | \n"
                    + " |-------------------------------------------------| \n"
                    + " | You have 10 seconds to answer as many           | \n"
                    + " | subtraction questions as possible.              | \n"
                    + " | Both the Questions and the Timer will start     | \n"
                    + " | once you type anything and click \"Enter\".     | \n"
                    + " ---------------------------------------------------");

        } else if (op.equals("*")) { // menu for * operator 
            System.out.println("-----------------------------------------------------\n"
                    + " | Race to the Finish                              | \n"
                    + " |-------------------------------------------------| \n"
                    + " | You have 10 seconds to answer as many           | \n"
                    + " | multiplication questions as possible.           | \n"
                    + " | Both the Questions and the Timer will start     | \n"
                    + " | once you type anything and click \"Enter\".     | \n"
                    + " ---------------------------------------------------");

        } else if (op.equals("/")) { // menu for / operator 
            System.out.println("-----------------------------------------------------\n"
                    + " | Race to the Finish                              | \n"
                    + " |-------------------------------------------------| \n"
                    + " | You have 10 seconds to answer as many           | \n"
                    + " | division questions as possible.                 | \n"
                    + " | Both the Questions and the Timer will start     | \n"
                    + " | once you type anything and click \"Enter\".     | \n"
                    + " ---------------------------------------------------");

        }
    }

    // This method contains all of the code needed to run race to the finish
    public static int raceToTheFinish(Scanner in, Random rng, String op) {

        if (op.equals("+")) {
            displayRaceToTheFinishMenu(op); // displaying race to finish menu for addition
            in.nextLine();
            long currentTime = System.currentTimeMillis();
            long endTime = currentTime + 10_000; // making race to finish last 10 seconds
            int count = 0;
            while (System.currentTimeMillis() < endTime) { // continue printing equations if timer is under 10 seconds 
                int num1 = rng.nextInt(12) + 1; // radomly generating numbers for equation in range of 1-12
                int num2 = rng.nextInt(12) + 1; // radomly generating numbers for equation in range of 1-12
                System.out.printf("%d + %d = ", num1, num2); // format printing the equation
                String input = in.nextLine();
                boolean flag = containsOnlyDigits(input);
                if (!flag) {
                    System.out.println("    Incorrect.");
                } else {
                    int userResult = Integer.parseInt(input);
                    if (userResult != num1 + num2) {
                        System.out.println("    Incorrect.");
                    } else if (userResult == num1 + num2) {
                        System.out.println("    Correct!");
                        if (System.currentTimeMillis() < endTime) {
                            count += 1;
                        } else {
                            System.out.println("");
                            System.out.println("You didn't quite get that last answer in quick enough.");
                            System.out.println("Time is up! Let's see how you did...");
                        }
                    }
                }
            }
            return count;

        } else if (op.equals("-")) {
            displayRaceToTheFinishMenu(op); // displaying race to finish menu for subtraction
            in.nextLine();
            long currentTime = System.currentTimeMillis();
            long endTime = currentTime + 10_000; // making race to finish last 10 seconds
            int count = 0;
            while (System.currentTimeMillis() < endTime) { // continue printing equations if timer is under 10 seconds 
                int num1 = rng.nextInt(12) + 1; // radomly generating numbers for equation in range of 1-12
                int num2 = rng.nextInt(12) + 1; // radomly generating numbers for equation in range of 1-12
                if (num2 > num1) {
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                    System.out.printf("%d - %d = ", num1, num2); // format printing the equation
                    String input = in.nextLine();
                    boolean flag = containsOnlyDigits(input);
                    if (!flag) {
                        System.out.println("    Incorrect.");
                    } else {
                        int userResult = Integer.parseInt(input);
                        if (userResult != num1 - num2) {
                            System.out.println("    Incorrect.");
                        } else if (userResult == num1 - num2) {
                            System.out.println("    Correct!");
                            if (System.currentTimeMillis() < endTime) {
                                count += 1;
                            } else {
                                System.out.println("");
                                System.out.println("You didn't quite get that last answer in quick enough.");
                                System.out.println("Time is up! Let's see how you did...");
                            }
                        }
                    }
                }
            }
            return count;

        } else if (op.equals("*")) {
            displayRaceToTheFinishMenu(op); // displaying race to finish menu for multiplication
            in.nextLine();
            long currentTime = System.currentTimeMillis();
            long endTime = currentTime + 10_000; // making race to finish last 10 seconds
            int count = 0;
            while (System.currentTimeMillis() < endTime) { // continue printing equations if timer is under 10 seconds 
                int num1 = rng.nextInt(12) + 1; // radomly generating numbers for equation in range of 1-12
                int num2 = rng.nextInt(12) + 1; // radomly generating numbers for equation in range of 1-12
                System.out.printf("%d * %d = ", num1, num2); // format printing the equation
                String input = in.nextLine();
                boolean flag = containsOnlyDigits(input);
                if (!flag) {
                    System.out.println("    Incorrect.");
                } else {
                    int userResult = Integer.parseInt(input);
                    if (userResult != num1 * num2) {
                        System.out.println("    Incorrect.");
                    } else if (userResult == num1 * num2) {
                        System.out.println("    Correct!");
                        if (System.currentTimeMillis() < endTime) {
                            count += 1;
                        } else {
                            System.out.println("");
                            System.out.println("You didn't quite get that last answer in quick enough.");
                            System.out.println("Time is up! Let's see how you did...");
                        }
                    }
                }
            }
            return count;
        } else if (op.equals("/")) {
            displayRaceToTheFinishMenu(op);// displaying race to finish menu for division
            in.nextLine();
            long currentTime = System.currentTimeMillis();
            long endTime = currentTime + 10_000; // making race to finish last 10 seconds
            int count = 0;
            while (System.currentTimeMillis() < endTime) { // continue printing equations if timer is under 10 seconds 
                int num1 = rng.nextInt(12) + 1; // radomly generating numbers for equation in range of 1-12
                int num2 = rng.nextInt(12) + 1; // radomly generating numbers for equation in range of 1-12
                int num3 = num1 * num2;
                System.out.printf("%d / %d = ", num3, num1); // format printing the equation
                String input = in.nextLine();
                boolean flag = containsOnlyDigits(input);
                if (!flag) {
                    System.out.println("    Incorrect.");
                } else {
                    int userResult = Integer.parseInt(input);
                    if (userResult != num3 / num1) {
                        System.out.println("    Incorrect.");
                    } else if (userResult == num3 / num1) {
                        System.out.println("    Correct!");
                        if (System.currentTimeMillis() < endTime) {
                            count += 1;
                        } else {
                            System.out.println("");
                            System.out.println("You didn't quite get that last answer in quick enough.");
                            System.out.println("Time is up! Let's see how you did...");
                        }
                    }
                }
            }
            return count;
        }
        return 0;
    }

    // This method displays the guess my number rules
    public static void displayGuessMenu() {
        System.out.println("-----------------------------------------------------\n"
                + "|       How Quickly Can You Guess My Number       | \n"
                + "|-------------------------------------------------| \n"
                + "| Let's play the childhood number guessing game!  | \n"
                + "| I'll choose a number between 1 and 100. Your    | \n"
                + "| job is to guess my number as quickly as you     | \n"
                + "| can. Can you beat the best previous time?       | \n"
                + "|                                                 | \n"
                + "|    --- Timer starts once you hit \"Enter\" ---    | \n"
                + "---------------------------------------------------");
    }

    // This method contains the code to run number guessing game
    public static float numberGuessingGame(Scanner in, Random rng) {
        displayGuessMenu();
        int gNum = rng.nextInt(100) + 1; // randomly generating a number to guess between 1 and 100
        in.nextLine();
        long currentTime = System.currentTimeMillis(); // logging current time
        System.out.print("Enter your guess (between 1 and 100): ");
        while (true) {
            int userGuess = readAndVerifyGuess(in);
            if (gNum > userGuess) { // if user guess is below guess number
                System.out.println("\nYour guess is too low.");
                System.out.println("");
                System.out.print("Enter your guess (between 1 and 100): ");
            } else if (gNum < userGuess) { // if user guess is above guess number
                System.out.println("\nYour guess is too high.");
                System.out.println("");
                System.out.print("Enter your guess (between 1 and 100): ");
            } else if (gNum == userGuess) {
                long endTime = System.currentTimeMillis(); // logging end time
                float guessTime = (endTime - currentTime) / 1000; // calculating time spent on guess
                System.out.println("\nYou guessed the correct number!"); // user guessed correctly
                System.out.printf("Total time taken: %.1f seconds\n", guessTime); // format printing how long it took the user the guess the number
                System.out.println("");
                return guessTime;
            }
        }
    }

    // This method validates the user input as being an integer
    public static int readAndVerifyGuess(Scanner in) {
        while (true) {
            String input = in.nextLine();
            boolean ans = containsOnlyDigits(input);
            if (ans) {
                return Integer.parseInt(input); // converting string to an int
            } else { // case for invalid options
                System.out.println(" \nInvalid entry. Please try again."); // if user answer contains anything other than digits 
                System.out.println("");
                System.out.print("Enter your guess (between 1 and 100): ");
            }

        }

    }
}