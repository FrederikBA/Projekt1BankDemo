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
    String email;


    public void addCustomer() {
        Customer customer = new Customer();
        name = setCustomerName();
        email = setCustomerEmail();

        customer.setName(name);
        customer.setEmail(email);

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        String sql = "";
        sql += "INSERT INTO customers(customerID,customerName,customerEmail) VALUES (?,?,?)";
        connection = dbc.getMyConnection();
        try {
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, customer.getCustomerID());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getEmail());
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

    public String setCustomerEmail() {
        String email = "";
        System.out.print("Enter customer email: ");
        email = sc.nextLine();
        return email;
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
                String email = res.getString(3);
                tmpCustomer = new Customer(ID, name, email);
                customers.add(tmpCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer getCustomer(String email) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "";
        Customer customer;

        connection = dbc.getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM customers WHERE customerEmail = \"" + email + "\"";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int customerID = res.getInt(1);
                String customerName = res.getString(2);
                String customerEmail = res.getString(3);
                customer = new Customer(customerID, customerName, customerEmail);
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer getCustomerByID(int id) {
        Customer customer = null;
        for (Customer c:getAllCustomers()) {
            if(c.getCustomerID() == id) {
                return c;
            }
        }

        return customer;
    }

    public void showAllCustomers() {
        for (Customer c : getAllCustomers()) {
            System.out.println(c);
        }
    }
}
