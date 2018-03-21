import hello.CoinManager
import hello.Product
import spock.lang.Specification


class InsertCoinSpec extends Specification {
    Product drink = new Product(123);


    def "Determining if there is enough coins for selected product"() {

        given: "A coin manager"

        CoinManager coinManager1 = new CoinManager();

        and: "Coins are inserted"
        coinManager1.addCustomerCoins("quarter")
        coinManager1.addCustomerCoins("dime")
        coinManager1.addCustomerCoins("nickel")
        coinManager1.displayCustomerCoins()

        when: "The customer's total is calculated"
        coinManager1.customerTotalInputAmount();

        then: "Compare if total is greater than or equal to the retail price of the selected product"
        drink.setName("Drink")
        drink.setRetailPrice(0.40)
        coinManager1.hasEnoughForProduct(drink)


    }


}