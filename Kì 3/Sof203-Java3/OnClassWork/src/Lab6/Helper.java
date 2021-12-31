/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user-ma
 */
public class Helper {

    private static Connection connection;

    public static synchronized Connection openConnection(String dbName) {
        if (connection != null) {
            return connection;
        } else {

            String url = "jdbc:sqlserver://localhost:1433" + (dbName.equals("") ? "" : ";databaseName=" + dbName);
            String user = "sa";
            String pass = "123456";
            try {
                //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return connection;
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
    }//create 
}
