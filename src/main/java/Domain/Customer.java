package Domain;

public class Customer {
    private int customerID;
    private String name;

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    public Customer() {

    }

    public String getName() {
        return name;
    }
}

