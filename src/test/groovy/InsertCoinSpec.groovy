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

    def "Get the coin count for each coin type"(){

        given: "A coin manager"
        CoinManager coinManager4 = new CoinManager();
        coinManager4.addCustomerCoins("dime")
        coinManager4.addCustomerCoins("dime")
        coinManager4.addCustomerCoins("dime")
        coinManager4.addCustomerCoinsToCM()
        when: "the count of a coin is requested"
        int result = coinManager4.getCoinCount("dime")

        then: "I get the total amount of coins for each type requested"
        result == 33
        println result

    }

    def "Get the total value of the coin for each type"(){

        given: "A coin Manager"
        CoinManager coinManager5 = new CoinManager();
        coinManager5.addCustomerCoins("quarter")
        coinManager5.addCustomerCoins("quarter")
        coinManager5.addCustomerCoins("quarter")
        coinManager5.addCustomerCoinsToCM()

        when: "the total value of a coin is requested"
        double result = coinManager5.getTotalCoinValue("quarter")

        then: "I get the total value of the requested coin"

        result == 8.25
        println result
    }


}