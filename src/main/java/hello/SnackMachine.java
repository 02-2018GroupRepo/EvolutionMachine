package hello;

import java.util.*;

public class SnackMachine{

    Scanner input = new Scanner(System.in);
    private String name;
    Map<String, Queue<Product>> mapComtProd;
    CoinManager snackCoinManager;

    public SnackMachine() {
        snackCoinManager = new CoinManager();
        mapComtProd = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItemToMachine(Product prod, String index, int quanity) {

        char firstChar = index.charAt(0);
        char secondChar = index.charAt(1);
        System.out.println(firstChar);

        if (firstChar >= 70 || secondChar <= 48 || secondChar >= 54) {
            System.out.println("Invalid Index");
        } else {
            if (mapComtProd.get(index) == null) {
                Queue<Product> queProd = new LinkedList<>();
                if (quanity <= 10) {
                    for (int i = 0; i < quanity; i++) {
                        queProd.add(prod);
                    }
                    mapComtProd.put(index, queProd);
                    } else {
                        System.out.println("The size of the compartment is 10");
                }
            } else {
                Queue<Product> queOfProd = mapComtProd.get(index);
                Product item = queOfProd.peek();

                if (item.getUniqueId() == prod.getUniqueId()) {
                    if (quanity <= (12 - mapComtProd.get(index).size())) {
                        for (int i = 0; i < quanity; i++) {
                            queOfProd.add(prod);
                        }
                    } else {
                        System.out.println("The compartment has " + mapComtProd.get(index).size() + "  items and total space is 12");
                    }
                } else {
                        System.out.println("Other product exist in the compartment");
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
            snackCoinManager.insertCoins();
            double totalCustomer = snackCoinManager.customerTotalInputAmount();
            double productSelectedPrice = queueOfProduct.peek().getRetailPrice();
            double totalAmountOfChange = snackCoinManager.getChangeInDollarAmount(totalCustomer,productSelectedPrice);

            boolean totalIsGreaterThenPrice = snackCoinManager.hasEnoughForProduct(queueOfProduct.peek());

            if(totalIsGreaterThenPrice == true) {
                String change = snackCoinManager.returnChangeInCoinCount(totalAmountOfChange);
                snackCoinManager.addCustomerCoinsToCM();

                queueOfProduct.remove();
                mapComtProd.put(index,queueOfProduct);
                System.out.println("You have purchased a " +queueOfProduct.peek().getName());
                System.out.println("The price of your product is " + queueOfProduct.peek().getRetailPrice());
                System.out.println(change);

            } else {
                String change = snackCoinManager.returnCustomerChangeInserted();
                System.out.println(change);
            }
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

    public void viewCoinCart() {
        double finalTotal = snackCoinManager.getTotalCoinManagerValue();
        finalTotal = Double.parseDouble(String.format("%.2f", finalTotal));
        System.out.println("Your machine has total coins of " + finalTotal);
        System.out.println("Number of Quarters $0.25 = " + snackCoinManager.getCoinCount("quarter") +
                "\nNumber of Dimes $0.10 = " + snackCoinManager.getCoinCount("dime") +
                "\nNumber of Nickles $0.05 = " + snackCoinManager.getCoinCount("nickel"));
    }
}