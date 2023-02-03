// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757

public class FSCcourse {
    private FSCcourse next;
private String ID; // courses IDsss
    private int grade; // grade the student receieved, used to calculate average grade of course
    private int numStudents; // num of students that have taken the course, used to calculate average grade of course

    
    // CONSTRUCTORs
    public FSCcourse(String ID, int grade) {
        this.ID = ID;
        this.grade = grade;
    }
    

    // ACCESSORS
    public FSCcourse getNext() {
        return next;
    }

    public String getID() {
        return ID;
    }

    public int getGrade() {
        return grade;
    }
    public int getNumStudents() {
        return numStudents;
    }
    
    // MUTATORS
    public void setNext(FSCcourse next) {
        this.next = next;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }  
    
    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }
}
