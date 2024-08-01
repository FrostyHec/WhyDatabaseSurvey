package experiment.CSVDB;

import experiment.Database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVDatabase implements Database {
    private static final int oneTimeTransferAmountLimit=1;

    public void update(Table table, int row, int column, String val) {
        String[] rowstr = table.getData().get(row);
        rowstr[column] = val;
        try {
            CSVHandler.drop(table.getName());
            CSVHandler.insertAll(table);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void increaseAmount(Table table,int row,int col,int val){
        String[] rowstr = table.getData().get(row);
        int deposit = Integer.parseInt(rowstr[col]);
        if(deposit+val<0) throw new RuntimeException("Not enough money");

    }

    @Override
    public void transferMoney(String from, String to, int val) {
        increaseAccountAmount(from,-val);
        increaseAccountAmount(to,val);
    }
    private void increaseAccountAmount(String username, int val) {
        Table table = null;
        try {
            table = CSVHandler.readFile("account", false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RowContainer row = RowContainer.init(table);
        boolean find = false;
        for (int i = 0; i < table.getData().size(); i++) {
            String[] _rowstr = table.getData().get(i);
            row.putValue(i, _rowstr);
            String nameval = row.getValue("name");
            if (nameval.equals(username)) {
                find = true;
                break;
            }
        }
        if (!find) throw new RuntimeException("Username:" + username + "not found");
        int depositIndex = row.getFieldIndex("deposit");
        increaseAmount(table,row.getRowLine(),depositIndex,val);
    }

    @Override
    public void selectAccount() {
        Table table = null;
        try {
            table = CSVHandler.readFile("account", false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RowContainer row = RowContainer.init(table);
        System.out.println("Table:account");
        System.out.println("name    \tdeposit    \t");
        for (int i = 0; i < table.getData().size(); i++) {
            String[] _rowstr = table.getData().get(i);
            row.putValue(i, _rowstr);
            String nameval = row.getValue("name");
            String depositval = row.getValue("deposit");
            System.out.println(nameval +"    \t"+ depositval+"    \t");
        }
    }

    @Override
    public void close() {
        //do nothing.
    }
}

