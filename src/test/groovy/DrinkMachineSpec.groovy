import hello.DrinkMachine
import hello.DummyDrinkMachine
import hello.Product
import spock.lang.Specification


class DrinkMachineSpec extends Specification {

    def "Successfully Added an item" () {

        given : "A drink machine"
        DrinkMachine drinkMachine = new DrinkMachine();

        and: "A product"
        Product twix = new Product ("Twix", 2, 1.70, 1.20, "Candy");

        and : "Quantity of product"
        int quantity = 5;

        when : "A operator adds the product to the drink machine"
        and :  "Provides valid index"
        and : "Provides valid quantity"
        and : "Provides valid product"

        drinkMachine.addItemToMachine(twix, "A1", 5);

        then : "A operator successfully adds the product to the drink machine"

        drinkMachine.getSizeOfCompt("A1");
        println("Message should display with the size of the compartment A1 is 5");
    }

    def "Not able to insert an item because compartment is full" () {

        given : "A drink machine"
        DrinkMachine drinkMachine = new DrinkMachine();

        and: "A product"
        Product twix = new Product ("Twix", 2, 1.70, 1.20, "Candy");

        and : "Quantity of product"
        int quantity = 3;

        and : "Quantity of product currently in machine"
        drinkMachine.addItemToMachine(twix, "A1", 12);

        when : "A operator adds the product to the drink machine"
        and :  "Provides valid index"
        and : "Provides valid quantity"
        and : "Provides valid product"

        drinkMachine.addItemToMachine(twix, "A1", 3);

        then : "the operator is unable to insert the product because the compartment is full"

        drinkMachine.getSizeOfCompt("A1");
        println "Message will display that Compartment is full"
    }

    def "Mismatched compartment" () {

        given : "A drink machine"
        DrinkMachine drinkMachine = new DrinkMachine();

        and: "A product currently in machine"
        Product twix = new Product ("Twix", 2, 1.70, 1.20, "Candy");
        drinkMachine.addItemToMachine(twix, "A1", 8);

        and : "Product to be added"
        Product kitKat = new Product ("KitKat", 3, 1.50, 1.10, "Candy");


        when : "A operator adds the product to the drink machine"
        and :  "Provides valid index"
        and : "Provides valid quantity"
        and : "Provides valid product"
        drinkMachine.addItemToMachine(kitKat, "A1", 2);

        then : "the operator is unable to insert the product because the product is mismatched with compartment"

        kitKat != twix
        println "Unable to accept product because this product does not belong in this compartment"
    }


    def "Operator selects an invalid compartment" () {

        given : "A drink machine"
        DrinkMachine drinkMachine = new DrinkMachine();

        and: "an invalid compartment selection"
        String index = "A8";

        and: "product"
        Product kitKat = new Product ("KitKat", 3, 1.50, 1.10, "Candy");

        when : "A operator selects a compartment"
        and : "Provides invalid index"
        and : "Provides valid quantity"
        and : "Provides valid product"
        drinkMachine.addItemToMachine(kitKat, index, 2);

        then : "the operator is unable to add items to the invalid compartment"
        and: "The operator is prompted to make a valid compartment selection"
        println "Please make a valid compartment selection"
    }

    def "Not enough space" () {

        given : "A drink machine"
        DrinkMachine drinkMachine = new DrinkMachine();

        and: "Quantity of product"
        int quantity = 20;
        and: "product"
        Product kitKat = new Product ("KitKat", 3, 1.50, 1.10, "Candy");

        when : "A operator inputs the quantity of product"
        and : "Provides valid index"
        and : "Provides excess the size of the compartment "
        and : "Provides valid product"
        drinkMachine.addItemToMachine(kitKat, "A1", quantity);

        then : "the operator is unable to add items to the compartment"
        println "because quantity exceeded the size of the compartment"
    }

    def "Unable to view an item of the compartment" () {

        given : "A drink machine"
        DrinkMachine drinkMachine = new DrinkMachine();
        and: "a valid index"
        String index = "A1"

        when : "A operator inputs the valid index to view the item"
        and : "Provides valid index"
        drinkMachine.viewItem(index);

        then : "the operator is unable to view item"
        println "because the compartment is empty and prompted for another selection"
    }

    def "View an item of the compartment" () {

        given : "A drink machine"
        DrinkMachine drinkMachine = new DrinkMachine();

        and: "an item to the compartment"
        Product kitKat = new Product ("KitKat", 3, 1.50, 1.10, "Candy");
        drinkMachine.addItemToMachine(kitKat, "A1", 5);

        when : "A operator inputs the valid index to view the item"
        drinkMachine.viewItem("A1");

        then : "the operator is able to view an item"
        println("Message will display the name of the item");
    }

    def "customer makes successful selection" () {

        given : "A drink machine"
        DummyDrinkMachine dummyDrinkMachine = new DummyDrinkMachine();

        and : "input"
        and : "valid index"
        String input = "A1";

        when : "The customer makes a selection"
            boolean found = dummyDrinkMachine.removeItem(input);

        then : "the product will be dispensed"
            found == true
    }

    def "customer makes invalid selection" () {

        given : "A drink machine"
        DummyDrinkMachine dummyDrinkMachine = new DummyDrinkMachine();

        and : "input"
        and : "invalid index"
        String input = "A9";

        when : "The customer makes a selection"
            boolean found = dummyDrinkMachine.removeItem(input);

        then : "the product will be dispensed"
            found == false
    }

    def "Customer selects empty compartment" () {

        given : "A drink machine"
        DummyDrinkMachine dummyDrinkMachine = new DummyDrinkMachine();

        and : "input"
        and : "valid index"
        String input = "A2";

        when : "The customer makes a selection"
            boolean found = dummyDrinkMachine.removeItem(input);

        then : "the product will be dispensed"
            found == false
    }

}