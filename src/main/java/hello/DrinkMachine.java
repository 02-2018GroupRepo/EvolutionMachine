package hello;
import java.util.*;

/**
 * This is the drink machine which has first 3 shelves with 6 compartments with size of 12, and
 * it also has two more shelves with 5 compartments with the size of 8
 * Valid indices are from A1 to A6, B1 to B6, C1 to C6, D1 to D5, E1 to E5
 */
public class DrinkMachine {



//        String company = "Thank you for using The Evolution Machine!";
//        System.out.println(company);




    private String name;

    Map<String, Queue<Product>> mapComtProd;

//    Map<Double, Integer> coinCart;
    Scanner input = new Scanner(System.in);

    CoinManager drinkCoinManager;

    public DrinkMachine() {
        drinkCoinManager = new CoinManager();
        mapComtProd = new HashMap<>();
//        coinCart = new HashMap<>();


    }



    public void setName(String name) {
        this.name = name;
    }

    public void addItemToMachine(Product prod, String index, int quanity) {

        char firstChar = index.charAt(0);
        char secondChar = index.charAt(1);
        System.out.println(firstChar);

        if (firstChar >= 70 || secondChar <= 48 || secondChar >= 55) {
            System.out.println("Invalid Index");
        } else {

            if(firstChar >= 68 && secondChar >= 54) {
                System.out.println("Invalid Index");
            } else {

                if (mapComtProd.get(index) == null) {
                    Queue<Product> queProd = new LinkedList<>();
                    if (firstChar == 'A' || firstChar == 'B' || firstChar == 'C') {
                        if (quanity <= 12) {
                            for (int i = 0; i < quanity; i++) {
                                queProd.add(prod);
                            }
                            mapComtProd.put(index, queProd);
                        } else {
                            System.out.println("The size of the compartment is 12");
                        }
                    } else {
                        if (quanity <= 8) {
                            for (int i = 0; i < quanity; i++) {
                                queProd.add(prod);
                            }
                            mapComtProd.put(index, queProd);
                        } else {
                            System.out.println("The size of the compartment is 8");
                        }
                    }
                } else {
                    Queue<Product> queOfProd = mapComtProd.get(index);
                    Product item = queOfProd.peek();

                    if (item.getUniqueId() == prod.getUniqueId()) {

                        if (firstChar == 'A' || firstChar == 'B' || firstChar == 'C') {
                            if (quanity <= (12 - mapComtProd.get(index).size())) {
                                for (int i = 0; i < quanity; i++) {
                                    queOfProd.add(prod);
                                }
                            } else {
                                System.out.println("The compartment has " + mapComtProd.get(index).size() + "  items and total space is 12");
                            }
                        } else {
                            if (quanity <= (8 - mapComtProd.get(index).size())) {
                                for (int i = 0; i < quanity; i++) {
                                    queOfProd.add(prod);
                                }
                            } else {
                                System.out.println("The compartment has " + mapComtProd.get(index).size() + " items and total space is 8");
                            }
                        }
                    } else {
                        System.out.println("Other product exist in the compartment");
                    }
                }
            }
        }
    }

    public void removeItem () {

        System.out.println("Please enter the index");
        String index = input.next();


        if(mapComtProd.get(index) == null || mapComtProd.get(index).size() == 0) {
            System.out.println("The compartment is empty");
        } else  {
            Queue<Product> queueOfProduct = mapComtProd.get(index);
            drinkCoinManager.insertCoins();
            double totalCustomer = drinkCoinManager.customerTotalInputAmount();
            double productSelectedPrice = queueOfProduct.peek().getRetailPrice();
            double totalAmountOfChange = drinkCoinManager.getChangeInDollarAmount(totalCustomer,productSelectedPrice);

            boolean totalIsGreaterThenPrice = drinkCoinManager.hasEnoughForProduct(queueOfProduct.peek());

            if(totalIsGreaterThenPrice == true) {
                String change = drinkCoinManager.returnChangeInCoinCount(totalAmountOfChange);
                drinkCoinManager.addCustomerCoinsToCM();

                queueOfProduct.remove();
                mapComtProd.put(index,queueOfProduct);
                System.out.println("You have purchased a " +queueOfProduct.peek().getName());
                System.out.println(change);

            } else {
                String change = drinkCoinManager.returnCustomerChangeInserted();
                System.out.println(change);
            }
//
        }
    }

    public void viewItem(String index) {
        if(mapComtProd.get(index) == null || mapComtProd.get(index).size() == 0) {
            System.out.println("The compartment is empty ");
        } else {
            Queue<Product> queProd = mapComtProd.get(index);
            System.out.println("The compartment has following item ");
            System.out.print("{ ");
            for (Product prd : queProd) {
                System.out.print(prd.getName() + " ");
            }
            System.out.print("}");
            System.out.println();
        }
    }

    public void getSizeOfCompt(String index) {
        if(mapComtProd.get(index) == null) {
            System.out.println("The compartment is empty");
        } else {
            System.out.println("The Size of the compartment " + index + " is " + mapComtProd.get(index).size());
        }
    }

//    public void viewCoinCart() {
//        double finalTotal = 0;
//        System.out.println(Collections.singletonList(coinCart));
//        for (Map.Entry<Double, Integer> cn : coinCart.entrySet()) {
//            double total = (cn.getKey() * cn.getValue());
//            finalTotal = total + finalTotal;
//        }
//        finalTotal = Double.parseDouble(String.format("%.2f", finalTotal));
//        System.out.println("Your vending machine has total coins of $" + finalTotal);
//    }
}
