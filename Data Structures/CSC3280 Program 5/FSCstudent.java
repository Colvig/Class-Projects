// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757

public class FSCstudent {
    private FSCstudent left;
    private FSCstudent right;
    
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private long phone;
    private int level;
    private FSCcourses courses;
    private double gpa;

    
    // CONSTRUCTORS
    public FSCstudent(int ID, String firstName, String lastName, String email, int age, long phone) {
        this.left = null;
        this.right = null;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.level = 0;
        this.courses = new FSCcourses();
        this.gpa = -1;
    }
    
    

    // ACCESSORS
    public FSCstudent getLeft() {
        return left;
    }

    public FSCstudent getRight() {
        return right;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public long getPhone() {
        return phone;
    }

    public int getLevel() {
        return level;
    }

    public FSCcourses getCourses() {
        return courses;
    }

    public double getGpa() {
        return gpa;
    }
    
    
    // MUTATORS
    public void setLeft(FSCstudent left) {
        this.left = left;
    }

    public void setRight(FSCstudent right) {
        this.right = right;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCourses(FSCcourses courses) {
        this.courses = courses;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

