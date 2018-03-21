import hello.VendingMachine
import spock.lang.Specification


class ReturnChangeSpec extends Specification {
    def"Return Change when Greater Amount"(){
        given:"A vending machine"
        VendingMachine fakeVendingMachine = new VendingMachine();

        and: "total amount customer inserted in vending machine"
        double totalAmount = 2.50;

        and: "customer selected a product with price"
        double productPrice = 1.50;

        and: "total amount inserted is more than price of product"
        (totalAmount > productPrice) == true;

        when: "machine dispenses product"
        double result = fakeVendingMachine.returnChange(totalAmount, productPrice);

        then: "machine returns difference in total amount inserted and product price"
        result == 1.00;
    }
    def "Return Change when Not Enough Money Entered"(){
        given: "A vending Machine"
        and:""
    }

}