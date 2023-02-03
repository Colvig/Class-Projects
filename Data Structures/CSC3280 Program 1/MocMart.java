// Name: Haley Cahoon
// Email: haleyanncahoon@gmail.com
// Course Number: CSC3280-002
// Title: MocMart
// Date: 08/26/2022
// Student ID: 1259757
// FSC Honor Code: I will practice academic and personal integrity and
// excellence of character and expect the same from others.

import java.util.*; // importing everything needed for this program

public class MocMart {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // variables used to create array sizes
        int maxProducts = in.nextInt();
        int maxSales = in.nextInt();
        // arrays to store  products and sales
        MocMartProduct[] products = new MocMartProduct[maxProducts];
        MocMartSale[] sales = new MocMartSale[maxSales];

        // determining what command the user is imputting
        while (true) {
            String userChoice = in.next(); // input for command
            if (userChoice.equals("ADDITEM")) {
                additem(products, sales, in);
            } else if (userChoice.equals("FINDITEM")) {
                finditem(products, sales, in);
            } else if (userChoice.equals("RESTOCK")) {
                restock(products, sales, in);
            } else if (userChoice.equals("CUSTOMER")) {
                customer(products, sales, in);
            } else if (userChoice.equals("INVENTORY")) {
                inventory(products, sales, in);
            } else if (userChoice.equals("PRINTSALESSUMMARY")) {
                printSalesSummary(products, sales, in);
            } else if (userChoice.equals("QUIT")) {
                quit();
            }
        }
    }

    // method for adding items to the store
    public static void additem(MocMartProduct[] products, MocMartSale[] sales, Scanner in) {
        // taking in input for the product that needs to be added to the store
        int itemNum = in.nextInt();
        String itemName = in.next();
        double userPrice = in.nextDouble();
        int stockQty = in.nextInt();
        int restockQty = in.nextInt();

        // The remaining half of this method is determining where to place this new product
        // based off of their item number
        MocMartProduct product = new MocMartProduct(itemNum, itemName, userPrice, stockQty, restockQty);
        products[MocMartProduct.getNumProducts()] = product;
        MocMartProduct.setNumProducts(MocMartProduct.getNumProducts() + 1);

        // This array holds all of the product numbers for sorting
        int[] proNo = new int[MocMartProduct.getNumProducts()];

        // Putting the products item numbers into the proNo array
        for (int i = 0; i < MocMartProduct.getNumProducts(); i++) {
            proNo[i] = products[i].getItemNum();
        }

        // sorting the item numbers
        Arrays.sort(proNo);

        // Creating a temp array to match with the sorted product numbers
        MocMartProduct[] temp = new MocMartProduct[MocMartProduct.getNumProducts()];

        // Matching the product item number with the sorted numbers from proNo 
        // aray and then saving the product object into the temp array
        for (int i = 0; i < MocMartProduct.getNumProducts(); i++) {
            for (int j = 0; j < MocMartProduct.getNumProducts(); j++) {
                if (proNo[i] == products[j].getItemNum()) {
                    temp[i] = products[j];
                }

            }
        }

        // Copying the temp array into the competitor array
        System.arraycopy(temp, 0, products, 0, MocMartProduct.getNumProducts());
        System.out.println("ADDITEM:");
        System.out.printf("	Item %d, %s, with a cost of $%.2f and initial stock of %d, has been added to the product database.\n",
                product.getItemNum(), product.getItemName(), product.getItemPrice(), stockQty);
        System.out.println("");
    }

    // this method scans an item number to search for a matching product. If found the products
    // details are printed, and if there is no matching item number an appropriate output is printed
    public static void finditem(MocMartProduct[] products, MocMartSale[] sales, Scanner in) {
        // taking input and creating variables for binary search
        int itemNum = in.nextInt();
        int mid = -1;
        int high = MocMartProduct.getNumProducts() - 1;
        int low = 0;
        String indexViewed = ""; // indicies viewed

        // print statement for if there is are products in the store
        if (MocMartProduct.getNumProducts() == 0) {
            System.out.println("FINDITEM:");
            System.out.println("	Cannot perform command; there are no items in the product database.\n");
            return;
        }
        // looping through all of the item numbers for a match using binary search
        while (low <= high) {
            mid = (high + low) / 2;
            if (itemNum == products[mid].getItemNum()) {
                indexViewed += (" " + mid);
                // variable to keep track of units sold
                int total = 0;
                // loop for getting total number of units sold
                for (int i = 0; i < MocMartSale.getNumSales(); i++) {
                    for (int j = 0; j < sales[i].getPurchasedItemNumber().length; j++) {
                        if (sales[i].getPurchasedItemNumber()[j] == itemNum) {
                            total += sales[i].getPurchasedItemQuantity()[j];
                        }
                    }
                }
                // printing the found item along with all its info
                System.out.println("FINDITEM:");
                System.out.printf("	Performing Binary Search...(Indices viewed:%s )\n", indexViewed);
                System.out.printf("	Item #%d (%s)\n", products[mid].getItemNum(), products[mid].getItemName());
                System.out.printf("	Price            :  $%.2f\n", products[mid].getItemPrice());
                System.out.printf("	Current Quantity :  %d\n", products[mid].getQuantity());
                System.out.printf("	Units Sold       :  %d\n", total);
                System.out.printf("	Total Amount     :  $%.2f\n", products[mid].getItemPrice() * total);
                System.out.println("");
                return;
                
            } else if (itemNum < products[mid].getItemNum()) {
                indexViewed += (" " + mid);
                high = mid - 1;
            } else {
                indexViewed += (" " + mid);
                low = mid + 1;
            }
        }

        // print statement for if item is not found
        System.out.println("FINDITEM:");
        System.out.printf("	Performing Binary Search...(Indices viewed:%s )\n", indexViewed);
        System.out.printf("	Item #%d was not found in the product database.\n", itemNum);
        System.out.println("");
    }

    // this method is used to restock products that have a stock of 0
    public static void restock(MocMartProduct[] products, MocMartSale[] sales, Scanner in) {
        System.out.println("RESTOCK:");
        // print statement for if there are no products in store
        
        // loopiong through items that need to be restocked (have 0 stock) and then restocking them along with 
        // printing what was restocked
        boolean didRestock = false;
        for (int i = 0; i < MocMartProduct.getNumProducts(); i++) {
            if (products[i].getQuantity() == 0) {
                products[i].setQuantity(products[i].getRestockQuantity());
                System.out.printf("	Item %d, %s, restocked to a quantity of %d.\n",
                        products[i].getItemNum(), products[i].getItemName(), products[i].getRestockQuantity());
                didRestock = true;
            }
        }
        // print statement for if a restock did not happen 
        if (!didRestock) {
            System.out.println("	There are no items to restock.\n");
            return;
        }
        System.out.println("");

    }

    // this method is for customers that want to make a purchase. It takes in the item number and
    // how much of that item is wanted. Then the store is adjusted based off of the purchase
    public static void customer(MocMartProduct[] products, MocMartSale[] sales, Scanner in) {
        // taking in the customers first and last name
        String firstName = in.next();
        String lastName = in.next();
        int n = in.nextInt(); // number of lines to come
        int purchasedItemNumber[] = new int[n / 2]; // item number of the product customer wants
        int purchasedItemQuantity[] = new int[n / 2]; // quantity of the item the customer wants
        boolean hasMadePurchase = false;
        // output for if the customer came to make purchses but there are 0 items in the store
        if (MocMartProduct.getNumProducts() == 0) {
            System.out.println("CUSTOMER:");
            System.out.printf("	Customer %s %s came and made no purchases.\n", firstName, lastName);
            System.out.println("");
            return;
        }
        MocMartSale newSale = new MocMartSale(firstName, lastName, purchasedItemNumber, purchasedItemQuantity);
        // looping over n to see how many items the customer wants to purchase along with the quantity of each item wanted
        for (int i = 0; i < n / 2; i++) {
            // taking input for the item and quantity the customer wants
            int itemNumber = in.nextInt();
            int quantityToBuy = in.nextInt();

            // using binary search to locate product in array
            int mid = -1;
            int high = MocMartProduct.getNumProducts() - 1;
            int low = 0;
            while (low <= high) {
                mid = (high + low) / 2;
                if (itemNumber == products[mid].getItemNum()) {
                    break;
                } else if (itemNumber < products[mid].getItemNum()) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // multiple if/elses to check all scenerios of a customer wanting a product and if we have
            // more/less than they want or if the product is not in stock. The stock also gets adjusted in here 
            // based off of what the customer buys
            if (itemNumber == products[mid].getItemNum()) {
                if (products[mid].getQuantity() == 0) {
                    if (hasMadePurchase) {
                        newSale.getPurchasedItemNumber()[i] = itemNumber;
                        newSale.getPurchasedItemQuantity()[i] = 0;
                    }
                } else if (products[mid].getQuantity() >= quantityToBuy) {
                    if (hasMadePurchase) {
                        newSale.getPurchasedItemNumber()[i] = itemNumber;
                        newSale.getPurchasedItemQuantity()[i] = quantityToBuy;
                        newSale.setTotalItemsPurchased(newSale.getTotalItemsPurchased() + quantityToBuy);
                        products[mid].setQuantity(products[mid].getQuantity() - quantityToBuy);
                    } else {
                        newSale.setFirstName(firstName);
                        newSale.setLastName(lastName);
                        newSale.getPurchasedItemNumber()[i] = itemNumber;
                        newSale.getPurchasedItemQuantity()[i] = quantityToBuy;
                        newSale.setTotalItemsPurchased(newSale.getTotalItemsPurchased() + quantityToBuy);
                        products[mid].setQuantity(products[mid].getQuantity() - quantityToBuy);

                        hasMadePurchase = true;
                    }
                } else {
                    if (hasMadePurchase) {
                        newSale.getPurchasedItemNumber()[i] = itemNumber;
                        newSale.getPurchasedItemQuantity()[i] = products[mid].getQuantity();
                        newSale.setTotalItemsPurchased(newSale.getTotalItemsPurchased() + products[mid].getQuantity());
                        products[mid].setQuantity(0);

                    } else {
                        newSale.setFirstName(firstName);
                        newSale.setLastName(lastName);
                        newSale.getPurchasedItemNumber()[i] = itemNumber;
                        newSale.getPurchasedItemQuantity()[i] = products[mid].getQuantity();
                        newSale.setTotalItemsPurchased(newSale.getTotalItemsPurchased() + products[mid].getQuantity());
                        products[mid].setQuantity(0);
                        hasMadePurchase = true;
                    }
                }
            } else {
                if (hasMadePurchase) {
                    newSale.getPurchasedItemNumber()[i] = itemNumber;
                    newSale.getPurchasedItemQuantity()[i] = 0;
                }
            }
        }
        if (hasMadePurchase) { // if a purchase took place
            // add newSale to the sales[] array
            sales[MocMartSale.getNumSales()] = newSale;
            MocMartSale.setNumSales(MocMartSale.getNumSales() + 1);
            System.out.println("CUSTOMER:");
            System.out.printf("	Customer %s %s came and made some purchases.\n", firstName, lastName);
            System.out.println("");
        } else { // if no purchase happened 
            System.out.println("CUSTOMER:");
            System.out.printf("	Customer %s %s came and made no purchases.\n", firstName, lastName);
            System.out.println("");
        }
    }

    // this method will show the current inventory of each item in the store
    public static void inventory(MocMartProduct[] products, MocMartSale[] sales, Scanner in) {
        // checking if there are products to display
        if (MocMartProduct.getNumProducts() == 0) { // if there is no product
            System.out.println("INVENTORY:");
            System.out.println("	Contains no items.\n");
            return;
        } else { // if there is product
            System.out.println("INVENTORY:");
            System.out.println("	Contains the following items:");
            for (int i = 0; i < MocMartProduct.getNumProducts(); i++) { // looping over all products to print
                System.out.printf("\t| Item %6d | %-20s | $%7.2f | %4d unit(s) |%n",
                        products[i].getItemNum(), products[i].getItemName(), products[i].getItemPrice(), products[i].getQuantity());
            }
            System.out.println("");
        }
        return;
    }

    // this method prints a sales summary including the customer, which items they purchsed and how many,
    // along with total number of purcheses, and the total they spent. There is then a grandtotal for all 
    // customer purchases
    public static void printSalesSummary(MocMartProduct[] products, MocMartSale[] sales, Scanner in) {
        // checking if there are products to display
        if (MocMartSale.getNumSales() == 0) {
            // output for if no product was sold
            System.out.println("PRINTSALESSUMMARY:");
            System.out.println("Moc Mart Sales Report:");
            System.out.println("	Grand Total: $0.00\n");
        } else {
            // output for if product was sold
            System.out.println("PRINTSALESSUMMARY:");
            System.out.println("Moc Mart Sales Report:");

            double grandTotal = 0; // variable to store grand total
            for (int i = 0; i < MocMartSale.getNumSales(); i++) { // looping over all sales
                System.out.printf("\tSale #%d, %s %s purchased %d item(s):\n",
                        i + 1, sales[i].getFirstName(), sales[i].getLastName(), sales[i].getTotalItemsPurchased());
                double totalSpent = 0;
                for (int j = 0; j < sales[i].getPurchasedItemNumber().length; j++) { // looping over each individual sale
                    // getting item number from the sales array
                    int itemNumber = sales[i].getPurchasedItemNumber()[j];
                    // using binary search to locate product in array
                    int mid = -1;
                    int high = MocMartProduct.getNumProducts() - 1;
                    int low = 0;
                    while (low <= high) {
                        mid = (high + low) / 2;
                        if (itemNumber == products[mid].getItemNum()) {
                            break;
                        } else if (itemNumber < products[mid].getItemNum()) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                    // rest of the output for it products were sold after it was located with binary search
                    if (sales[i].getPurchasedItemQuantity()[j] != 0) {
                        System.out.printf("\t\t| Item %6d | %-20s | $%7.2f (x%4d) |%n",
                                sales[i].getPurchasedItemNumber()[j], products[mid].getItemName(),
                                products[mid].getItemPrice(), sales[i].getPurchasedItemQuantity()[j]);
                        totalSpent += (products[mid].getItemPrice() * sales[i].getPurchasedItemQuantity()[j]);
                    }

                } 
                // calculating total spent for each individual customer
                grandTotal += totalSpent;
                System.out.printf("\t\tTotal: $%.2f\n", totalSpent);

            }
            // calculating the grand total for all customers combined
            System.out.printf("\tGrand Total: $%.2f\n", grandTotal);
            System.out.println("");
        }
    }

    // this method quits the program 
    public static void quit() {
        // output for quitting the program
        System.out.println("Goodbye.\n");
        System.exit(0); // exits program
    }
}