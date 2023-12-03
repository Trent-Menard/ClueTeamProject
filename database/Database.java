package database;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    private boolean isConnected;
    public Database() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_space",
                    "student",
                    "hello");
            this.isConnected = true;
        } catch (SQLException e) {
            System.err.println("[Error:] Couldn't connect to the database (is it online?).\n");
            this.isConnected = false;
//            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> query(String query) {

        ArrayList<String> queryResult = new ArrayList<>();

        try(Statement statement = this.connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    queryResult.add(resultSet.getString(i));
                    if (i < columnCount)
                        queryResult.add(",");
                }
            }

            if (queryResult.isEmpty())
                return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return queryResult;
    }

    public void executeDML(String dml) throws SQLException
    {
        Statement stmt = this.connection.createStatement();
        stmt.execute(dml);
    }

    public boolean checkUserExists(String username) {
        ArrayList<String> queryUsername = query("SELECT username FROM clueaccounts WHERE username='" + username + "'");
        return queryUsername != null;
    }

    public boolean verifyUser(String username, String password) {
        ArrayList<String> queryUsername = query("SELECT username FROM clueaccounts WHERE username='" + username + "'");

        if (queryUsername != null) {
            // Username is PK so can only be 1 entry.
            String queryUsernameResult = queryUsername.get(0);

            // Password always Non-Null (can't have Username w/o Password).
            String actualPassword = query("SELECT password FROM clueaccounts WHERE username='" + username + "'").get(0);

            return username.equalsIgnoreCase(queryUsernameResult) && password.equals(actualPassword);
        }

        return false;
    }

    public void addUser(String username, String password) {
        try {
            executeDML("INSERT INTO clueaccounts (username, password) VALUES('" + username + "','" + password + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getUserID(String username) {
        ArrayList<String> queryID = query("SELECT id FROM clueaccounts WHERE username='" + username + "'");
        if (queryID == null) {
            // No user exists w/ that ID.
            return -1;
        }
        return Integer.parseInt(queryID.get(0));
    }

    public static void main(String[] args) {
        new Database();
    }

    public boolean isConnected() {
        return isConnected;
    }
}