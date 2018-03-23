package hello;

import java.util.ArrayList;

public class Machine {

    final String companyName = "Thank you for using The Evolution Machine!";
    private Location location;
    private String id;
    private double totalMoneyValue;
    private int quarterCount;
    private int dimeCount;
    private int nickelCount;

    final String operatorSecurityCode = "pineapple";



    public Machine(String city,String state, String id){

        location= new Location(city,state);
        this.id=id;
//        this.totalMoneyValue = 0;

    }





    public String displayCompanyName (){

        System.out.println(companyName);

        return companyName;

    }


    public Location getLocation() {
        return location;
    }

    public String getId() {
        return id;
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
    // This needs to be checked.
    public String searchMachineByLocation(Machine machine, String loc){
        ArrayList<Machine> machineList = new ArrayList<Machine>();
        machineList.add(machine);
        Machine machine1;
        for(Machine m: machineList) {
            if (m.location.getCity() == (loc)) {
                machine1 = m;
            }
        }
//        String mloc;
//        mloc = machine.getLocation().city;
        return machine1.location.getCity().toString();
    }

    //    public String getCompanyName() {
//        return companyName;
//    }
}

