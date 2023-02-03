// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757
public class MocMartProduct {

    // data members
    private int itemNum;
    private String itemName;
    private double itemPrice;
    private int quantity;
    private int restockQuantity;
    private static int numProducts;
    
    // constructors
    public MocMartProduct(int itemNum, String itemName, double itemPrice, int quantity, int restockQuantity) {
        this.itemNum = itemNum;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.restockQuantity = restockQuantity;
    }
    
    
    // getters
    public int getItemNum() {
        return itemNum;
    }
    public String getItemName() {
        return itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getRestockQuantity() {
        return restockQuantity;
    }
    public static int getNumProducts() {
        return numProducts;
    }
    
    // setters
    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setRestockQuantity(int restockQuantity) {
        this.restockQuantity = restockQuantity;
    }
    public static void setNumProducts(int numProducts) {
        MocMartProduct.numProducts = numProducts;
    }   
}