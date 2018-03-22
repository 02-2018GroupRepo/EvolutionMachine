package hello;

public class CoinManager {

    private int nickel = 30;
    private int dime = 30;
    private int quarter = 30;
    private int customerNickel = 0;
    private int customerDime = 0;
    private int customerQuarter = 0;

    public void addCustomerCoins(String coin){
        if(coin.equals("quarter")){
            customerQuarter++;
        }else if(coin.equals("dime")){
            customerDime++;
        }else {
            customerNickel++;
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

        if (customerTotalInputAmount() >= product.retailPrice){
             confirmed = true;
        }

        return confirmed;
    }

    public void displayCustomerTotal(){

        System.out.println(customerTotalInputAmount());
    }

    public String addCustomerCoinsToCM(){
        nickel += customerNickel;
        dime += customerDime;
        quarter += customerQuarter;

        return (nickel+ " " +dime+ " " +quarter);
    }

    public int getCoinCount(String coin){
        int coinCount = 0;
        if(coin.equals("quarter")){
            coinCount = quarter;
        } else if(coin.equals("dime")){
            coinCount = dime;
        } else {
            coinCount = nickel;
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
            totalCoinValue = getCoinCount("nickle") * 0.05;
        }

        return totalCoinValue;

    }


}
