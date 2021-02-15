package Services;

import Connector.*;
import Domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerService implements ICustomerService {
    Scanner sc = new Scanner(System.in);
    IDBConnector dbc = new DBConnector();
    String name;


    public void addCustomer() {
        Customer customer = new Customer();
        name = setCustomerName();

        customer.setName(name);

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        String sql = "";

        sql += "INSERT INTO customers(customerID,customerName) VALUES (?,?)";
        connection = dbc.getMyConnection();
        try {
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, customer.getCustomerID());
            stmt.setString(2, customer.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String setCustomerName() {
        String name = "";
        System.out.print("Enter customer name: ");
        name = sc.nextLine();
        return name;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "";
        Customer tmpCustomer = null;
        connection = dbc.getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM customers";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int ID = res.getInt(1);
                String name = res.getString(2);
                tmpCustomer = new Customer(ID, name);
                customers.add(tmpCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public void showAllCustomers() {
        for (Customer c : getAllCustomers()) {
            System.out.println(c);
        }
    }
}
