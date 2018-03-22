import hello.VendingMachine
import spock.lang.Specification

class ReturnChangeSpec extends Specification {
    def "Return Change when Greater Amount"() {
        given: "A vending machine"
        VendingMachine fakeVendingMachine = new VendingMachine()

        and: "total amount customer inserted in vending machine"
        double totalAmount = 2.50

        and: "customer selected a product with price"
        double productPrice = 1.50

        and: "total amount inserted is more than price of product"
        (totalAmount > productPrice) == true

        when: "machine dispenses product"
        double totalAmountOfChange = fakeVendingMachine.getChangeInDollarAmount(totalAmount, productPrice)

        then: "machine returns difference in total amount inserted and product price"
        totalAmountOfChange == 1.00
    }

    def "Return change amount in individual coin counts"() {
        given: "total amount of change in dollar amount"
        double totalAmountOfChange = 1.20

        and: "A vending machine"
        VendingMachine fakeVendingMachine = new VendingMachine()

        and: "machine coin counts"
        //stub in machine coin counts

        when: "convert change to coin count"
        String result = fakeVendingMachine.returnChangeInCoinCount(totalAmountOfChange)

        then: "return coin count values"
        result.equals("Your change is: " + "\n" + "Quarters: " + "4"
                + "\n" + "Dimes: " + "2"
                + "\n" + "Nickels: " + "0")


    }

    def "Exact Amount of Coin"() {
        given: "A Vending Machine"
        VendingMachine fakeVendingMachine = new VendingMachine()

        and: "Total amount of Change due back is 0"
        double totalAmountOfChange = 0.0

        when: "coin count change is calculated"
        String result = fakeVendingMachine.returnChangeInCoinCount(totalAmountOfChange)

        then: "No change is returned"
        result.equals("Exact amount of coin entered")
    }

    def "Coin amount inserted is not enough for product"(){
        given: "Vending Machine"
        VendingMachine vm = new VendingMachine();

        when: "Total amount of change is less than amount of price"
        double totalAmount = 1.0
        double retailPrice = 2.0;
        (totalAmount < retailPrice) == true;

        then: "Money inserted is returned"
        vm.returnExactChangeInserted(totalAmount);
    }

}