// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Title: CS Registration Lab
// Date: 10/26/2022
// Student ID: 1259757
// FSC Honor Code: I will practice academic and personal integrity and
// excellence of character and expect the same from others.

import java.util.*;

public class CSregistrationLab {

    public static void main(String[] args) throws Exception {
        // Make variables
        int numLaptops;
        int numDays;
        int numStudents;

        // Make Scanner for input
        Scanner input = new Scanner(System.in);

        // Scan 1st line of input file (number of laptops)
        numLaptops = input.nextInt();

        // Make a new Stack of Laptops
        CSlaptopStack laptops = new CSlaptopStack(numLaptops);

        // Scan laptops and PUSH them into the stack
        for (int i = 0; i < numLaptops; i++) {
            laptops.push(input.nextInt());
        }

        // Make the FOUR queues for each of the needed queues
        CSqueue outsideLine = new CSqueue(); // students outside that need everything
        CSqueue laptopCheckOutLine = new CSqueue(); // students that need a laptop
        CSqueue studentsRegistering = new CSqueue(); // students have laptop & need to to register 
        CSqueue laptopReturnLine = new CSqueue(); // student done registering and need to return laptop

        

        // Make LCM & LRM
        CSstudent studentWithLCM = null; // Reference to student who is working with the LCM
        CSstudent studentWithLRM = null; // Reference to student who is working with the LRM
        // We use them to point to students who are currently interacting with the LCM or LRM

        // Scan number of days of the simulation
        numDays = input.nextInt();

        // OUTER FOR LOOP over all days of simulation
        for (int i = 0; i < numDays; i++) {
            // Make ONE linked-list for the Daily Registration Report
            CSregistrations dailyRegistrations = new CSregistrations(); // use this linklist to print EOD report
            // Print header message to output for given day
            System.out.println("**********");
            System.out.println("Day " + (i + 1) + ":");
            System.out.println("**********");
            System.out.println();

            // Scan the number of students for this day
            numStudents = input.nextInt();
            int studentsRemaining = numStudents; // used for MAIN LOOP condition

            // INNER FOR LOOP to scan/save all students for given day
            for (int j = 0; j < numStudents; j++) {
                // Make a NEW CSstudent object and SAVE data
                CSstudent tempStudent = new CSstudent();
                tempStudent.setEnterTime(input.nextInt());
                tempStudent.setLastName(input.next());
                tempStudent.setFirstName(input.next());
                tempStudent.setID(input.nextInt());
                tempStudent.setNumCourses(input.nextInt());
                tempStudent.setNext(null);

                // Make temp CScourse array to temporarily hold the courses for this particular student
                CScourse[] tempCourses = new CScourse[tempStudent.getNumCourses()];

                // FOR loop over the number of courses for above NEW student
                for (int k = 0; k < tempStudent.getNumCourses(); k++) {
                    // Make a NEW CScourse object and SAVE data
                    CScourse tempCourse = new CScourse();
                    tempCourse.setCourseNumber(input.next());
                    tempCourse.setCourseDays(input.next());
                    String courseTime = input.nextLine();
                    tempCourse.setCourseTime(courseTime.substring(1));
                    // Save the course into the tempCourses array
                    tempCourses[k] = tempCourse;
                }

                // Finally, save the array of courses into the tempStudent courses member
                tempStudent.setCourses(tempCourses);

                // ENQUEUE tempStudent into outsideLine queue
                outsideLine.enqueue(tempStudent); // all students in outside line

            } // END loop SCANNING/SAVING all students to outsideLine

            //**********************************************************************/
            //********************** MAIN SIMULATION FOR LOOP **********************/
            //**********************************************************************/
            
            // looping by the minute while there is time left or students left
            for (int currentTime = 0; currentTime < 300 || studentsRemaining > 0; currentTime++) {
                // processing the laptop return minion
                if (studentWithLRM != null) { // checking if someone is with the laptop return minion
                    studentWithLRM.setTimeRegistered(convertTime(currentTime)); // setting registration time for student with LRM
                    dailyRegistrations.insert(studentWithLRM);
                    laptops.push(studentWithLRM.getLaptopSerialNumber());
                    System.out.printf("%s:  %s %s successfully registered and returned laptop # %d.\n", convertTime(currentTime), studentWithLRM.getFirstName(), studentWithLRM.getLastName(), studentWithLRM.getLaptopSerialNumber());
                    numLaptops++; // adding laptop back to total 
                    studentWithLRM = null;
                    studentsRemaining--; // changing the students that are remaining
                }
                // processing the laptop check out minion
                if (studentWithLCM != null && numLaptops > 0) { // checking if someone is with the laptop checkout minion 
                    studentWithLCM.setTimeRemaining(6); // setting students remaining time for registration
                    studentWithLCM.setLaptopSerialNumber(laptops.pop()); // giving the student a laptop
                    System.out.printf("%s:  %s %s has checked-out laptop # %d.\n",convertTime(currentTime), studentWithLCM.getFirstName(), studentWithLCM.getLastName(), studentWithLCM.getLaptopSerialNumber());
                    studentsRegistering.enqueue(studentWithLCM); // put student with LCM into registration queue
                    numLaptops--; // removing laptop from total
                    studentWithLCM = null;
                }
                // processing students who are currently registering with laptops
                if (!studentsRegistering.isEmpty()) {
                    studentsRegistering.countDown(); // starting the registration countdown
                    if (studentsRegistering.peek().getTimeRemaining() == 0) { // if students are done registering
                        CSstudent tempStudent = studentsRegistering.dequeue(); // remove student from registratiopn queue
                        laptopReturnLine.enqueue(tempStudent); // place student in the laptop return queue
                        System.out.printf("%s:  %s %s finished registering and entered the Laptop Return Line.\n", convertTime(currentTime), tempStudent.getFirstName(), tempStudent.getLastName());
                    }
                }
                // processing laptop return line
                if (!laptopReturnLine.isEmpty()) {
                    studentWithLRM = laptopReturnLine.dequeue();
                }
                // processing outside line
                if (!outsideLine.isEmpty()) {
                    while (currentTime == outsideLine.peek().getEnterTime()) { // checking if student arrival time equals current time
                        CSstudent tempStudent = outsideLine.dequeue(); // moving student out of line
                        laptopCheckOutLine.enqueue(tempStudent); // placing student in laptop check out line
                        System.out.printf("%s:  %s %s has arrived at the Registration Lab and entered the Laptop Check-out Line.\n", convertTime(currentTime), tempStudent.getFirstName(), tempStudent.getLastName());
                        if (outsideLine.isEmpty()) { // noone in line to register
                            break;
                        }
                    }
                }
                // processing laptop check out line
                if (numLaptops > 0 && !laptopCheckOutLine.isEmpty()) {
                    studentWithLCM = laptopCheckOutLine.dequeue();
                }
            } //*********** END main FOR Loop of Simulation ***********//

            // PRINT Daily Registration Report
            // Notice that the printing of the daily registration report happens AFTER the
            // main for loop over each minute...and that should make sense, right? Once the day
            // has completed, then and only then are you ready to traverse/print the linked-list
            // of the completed registrations.
            System.out.printf("\n*** Day %s:  FCIT Daily Registration Report ***:\n\n", i+1);
            System.out.printf("The Registration Lab received %d registrations as follows:\n\n", numStudents);
            dailyRegistrations.PrintList();
            
        }
    }

    // converting our x minutes after 12 to a time
    public static String convertTime(int currentTime) {
        int hours = currentTime / 60;
        int minutes = currentTime % 60;
        if (hours == 0) {
            hours = 12;
        }
        String time = "%d:%02d PM".formatted(hours, minutes);
        return time;
    }

}
