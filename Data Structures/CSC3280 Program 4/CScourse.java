// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757

public class CScourse {
    
    // data members
    private String courseNumber;
    private String courseDays;
    private String courseTime;
    
    // constructor
    public CScourse(String courseNumber, String courseDays, String courseTime) {
        this.courseNumber = courseNumber;
        this.courseDays = courseDays;
        this.courseTime = courseTime;
    }
    public CScourse(){
    }

    // getters
    public String getCourseNumber() {
        return courseNumber;
    }

    public String getCourseDays() {
        return courseDays;
    }

    public String getCourseTime() {
        return courseTime;
    }

    // setters
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setCourseDays(String courseDays) {
        this.courseDays = courseDays;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
    
    
    
}
