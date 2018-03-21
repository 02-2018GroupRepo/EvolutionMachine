package hello;

public class Product {

    String name;
    int uniqueId;
    double retailPrice;
    double wholesalePrice;
    String description;

    public Product(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Product(String name, int uniqueId, double retailPrice, double wholesalePrice, String description) {
        this.name = name;
        this.uniqueId = uniqueId;
        this.retailPrice = retailPrice;
        this.wholesalePrice = wholesalePrice;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
