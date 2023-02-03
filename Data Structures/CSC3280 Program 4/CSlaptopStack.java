// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757

public class CSlaptopStack {
	private int[] stack;
	private int maxSize;
	private int top;
	
	// Constructor
	public CSlaptopStack (int size) {
		maxSize = size;             // set array size
		stack = new int[maxSize];   // create array for stack
		top = -1;                   // set top to -1 (no items in stack yet)
	}
	
	
	//
	// boolean | isFull()
	//
	public boolean isFull () {
		return top == maxSize-1;
	}
	
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return top == -1;
	}
	
	
	//
	// int | pop()
	//
	public int pop() {
		// temporarily save the value at top into "temp"
		int temp = stack[top];
		
		// decrement top
		top--;
		
		// return the value that WAS at the top
		return temp;
	}
	
	
	//
	// int | peek()
	//
	public int peek() {
		return stack[top];
	}
	
	
	//
	// void | push(int)
	//
	public void push(int value) {
		// increment the top pointer
		top++;
		
		// then save the value into stack[top]
		stack[top] = value;
	}
	
	
	//
	// boolean | search(int)
	//
	public boolean search(int value) {
		for(int i=0; i<=top; i++) {
			// if the value is found at stack[i], return true
			if (stack[i] == value)
				return true;
		}
		// If we make it till here, the value was not found in the array.
		return false;
	}
	
	
	//
	// void | PrintStack()
	//
	public void PrintStack() {
		for(int i=0; i<=top; i++) {
			System.out.print(stack[i] + ", ");
		}
		// print a newline
		System.out.println();
	}
	
}