package experiment.PostgreSQLDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PostgreSQLController {
    private Connection connection;
    private static final URL propertyURL = PostgreSQLController.class.getResource("/loader.cnf");
    private final Map<String, PreparedStatement> prepareStatements=new HashMap<>();

    private void connect(String host, String dbname, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://" + host + "/" + dbname + "?user=" + user + "&password=" + password;
        connection = DriverManager.getConnection(url);
    }

    public void connect() throws IOException, SQLException, ClassNotFoundException {
        Properties connectParam = new Properties();
        connectParam.put("host", "");
        connectParam.put("user", "");
        connectParam.put("password", "");
        connectParam.put("database", "");
        if(propertyURL==null) throw new IOException("Cannot find the load.cnf.");
        try (BufferedReader conf = new BufferedReader(new FileReader(propertyURL.getPath()))) {
            connectParam.load(conf);
        }
        connect(connectParam.getProperty("host"), connectParam.getProperty("database"),
                connectParam.getProperty("user"), connectParam.getProperty("password"));
    }
    public void connectIfNot() throws SQLException, IOException, ClassNotFoundException {
        if(connection==null||connection.isClosed()){
            connect();
        }
    }
    public void disconnect() throws SQLException {
        connection.close();
        for (var v:prepareStatements.values()) {
            v.close();
        }
    }
    public void prepareStatement(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        prepareStatements.put(sql, statement);
    }

    public Statement executeStatement(String preparedSQL, Object... params) throws SQLException {
        PreparedStatement statement = prepareStatements.get(preparedSQL);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        statement.execute();
        return statement;
    }
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    public void beginTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public Statement executeStatement(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
        return statement;
    }
    public void commit() throws SQLException {
        connection.commit();
    }
    public void rollback() throws SQLException {
        connection.rollback();
    }
}
