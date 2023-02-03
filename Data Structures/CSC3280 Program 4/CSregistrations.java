// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757

public class CSregistrations {

    // head: reference variable to the first node of the list
    private CSstudent head;

    // CONSTRUCTORS
    public CSregistrations() {
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

    //
    // boolean | search(int)
    //
//	public boolean search(int data) {
//		return search(head, data);
//	}
//	//
//	// boolean | search(LLnode, int)
//	//
//	private boolean search(CSstudent p, int data) {
//		CSstudent helpPtr = p;
//		while (helpPtr != null) {
//			if (helpPtr.getData() == data)
//				return true;
//			helpPtr = helpPtr.getNext();			
//		}
//		return false;
//	}
    //
    // LLnode | findNode(int)
    //
//	public CSstudent findNode(int data) {
//		return findNode(head, data);
//	}
//	//
//	// LLnode | findNode(LLnode, int)
//	//
//	private CSstudent findNode(CSstudent p, int data) {
//		CSstudent helpPtr = p;
//		while (helpPtr != null) {
//			if (helpPtr.getData() == data)
//				return helpPtr;
//			helpPtr = helpPtr.getNext();			
//		}
//		return null;
//	}
    //
    // void | PrintList()
    //
    public void PrintList() {
        PrintList(head);
    }
    //
    // void | PrintList(LLnode)
    //

    private void PrintList(CSstudent head) {
        // We need to traverse...so we need a help ptr
        CSstudent hp = head;
        // Traverse to correct insertion point
        while (hp != null) {
            // printig for the daily registration report
            System.out.printf("%s, %s, ID # %d\n", hp.getLastName(), hp.getFirstName(), hp.getID());
            System.out.printf("	Time Registered:  %s\n", hp.getTimeRegistered());
            System.out.println("	Classes:");
            for (int i = 0; i < hp.getNumCourses(); i++) { // for students who registered for more than one class
                String courseNumber = hp.getCourses()[i].getCourseNumber();
                String courseDays = hp.getCourses()[i].getCourseDays();
                String courseTime = hp.getCourses()[i].getCourseTime();
                System.out.printf("\t| %-8s | %-5s | %-19s |%n", courseNumber, courseDays, courseTime); 
            }
            hp = hp.getNext();
        }
        System.out.println("\n");
    }

    //
    // void | PrintList()
    //
//	public void ModifyAllNodes() {
//		ModifyAllNodes(head);
//	}
//	//
//	// void | PrintList(LLnode)
//	//
//	private void ModifyAllNodes(CSstudent head) {
//		// We need to traverse...so we need a help ptr
//		CSstudent helpPtr = head;
//		// Traverse to correct insertion point
//		while (helpPtr != null) {
//			// We add 10 to the data value of each node
//			helpPtr.setData(helpPtr.getData() + 10);
//			// Step one node over
//			helpPtr = helpPtr.getNext();
//		}
//	}
    //
    // int | sumNodes()
    //
//	public int sumNodes() {
//		return sumNodes(head);
//	}
//	//
//	// int | sumNodes(BSTnode)
//	//
//	private int sumNodes(CSstudent head) {
//		// We need to traverse...so we need a help ptr
//		CSstudent helpPtr = head;
//		int sum = 0; // counter
//		// Traverse to correct insertion point
//		while (helpPtr != null) {
//			// Increase sum
//			sum += helpPtr.getData();
//			// Step one node over
//			helpPtr = helpPtr.getNext();
//		}
//		return sum;
//	}
    //
    // void | insert(int)
    //
    public void insert(CSstudent student) {
        head = insert(head, student);
    }
    //
    // LLnode | insert(LLnode, value)
    //

    private CSstudent insert(CSstudent head, CSstudent student) {
        // IF there is no list, newNode will be the first node, so just return it
        if (head == null) {
            student.setNext(head);
            return student;
           
        }
        else if (CSstudent.compareTo(student, head) < 0) {
            student.setNext(head);
            head = student;
            return head;
        }// ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            CSstudent helpPtr = head;
            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) {
                if (CSstudent.compareTo(student, helpPtr.getNext()) < 0) {
                    break; // we found our spot and should break out of the while loop
                }
                helpPtr = helpPtr.getNext();
            }
            // Now make the new node. Set its next to point to the successor node.
            // And then make the predecessor node point to the new node
            student.setNext(helpPtr.getNext());
            helpPtr.setNext(student);
        }
        // Return head
        return head;
    }

//	//
//	// void | delete(int)
//	//
//	public void delete(int data) {
//		head = delete(head, data);
//	}
//	//
//	// LLnode | delete(LLnode, value)
//	//
//	private CSstudent delete(CSstudent head, int data) {
//		// We can only delete if the list has nodes (is not empty)
//		if (!isEmpty()) {
//			// IF the first node (at the head) has the data value we are wanting to delete
//			// we found it. Delete by skipping the node and making head point to the next node.
//			if (head.getData() == data) {
//				head = head.getNext();
//			}
//			// ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
//			else {
//				// We need to traverse to find the data we want to delete...so we need a help ptr
//				CSstudent helpPtr = head;
//				// Traverse to correct deletion point
//				while (helpPtr.getNext() != null) {
//					if (helpPtr.getNext().getData() == data) {
//						helpPtr.setNext(helpPtr.getNext().getNext());
//						break; // we deleted the value and should break out of the while loop
//					}
//					helpPtr = helpPtr.getNext();
//				}
//			}
//			// return the possibly updated head of the list
//			return head;
//		}
//		return head;
//	}
}
