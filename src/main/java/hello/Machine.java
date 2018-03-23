package hello;

public class Machine {

    final String companyName = "Thank you for using The Evolution Machine!";

    private Location location;

    private String machineId;

    private double totalMoneyValue;

    private int quarterCount;

    private int dimeCount;

    private int nickelCount;



    public Machine(String city,String state, String machineId){

        location= new Location(city,state);
        this.machineId=machineId;
//        this.totalMoneyValue = 0;

    }


    public String displayCompanyName (){

        System.out.println(companyName);

        return companyName;

    }


    public Location getLocation() {
        return location;
    }

    public String getMachineId() {
        return machineId;
    }

    public double getTotalMoneyValue() {
        return totalMoneyValue;
    }

    public int getQuarterCount() {
        return quarterCount;
    }

    public int getDimeCount() {
        return dimeCount;
    }

    public int getNickelCount() {
        return nickelCount;
    }

    public void setTotalMoneyValue(double totalMoneyValue) {
        this.totalMoneyValue = totalMoneyValue;
    }

    public void setQuarterCount(int quarterCount) {
        this.quarterCount = quarterCount;
    }

    public void setDimeCount(int dimeCount) {
        this.dimeCount = dimeCount;
    }

    public void setNickelCount(int nickelCount) {
        this.nickelCount = nickelCount;
    }

    //    public String getCompanyName() {
//        return companyName;
//    }
}

