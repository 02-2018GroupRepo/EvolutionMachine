package hello;

public class VendingMachine extends Machine {

    //TODO: add addCustomerCoinsToCM() to dispense item to add customer coins to Coin manager

    public double returnChange(double totalAmountInsertedByCustomer, double productPrice){
        return totalAmountInsertedByCustomer - productPrice;
    }
}
