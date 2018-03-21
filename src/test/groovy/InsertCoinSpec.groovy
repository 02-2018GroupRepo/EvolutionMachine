import hello.Machine
import spock.lang.Specification


class InsertCoinSpec extends Specification {
    def "Check if coin is valid"(){
        given: "A machine "
        Machine machine3 = new Machine();

        and: "a coin"
        double coin1 = 0.17
        double coin2 = 0.25

        when: "The coin is equal to 0.25, 0.10, or 0.05"
        boolean result1 = machine3.validCoin(coin1)
        boolean result2 = machine3.validCoin(coin2)

        then: "The coin is valid"
        !result1
        result2
    }


    def "Determining if the correct amount was inserted"(){

        given: "Machine"
        Machine machine = new Machine();

        and: "Customer had inserted valid coins"
        double coin1 = 0.25
        machine.validCoin(coin1)
        double coin2 = 0.25
        machine.validCoin(coin2)
        double coin3 = 0.35
        machine.validCoin(coin3)

        and: "Machine has determined total amount inserted"
        machine.addCoinsTogether(coin1)
        machine.addCoinsTogether(coin2);
        machine.addCoinsTogether(coin3)

        when: "Customer selects product"
        double drink = 0.50;

        then: "Machine determines if customer entered enough money for product"
        machine.hasEnoughForProduct(drink)
    }

    def "Exact Amount"(){

        given: "A vending machine"

        Machine machine1 = new Machine();

        and: "A valid coin"

        double coin1 = 0.25;
        double coin2 = 0.25;

        when: "Exact Change is inserted for product"

        machine1.addCoinsTogether(coin1);
        machine1.addCoinsTogether(coin2);


        then: "the customer receives product"
        //dispense product group deals with this


    }

}
