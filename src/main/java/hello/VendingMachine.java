package hello;

public class VendingMachine extends Machine {

    public double returnChange(double totalAmountInsertedByCustomer, double productPrice){
        return totalAmountInsertedByCustomer - productPrice;
    }
}
