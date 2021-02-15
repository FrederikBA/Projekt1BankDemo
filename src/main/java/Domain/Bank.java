package Domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int id;
    private String name;
    private String city;
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }
}

