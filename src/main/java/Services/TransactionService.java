package Services;

import Connector.DBConnector;
import Connector.IDBConnector;
import Domain.Customer;
import Domain.Transaction;

import java.sql.*;
import java.util.ArrayList;

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
}
