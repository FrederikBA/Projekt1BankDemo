package Connector;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectorTest {

    @org.junit.jupiter.api.Test
    void getMyConnection() {
        IDBConnector dbc = new DBConnector();
        Connection connection = dbc.getMyConnection();
        assertNotNull(connection);
    }
}