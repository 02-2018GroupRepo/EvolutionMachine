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
        fakeVendingMachine.dispenseProduct();

        then: "machine returns difference in total amount inserted and product price"
        double result = 1.00;
    }

}