package Services;

import Connector.DBConnector;
import Connector.IDBConnector;
import Domain.Customer;
import Domain.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionService implements ITransactionService {
    IDBConnector dbc = new DBConnector();
    ICustomerService cs = new CustomerService();

    public void confirmTransaction(ArrayList<Transaction> transactions) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        String sql = "";

        sql += "INSERT INTO transactions(transactionID,customerID,amount,transactionTime) VALUES (?,?,?,?)";
        connection = dbc.getMyConnection();
        try {
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (Transaction t : transactions) {
                stmt.setInt(1, t.getId());
                stmt.setInt(2, t.getCustomerID());
                stmt.setInt(3, t.getAmount());
                stmt.setString(4, t.getDateAsString());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql;
        Transaction tmpTransaction = null;
        connection = dbc.getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM transactions";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int transactionID = res.getInt(1);
                int customerID = res.getInt(2);
                int amount = res.getInt(3);
                String timestamp = res.getString(4);
                Customer customer = cs.getCustomerByID(customerID);
                tmpTransaction = new Transaction(transactionID, customer, amount, timestamp);
                transactions.add(tmpTransaction);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public void getPreviousTransactionsByCustomer(Customer customer) {
        List<Transaction> customerTransactions = new ArrayList<>();
        for (Transaction t : getAllTransactions()) {
            if (t.getCustomerID() == customer.getCustomerID()) {
                customerTransactions.add(t);
                System.out.println(t);
            }
        }
    }
}
