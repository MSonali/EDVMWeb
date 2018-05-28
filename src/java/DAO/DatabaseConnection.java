/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author Welcome
 */
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection con;
        public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection successful!");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed" + e);
        }
        String url = "jdbc:mysql://localhost:3306/edvmDB";
        try {
            con = (Connection) DriverManager.getConnection(url, "root", "root");
            System.out.println("Database Connected");
        } catch (SQLException se) {
            System.out.println("No Database" + se);
        }
        return con;
    }

    }
