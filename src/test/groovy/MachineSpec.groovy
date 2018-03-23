import hello.DrinkMachine

import spock.lang.Specification

class MachineSpec extends Specification {

    def "Company name displayed on all machines"(){

        given: "A Machine"

        DrinkMachine vM = new DrinkMachine();

        when: "the machine is accessed"

        String nameTest=vM.displayCompanyName()

        then: " the company name is displayed"

        nameTest.equals("Thank you for using The Evolution Machine!")



    }

    def "Type and Location for each Machine"(){

        given: "A machine"

        when: "someone accesses the Machine"

        then: "the Machine's Type and Location is displayed"

    }



}