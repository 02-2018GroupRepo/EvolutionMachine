import hello.CoinManager
import spock.lang.Specification


class InsertCoinSpec extends Specification {
    def "Check if coin is valid"(){
        given: "A Coin Manager "
        CoinManager coinManager = new CoinManager();

        and: "a coin"
        double coin1 = 0.17
        double coin2 = 0.25

        when: "The coin is equal to 0.25, 0.10, or 0.05"
        boolean result1 = coinManager.validCoin(coin1)
        boolean result2 = coinManager.validCoin(coin2)

        then: "The coin is valid"
        !result1
        result2
    }


    def "Determining if the correct amount was inserted"(){

        given: "Coin Manager"
        CoinManager coinManager1 = new CoinManager();

        and: "Customer had inserted valid coins"
        double coin1 = 0.25
        coinManager1.validCoin(coin1)
        double coin2 = 0.25
        coinManager1.validCoin(coin2)
        double coin3 = 0.35
        coinManager1.validCoin(coin3)

        and: " The Coin Manager has determined total amount inserted"
        coinManager1.addCoinsTogether(coin1)
        coinManager1.addCoinsTogether(coin2);
        coinManager1.addCoinsTogether(coin3)

        when: "Customer selects product"
        double drink = 0.50;

        then: "Coin Manager determines if customer entered enough money for product"
        coinManager1.hasEnoughForProduct(drink)
    }

    def "Exact Amount"(){

        given: "A vending machine"

        CoinManager coinManager2 = new CoinManager();

        and: "A valid coin"

        double coin1 = 0.25;
        double coin2 = 0.25;

        when: "Exact Change is inserted for product"

        coinManager2.addCoinsTogether(coin1);
        coinManager2.addCoinsTogether(coin2);


        then: "the customer receives product"
        //dispense product group deals with this


    }

}
