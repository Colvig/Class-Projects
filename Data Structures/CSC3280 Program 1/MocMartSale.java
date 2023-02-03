// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Student ID: 1259757
public class MocMartSale {
        
    // data members
    private String firstName;
    private String lastName;
    private int numItemsOnList;
    private int[] purchasedItemNumber;
    private int[] purchasedItemQuantity;
    private static int numSales;
    private int totalItemsPurchased;

    // constructors
    public MocMartSale(String firstName, String lastName, int[] purchasedItemNumber, int[] purchasedItemQuantity ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.purchasedItemNumber  = purchasedItemNumber;
        this.purchasedItemQuantity = purchasedItemQuantity;
        this.totalItemsPurchased = 0;
    }
    
    // getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getNumItemsOnList() {
        return numItemsOnList;
    }
    public int[] getPurchasedItemNumber () {
        return purchasedItemNumber ;
    }
    public int[] getPurchasedItemQuantity(){
        return purchasedItemQuantity;
    }
    public static int getNumSales() {
        return numSales;
    }
    
    public int getTotalItemsPurchased() {
        return totalItemsPurchased;
    }
    
    
    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setNumItemsOnList(int numItemsOnList) {
        this.numItemsOnList = numItemsOnList;
    }
    public void setPurchasedItemNumber (int[] purchasedItemNumber ) {
        this.purchasedItemNumber  = purchasedItemNumber;
    }
    public void setPurchasedItemQuantity  (int[] purchasedItemQuantity){
        this.purchasedItemQuantity = purchasedItemQuantity;
    }
    public static void setNumSales(int numSales) {
        MocMartSale.numSales = numSales;
    }
    
    public void setTotalItemsPurchased(int totalItemsPurchased) {
        this.totalItemsPurchased = totalItemsPurchased;
    }
}
