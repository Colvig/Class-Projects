// Name: Haley Cahoon
// Date: 04/06/2022
// Email: haleyanncahoon@gmail.com
// Course Number: CSC2290-002
// Marvel vs DC
// FSC Honor Code: I will practice academic and personal integrity and
// excellence of character and expect the same from others.
// I am using my late pass

import java.util.*; // importing everything needed for this program
import java.io.*;

public class Marvel_vs_DC {

    public static void main(String[] args) throws Exception {

        // Input File:
        //File inputFile = new File("Marvel_vs_DC.in");
        // Output File:
        File outputFile = new File("Marvel_vs_DC.out");

        // Make Scanner variable to read from input file, and 
        // make Printwriter variable to print to output
        //Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter(outputFile);
        Scanner in = new Scanner(System.in);

        ArrayList<Character> chars = new ArrayList<>();

        String[] items;

        while (in.hasNext()) {
            items = in.nextLine().split(",");
            String command = items[0];
            // Command to add a character
            if (command.equals("ADDCHARACTER")) {
                addCharacter(in, chars, items, out);
            }

            // Command to search for a character
            if (command.equals("SEARCHCHARACTER")) {
                searchCharacter(in, chars, items, out);
            }

            // Command to add a power to character
            if (command.equals("ADDPOWER")) {
                addPower(in, chars, items, out);
            }

            // Command to make characters fight
            if (command.equals("FIGHT")) {
                fight(in, chars, items, out);
            }

            // Command to display heros
            if (command.equals("DISPLAYHEROES")) {
                displayHeroes(in, chars, items, out);
            }

            // Command to display villains
            if (command.equals("DISPLAYVILLAINS")) {
                displayVillains(in, chars, items, out);
            }

            // Command to display Marvel characters
            if (command.equals("DISPLAYMARVEL")) {
                displayMarvel(in, chars, items, out);
            }

            // Command to display DC characters
            if (command.equals("DISPLAYDC")) {
                displayDC(in, chars, items, out);
            }

            // Command to display characters stats
            if (command.equals("DISPLAYSTATS")) {
                displayStats(in, chars, items, out);
            }

            // Command to quit program
            if (command.equals("EXIT")) {
                System.out.println();
                System.out.println("Goodbye.");
                in.close();
                System.exit(0);
            }
        }
    }

    // This method
    public static void addCharacter(Scanner in, ArrayList<Character> chars, String[] items, PrintWriter out) {
        if (items[1].equals("superhv")) { // if the character is not an NPC
            String name = items[2];
            String team = items[3];
            String universe = items[4];
            String homePlanet = items[5];
            int intelligence = Integer.parseInt(items[6]);
            int strength = Integer.parseInt(items[7]);
            int stamina = Integer.parseInt(items[8]);
            int speed = Integer.parseInt(items[9]);
            int skills = Integer.parseInt(items[10]);
            ArrayList<String> powers = new ArrayList<>();
            for (int i = 11; i < items.length; i++) {
                powers.add(items[i]);

            }
            Stats s = new Stats(intelligence, strength, stamina, speed, skills);
            SuperHV person = new SuperHV(name, team, universe, homePlanet, s, powers);
            chars.add(person);

            // Printing the newly added non-NPC character(s).
            System.out.println("Command: ADDCHARACTER");
            System.out.println(person.toString());
            System.out.println("");
        } else { // if character is an NPC
            String name = items[1];
            String team = items[2];
            String universe = items[3];
            String homePlanet = items[4];
            int intelligence = Integer.parseInt(items[5]);
            int strength = Integer.parseInt(items[6]);
            int stamina = Integer.parseInt(items[7]);
            int speed = Integer.parseInt(items[8]);
            int skills = Integer.parseInt(items[9]);
            Stats s = new Stats(intelligence, strength, stamina, speed, skills);
            Character person = new Character(name, team, universe, homePlanet, s);
            chars.add(person);

            // Printing the newly added NPC character
            System.out.println("Command: ADDCHARACTER");
            System.out.println(person.toString());
            System.out.println("");
        }

        Character.setNumCharacters(Character.getNumCharacters() + 1);

    }

    // This method searches for a character. If found, appropriate character
    // information will be printed. If there are no characters or the given
    // character does not exist, an appropriate output will be printed.
    public static void searchCharacter(Scanner in, ArrayList<Character> chars, String[] items, PrintWriter out) {
        System.out.println("Command: SEARCHCHARACTER");
        if (chars.isEmpty()) { // If there are no characters.
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println();
            return;
        }
        String searchedName = items[1]; // The searched character matches a character in the system.
        for (int i = 0; i < Character.getNumCharacters(); i++) {
            if (chars.get(i).getName().equals(searchedName)) {
                System.out.println(chars.get(i).toString()); // Printing the characters info.
                System.out.println("");
                return;
            }
        }
        System.out.println("");
        System.out.printf("   ERROR: %s is not a character currently in the system.\n", searchedName);
        System.out.println();
    }

    // This method adds powers to characters. If the character exists and does 
    // not have the given power, the power will be added to that characters
    // String ArrayList of powers and an appropriate output will be printed.
    // If the given character already has the inputted power, the character
    // is not found, or there are no characters an appropriate error message will be given.
    public static void addPower(Scanner in, ArrayList<Character> chars, String[] items, PrintWriter out) {
        System.out.println("Command: ADDPOWER");
        if (chars.isEmpty()) { // There are no characters.
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println();
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i).getName().equals(items[1])) {
                // This line is casting the object returned from char.get to a superHV,
                // this means I can use get.Powers
                ArrayList<String> superPowers = new ArrayList<>(((SuperHV) chars.get(i)).getPowers());
                if (superPowers.contains(items[2])) {
                    System.out.printf("   ERROR: %s already has the superpower of %s.\n", items[1], items[2]);
                    System.out.println();
                    return;
                } else {
                    // This line is casting the object returned from char.get to a superHV,
                    // this means I can use get.Powers
                    (((SuperHV) chars.get(i)).getPowers()).add(items[2]);
                    System.out.printf("   %s now has the new superpower of %s.\n", items[1], items[2]);
                    System.out.println();
                    return;
                }
            }
        }
        System.out.printf("   ERROR: %s is not a character currently in the system.\n", items[1]);
        System.out.println();
    }

    // This method takes the two given characters and makes them fight. If the 
    // two characters exist the fight will happen no matter the team or universe
    // they are from, and then an appropriate output will be printed. If there
    // are no characters in the system or the given characters can not be found,
    // an appropirate message will be printed.
    public static void fight(Scanner in, ArrayList<Character> chars, String[] items, PrintWriter out) {
        System.out.println("Command: FIGHT");
        // Checking to see if there are any characters in the system.
        if (chars.isEmpty()) { // If there are no characters.
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println();
            return;
        }
        // Checking to see if the given characters are found in the system.
        boolean fighterOneFound = false;
        boolean fighterTwoFound = false;
        int indexFighterOne = 0;
        int indexFighterTwo = 0;
        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i).getName().equals(items[1])) {
                fighterOneFound = true;
                indexFighterOne = i;
            }
            if (chars.get(i).getName().equals(items[2])) {
                fighterTwoFound = true;
                indexFighterTwo = i;
            }
        }
        // If a character is not found, this checks to see which one it is.
        if (!fighterOneFound || !fighterTwoFound) {
            System.out.println("   ERROR: cannot execute command. One or more characters cannot be found.");
            if (!fighterOneFound) {
                System.out.printf("      %s is not a character currently in the system.\n", items[1]);
            }
            if (!fighterTwoFound) {
                System.out.printf("      %s is not a character currently in the system.\n", items[2]);
            }
            System.out.println();
            return;
        }
        if (!(chars.get(indexFighterOne) instanceof SuperHV) && !(chars.get(indexFighterTwo) instanceof SuperHV)) {
            int fighterOnePoints = 0;
            int fighterTwoPoints = 0;

            fighterOnePoints += chars.get(indexFighterOne).getS().combinedStats();
            fighterTwoPoints += chars.get(indexFighterTwo).getS().combinedStats();
            
            System.out.printf("   %s vs %s\n", items[1], items[2]);
            
            // Printing fighter one.
            System.out.println("   Fighter #1:");
            System.out.println(chars.get(indexFighterOne).toString());
            System.out.println();
            
            // Printing fighter two.
            System.out.println("   Fighter #2:");
            System.out.println(chars.get(indexFighterTwo).toString());
            System.out.println();
            
            System.out.println("   Fight Results:");
            System.out.printf("      %s's total attack power: %d\n", items[1], fighterOnePoints);
            System.out.printf("      %s's total attack power: %d\n", items[2], fighterTwoPoints);
            if (fighterOnePoints > fighterTwoPoints) {
                System.out.printf("      Winner: %s\n", items[1]);
            } else if (fighterOnePoints < fighterTwoPoints) {
                System.out.printf("      Winner: %s\n", items[2]);
            } else {
                System.out.println("      Tie!");
            }
            
        } else if (chars.get(indexFighterOne) instanceof SuperHV && !(chars.get(indexFighterTwo) instanceof SuperHV)) {
            System.out.printf("   %s vs %s\n", items[1], items[2]);
            System.out.println();
            
            // Printing fighter one.
            System.out.println("   Fighter #1:");
            System.out.println(chars.get(indexFighterOne).toString());
            System.out.println();
            
            // Printing fighter two.
            System.out.println("   Fighter #2:");
            System.out.println(chars.get(indexFighterTwo).toString());
            
            System.out.println("   Fight Results:");
            System.out.printf("      %s has no superpowers. Thus, %s wins every time.\n", items[2], items[1]);
            
        } else if (!(chars.get(indexFighterOne) instanceof SuperHV && (chars.get(indexFighterTwo) instanceof SuperHV))) {
            System.out.printf("   %s vs %s\n", items[1], items[2]);
            System.out.println();
            
            // Printing fighter one.
            System.out.println("   Fighter #1:");
            System.out.println(chars.get(indexFighterOne).toString());
            System.out.println();
            
            // Printing fighter two.
            System.out.println("   Fighter #2:");
            System.out.println(chars.get(indexFighterTwo).toString());
            
            System.out.println("   Fight Results:");
            System.out.printf("      %s has no superpowers. Thus, %s wins every time.\n", items[1], items[2]);
            
        } else { // Calculatng the fighters points
            int fighterOnePoints = 0;
            int fighterTwoPoints = 0;
            if ((chars.get(indexFighterOne) instanceof SuperHV && (chars.get(indexFighterTwo) instanceof SuperHV))) {
                fighterOnePoints += chars.get(indexFighterOne).getS().combinedStats();
                fighterTwoPoints += chars.get(indexFighterTwo).getS().combinedStats();
                fighterOnePoints += ((SuperHV) chars.get(indexFighterOne)).combinedPowers();
                fighterTwoPoints += ((SuperHV) chars.get(indexFighterTwo)).combinedPowers();
            }
            System.out.printf("   %s vs %s\n", items[1], items[2]);
            
            // Printing fighter one.
            System.out.println("   Fighter #1:");
            System.out.println(chars.get(indexFighterOne).toString());
            System.out.println();
            
            // Printing fighter two.
            System.out.println("   Fighter #2:");
            System.out.println(chars.get(indexFighterTwo).toString());
            
            System.out.println("   Fight Results:");
            System.out.printf("      %s's total attack power: %d\n", items[1], fighterOnePoints);
            System.out.printf("      %s's total attack power: %d\n", items[2], fighterTwoPoints);
            if (fighterOnePoints > fighterTwoPoints) {
                System.out.printf("      Winner: %s\n", items[1]);
            } else if (fighterOnePoints < fighterTwoPoints) {
                System.out.printf("      Winner: %s\n", items[2]);
            } else {
                System.out.println("      Tie!");
            }
        }
        System.out.println();
    }

    // This method displays the heroes. If there are heroes in the system, no
    // matter the universe, an appropriate output will be printed. If there are
    // no characters in the system, or no heroes exist, an appropirate
    // message will be printed.
    public static void displayHeroes(Scanner in, ArrayList<Character> chars, String[] items, PrintWriter out) {
        System.out.println("Command: DISPLAYHEROES");
        if (chars.isEmpty()) { // If there are no characters
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println();
            return;
        }
        for (int i = 0; i < Character.getNumCharacters(); i++) {
            if (chars.get(i).getTeam().equals("Heroes")) {
                System.out.println("   -----------------------------------------");
                System.out.println(chars.get(i).toString()); // Print characters info.
            }
        }
    }

    // This method displays the villians. If there are villians in the system,
    // no matter the universe, an appropriate output will be printed. If there are
    // no characters in the system, or no villians exist, an appropirate
    // message  will be printed. 
    public static void displayVillains(Scanner in, ArrayList<Character> chars, String[] items, PrintWriter out) {
        System.out.println("Command: DISPLAYVILLAINS");
        if (chars.isEmpty()) { // If there are no chaarcters.
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println();
            return;
        }
        for (int i = 0; i < Character.getNumCharacters(); i++) {
            if (chars.get(i).getTeam().equals("Villains")) {
                System.out.println("   -----------------------------------------");
                System.out.println(chars.get(i).toString()); // Print characters info.
            }
        }
    }

    // This method will display the Marvel characters (heroes and villains, 
    // if there are no characters in the system or no Marvel characters, 
    // an appropriate output will be printed.
    public static void displayMarvel(Scanner in, ArrayList<Character> chars, String[] items, PrintWriter out) {
        System.out.println("Command: DISPLAYMARVEL");
        if (chars.isEmpty()) { // If there are no characters.
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println();
            return;
        }
        for (int i = 0; i < Character.getNumCharacters(); i++) {
            if (chars.get(i).getUniverse().equals("Marvel")) {
                System.out.println("   -----------------------------------------");
                System.out.println(chars.get(i).toString()); // Print characters info.
            }
        }
    }

    // This method will display the DC characters (heroes and villains, 
    // if there are no characters in the system or no DC characters, 
    // an appropriate output will be printed.
    public static void displayDC(Scanner in, ArrayList<Character> chars, String[] items, PrintWriter out) {
        System.out.println("Command: DISPLAYDC");
        if (chars.isEmpty()) { // If  there are no characters.
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println();
            return;
        }
        for (int i = 0; i < Character.getNumCharacters(); i++) {
            if (chars.get(i).getUniverse().equals("DC")) {
                System.out.println("   -----------------------------------------");
                System.out.println(chars.get(i).toString()); // Print characters info.
            }
        }
    }

    // This method will display stats for Marvel characters and DC chaarcters. 
    // The stats will be displayed as Marvel heroes and then villians, followed
    // by DC heroes and villians. The calculated stats will include: average
    // intelligence, average strength, average stamina, average speed, average
    // skill, number of normal persons for the respective universes heroes or
    // villains, number of heroes/villians with superpowers, and lastly aggregate superpowers.
    public static void displayStats(Scanner in, ArrayList<Character> chars, String[] items, PrintWriter out) {
        System.out.println("Command: DISPLAYSTATS");
        if (chars.isEmpty()) {
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println();
            return;
        }
        // Keeping track of how many marvel characters.
        int marvelHeroNPC = 0;
        int marvelHero = 0;
        int marvelVillainNPC = 0;
        int marvelVillain = 0;

        // Keeping track of how many DC characters.
        int DCHeroNPC = 0;
        int DCHero = 0;
        int DCVillainNPC = 0;
        int DCVillain = 0;

        // Checking to see how many characters of each category there are.
        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i).getUniverse().equals("Marvel")) {
                if (chars.get(i).getTeam().equals("Heroes")) {
                    if (chars.get(i) instanceof SuperHV) { // Incrementing when a Marvel hero/NPC hero is found.
                        marvelHero++;
                    } else {
                        marvelHeroNPC++;
                    }
                } else { // Incrementing when a Marvel villain/NPC villain is found.
                    if (chars.get(i) instanceof SuperHV) {
                        marvelVillain++;
                    } else {
                        marvelVillainNPC++;
                    }

                }
            } else {
                if (chars.get(i).getTeam().equals("Heroes")) {
                    if (chars.get(i) instanceof SuperHV) { // Incrementing when a DC hero/NPC hero is found.
                        DCHero++;
                    } else {
                        DCHeroNPC++;
                    }
                } else {
                    if (chars.get(i) instanceof SuperHV) { // Incrementing when a DC villain/NPC villain is found.
                        DCVillain++;
                    } else {
                        DCVillainNPC++;
                    }
                }
            }
        }
        boolean marvel = true;
        boolean DC = true;
        
        // CODE FOR DISPLAYING MARVEL HERO STATS
        System.out.println("   Marvel Characters");
        // Checking for any Marvel characters.
        if (marvelHeroNPC == 0 && marvelHero == 0 && marvelVillain == 0 && marvelVillainNPC == 0) {
            System.out.println("      There are currently no Marvel characters in the system.");
            marvel = false;
        } 
        // Checking for Marvel heroes/npc heroes.
        if (marvelHero == 0 && marvelHeroNPC == 0 && marvel) {
            System.out.println("      Hero Stats:");
            System.out.println("      Number of Normal-Person Heroes:    0");
            System.out.println("      Number of Heroes with Superpowers: 0");
        } 
        // If there are Marvel hero/npc hero characters.
        else if (marvelHero != 0 || marvelHeroNPC != 0) {
            // Set all stats equal to 0.
            double avgInt = 0;
            double avgStr = 0;
            double avgSta = 0;
            double avgSpe = 0;
            double avgSki = 0;
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("Marvel") && chars.get(i).getTeam().equals("Heroes")) {
                    // Calculating stats.
                    avgInt += chars.get(i).s.getIntelligence();
                    avgStr += chars.get(i).s.getStrength();
                    avgSta += chars.get(i).s.getStamina();
                    avgSpe += chars.get(i).s.getSpeed();
                    avgSki += chars.get(i).s.getSkills();

                }
            }
            // Displaying stats for marvel heros.
            System.out.println("      Hero Stats:");
            // Format printing the stats
            System.out.printf("         Average Intelligence: %.2f\n", avgInt / (double) (marvelHero + marvelHeroNPC));
            System.out.printf("         Average Strength:     %.2f\n", avgStr / (double) (marvelHero + marvelHeroNPC));
            System.out.printf("         Average Stamina:      %.2f\n", avgSta / (double) (marvelHero + marvelHeroNPC));
            System.out.printf("         Average Speed:        %.2f\n", avgSpe / (double) (marvelHero + marvelHeroNPC));
            System.out.printf("         Average Skill:        %.2f\n", avgSki / (double) (marvelHero + marvelHeroNPC));
            System.out.printf("      Number of Normal-Person Heroes:    %d\n", marvelHeroNPC);
            System.out.printf("      Number of Heroes with Superpowers: %d\n", marvelHero);
            if (marvelHero != 0) { // If there are Heroes that are not NPC's.
                System.out.println("      Aggregate Superpowers:");
                ArrayList<String> mitochondria = new ArrayList<>(); // Making an arraylist for the powers
                for (int j = 0; j < chars.size(); j++) {
                    if (chars.get(j).getUniverse().equals("Marvel") && chars.get(j).getTeam().equals("Heroes") && chars.get(j) instanceof SuperHV) {
                        ArrayList<String> temp = new ArrayList<>(((SuperHV) chars.get(j)).getPowers());
                        for (int k = 0; k < temp.size(); k++) {
                            if (!mitochondria.contains(temp.get(k))) {
                                mitochondria.add(temp.get(k));
                            }
                        }
                    }
                }
                Collections.sort(mitochondria); // Sorting the array list of powers and then displaying
                String thing = String.format(mitochondria.toString().replace("[", "").replace("]", ""));
                System.out.printf("         %s\n", thing);
                System.out.println();
            }
        }
        
        // CODE FOR DISPLAYING MARVEL VILLAIN STATS
        // Checking for any Marvel villain characters
        if (marvelVillain == 0 && marvelVillainNPC == 0 && marvel) {
            System.out.println("      Villain Stats:");
            System.out.println("      Number of Normal-Person Villains:    0");
            System.out.println("      Number of Villains with Superpowers: 0");
        } 
        // If there are Marvel hero/npc hero characters
        else if (marvelVillain != 0 || marvelVillainNPC != 0) { // If there are Marvel villain/npc villain characters.
            // Set all stats equal to 0.
            double avgInt = 0;
            double avgStr = 0;
            double avgSta = 0;
            double avgSpe = 0;
            double avgSki = 0;
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("Marvel") && chars.get(i).getTeam().equals("Villains")) {
                    // Calculating stats.
                    avgInt += chars.get(i).s.getIntelligence();
                    avgStr += chars.get(i).s.getStrength();
                    avgSta += chars.get(i).s.getStamina();
                    avgSpe += chars.get(i).s.getSpeed();
                    avgSki += chars.get(i).s.getSkills();
                }
            }
            // Displaying stats for marvel villains.
            System.out.println("      Villain Stats:");
            // Format printing the stats
            System.out.printf("         Average Intelligence: %.2f\n", avgInt / (double) (marvelVillain + marvelVillainNPC));
            System.out.printf("         Average Strength:     %.2f\n", avgStr / (double) (marvelVillain + marvelVillainNPC));
            System.out.printf("         Average Stamina:      %.2f\n", avgSta / (double) (marvelVillain + marvelVillainNPC));
            System.out.printf("         Average Speed:        %.2f\n", avgSpe / (double) (marvelVillain + marvelVillainNPC));
            System.out.printf("         Average Skill:        %.2f\n", avgSki / (double) (marvelVillain + marvelVillainNPC));
            System.out.printf("      Number of Normal-Person Villains:    %d\n", marvelVillainNPC);
            System.out.printf("      Number of Villains with Superpowers: %d\n", marvelVillain);
            if (marvelVillain != 0) {
                System.out.println("      Aggregate Superpowers:");
                ArrayList<String> mitochondria = new ArrayList<>();
                for (int j = 0; j < chars.size(); j++) {
                    if (chars.get(j).getUniverse().equals("Marvel") && chars.get(j).getTeam().equals("Villains") && chars.get(j) instanceof SuperHV) {
                        ArrayList<String> temp = new ArrayList<>(((SuperHV) chars.get(j)).getPowers());
                        for (int k = 0; k < temp.size(); k++) {
                            if (!mitochondria.contains(temp.get(k))) {
                                mitochondria.add(temp.get(k));
                            }
                        }
                    }
                }
                Collections.sort(mitochondria); // Sorting the array list of powers and then displaying.
                String thing = String.format(mitochondria.toString().replace("[", "").replace("]", ""));
                System.out.printf("         %s\n", thing);
                System.out.println();
            }
        }
        
        // CODE FOR DISPLAYING DC HERO STATS
        System.out.println("   DC Characters");
        // Checking for any DC characters.
        if (DCHeroNPC == 0 && DCHero == 0 && DCVillain == 0 && DCVillainNPC == 0) { // If there are no DC characters
            System.out.println("      There are currently no DC characters in the system.");
            DC = false;
        }
        // If there are not DC hero/npc hero characters
        if (DCHero == 0 && DCHeroNPC == 0 && DC) {
            System.out.println("      Hero Stats:");
            System.out.println("      Number of Normal-Person Heroes:    0");
            System.out.println("      Number of Heroes with Superpowers: 0");
        } else if (DCHero != 0 || DCHeroNPC != 0) { // If there are Marvel hero/npc hero characters.
            // Set all stats equal to 0.
            double avgInt = 0;
            double avgStr = 0;
            double avgSta = 0;
            double avgSpe = 0;
            double avgSki = 0;
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("DC") && chars.get(i).getTeam().equals("Heroes")) {
                    // Calculating stats.
                    avgInt += chars.get(i).s.getIntelligence();
                    avgStr += chars.get(i).s.getStrength();
                    avgSta += chars.get(i).s.getStamina();
                    avgSpe += chars.get(i).s.getSpeed();
                    avgSki += chars.get(i).s.getSkills();

                }
            }
            // Printing stats for DC hero characters
            System.out.println("      Hero Stats:");
            // Format printing the stats
            System.out.printf("         Average Intelligence: %.2f\n", avgInt / (double) (DCHero + DCHeroNPC));
            System.out.printf("         Average Strength:     %.2f\n", avgStr / (double) (DCHero + DCHeroNPC));
            System.out.printf("         Average Stamina:      %.2f\n", avgSta / (double) (DCHero + DCHeroNPC));
            System.out.printf("         Average Speed:        %.2f\n", avgSpe / (double) (DCHero + DCHeroNPC));
            System.out.printf("         Average Skill:        %.2f\n", avgSki / (double) (DCHero + DCHeroNPC));
            System.out.printf("      Number of Normal-Person Heroes:    %d\n", DCHeroNPC);
            System.out.printf("      Number of Heroes with Superpowers: %d\n", DCHero);
            if (DCHero != 0) {
                System.out.println("      Aggregate Superpowers:");
                ArrayList<String> mitochondria = new ArrayList<>();
                for (int j = 0; j < chars.size(); j++) {
                    if (chars.get(j).getUniverse().equals("DC") && chars.get(j).getTeam().equals("Heroes") && chars.get(j) instanceof SuperHV) {
                        ArrayList<String> temp = new ArrayList<>(((SuperHV) chars.get(j)).getPowers());
                        for (int k = 0; k < temp.size(); k++) {
                            if (!mitochondria.contains(temp.get(k))) {
                                mitochondria.add(temp.get(k));
                            }
                        }
                    }
                }
                Collections.sort(mitochondria); // Sorting the array list of powers and then displaying.
                String thing = String.format(mitochondria.toString().replace("[", "").replace("]", ""));
                System.out.printf("         %s\n", thing);
                System.out.println();
            }
        }
        
        // CODE FOR DISPLAYING DC VILLAIN STATS
         // If there are not DC villain/npc villain characters
        if (DCVillain == 0 && DCVillainNPC == 0 && DC) {
            System.out.println("      Villain Stats:");
            System.out.println("      Number of Normal-Person Villains:    0");
            System.out.println("      Number of Villains with Superpowers: 0");
        } else if (DCVillain != 0 || DCVillainNPC != 0) { // If there are DC villain/npc villain characters.
             // Set all stats equal to 0.
            double avgInt = 0;
            double avgStr = 0;
            double avgSta = 0;
            double avgSpe = 0;
            double avgSki = 0;
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("DC") && chars.get(i).getTeam().equals("Villains")) {
                    // Calculating stats.
                    avgInt += chars.get(i).s.getIntelligence();
                    avgStr += chars.get(i).s.getStrength();
                    avgSta += chars.get(i).s.getStamina();
                    avgSpe += chars.get(i).s.getSpeed();
                    avgSki += chars.get(i).s.getSkills();

                }
            }
            // Printing stats for DC hero characters
            System.out.println("      Villain Stats:");
            // Format printing the stats
            System.out.printf("         Average Intelligence: %.2f\n", avgInt / (double) (DCVillain + DCVillainNPC));
            System.out.printf("         Average Strength:     %.2f\n", avgStr / (double) (DCVillain + DCVillainNPC));
            System.out.printf("         Average Stamina:      %.2f\n", avgSta / (double) (DCVillain + DCVillainNPC));
            System.out.printf("         Average Speed:        %.2f\n", avgSpe / (double) (DCVillain + DCVillainNPC));
            System.out.printf("         Average Skill:        %.2f\n", avgSki / (double) (DCVillain + DCVillainNPC));
            System.out.printf("      Number of Normal-Person Villains:    %d\n", DCVillainNPC);
            System.out.printf("      Number of Villains with Superpowers: %d\n", DCVillain);
            if (DCVillain != 0) {
                System.out.println("      Aggregate Superpowers:");
                ArrayList<String> mitochondria = new ArrayList<>();
                for (int j = 0; j < chars.size(); j++) {
                    if (chars.get(j).getUniverse().equals("DC") && chars.get(j).getTeam().equals("Villains") && chars.get(j) instanceof SuperHV) {
                        ArrayList<String> temp = new ArrayList<>(((SuperHV) chars.get(j)).getPowers());
                        for (int k = 0; k < temp.size(); k++) {
                            if (!mitochondria.contains(temp.get(k))) {
                                mitochondria.add(temp.get(k));
                            }
                        }
                    }
                }
                Collections.sort(mitochondria); // Sorting the array list of powers and then displaying.
                String thing = String.format(mitochondria.toString().replace("[", "").replace("]", ""));
                System.out.printf("         %s\n", thing);
                System.out.println();
            }
        }
    }
}
