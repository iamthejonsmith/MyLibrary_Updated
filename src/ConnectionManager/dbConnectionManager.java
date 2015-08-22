/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class dbConnectionManager {

    static Connection conn1 = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // connect way #1
            String url1 = "jdbc:mysql://localhost:3306/my_library";
            String user = "root";
            String password = "nitemare79";

            conn1 = DriverManager.getConnection(url1, user, password);
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Is the Username/Password you entered correct?");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "I'm sorry, it seems that something went wrong!");
        }
    return conn1;
    }
}
