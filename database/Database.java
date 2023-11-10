package lab7out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final Connection connection;
    public Database2() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_space",
                    "student",
                    "hello");
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    public static void main(String[] args) {
        new Database();
    }
}