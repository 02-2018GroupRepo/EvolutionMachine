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





    public void displayCustomerCoins(){
        System.out.println("Quarters = " +customerQuarter+ ", Dimes = " +customerDime+ ", Nickels = " +customerNickel);
        System.out.println(customerTotalInputAmount());
    }

}
