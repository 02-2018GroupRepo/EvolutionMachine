package hello;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CoinManager {

    private int nickel = 30;
    private int dime = 30;
    private int quarter = 30;
    private int customerNickel = 0;
    private int customerDime = 0;
    private int customerQuarter = 0;

    Scanner scan = new Scanner(System.in);


    public int getNickel() {
        return nickel;
    }

    public int getDime() {
        return dime;
    }

    public int getQuarter() {
        return quarter;
    }

    public int getCustomerNickel() {
        return customerNickel;
    }

    public int getCustomerDime() {
        return customerDime;
    }

    public int getCustomerQuarter() {
        return customerQuarter;
    }

    public void addCustomerCoins(String coin) {
        if (coin.equals("quarter")) {
            customerQuarter++;
        } else if (coin.equals("dime")) {
            customerDime++;
        } else if (coin.equals("nickel")) {
            customerNickel++;
        } else {
            System.out.println("Why would you do that? Use nickel, dime, quarter!!");
        }
    }


    public double customerTotalInputAmount() {
        double customerQuarterValue = customerQuarter * 0.25;
        double customerDimeValue = customerDime * 0.10;
        double customerNickelValue = customerNickel * 0.05;

        return customerDimeValue + customerNickelValue + customerQuarterValue;
    }

    public boolean hasEnoughForProduct(Product product) {
        boolean confirmed = false;

        if (customerTotalInputAmount() >= product.getRetailPrice()) {
            confirmed = true;
        }

        return confirmed;
    }

    public void displayCustomerTotal() {

        System.out.println(customerTotalInputAmount());
    }

    public void addCustomerCoinsToCM() {
        nickel += customerNickel;
        customerNickel = 0;
        dime += customerDime;
        customerDime = 0;
        quarter += customerQuarter;
        customerQuarter = 0;
    }

    public void removeQuatersFromCM(int machineQuarterCount) {
        quarter = quarter - machineQuarterCount;
    }

    public void removeDimesFromCM(int machineDimeCount) {
        this.dime = dime - machineDimeCount;
    }

    public void removeNickelsFromCM(int machineNickelCount) {
        this.nickel = nickel - machineNickelCount;
    }

    public int getCoinCount(String coin) {
        int coinCount = 0;
        if (coin.equals("quarter")) {
            coinCount = quarter;
        } else if (coin.equals("dime")) {
            coinCount = dime;
        } else if (coin.equals(("nickel"))) {
            coinCount = nickel;
        } else {
            System.out.println("NO NO NOOOOOOO, you better use nickel, dime, quarter");
        }

        return coinCount;
    }


    public double getTotalCoinValue(String coin) {
        double totalCoinValue = 0;
        if (coin.equals("quarter")) {
            totalCoinValue = getCoinCount("quarter") * 0.25;
        } else if (coin.equals("dime")) {
            totalCoinValue = getCoinCount("dime") * 0.10;
        } else {
            totalCoinValue = getCoinCount("nickel") * 0.05;
        }

        return totalCoinValue;

    }

    public double getTotalCoinManagerValue() {
        double valueForQuarter = getTotalCoinValue("quarter");
        double valueForDime = getTotalCoinValue("dime");
        double valueForNickel = getTotalCoinValue("nickel");

        return valueForDime + valueForNickel + valueForQuarter;
    }

    public void insertCoins() {
        boolean switchOut = true;

        while (switchOut) {

            System.out.println("\nEnter numbers 1 - 4 for the coin that you would like to insert");
            System.out.printf("You currently have $%.2f inserted%n", customerTotalInputAmount());
            System.out.println("1: Quarter \n2: Dime \n3: Nickle \n4: I'm done entering coins. Product please!");

            int userInput = scan.nextInt();
            switch (userInput) {

                case 1:

                    addCustomerCoins("quarter");
                    break;

                case 2:

                    addCustomerCoins("dime");
                    break;

                case 3:

                    addCustomerCoins("nickel");
                    break;

                case 4:

                    switchOut = false;
                    break;

                default:

                    System.out.println("Seriously? It's just four choices");

            }

        }
    }
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

        int machineQuarterCount = this.quarter;
        int machineDimeCount = this.dime;
        int machineNickelCount = this.nickel;

        if(totalAmountOfChange == 0){
            String change = "Exact amount of coin entered";
            return change;
        }

        customerChangeQuarterAmount = (int) (coin / .25); //the number of quarters
        amount = (coin % .25);
        amount = Double.parseDouble(df.format(amount));

        if (customerChangeQuarterAmount <= machineQuarterCount){
            // the number of quarters needed in change is available. machine quarter count is subtracted by customer quarter count
            removeQuatersFromCM(customerChangeQuarterAmount);
        }else {
            double excessQuarterAmount = customerChangeQuarterAmount - machineQuarterCount;
            customerChangeQuarterAmount = machineQuarterCount;
            removeQuatersFromCM(machineQuarterCount);
            amount = amount + (excessQuarterAmount * 0.25);
        }


        customerChangeDimeAmount = (int) (amount / .10);
        amount = amount % .10;
        amount = Double.parseDouble(df.format(amount));

        if (customerChangeDimeAmount <= machineDimeCount){
            // the number of Dimes needed in change is available. machine dime count is subtracted by customer dime count
            removeDimesFromCM(customerChangeDimeAmount);
        }else {
            double excessDimeAmount = customerChangeDimeAmount - machineDimeCount;
            customerChangeDimeAmount = machineDimeCount;
            removeDimesFromCM(machineDimeCount);
            amount = amount + (excessDimeAmount * 0.10);
        }

        customerChangeNickelAmount = (int) (amount / .05);
        amount = amount % .05;
        amount = Double.parseDouble(df.format(amount));

        if (customerChangeNickelAmount <= machineNickelCount){
            // the number of nickles needed in change is available. machine nickel count is subtracted by customer nickek count
            removeNickelsFromCM(customerChangeNickelAmount);

        }else {
            double excessNickelAmount = customerChangeNickelAmount - machineNickelCount;
            customerChangeNickelAmount = machineNickelCount;
            removeNickelsFromCM(machineNickelCount);
            amount = amount + (excessNickelAmount * 0.05);
        }

        String returnChangeInCoinCount = "Your change is: " + "\n" + "Quarters: " + customerChangeQuarterAmount
                + "\n" + "Dimes: " + customerChangeDimeAmount
                + "\n" + "Nickels: " + customerChangeNickelAmount;

        return returnChangeInCoinCount;
    }

    //Return Less Than Change Scenario
    public String returnCustomerChangeInserted(){
        int customerReturnQuarterAmount = getCustomerQuarter();
        int customerReturnDimeAmount = getCustomerDime();
        int customerReturnNickelAmount = getCustomerNickel();

        String returnCustomerCoinCount = "Not Enough Coins." + "\n" + "Quarters: " + customerReturnQuarterAmount
                + "\n" + "Dimes: " + customerReturnDimeAmount
                + "\n" + "Nickels: " + customerReturnNickelAmount;

        return returnCustomerCoinCount;

    }

}
