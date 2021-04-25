/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rezabdullah
 */
public class Database {
    private static Connection MySQLCon;
    private static String host = "localhost";
    private static String port = "3306";
    private static String dbname = "kkp";
    private static String username = "root";
    private static String passsword = "";

    public static Connection ConnectDB() throws SQLException{
        try {
            String DBUrl = "jdbc:mysql://"+ host +":"+ port +"/"+ dbname;
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLCon = DriverManager.getConnection(DBUrl, username, passsword);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghubungkan ke DB, error => " + e.getMessage(), "Terjadi kesalahan" , JOptionPane.ERROR_MESSAGE);
        }
        
        return MySQLCon;
    }
}
