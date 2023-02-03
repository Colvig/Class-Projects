
import java.util.HashSet;

// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757

public class FSCcourses {
    // head: reference variable to the first node of the list

    private FSCcourse head;

    // CONSTRUCTORS
    public FSCcourses() {
        head = null;
    }

    /* Below are MANY methods that are used on Linked Lists.
	 * 
	 * Examples:
	 * search, insert, delete, isEmpty, sumNodes, and many more
     */
    //
    // boolean | isEmpty()
    //
    public boolean isEmpty() {
        return head == null;
    }
    
    public FSCcourse front() {
        return head;
    }

    //
    // boolean | search(int)
    //
    public boolean search(String ID) {
        return search(head, ID);
    }
    //
    // boolean | search(LLnode, int)
    //

    private boolean search(FSCcourse p, String ID) {
        FSCcourse helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getID().equals(ID)) {
                return true;
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

    //
    // LLnode | findNode(int)
    //
    public FSCcourse findNode(String courseID) {
        return findNode(head, courseID);
    }
    //
    // LLnode | findNode(LLnode, int)
    //

    private FSCcourse findNode(FSCcourse p, String courseID) {
        FSCcourse helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getID().equals(courseID)) {
                return helpPtr;
            }
            helpPtr = helpPtr.getNext();
        }
        return null;
    }

    //
    // void | PrintList()
    //
    public void printGrades() {
        printGrades(head);
    }
    //
    // void | PrintList(LLnode)
    //

    private void printGrades(FSCcourse head) {
        // We need to traverse...so we need a help ptr
        FSCcourse helpPtr = head;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Print the data value of the node
            System.out.printf("		Course ID:  %s   Grade:   %d\n", helpPtr.getID(), helpPtr.getGrade());
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }
    
    public void printCourses() {
        printCourses(head);
    }
    //
    // void | PrintList(LLnode)
    //

    private void printCourses(FSCcourse head) {
        System.out.println("	All courses saved in FSCdbms:");
        System.out.println("	COURSE NAME         AVERAGE GRADE");
        // We need to traverse...so we need a help ptr
        FSCcourse helpPtr = head;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Print the data value of the node
            //System.out.println(helpPtr.getID() + " " + helpPtr.getNumStudents());
            System.out.printf("	%s                %d\n", helpPtr.getID(), helpPtr.getGrade()/helpPtr.getNumStudents());
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
    }

//    //
//    // void | PrintList()
//    //
//    public void ModifyAllNodes() {
//        ModifyAllNodes(head);
//    }
//    //
//    // void | PrintList(LLnode)
//    //
//
//    private void ModifyAllNodes(FSCcourse head) {
//        // We need to traverse...so we need a help ptr
//        FSCcourse helpPtr = head;
//        // Traverse to correct insertion point
//        while (helpPtr != null) {
//            // We add 10 to the data value of each node
//            helpPtr.setData(helpPtr.getData() + 10);
//            // Step one node over
//            helpPtr = helpPtr.getNext();
//        }
//    }


    //
    // void | insert(int)
    //
    public void insert(FSCcourse course) {
        head = insert(head, course);
    }
    //
    // LLnode | insert(LLnode, value)
    //

    private FSCcourse insert(FSCcourse head, FSCcourse course) {
        // IF there is no list, newNode will be the first node, so just return it signnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
        if (head == null) {
            head = course;
            return head;
        }
        else if (head.getID().compareTo(course.getID()) > 0) {
            course.setNext(head.getNext());
            head = course;
            return head;
            
        }// ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            FSCcourse helpPtr = head;
            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) {
                if (helpPtr.getNext().getID().compareTo(course.getID()) > 0) {
                    break; // we found our spot and should break out of the while loop
                }
                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
//            FSCcourse newNode = new FSCcourse(data, helpPtr.getNext());
            course.setNext(helpPtr.getNext());
            helpPtr.setNext(course);
        }
        // Return head
        return head;
    }
    

}
