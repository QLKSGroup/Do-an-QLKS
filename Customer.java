package QLKS;

import java.util.Scanner;

public class Customer {
        private String name;
        private String birthYear;
        private String ID;
        private String phoneNumber;
        private String address;
          
    public Customer(String name, String birthYear, String ID, String phoneNumber, String address){
        super();
        this.name=name;
        this.birthYear=birthYear;
        this.ID=ID;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", birthYear=" + birthYear + ", ID=" + ID + ", phoneNumber=" + phoneNumber
                + ", address=" + address + "]";
    }

    public Customer(){
        super();
    }
    public String getID(){
        return ID;
    }

    public void setID(String ID){
        this.ID=ID; 
    }

    public void putInfCustomer()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("- Customer's information: ");
        System.out.print("\n Name: ");
        name=in.nextLine();
        System.out.print("\n Birth year: ");
        birthYear=in.nextLine();
        System.out.print("\n Citizen identity number: ");
        ID=in.nextLine();
        System.out.print("\n Phone Number: ");
        phoneNumber=in.nextLine();
        System.out.print("\n Address: ");
        address=in.nextLine();
        in.close();
    }

    // public void showInfCustomer()
    // {
    //     System.out.print("- Customer's information: ");
    //     System.out.print("\n Name: "+ name);
    //     System.out.print("\n Birth year: "+birthYear);
    //     System.out.print("\n Citizen identity number: "+ID);
    //     System.out.print("\n Phone Number: "+phoneNumber);
    //     System.out.print("\n Address: "+address);
    // }
    
}
