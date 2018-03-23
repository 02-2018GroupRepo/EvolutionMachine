import hello.DrinkMachine
import spock.lang.Specification

class OperatorSpec extends Specification{

    def "Get total amount of money"(){

        given: "A machine with a total of 12 dollars";

        DrinkMachine dM = new DrinkMachine("Smyrna", "GA", "001")

        dM.setTotalMoneyValue(12);

        when: "an operator accesses a machine";

        double moneyTotalAmount = dM.getTotalMoneyValue();


        then: "the operator is able to view the total amount of cash";

        moneyTotalAmount==12;

    }

    def "Get total amount of coins"(){

        given: "A Machine";

        DrinkMachine dM = new DrinkMachine("Smyrna", "GA", "001")

        dM.setQuarterCount(5);
        dM.setDimeCount(5);
        dM.setNickelCount(5);

        when: "an operator accesses a machine";

        double quarterTotalAmount = dM.getQuarterCount()
        double dimeTotalAmount = dM.getDimeCount()
        double nickelTotalAmount = dM.getNickelCount()

        then: "the operator is able to view the total individual coins"

        quarterTotalAmount==5;
        dimeTotalAmount==5;
        nickelTotalAmount==5;


    }


}