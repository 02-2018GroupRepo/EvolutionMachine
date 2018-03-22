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

        if(totalAmountOfChange == 0){
            return "Exact amount of coin entered";
        }

        customerChangeQuarterAmount = (int) (coin / .25); //the number of quarters
        amount = (coin % .25);
        amount = Double.parseDouble(df.format(amount));

        if (customerChangeQuarterAmount <= machineQuarterCount){
            // the number of quarters needed in change is available. machine quarter count is subtracted by customer quarter count
            machineCoinCounts.removeQuatersFromCM(customerChangeQuarterAmount);
        }else {
            double excessQuarterAmount = customerChangeQuarterAmount - machineQuarterCount;
            customerChangeQuarterAmount = machineQuarterCount;
            machineCoinCounts.removeQuatersFromCM(machineQuarterCount);
            amount = amount + (excessQuarterAmount * 0.25);
        }


        customerChangeDimeAmount = (int) (amount / .10);
        amount = amount % .10;
        amount = Double.parseDouble(df.format(amount));

        if (customerChangeDimeAmount <= machineDimeCount){
            // the number of Dimes needed in change is available. machine dime count is subtracted by customer dime count
            machineCoinCounts.removeDimesFromCM(customerChangeDimeAmount);
        }else {
            double excessDimeAmount = customerChangeDimeAmount - machineDimeCount;
            customerChangeDimeAmount = machineDimeCount;
            machineCoinCounts.removeDimesFromCM(machineDimeCount);
            amount = amount + (excessDimeAmount * 0.10);
        }

        customerChangeNickelAmount = (int) (amount / .05);
        amount = amount % .05;
        amount = Double.parseDouble(df.format(amount));

        if (customerChangeNickelAmount <= machineNickelCount){
            // the number of nickles needed in change is available. machine nickel count is subtracted by customer nickek count
            machineCoinCounts.removeNickelsFromCM(customerChangeNickelAmount);

        }else {
            double excessNickelAmount = customerChangeNickelAmount - machineNickelCount;
            customerChangeNickelAmount = machineNickelCount;
            machineCoinCounts.removeNickelsFromCM(machineNickelCount);
            amount = amount + (excessNickelAmount * 0.05);
        }

        String returnChangeInCoinCount = "Your change is: " + "\n" + "Quarters: " + customerChangeQuarterAmount
                                                            + "\n" + "Dimes: " + customerChangeDimeAmount
                                                            + "\n" + "Nickels: " + customerChangeNickelAmount;

        return returnChangeInCoinCount;
    }

    //Return Less Than Change Scenario
    public String returnExactChangeInserted(){
       int customerReturnQuarterAmount = 4;
//               machineCoinCounts.getCustomerQuarter();
       int customerReturnDimeAmount = 0;
//               machineCoinCounts.getCustomerDime();
       int customerReturnNickelAmount = 0;
//               machineCoinCounts.getCustomerNickel();

       String returnCustomerCoinCount = "Not Enough Coins." + "\n" + "Quarters: " + customerReturnQuarterAmount
               + "\n" + "Dimes: " + customerReturnDimeAmount
               + "\n" + "Nickels: " + customerReturnNickelAmount;

       return returnCustomerCoinCount;

    }


}
