package ru.geekbrains.java3.lesson2;

import java.sql.*;

public class MainClass {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();
            dropTableEx();
            createTableEx();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id = -100;");
            if(rs == null) {
                System.out.println("ooo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void rollbackEx() throws SQLException {
        stmt.execute("INSERT INTO students (name, score) VALUES ('bob1', 10);");
        Savepoint sp1 = connection.setSavepoint();
        stmt.execute("INSERT INTO students (name, score) VALUES ('bob2', 20);");
        connection.rollback(sp1);
        stmt.execute("INSERT INTO students (name, score) VALUES ('bob3', 30);");
        connection.setAutoCommit(true);
    }

    private static void psBatchEx() throws SQLException {
        long t = System.currentTimeMillis();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);");
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++) {
            ps.setString(1, "Bob" + i);
            ps.setInt(2, (i * 10) % 100);
            ps.addBatch();
            if (i % 50000 == 0) {
                ps.executeBatch();
            }
        }
        connection.setAutoCommit(true);
        System.out.println(System.currentTimeMillis() - t);
    }

    private static void transactionEx() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 1000000; i++) {
            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('bob', 10);");
        }
        connection.setAutoCommit(true);
    }

    private static void dropTableEx() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS students;");
    }

    private static void createTableEx() throws SQLException {
        stmt.execute("CREATE TABLE IF NOT EXISTS students (\n" +
                "    id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name  TEXT,\n" +
                "    score INTEGER\n" +
                ");");
    }

    private static void deleteEx() throws SQLException {
        stmt.executeUpdate("DELETE FROM students WHERE id = 2;");
    }

    private static void updateEx() throws SQLException {
        stmt.executeUpdate("UPDATE students SET score = 100 WHERE id = 4;");
    }

    private static void insertEx() throws SQLException {
        String sqlInsert = "INSERT INTO students (name, score) VALUES ('bob4', 40);";
        stmt.executeUpdate(sqlInsert);
    }

    private static void selectEx() throws SQLException {
        String sqlQuery = "SELECT * FROM students;";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
