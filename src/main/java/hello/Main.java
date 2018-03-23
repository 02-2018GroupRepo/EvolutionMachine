package hello;


public class Main {

    public static void main (String [] args) {



        Product kitkat = new Product("KitKat", 1, 1.50, 0.90, "Candy");
        Product twix = new Product("Twix", 2, 1.70, 1.20, "Candy");

        DrinkMachine drinkMachine = new DrinkMachine();
        drinkMachine.displayCompanyName();
        drinkMachine.addItemToMachine(kitkat, "C6", 6);
        drinkMachine.addItemToMachine(twix, "A2", 6);

//        List<String> inventoryList = new ArrayList<>();
//        inventoryList.add("A2 = Twix");
//        inventoryList.add("C6 = Kitkat");


        drinkMachine.removeItem();

        drinkMachine.viewCoinCart();
        drinkMachine.getSizeOfCompt("A1");
        drinkMachine.getSizeOfCompt("A2");


            //System.out.printf("You currently have $%.2f inserted%n", coinManager.customerTotalInputAmount());
//            System.out.println("Please select a Product");
//            for(String item : inventoryList){
//                System.out.println(item);

            

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
