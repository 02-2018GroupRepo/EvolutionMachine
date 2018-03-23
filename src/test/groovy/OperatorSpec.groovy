import hello.DrinkMachine
import spock.lang.Specification

class OperatorSpec extends Specification{

    def "Get total amounts of money and coins"(){

        given: "A machine with a total of 12 dollars";

        DrinkMachine dM = new DrinkMachine("Smyrna", "GA", "001")

        dM.setTotalMoneyValue(12);

        when: "an operator accesses a machine";

        double moneyTotalAmount = dM.getTotalMoneyValue();


        then: "the operator is able to view the total amount and individual coins";

        moneyTotalAmount==12;

    }


}