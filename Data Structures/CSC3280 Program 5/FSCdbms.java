// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Title: FSC Database Management System (FSCdbms) COMMENT ASSIGNMENT
// Date: 11/18/2022
// Student ID: 1259757
// FSC Honor Code: I will practice academic and personal integrity and
// excellence of character and expect the same from others.

// import the scanner needed for reading in input
import java.util.*;
public class FSCdbms {
    
    // make a main method
    public static void main(String[] args) {
        
        // create a scanner to read in input
        Scanner in = new Scanner(System.in);
        
        // create the FSCdbmsBST for holding the students
        FSCdbmsBST tree = new FSCdbmsBST();
        
        // create the master course list
        FSCcourses masterList = new FSCcourses();
        
        // create a variable that indicates the number of commands to follow
        int k = in.nextInt();
        
        // loop over our new variable k to read each command
        for (int i = 0; i < k; i++) {
            
            // create a new variable that holds a single command
            String command = in.next();
            
            // command center calls the methods based off of the command given
            if (command.equals("NEWSTUDENT")) {
                newStudent(in, tree);
            } else if (command.equals("SEARCHNAME")) {
                searchName(in, tree);
            } else if (command.equals("SEARCHID")) {
                searchID(in, tree);
            } else if (command.equals("ADDCOURSE")) {
                addCourse(in, tree, masterList);
            } else if (command.equals("DELETE")) {
                delete(in, tree, masterList);
            } else if (command.equals("PRINTRECORD")) {
                printRecord(in, tree);
            } else if (command.equals("PRINTALLRECORDS")) {
                printAllRecords(in, tree, masterList);
            } else if (command.equals("PRINTALLCOURSES")) {
                printAllCourses(in, tree, masterList);
            }
        }
    }
    
    // make a method for adding new students.
    public static void newStudent(Scanner in, FSCdbmsBST tree){
        System.out.println("NEWSTUDENT Command");
        // newStudent command will be followed by additional information about student
        // example input: newStudent(command) ID(int) firstName(string) lastName(string)
        // email(string) age(int) phone(int)
        int ID = in.nextInt();
        String firstName = in.next();
        String lastName = in.next();
        String email = in.next();
        int age = in.nextInt();
        long phone = in.nextLong();
      
        // making a new Student object
        FSCstudent studentinfo = new FSCstudent(ID, firstName, lastName, email, age, phone);
        
        // if a new student is being added a new node will be added to the BST
        if (tree.searchByID(ID) == null) {
            // add student to the BST then print info
            tree.insert(studentinfo);
            // print format --> firstName lastName (ID(int))) has been inserted as a new student in FSCdbms.
            System.out.printf("	%s %s (ID %d) has been inserted as a new student in FSCdbms.\n", firstName, lastName, ID);
        }
        else {
            // if student already exist print message
            System.out.println("This is the error when you try to insert a student, but they already exist!");
        } 
    }
    
    // make a method that searches for a student based on first and last name
    public static void searchName(Scanner in, FSCdbmsBST tree){
        System.out.println("SEARCHNAME Command");
        // searchName command will be followed by first and last name of the student
        // example input: searchName(command) firstName(string) lastName(string)
        String firstName = in.next();
        String lastName = in.next();
        
        // search database for the name
        FSCstudent student = tree.searchByName(firstName, lastName);
        // if the name is found then print out the students information
        // print format --> Found: ID(int), firstName(string) lastName(string)
        if (student != null) {
            System.out.printf("	Found:  ID %d, %s %s\n", student.getID(), student.getFirstName(), student.getLastName());
        }
        // if the name isnt found print an error message
        else {
            System.out.printf("	%s %s was not found in FSCdbms.\n", firstName, lastName);
        }      
    }
    
    // make a method that searches for a student based on their ID num
    public static void searchID(Scanner in, FSCdbmsBST tree){
        System.out.println("SEARCHID Command");
        // searchiD command will be followed by their ID num
        // example input: searchID(command) ID(int)
        int ID = in.nextInt();
        
        // search database for the ID
        FSCstudent student = tree.searchByID(ID);
            // if the ID is found then print out the students information
            if (student != null){
                System.out.printf("	Found:  ID %d, %s %s\n", student.getID(), student.getFirstName(), student.getLastName());
            }
            // if the ID isnt found print an error message
            else{
                System.out.printf("	%d was not found in FSCdbms.\n", ID);
            }        
    }
    // make a method that adds a course to the students record
    public static void addCourse(Scanner in, FSCdbmsBST tree, FSCcourses masterList){
        System.out.println("ADDCOURSE Command");
        // addCourse command will be followed by student info
        // example input: addCourse(command)+ ID(int) courseID(string) grade(int)
        int ID = in.nextInt();
        String courseID = in.next();
        int grade = in.nextInt();
        // make a new course object and take data from user
        FSCcourse newCourse = new FSCcourse(courseID, grade);
        
        // search for the student in the database
        // search the students list of courses to see if they have taken the course yet
        FSCstudent student = tree.searchByID(ID);
        // if the student is found 
        if (student != null){
            // search for the course 
            FSCcourse course = student.getCourses().findNode(courseID);
            // if course NOT found, taking for the first time 
            if (course == null) {
                // insert this into the students linked list of courses
                student.getCourses().insert(newCourse);
                // update student creditHours
                student.setLevel(student.getLevel() + 4);
                // print format --> course (Grade: x) has been added to the record of Student ID()
                System.out.printf("	%s (Grade: %d) has been added to the record of Student ID %d.\n", newCourse.getID(), newCourse.getGrade(), student.getID());
                
            }
            // if the course is found in students record this course is being retaken
            else {
                // update record but not the student creditHours
                if (course.getGrade() < grade) {
                    course.setGrade(grade);
                }
            }
            // if this course is not in the list 
            if (masterList.findNode(courseID) == null) {
                // add course to list
                masterList.insert(newCourse);
            }
            // update the average lifetime grade (grade / num)
            FSCcourse temp = masterList.findNode(courseID);
            // add the students grade to the FSCcourse grade
            temp.setGrade(temp.getGrade());
            // increment FSCcourse num
            temp.setNumStudents(temp.getNumStudents() + 1);
        }
        else {
            System.out.printf("	ERROR: cannot add course. Student ID # %d was not found in FSCdbms.\n", ID);
        }       
    }
    
    // make a method to delete student records from FSCdbms
    public static void delete(Scanner in, FSCdbmsBST tree, FSCcourses masterList){
        System.out.println("DELETE Command");
        String firstName = in.next();
        String lastName = in.next();
        // search the BST
        FSCstudent student = tree.searchByName(firstName, lastName);
            // if the student is found delete them from the tree
            // remove their grade from the master list grade
            // remove -1 from the num 
            if (student != null) { // student was found
//                FSCcourses temp = student.getCourses(); // get list of courses taken
//                FSCcourse hp = temp.front(); // make a help pointer
                // we need to loop over all of the students courses
//                while(hp != null) {
//                    FSCcourse remove = masterList.findNode(hp.getID());
//                    if (remove != null){
//                        remove.setGrade(remove.getGrade() - hp.getGrade());
//                        remove.setNumStudents(remove.getNumStudents() - 1);
//                        if (remove.getNumStudents() == 0) {
//                        // if were supposed to remove the class from the masterList do something here
//                        }
//                    }
//                    
//                    hp = hp.getNext();
//                }   
//                while(temp == course){  
//                    // we need to check if the course has been taken by more than just the deleted student
//                    if (){
//                        // if taken by other students, dont delete, change numstudents and avaerage grade
//                    }
//                    else{
//                        // if deleted student was the only one, delete the course from the master list, change numstudents and average grade
//                    }
//                }
                // delete the student after changing the master list of courses
                tree.delete(student);
                // print delete message
                System.out.printf("	Student (%s %s) has been removed from FSCdbms.\n", firstName, lastName);
            }
            // if the student is not found print error message
            else{
                System.out.printf("	%s %s was not found in FSCdbms.\n", firstName,lastName);
            }
    }
    // make a method to print a students record
    public static void printRecord(Scanner in, FSCdbmsBST tree){
        System.out.println("PRINTRECORD Command");
        // printRecord command is followed by student info
        // example input: printRecord(command) firstName(string) lastName(string)
        String firstName = in.next();
        String lastName = in.next();
        FSCstudent student = tree.searchByName(firstName, lastName);
        // if student record is found
        if (student == null) {
            System.out.println("	Cannot Perform PRINTRECORD Command:");
            System.out.printf("		Student (%s %s) was not found in FSCdbms.\n", firstName, lastName);
            return;
        }
        else{
            // print all personal info with the students record such as 
            // their info, current level, gpa, courses they have taken, and grades recieved
            System.out.printf("	Student Record for ID %d\n", student.getID());
            System.out.printf("	First Name:  %s\n", student.getFirstName());
            System.out.printf("	Last Name:   %s\n", student.getLastName());
            System.out.printf("	Email:       %-36sPhone:  %d\n", student.getEmail(), student.getPhone());
            System.out.printf("	Age:         %d                                  Level:  %s\n", student.getAge(), studentYear(student.getLevel()));
        }
        // if student hasnt taken any courses
        if (student.getCourses().front() == null){
           System.out.print("	GPA:         N/A\n");
            System.out.print("	Course Record:\n");
            System.out.print("		Student has not taken any courses\n"); 
        }
        // if the student has taken courses
        else {
            System.out.printf("	GPA:         %.2f\n", calculateGPA(student));
            System.out.println("	Course Record:");
            student.getCourses().printGrades();
        }
    }
    // make a method to print all student records in FSCdbms
    public static void printAllRecords(Scanner in, FSCdbmsBST tree, FSCcourses masterList){
        System.out.println("PRINTALLRECORDS Command");
        // check to see if there are any students
        // if there are no students
        if (tree.isEmpty()) {
            // print error message
            System.out.println("There are no students in the database.");
        }
        // if there are print each studnts info
        else {
            // traverse through all students in the database
            System.out.println("	All records saved in FSCdbms:");
            System.out.println("	STUDENT ID     NAME                     AGE     YEAR/LEVEL     GPA");
            tree.inorder();
            
        }      
    }
    // make a method to print all courses that have ever been recorded in FSCdbms
    public static void printAllCourses(Scanner in, FSCdbmsBST tree, FSCcourses masterList){
        System.out.println("PRINTALLCOURSES Command");
        // check to see if there have been courses added
        // if there are no courses
        if (masterList.isEmpty()) {
            // print error message
            System.out.println("Error Message All Courses");
        }
        // if there are courses
        else {
            // print these courses
            masterList.printCourses();
        }   
    }
    
    // make a method to determine the students current grade
    // call this method when we need to print students grade
    public static String studentYear(int creditHours){
        // method will return a STRING
        if (creditHours < 30){
            return "1st Year";
        }
        else if (creditHours < 60){
            return "2nd Year";
        }
        else if (creditHours < 93){
            return "3rd Year";
        }
        else{
            return "4th Year";
        }
    }
    // make a method to calculate the GPA of a student
    // call this method when we need to calculate student GPA
    public static double calculateGPA(FSCstudent student) {
        // total grade variable
        double totalGrade = 0;
        // loop over the students courses
        FSCcourses temp = student.getCourses(); // get list of courses taken
        FSCcourse hp = temp.front(); // make a help pointer
        // we need to loop over all of the students courses
        while(hp.getNext() != null) {

            int givenGrade = hp.getGrade();
            int givenGradeLetter;
            // turn their grade into a number 1-4 (D-A) and multiply it by 4
            if (givenGrade < 70){
                givenGradeLetter = 1;
            }
            else if (givenGrade < 80){
                givenGradeLetter = 2;
            }
            else if (givenGrade < 90){
                givenGradeLetter = 3;
            }
            else {
                givenGradeLetter = 4;
            }
            // add to the total grade
            totalGrade += (givenGradeLetter * 4.0);
            hp = hp.getNext();
        }
        // return the total grade / creditHours
        student.setGpa(totalGrade / student.getLevel());
        return totalGrade / student.getLevel();
    }
}
