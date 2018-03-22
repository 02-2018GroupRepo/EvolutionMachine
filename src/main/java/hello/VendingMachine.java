package hello;

import java.text.DecimalFormat;

public class VendingMachine extends Machine {

    //TODO: add addCustomerCoinsToCM() to dispense item to add customer coins to Coin manager

    CoinManager machineCoinCounts = new CoinManager();

    public double getChangeInDollarAmount(double totalAmountInsertedByCustomer, double productPrice){
        double totalAmountOfChange = totalAmountInsertedByCustomer - productPrice;
        return totalAmountOfChange;
    }

    public String returnChangeInCoinCount (double totalAmountOfChange){
        int customerChangeQuarterAmount;
        double amount = 0.00;
        double coin = totalAmountOfChange;
        int customerChangeDimeAmount;
        int customerChangeNickelAmount;
        DecimalFormat df = new DecimalFormat("#.00");

        int machineQuarterCount = 4;
//                machineCoinCounts.getQuarterCount();
        int machineDimeCount = 2;
//                machineCoinCounts.getDimeCount();
        int machineNickelCount = 5;
//                machineCoinCounts.getNickelCount();

        customerChangeQuarterAmount = (int) (coin / .25); //the number of quarters
        amount = (coin % .25);
        amount = Double.parseDouble(df.format(amount));
//        System.out.println("Quater Quantity: " + qAmount + " Left over: " + amount);
        if (customerChangeQuarterAmount <= machineQuarterCount){
            // the number of quarters needed in change is available. machine quarter count is subtracted by customer quarter count
            machineQuarterCount = machineQuarterCount - customerChangeQuarterAmount;
        }else {
            double excessQuarterAmount = customerChangeQuarterAmount - machineQuarterCount;
            customerChangeQuarterAmount = machineQuarterCount;
            machineQuarterCount = machineQuarterCount - customerChangeQuarterAmount;
            amount = amount + (excessQuarterAmount * 0.25);
        }


        customerChangeDimeAmount = (int) (amount / .10);
        amount = amount % .10;
        amount = Double.parseDouble(df.format(amount));
//        System.out.println("Dime Quantity: " + dAmount + " Left over: " + amount);

        if (customerChangeDimeAmount <= machineDimeCount){
            // the number of quarters needed in change is available. machine quarter count is subtracted by customer quarter count
            machineDimeCount = machineDimeCount - customerChangeDimeAmount;
        }else {
            double excessDimeAmount = customerChangeDimeAmount - machineDimeCount;
            customerChangeDimeAmount = machineDimeCount;
            machineDimeCount = machineDimeCount - customerChangeDimeAmount;
            amount = amount + (excessDimeAmount * 0.10);
        }

        customerChangeNickelAmount = (int) (amount / .05);
        amount = amount % .05;
        amount = Double.parseDouble(df.format(amount));
//        System.out.println("Nickle Quantity: " + nAmount + " Left over: " + amount);

        if (customerChangeNickelAmount <= machineNickelCount){
            // the number of quarters needed in change is available. machine quarter count is subtracted by customer quarter count
            machineNickelCount = machineNickelCount - customerChangeNickelAmount;
        }else {
            double excessNickelAmount = customerChangeNickelAmount - machineNickelCount;
            customerChangeNickelAmount = machineNickelCount;
            machineNickelCount = machineNickelCount - customerChangeNickelAmount;
            amount = amount + (excessNickelAmount * 0.05);
        }

        String returnChangeInCoinCount = "Your change is: " + "\n" + "Quarters: " + customerChangeQuarterAmount
                                                            + "\n" + "Dimes: " + customerChangeDimeAmount
                                                            + "\n" + "Nickels: " + customerChangeNickelAmount;

        return returnChangeInCoinCount;
    }
}
