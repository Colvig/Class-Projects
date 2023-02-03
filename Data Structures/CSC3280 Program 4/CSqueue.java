// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757

public class CSqueue {
    // top: reference variable to the top of the stack (same as "head" of linked list)

    private CSstudent front;
    private CSstudent back;

    // CONSTRUCTOR
    public CSqueue() {
        front = null;
        back = null;
    }

    /* Below are MANY methods that are used on stacks.
	 * 
	 * Examples:
	 * isEmpty, PUSH, POP, PEEK, and more.
     */
    //
    // boolean | isEmpty()
    //
    public boolean isEmpty() {
        return front == null;
    }

    //
    // void | PrintQueue()
    //
    public void PrintQueue() {
        PrintQueue(front);
    }
    //
    // void | PrintQueue(QueueNode)
    //

    private void PrintQueue(CSstudent front) {
        // We need to traverse...so we need a help ptr
        CSstudent helpPtr = front;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Print the data value of the node
            System.out.print(helpPtr.getLastName() + ", ");
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }
    //
    // boolean | search(int)
    //
//	public boolean search(int data) {
//		return search(front, data);
//	}
//	//
//	// boolean | search(QueueNode, int)
//	//
//	private boolean search(CSstudent p, int data) {
//		// To search, we must traverse. Therefore, we need helpPtr.
//		CSstudent helpPtr = p;
//		while (helpPtr != null) {
//			if (helpPtr.getData() == data)
//				return true;
//			helpPtr = helpPtr.getNext(); // step one node over		
//		}
//		return false;
//	}
    //
    // void | enqueue(int)
    //
    public void enqueue(CSstudent data) {
        if (isEmpty()) {
            front = back = enqueue(front, back, data);
        } else {
            back = enqueue(front, back, data);
        }

    }
    //
    // QueueNode | enqueue(QueueNode, QueueNode, int)
    //

    private CSstudent enqueue(CSstudent front, CSstudent back, CSstudent data) {
        // Make a new QueueNode with "data" as the data value
        CSstudent temp = data;

        // Now, if the list is empty, return the reference for temp
        // and save this reference into both "front" and "back"
        // Why? Since this is the only node in the queue, it will be the front and back node
        if (isEmpty()) {
            return temp;
        } // ELSE, the queue is not empty. We need to insert temp at the back of the queue.
        // So save the address of the new node into the next of back.
        // Then, make back "traverse" one node over, so it now points to the new back node.
        // Finally, return the updated address of back.
        else {
            //temp.setNext(back.getNext());
            back.setNext(temp);
            back = temp;
            temp.setNext(null);
            return back;
        }
    }

    //
    // QueueNode | dequeue()
    //
    public CSstudent dequeue() {
        CSstudent temp = front;
        front = front.getNext();
        if (front == null) {
            back = null;
        }
        temp.setNext(null);
        return temp;
    }
    //
    // QueueNode | dequeue(QueueNode)
    //

//    private CSstudent dequeue(CSstudent front) {
//        front = front.getNext();
//        return front;
//    }

    //
    // int | peek()
    //
    public CSstudent peek() {
        // Invoke the peek method with front as a parameter
        CSstudent frontValue = peek(front);

        // return topValue
        return frontValue;
    }
    //
    // int | peek(QueueNode)
    //

    private CSstudent peek(CSstudent front) {
        // Return the data value of the front node.
        // You can see that we do NOT dequeue. We are only returning the data value.
        return front;
    }

    public void countDown() {
        //We need to traverse...so we need a help ptr
        CSstudent helpPtr = front;
        
        // Traverse the queue
        while (helpPtr != null) {
            // lower each value
            helpPtr.setTimeRemaining(helpPtr.getTimeRemaining() - 1);
            helpPtr = helpPtr.getNext();
        }
    }
}
