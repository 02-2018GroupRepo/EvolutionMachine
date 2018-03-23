package hello;

public class Location {

    String city;
    String state;

    public Location (String city, String state){
        this.city = city;
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
