package hello;


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


    }
}
