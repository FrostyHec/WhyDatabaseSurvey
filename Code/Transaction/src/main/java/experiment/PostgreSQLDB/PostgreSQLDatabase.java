package experiment.PostgreSQLDB;

import experiment.Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PostgreSQLDatabase implements Database {
    PostgreSQLController controller = new PostgreSQLController();
    private static final int oneTimeTransferAmountLimit = 1;
    String[] prepareSQLs = {
            "select * from account",
            "update account set deposit=? where name=?",
            "select deposit from account where name=?"
    };

    public PostgreSQLDatabase() {
        try {
            init();
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void increaseAccountAmount(String username, int val) {
        try {
            boolean add = val > 0;
            int dif = Math.abs(val);
            //获取deposit
            int deposit;
            Statement stmt = controller.executeStatement(prepareSQLs[2], username);
            ResultSet rs = stmt.getResultSet();
            rs.next();
            deposit = rs.getInt("deposit");

            while (dif / oneTimeTransferAmountLimit > 0) {
                deposit += (add ? 1 : -1) * oneTimeTransferAmountLimit;
                controller.executeStatement(prepareSQLs[1], deposit, username);
                dif -= oneTimeTransferAmountLimit;
                System.out.println("processing... remain:" + dif);
            }
            deposit += (add ? 1 : -1) * dif;
            controller.executeStatement(prepareSQLs[1], deposit, username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() throws SQLException, IOException, ClassNotFoundException {
        controller.connectIfNot();
        for (String sql : prepareSQLs) {
            controller.prepareStatement(sql);
        }
    }

    @Override
    public void transferMoney(String from, String to, int val) {
        try {
            controller.beginTransaction();
            increaseAccountAmount(from, -val);
            increaseAccountAmount(to, val);
            controller.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void selectAccount() {
        try {
            controller.beginTransaction();
            Statement stmt = controller.executeStatement(prepareSQLs[0]);
            System.out.println("Table:account(PostgreSQL)");
            System.out.println("name    \tdeposit    \t");
            System.out.println("----------------------------");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString("name") + "    \t"
                        + rs.getString("deposit") + "    \t");
            }
            controller.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            controller.disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
