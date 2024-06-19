package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaS2", "root", "");
            stmt = conn.createStatement();
            String sqlCreate = "CREATE TABLE Product (id INT, name VARCHAR(255),price DOUBLE, sell BOOLEAN)";
            stmt.executeUpdate(sqlCreate);
            String sqlInsert = "INSERT INTO Product (id, name, price, sell) VALUES " +
                    "(1, 'Coke', 2.00, true), " +
                    "(2, 'Pepsi', 2.00, true), " +
                    "(3, 'Kizz', 1.50, true), " +
                    "(4, 'Redbull', 2.00, true)";
            stmt.executeUpdate(sqlInsert);
            String sqlSelect = "SELECT * FROM Product";
            rs = stmt.executeQuery(sqlSelect);
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                boolean isActive = rs.getBoolean("sell");
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.print(", Price: " + price);
                System.out.println(", Active for Sell: " + isActive);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
