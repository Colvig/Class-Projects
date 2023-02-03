// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Title: FSCrecurse
// Date: 10/04/2022
// Student ID: 1259757
// FSC Honor Code: I will practice academic and personal integrity and
// excellence of character and expect the same from others.

import java.util.*; // importing everything needed for this program
public class FSCrecurse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // taking in the number of commands
        for (int i = 0; i < n; i++) {
            String command = in.next(); // taking in the command
            // calling methods based off of command
            if (command.equals("MocsMath")) {
                mocsMath(in);
            } else if (command.equals("MocsShape")) {
                mocsShape(in);
            } else if (command.equals("MocsFlip")) {
                mocsFlip(in);
            } else if (command.equals("MocsCompress")) {
                mocsCompressMain(in);
            }
        }
    }
    public static void mocsMath(Scanner in) { 
        System.out.println("MocsMath:");
        // taking input
        int k = in.nextInt();
        int n = in.nextInt();
        System.out.println(sum(k, n));
    }
    // method to add together the fibonacci numbers
    public static int sum(int k, int n) {
        if (n == k) {
            return fib(n);
        } else {
            return fib(n) + sum(k, n - 1);
        }
    }
    // method to calculate fibonacci
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    public static void mocsShape(Scanner in) {
        System.out.println("MocsShape:");
        int n = in.nextInt(); // taking in the max width of the diamond
        top(n, n); // calling the top method
        bottom(1, n); // calling the bottom method
        System.out.println("");
    }
    // method to print the top half of the diamond
    public static void top(int n, int w) {
        if (n <= 0) { // base case when n is 0
            return;
        }
        top(n - 2, w);
        if (n < w) { // handles printing
            for (int i = 0; i < w - n; i++) {
                System.out.print(" ");
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println("");
    }
    // method to print the bottom half of the diamond
    public static void bottom(int n, int w) {
        if (n >= w) { // base case when n > w
            return;
        }
        bottom(n + 2, w);
        if (n < w) { // handles printing
            for (int i = 0; i < w - n; i++) {
                System.out.print(" ");
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println("");
    }
    public static void mocsFlip(Scanner in) {
        System.out.println("MocsFlip:");
        int n = in.nextInt();
        flipper(n, "");
        System.out.println("");
    }
    public static void flipper(int n, String current) {
        if (n == 1) { // base case
            // print for this case
            System.out.print(current + "C");
            System.out.println("");
            System.out.print(current + "S");
            System.out.println("");
        } else {
            // printing for not the base case
            flipper(n - 1, current + "C");
            flipper(n - 1, current + "S");
        }
    }
    // reads in data and calls the recursive method
    public static void mocsCompressMain(Scanner in) {
        int n = in.nextInt();
        int thresh = in.nextInt();
        in.nextLine();     
        // reads the numbers in 
        char[][] image = new char[n][];
        for (int i = 0; i < n; i++) {
            image[i] = in.nextLine().toCharArray();
        }
        // calls the recursive function
        mocsCompress(image, thresh, 0, n - 1, 0, n - 1, n / 2);
    }
    public static void mocsCompress(char[][] image, int thresh, int rowStart, int rowEnd, int colStart, int colEnd, int depth) {
        char result = meetsThresh(image, thresh, rowStart, rowEnd, colStart, colEnd); // saves the result of the meetsThresh
        // if result is 1 or 0 fill that section
        if (result == '1' || result == '0') {
            fillImage(image, rowStart, rowEnd, colStart, colEnd, result);
        } else {
            // calls the method with updated values <-- doesn't work :(
            mocsCompress(image, thresh, rowStart, rowEnd - depth, colStart + depth, colEnd, depth / 2);
            mocsCompress(image, thresh, rowStart, rowEnd - depth, colStart, colEnd - depth, depth / 2);
            mocsCompress(image, thresh, rowStart + depth, rowEnd, colStart, colEnd - depth, depth / 2);
            mocsCompress(image, thresh, rowStart + depth, rowEnd, colStart + depth, colEnd, depth / 2);
        }
    }
    public static char meetsThresh(char[][] image, int thresh, int rowStart, int rowEnd, int colStart, int colEnd) {
        int count1s = 0;
        int count0s = 0;
        // save the number of times 1 and 0 shows up
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (image[i][j] == '1') {
                    count1s++;
                } else {
                    count0s++;
                }
            }
        }
        // calculates the threshhold value
        if (100.0 * count1s / ((rowEnd - rowStart) * colEnd - colStart) >= thresh) {
            return '1';
        } else if (100.0 * count0s / ((rowEnd - rowStart) * colEnd - colStart) >= thresh) {
            return '0';
        } else {
            return '9';
        }
    }
    // fills the image with 1s or 0s depending on the result
    public static void fillImage(char[][] image, int rowStart, int rowEnd, int colStart, int colEnd, char result) {
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                image[i][j] = result;
            }
        }
    }
}