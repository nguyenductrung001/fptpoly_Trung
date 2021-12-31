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
 * @author Truong Dep Zai
 */
public class Helper {

    public static Connection connection;

    public static synchronized Connection openConnection() {
        if (connection != null) {
            return connection;
        } else {

            String url = "jdbc:sqlserver://localhost:1433" + (QLDTIP.equals("") ? "" : ";databaseName=" + dbName);
            String user = "sa";
            String pass = "123456";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url, user, pass);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }

    public static synchronized void closeConnection() {
    }
}
