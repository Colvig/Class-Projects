// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757

public class Student {
    private int studentID;
    private String studentFirstName;
    private String studentLastName;
    private String studentPhoneNum;
    private Student next;
    private double studentBalance;
    private String[] calledNumbers;
    private int[] callDuration;
    private String[] textedNumbers;
    private static int numStudents;
    private boolean hasCalled;
    private boolean hasTexted;
    
    

    // constructor
    public Student(int studentID, String studentFirstName,
            String studentLastName, String studentPhoneNum) {
        this.studentID = studentID;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentPhoneNum = studentPhoneNum;
        this.studentBalance = 20.00;
        this.textedNumbers = new String[]{"","","","","","","","","",""};
        this.calledNumbers = new String[]{"","","","","","","","","",""};
        this.callDuration = new int[]{0,0,0,0,0,0,0,0,0,0};
        
    }
    
    // getters
    public int getStudentID() {
        return studentID;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getStudentPhoneNum() {
        return studentPhoneNum;
    }

    public Student getNext() {
        return next;
    }

    public double getStudentBalance() {
        return studentBalance;
    }

    public String[] getCalledNumbers() {
        return calledNumbers;
    }

    public int[] getCallDuration() {
        return callDuration;
    }

    public String[] getTextedNumbers() {
        return textedNumbers;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public boolean isHasCalled() {
        return hasCalled;
    }

    public boolean isHasTexted() {
        return hasTexted;
    }

    
    
    
 
    
    
    
    
    
    // setters
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public void setStudentPhoneNum(String studentPhoneNum) {
        this.studentPhoneNum = studentPhoneNum;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    public void setStudentBalance(double studentBalance) {
        this.studentBalance = studentBalance;
    }

    public void setCalledNumbers(String[] calledNumbers) {
        this.calledNumbers = calledNumbers;
    }

    public void setCallDuration(int[] callDuration) {
        this.callDuration = callDuration;
    }

    public void setTextedNumbers(String[] textedNumbers) {
        this.textedNumbers = textedNumbers;
    }

    public static void setNumStudents(int numStudents) {
        Student.numStudents = numStudents;
    }

    public void setHasCalled(boolean hasCalled) {
        this.hasCalled = hasCalled;
    }
    public void setHasTexted(boolean hasTexted) {
        this.hasTexted = hasTexted;
    }
    
    
    
    
    
}
