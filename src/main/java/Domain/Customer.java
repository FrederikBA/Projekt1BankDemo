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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return customerID + ": " + name;
    }
}

