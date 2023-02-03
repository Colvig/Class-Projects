// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757

public class CSstudent {
    
    // data members
    private String firstName;
    private String lastName;
    private int ID;
    private int laptopSerialNumber;
    private int numCourses;
    private CScourse[] courses;
    private int enterTime; // n minutes after 12PM
    private int timeRemaining;
    private String timeRegistered; // time in min that the student returns the laptop and leaves lab
    private CSstudent next;

    // constructor
    public CSstudent(String firstName, String lastName, int ID, int laptopSerialNumber, int numCourses, CScourse[] courses, int enterTime, int timeRemaining, String timeRegistered) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.laptopSerialNumber = laptopSerialNumber;
        this.numCourses = numCourses;
        this.courses = courses;
        this.enterTime = enterTime;
        this.timeRemaining = timeRemaining;
        this.timeRegistered = timeRegistered;
        this.next = null; // If whole list is breaking i might want to look here oops I don't know if this will work
    }

    
    public CSstudent(){
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getID() {
        return ID;
    }

    public int getLaptopSerialNumber() {
        return laptopSerialNumber;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public CScourse[] getCourses() {
        return courses;
    }

    public int getEnterTime() {
        return enterTime;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public String getTimeRegistered() {
        return timeRegistered;
    }

    public CSstudent getNext() {
        return next;
    }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLaptopSerialNumber(int laptopSerialNumber) {
        this.laptopSerialNumber = laptopSerialNumber;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    public void setCourses(CScourse[] courses) {
        this.courses = courses;
    }

    public void setEnterTime(int enterTime) {
        this.enterTime = enterTime;
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public void setTimeRegistered(String timeRegistered) {
        this.timeRegistered = timeRegistered;
    }

    public void setNext(CSstudent next) {
        this.next = next;
    }
    
    // method to compare students names 
    public static int compareTo(CSstudent insert, CSstudent other) {
        int ans;
        ans = insert.getLastName().compareTo(other.getLastName());
        if (ans == 0) {
           ans = insert.getFirstName().compareTo(other.getFirstName());
           return ans;
        }
        else {
            return ans;
        }
    }
    
}
