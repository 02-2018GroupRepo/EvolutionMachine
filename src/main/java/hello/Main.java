package hello;


import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        Product kitkat = new Product("KitKat", 1, 1.50, 0.90, "Candy");
        Product twix = new Product("Twix", 2, 1.70, 1.20, "Candy");

        Machine vendingMachine = new Machine();
        vendingMachine.addItemToMachine(kitkat, "C6", 6);
       //vendingMachine.addItemToMachine(twix, "A2", 6);

//        vendingMachine.removeItem();
//
//        vendingMachine.viewCoinCart();
//        vendingMachine.getSizeOfCompt("A1");
//        vendingMachine.getSizeOfCompt("A2");

        Scanner scan = new Scanner(System.in);
        CoinManager coinManager = new CoinManager();

        boolean switchOut = true;

        while(switchOut) {

        System.out.println("\nEnter numbers 1 - 4 for the coin that you would like to insert");
        System.out.printf("You currently have $%.2f inserted%n", coinManager.customerTotalInputAmount());
        System.out.println("1: Quarter \n2: Dime \n3: Nickle \n4: I'm done entering coins. Product please!");

        int userInput = scan.nextInt();
        switch(userInput) {

            case 1:

                coinManager.addCustomerCoins("quarter");
                break;

            case 2:

                coinManager.addCustomerCoins("dime");
                break;

            case 3:

                coinManager.addCustomerCoins("nickel");
                break;

            case 4:

                switchOut = false;
                break;

            default:

                System.out.println("Seriously? It's just four choices");

        }
            System.out.printf("You currently have $%.2f inserted%n", coinManager.customerTotalInputAmount());
            //TODO: Select product method

            /**
             * use this method to confirm that the customer has enough for product
             * coinManager.hasEnoughForProduct(Product product)
             *
             * if true, when the product is dispensed, use this method to add customer coins to coin manager
             * coinManager.addCustomerCoinToCM()
             */
            //TODO: If false, return customer coins method

        }



    }
}
