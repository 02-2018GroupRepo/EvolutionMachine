import hello.CoinManager
import hello.DrinkMachine
import hello.Product
import spock.lang.Specification


class Dispense extends Specification {


    def "Dispensing product to customer and decreasing quantity of product"() {

        given: "A drink machine"
        DrinkMachine dm = new DrinkMachine();
        and: "the correct amount of coins have been inserted"
        CoinManager cm = new CoinManager();
        Product p = new Product(1);
        p.setName("kitkit");
        cm.hasEnoughForProduct(p);
        Queue<Product> queProd = new LinkedList<>();
        queProd.add("kitkit");
        queProd.add("kitkit");
        queProd.add("kitkit");


        when: "the item is selected"

        queProd.remove();
        boolean example = queProd.size() == 2;


        then: "Dispense an unit of that product and decrement the quantity"
        example == true;
    }
}