/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ma-user
 */
public class Helper {

    public static Connection connection;

    public static synchronized boolean openConnection() {
        if (connection != null) {
            return true;
        } else {
            try {
                String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDTIP";
                String u = "sa";
                String p = "Mvh123456aA@";
                connection = DriverManager.getConnection(url, u, p);
            } catch (Exception e) {
                connection = null;
                return false;
            }
        }
        return true;
    }

    public static synchronized void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {

            } finally {
                connection = null;
            }
        }
    }
}
