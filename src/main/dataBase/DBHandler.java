package main.dataBase;

import java.sql.*;
import java.util.ArrayList;

public class DBHandler {
    private Connection connection;
    private static final DBHandler dbHandler = new DBHandler();

    private DBHandler() {}
    public static DBHandler getDBHandler() {
        return dbHandler;
    }
    private void getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while(rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"),
                        rs.getString("middlename"), rs.getString("birthday"), rs.getString("iin"),
                        rs.getString("subscription"), rs.getString("note")));
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return users;
    }
    public void printAllUsers() {
        try {
            getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while(rs.next()) {
                System.out.println();
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("name = " + rs.getString("name"));
                System.out.println("lastname = " + rs.getString("lastname"));
                System.out.println("middlename = " + rs.getString("middlename"));
                System.out.println("birthday = " + rs.getString("birthday"));
                System.out.println("iin = " + rs.getString("iin"));
                System.out.println("subscription = " + rs.getString("subscription"));
                System.out.println("note = " + rs.getString("note"));
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }
    public void addUser(String name, String lastName, String middleName, String birthday, String iin, String subscription, String note) {
        try {
            getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into users(name, lastname, middlename, birthday, iin, subscription, note) " +
                    "values('" + name + "', '" + lastName + "', '" + middleName + "', '" + birthday + "', '" + iin + "', '" + subscription + "', '" + note + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
    }
    public void connectionDB() {
        try {
            getConnection();
            Statement statement = connection.createStatement();
            //statement.executeUpdate("drop table users");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name VARCHAR(50), lastname VARCHAR(50), middlename VARCHAR(50), birthday VARCHAR(50), iin VARCHAR(50), " +
                    "subscription VARCHAR(50), note VARCHAR(250), pathimage VARCHAR(250))");
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            if(connection != null)
                connection.close();
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
