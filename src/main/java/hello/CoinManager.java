package hello;

public class CoinManager {

    private int nickel = 30;
    private int dime = 30;
    private int quarter = 30;
    private int customerNickel = 0;
    private int customerDime = 0;
    private int customerQuarter = 0;

    //Noelle & Toby need a way to retrieve the total coin count of the MACHINE (getters)
    //TODO : RESPONSE - Its at the bottom as getTotalCoinManagerValue()


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

    public void addCustomerCoins(String coin){
        if(coin.equals("quarter")){
            customerQuarter++;
        }else if(coin.equals("dime")){
            customerDime++;
        }else if(coin.equals("nickel")){
            customerNickel++;
        } else {
            System.out.println("Why would you do that? Use nickel, dime, quarter!!");
        }
    }



    public double customerTotalInputAmount(){
        double customerQuarterValue = customerQuarter * 0.25;
        double customerDimeValue = customerDime * 0.10;
        double customerNickelValue = customerNickel * 0.05;

        return customerDimeValue + customerNickelValue + customerQuarterValue;
    }

    public boolean hasEnoughForProduct(Product product){
        boolean confirmed = false;

        if (customerTotalInputAmount() >= product.getRetailPrice()){
             confirmed = true;
        }

        return confirmed;
    }

    public void displayCustomerTotal(){

        System.out.println(customerTotalInputAmount());
    }

    public void addCustomerCoinsToCM(){
        nickel += customerNickel;
        customerNickel = 0;
        dime += customerDime;
        customerDime = 0;
        quarter += customerQuarter;
        customerQuarter = 0;
    }

    public void removeQuatersFromCM(int machineQuarterCount){
        quarter = quarter - machineQuarterCount;
    }
    public void removeDimesFromCM(int machineDimeCount){
        this.dime = dime - machineDimeCount;
    }
    public void removeNickelsFromCM(int machineNickelCount){
        this.nickel = nickel - machineNickelCount;
    }

    public int getCoinCount(String coin){
        int coinCount = 0;
        if(coin.equals("quarter")){
            coinCount = quarter;
        } else if(coin.equals("dime")){
            coinCount = dime;
        } else if(coin.equals(("nickel"))) {
            coinCount = nickel;
        } else {
            System.out.println("NO NO NOOOOOOO, you better use nickel, dime, quarter");
        }

        return coinCount;
    }


    public double getTotalCoinValue(String coin){
        double totalCoinValue = 0;
        if(coin.equals("quarter")){
            totalCoinValue = getCoinCount("quarter") * 0.25;
        } else if(coin.equals("dime")){
            totalCoinValue = getCoinCount("dime") * 0.10;
        } else {
            totalCoinValue = getCoinCount("nickel") * 0.05;
        }

        return totalCoinValue;

    }

    public double getTotalCoinManagerValue(){
        double valueForQuarter = getTotalCoinValue("quarter");
        double valueForDime = getTotalCoinValue("dime");
        double valueForNickel = getTotalCoinValue("nickel");

        return valueForDime + valueForNickel + valueForQuarter;
    }


}
