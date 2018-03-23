package hello;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DummyDrinkMachine {

    Map<String, Queue<Product>> mapOfIndexProduct;

    public DummyDrinkMachine() {
        mapOfIndexProduct = new HashMap<>();
    }

    public boolean removeItem (String index) {
        boolean found = false;
        char firstChar = index.charAt(0);
        char secondChar = index.charAt(1);

        if (firstChar >= 70 || secondChar <= 48 || secondChar >= 55) {
            System.out.println("invalid index");
            found = false;
        } else {
            if(index.equals("A1")) {
                Product twix = new Product("Twix", 2, 1.70, 1.20, "Candy");
                Queue<Product> queProd = new LinkedList<>();
                queProd.add(twix);
                mapOfIndexProduct.put(index, queProd);
            } else {
                found = false;
            }
            if (mapOfIndexProduct.get(index) == null || mapOfIndexProduct.get(index).size() == 0) {
                found = false;
            } else {
                found = true;
            }

        }
        return found;
    }
}
