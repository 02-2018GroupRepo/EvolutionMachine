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

        when: "The customer's total is calculated"
        coinManager1.customerTotalInputAmount();

        then: "Compare if total is greater than or equal to the retail price of the selected product"
        drink.setName("Drink")
        drink.setRetailPrice(0.40)
        coinManager1.hasEnoughForProduct(drink)


    }

    def "Get the total for customer"(){

        given: "A coin manager"
        CoinManager coinManager2 = new CoinManager();

        when: "The customer inserts a new coin"
        coinManager2.addCustomerCoins("quarter")
        coinManager2.addCustomerCoins("quarter")

        then: "Return the value of coins inserted"
        coinManager2.displayCustomerTotal()
    }

    def "Add customer coins to coin manager"(){

        given: "A coin manager"
        CoinManager coinManager3 = new CoinManager();

        and: "Customer coins"
        coinManager3.addCustomerCoins("quarter")
        coinManager3.addCustomerCoins("quarter")
        coinManager3.addCustomerCoins("dime")
        coinManager3.addCustomerCoins("nickel")

        when: "Customer receives product"
        //when product is dispensed to the customer

        then: "Customer coins are added to coin manager"
        String result = coinManager3.addCustomerCoinsToCM()
        println result
    }
    

}