// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Title: FSC Telecom
// Date: 09/16/2022
// Student ID: 1259757
// FSC Honor Code: I will practice academic and personal integrity and
// excellence of character and expect the same from others.

import java.util.*;

public class FSCTelecom {

    // FINAL (CONSTANT) variables
    public static final double ratePerMinute = 0.05;
    public static final double smsRate = 0.02;
    public static final double dataRatePerKB = (1.0 / 1024.0) / 100.0;

    // method for making a new student account
    public static void addAccount(FSCTelecomAccounts accounts, String[] inputLine, Scanner in) {
        // Note that this method should use the search() or findNode() method of the Linked List class
        // Note that this method should use the insert() method of the Linked List class
        // taking input info
        int studentID = Integer.parseInt(inputLine[1]);
        String studentFirstName = inputLine[2];
        String studentLastName = inputLine[3];
        String studentPhoneNum = inputLine[4];

        // making a new Student object
        Student studentinfo = new Student(studentID, studentFirstName, studentLastName, studentPhoneNum);

        // inserting the object into the linkedlist
        accounts.insert(studentinfo);

        // output for adding an account
        System.out.print("Command: ADDACCOUNT\n");
        System.out.printf("	Name:          %s %s\n", studentinfo.getStudentFirstName(), studentinfo.getStudentLastName());
        System.out.printf("	Student ID:    %d\n", studentinfo.getStudentID());
        System.out.printf("	Phone Number:  %s\n", studentinfo.getStudentPhoneNum());
        System.out.printf("	Balance:       $%.2f\n", studentinfo.getStudentBalance());
        System.out.println("");

    }

    // method for making a call
    public static void makeCall(FSCTelecomAccounts accounts, String[] inputLine, Scanner in) {
        // taking input
        int studentID = Integer.parseInt(inputLine[1]);
        String numberCalled = inputLine[2];
        int callMinutes = Integer.parseInt(inputLine[3]);

        // searching linklist for students info
        if (accounts.search(studentID)) {
            Student current = accounts.findNode(studentID); // setting current student account we want to modify
            double callCostCents = callMinutes * 0.05; // calculating the call cost

            if (current.getStudentBalance() < 0.05) {
                // if student has no money
                System.out.print("Command: MAKECALL\n");
                System.out.print("	Cannot perform MAKECALL. Account has insufficient balance.\n");
                System.out.println("");

            } else if (current.getStudentBalance() >= callCostCents) { // student has more than enough money
                double prevBalance = current.getStudentBalance(); // setting the students prev balance
                int callLengthInMinutes = callMinutes;
                current.setStudentBalance(current.getStudentBalance() - (callLengthInMinutes * 0.05)); // setting new balance
                // insert the number called and call duration into the arrays
                for (int i = 8; i >= 0; i--) {
                    current.getCalledNumbers()[i + 1] = current.getCalledNumbers()[i];
                    current.getCallDuration()[i + 1] = current.getCallDuration()[i];
                }
                current.getCalledNumbers()[0] = numberCalled;
                current.getCallDuration()[0] = callLengthInMinutes;

                // output for making a call
                System.out.print("Command: MAKECALL\n");
                System.out.printf("	Name:           %s %s\n", current.getStudentFirstName(), current.getStudentLastName());
                System.out.printf("	Phone Number:   %s\n", current.getStudentPhoneNum());
                System.out.printf("	Number Called:  %s\n", numberCalled);
                System.out.printf("	Call Duration:  %d minutes\n", callLengthInMinutes);
                System.out.printf("	Prev Balance:   $%.02f\n", prevBalance);
                System.out.printf("	Call Cost:      $%.02f\n", callLengthInMinutes * 0.05);
                System.out.printf("	New Balance:    $%.02f\n", current.getStudentBalance());
                System.out.println("");
                current.setHasCalled(true); // setting the flag for hasCalled to true

            } else if (current.getStudentBalance() < callCostCents) {
                // student has money but not enough for the full call they wanted
                double prevBalance = current.getStudentBalance();
                int callLengthInMinutes = (int) (current.getStudentBalance() / 0.05);
                current.setStudentBalance(prevBalance - (callLengthInMinutes * 0.05));
                // insert the number called and call duration into the arrays
                for (int i = 8; i >= 0; i--) {
                    current.getCalledNumbers()[i + 1] = current.getCalledNumbers()[i];
                    current.getCallDuration()[i + 1] = current.getCallDuration()[i];
                }
                current.getCalledNumbers()[0] = numberCalled;
                current.getCallDuration()[0] = callLengthInMinutes;

                // output for making a call
                System.out.print("Command: MAKECALL\n");
                System.out.printf("	Name:           %s %s\n", current.getStudentFirstName(), current.getStudentLastName());
                System.out.printf("	Phone Number:   %s\n", current.getStudentPhoneNum());
                System.out.printf("	Number Called:  %s\n", numberCalled);
                System.out.printf("	Call Duration:  %d minutes\n", callLengthInMinutes);
                System.out.printf("	Prev Balance:   $%.02f\n", prevBalance);
                System.out.printf("	Call Cost:      $%.02f\n", callLengthInMinutes * 0.05);
                System.out.printf("	New Balance:    $%.02f\n", current.getStudentBalance());
                System.out.println("	***Call terminated due to low balance.");
                System.out.println("");
                current.setHasCalled(true); // setting the flag for hasCalled to true
            }

        } else {
            // the student account could not be found
            System.out.print("Command: MAKECALL\n");
            System.out.print("	Cannot perform MAKECALL. Account does not exist in FSC Telecom System.\n");
            System.out.println("");
        }
    }

    // method for sending a text message
    public static void sendText(FSCTelecomAccounts accounts, String[] inputLine, Scanner in) {
        // taking input
        int studentID = Integer.parseInt(inputLine[1]);
        String destinationNumber = inputLine[2];
        double textCostPerMessage = 0.02;

        // searching linked list for the student
        if (accounts.search(studentID)) {
            Student current = accounts.findNode(studentID); // setting current student account we want to modify
            if (current.getStudentBalance() < 0.02) {
                // if student has no money
                System.out.print("Command: SENDTEXT\n");
                System.out.print("	Cannot perform SENDTEXT. Account has zero balance.\n");
                System.out.println("");
            } // student was found and has money for the text
            else if (current.getStudentBalance() >= textCostPerMessage) {
                double prevBalance = current.getStudentBalance(); // setting prev balance
                current.setStudentBalance(current.getStudentBalance() - textCostPerMessage); // calculating new balance
                for (int i = 8; i >= 0; i--) {
                    current.getTextedNumbers()[i + 1] = current.getTextedNumbers()[i];
                }
                current.getTextedNumbers()[0] = destinationNumber; // saving texted number into the students texted history

                // output for sending a text
                System.out.print("Command: SENDTEXT\n");
                System.out.printf("	Name:           %s %s\n", current.getStudentFirstName(), current.getStudentLastName());
                System.out.printf("	Phone Number:   %s\n", current.getStudentPhoneNum());
                System.out.printf("	Number Texted:  %s\n", destinationNumber);
                System.out.printf("	Prev Balance:   $%.02f\n", prevBalance);
                System.out.printf("	Text Cost:      $%.02f\n", textCostPerMessage);
                System.out.printf("	New Balance:    $%.02f\n", current.getStudentBalance());
                System.out.println("");
                current.setHasTexted(true); // setting the flag for hasTexted to true
            }
        } else {
            // output for when the studenr could not be found
            System.out.print("Command: SENDTEXT\n");
            System.out.print("	Cannot perform SENDTEXT. Account does not exist in FSC Telecom System.\n");
            System.out.println("");
        }
    }

    // method for using data
    public static void useData(FSCTelecomAccounts accounts, String[] inputLine, Scanner in) {
        // taking input
        int studentID = Integer.parseInt(inputLine[1]);
        int howMuchData = Integer.parseInt(inputLine[2]);

        if (accounts.search(studentID)) { // if student is found
            Student current = accounts.findNode(studentID); // setting current student account we want to modify
            // calculating data cost
            double dataCost = Math.ceil(howMuchData * dataRatePerKB * 100000.0) / 100000.0;
            dataCost = ((int) (dataCost * 100)) / 100.0;

            if (current.getStudentBalance() == 0) { // student has no money
                System.out.print("Command: USEDATA\n");
                System.out.print("	Cannot perform USEDATA. Account does not have enough balance.\n");
                System.out.println("");
            } else if (current.getStudentBalance() < dataCost) { // student has money but not enough for the data charge

                System.out.print("Command: USEDATA\n");
                System.out.print("	Cannot perform USEDATA. Account does not have enough balance.\n");
                System.out.println("");
            } else if (current.getStudentBalance() >= dataCost) { // student has enough money for data
                double prevBalance = current.getStudentBalance(); // setting the students prev balance
                current.setStudentBalance(current.getStudentBalance() - dataCost); // setting new balance
                // output
                System.out.print("Command: USEDATA\n");
                System.out.printf("	Name:           %s %s\n", current.getStudentFirstName(), current.getStudentLastName());
                System.out.printf("	Phone Number:   %s\n", current.getStudentPhoneNum());
                System.out.printf("	Kilobytes:      %d\n", howMuchData);
                System.out.printf("	Prev Balance:   $%.02f\n", prevBalance);
                System.out.printf("	Data Cost:      $%.02f\n", dataCost);
                System.out.printf("	New Balance:    $%.02f\n", current.getStudentBalance());
                System.out.println("");
            }
        } else { // student account is not found
            System.out.print("Command: USEDATA\n");
            System.out.print("	Cannot perform USEDATA. Account does not exist in FSC Telecom System.\n");
            System.out.println("");
        }
    }

    // method for recharging an account
    public static void recharge(FSCTelecomAccounts accounts, String[] inputLine, Scanner in) {
        // taking input
        int studentID = Integer.parseInt(inputLine[1]);
        double rechargeAmount = Double.parseDouble(inputLine[2]);

        if (accounts.search(studentID)) { // if student is found
            Student current = accounts.findNode(studentID); // setting current student account we want to modify
            double prevBalance = current.getStudentBalance(); // setting the students prev balance
            current.setStudentBalance(current.getStudentBalance() + rechargeAmount); // setting new balance
            System.out.print("Command: RECHARGE\n");
            System.out.printf("	Name:            %s %s\n", current.getStudentFirstName(), current.getStudentLastName());
            System.out.printf("	Phone Number:    %s\n", current.getStudentPhoneNum());
            System.out.printf("	Recharge Amount: $%.02f\n", rechargeAmount);
            System.out.printf("	New Balance:     $%.02f\n", current.getStudentBalance());
            System.out.println("");
        } else { // student account not found
            System.out.print("Command: RECHARGE\n");
            System.out.print("	Cannot perform RECHARGE. Account does not exist in FSC Telecom System.\n");
            System.out.println("");
        }
    }

    // method for deleting an account
    public static void deleteAccount(FSCTelecomAccounts accounts, String[] inputLine, Scanner in) {
        // taking input
        int studentID = Integer.parseInt(inputLine[1]);

        if (accounts.search(studentID)) { // if student is found
            Student current = accounts.findNode(studentID); // setting current student account we want to delete
            accounts.delete(studentID); // deleting account
            // output for deleting an account
            System.out.print("Command: DELETEACCOUNT\n");
            System.out.printf("	Name:           %s %s\n", current.getStudentFirstName(), current.getStudentLastName());
            System.out.printf("	Student ID:     %d\n", current.getStudentID());
            System.out.printf("	Phone Number:   %s\n", current.getStudentPhoneNum());
            System.out.printf("	Balance:        $%.02f\n", current.getStudentBalance());
            System.out.print("	***Account has been deleted.\n");
            System.out.println("");

        } else { // student account is not found
            System.out.print("Command: DELETEACCOUNT\n");
            System.out.print("	Cannot perform DELETEACCOUNT. Account does not exist in FSC Telecom System.\n");
            System.out.println("");
        }
    }

    // method for searching for an account
    public static void search(FSCTelecomAccounts accounts, String[] inputLine, Scanner in) {
        // taking input
        int studentID = Integer.parseInt(inputLine[1]);
        if (accounts.search(studentID)) { // if student is found
            Student current = accounts.findNode(studentID); // setting current student account we want to modify
            // output for searching for an account
            System.out.print("Command: SEARCH\n");
            System.out.printf("	Name:          %s %s\n", current.getStudentFirstName(), current.getStudentLastName());
            System.out.printf("	Student ID:    %d\n", current.getStudentID());
            System.out.printf("	Phone Number:  %s\n", current.getStudentPhoneNum());
            System.out.printf("	Balance:       $%.02f\n", current.getStudentBalance());
            System.out.println("");
        } else { // student account is not found
            System.out.print("Command: SEARCH\n");
            System.out.print("	Cannot perform SEARCH. Account does not exist in FSC Telecom System.\n");
            System.out.println("");
        }
    }

    // method for displaying an accounts details (calls/texts made)
    public static void displayDetails(FSCTelecomAccounts accounts, String[] inputLine, Scanner in) {
        int studentID = Integer.parseInt(inputLine[1]); // taking input

        if (accounts.search(studentID)) {
            // setting current student account we want to display details for
            Student current = accounts.findNode(studentID);

            System.out.print("Command: DISPLAYDETAILS\n");
            System.out.printf("	Name:          %s %s\n", current.getStudentFirstName(), current.getStudentLastName());
            System.out.printf("	Student ID:    %d\n", current.getStudentID());
            System.out.printf("	Phone Number:  %s\n", current.getStudentPhoneNum());
            System.out.print("	Called Numbers and Duration:\n");
            if (current.isHasCalled()) { // if calls were made
                for (int i = 0; i < 10; i++) {
                    if (!current.getCalledNumbers()[i].equals("")) {
                        System.out.printf("		%s (%d)\n", current.getCalledNumbers()[i], current.getCallDuration()[i]);
                    }
                }
            } else { // no calls made
                System.out.println("		(user has not made any calls yet)");
                
            }
            System.out.print("	Texted Numbers:\n");
            if (current.isHasTexted()) { // if texts were made

                for (int i = 0; i < 10; i++) {
                    if (!current.getTextedNumbers()[i].equals("")) {
                        System.out.printf("		%s\n", current.getTextedNumbers()[i]);
                    }
                }
                System.out.println("");
            } else { // no texts made
                System.out.println("		(user has not made any texts yet)");
                System.out.println("");
            }

        } else { // no account found
            System.out.print("Command: DISPLAYDETAILS\n");
            System.out.print("	Cannot perform DISPLAYDETAILS. Account does not exist in FSC Telecom System.\n");
            System.out.println("");
        }
    }

    // main method 
    public static void main(String[] args) {
        // Variables needed for program
        String[] inputLine; // used to save the command read from input file
        Scanner in = new Scanner(System.in);

        // Make linked-list
        FSCTelecomAccounts accounts = new FSCTelecomAccounts();
        // ^ ^ ^ ^ ^
        // | | | | |
        // | | | | |     "accounts" is the reference variable that points
        //               to your linked-list of Student objects

        // MAIN DO/WHILE LOOP:
        //    - We read commands and then process the commands by calling
        //      the appropriate methods.
        while (true) {
            inputLine = in.nextLine().split(" ");

            // ADDACCOUNT
            if (inputLine[0].equals("ADDACCOUNT") == true) {
                addAccount(accounts, inputLine, in);
                // NOTE: what are we sending to this method?
                //       Two things:
                //       1. a reference to the linked list (accounts)
                //       2. a reference to the array which has the inputLine
            } // MAKECALL
            else if (inputLine[0].equals("MAKECALL") == true) {
                makeCall(accounts, inputLine, in);
            } // SENDTEXT
            else if (inputLine[0].equals("SENDTEXT") == true) {
                sendText(accounts, inputLine, in);
            } // USEDATA
            else if (inputLine[0].equals("USEDATA") == true) {
                useData(accounts, inputLine, in);
            } // RECHARGE
            else if (inputLine[0].equals("RECHARGE") == true) {
                recharge(accounts, inputLine, in);
            } // DELETEACCOUNT
            else if (inputLine[0].equals("DELETEACCOUNT") == true) {
                deleteAccount(accounts, inputLine, in);
            } // SEARCH
            else if (inputLine[0].equals("SEARCH") == true) {
                search(accounts, inputLine, in);
            } // DISPLAYDETAILS
            else if (inputLine[0].equals("DISPLAYDETAILS") == true) {
                displayDetails(accounts, inputLine, in);
            } // Command QUIT: Quit the Program
            else if (inputLine[0].equals("QUIT") == true) {
                System.out.println("Command: QUIT.");
                System.out.println("\tExiting the FSC Telecom System...");
                System.out.println("\tGoodbye.");
                System.out.println("");
                break;
            } // Invalid Command --- this will NEVER occur if you coded things correctly
            else {
                System.out.println("Invalid Command: input invalid.");
            }

        } // END while loop

    } // END main() method
}
