package hello;

public class Machine {

    private double totalCoinAmount = 0.00;

    public double getTotalCoinAmount() {
        return totalCoinAmount;
    }

    public boolean validCoin(double coin){
        boolean conformed = false;
        if (coin == 0.25 || coin == 0.05 || coin == 0.10) {
            conformed = true;
        }
        return conformed;
    }

    public void addCoinsTogether(double coin){
        if(validCoin(coin)){
            totalCoinAmount += coin;
        }

    }

    public boolean hasExactChange(double product){
        return getTotalCoinAmount() == product;

    }

    public boolean hasEnoughForProduct(double product){
        boolean hasEnough = false;
        if(getTotalCoinAmount() >= product){
            hasEnough = true;
        }
        return hasEnough;
    }


}
