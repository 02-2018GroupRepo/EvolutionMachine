import hello.Machine
import spock.lang.Specification


class AddLocationSpec extends Specification {
    def "An operator can search for a machine at any location"(){

        given: "A machine with a state and id"
        Machine m1 = new Machine("Atlanta", "GA", "007")

        when: "when a operator searches for a machine"
        ArrayList<Machine> machineList = new ArrayList<Machine>()
        machineList.add(m1)
        Machine mach;
        for(Machine m: machineList){
            if(m.location.getCity() == ("Atlanta")){
                mach = m
            }

        }
//        println mach.getLocation().getCity()

        boolean isEqual = m1.getLocation().city
        then: "a location has a new machine"
        isEqual==true

    }
}