/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Truong Dep Zai
 */
public class SQLConnect {

    private static Connection connection;

    public static synchronized Connection openConnection() {
        if (connection != null) {
            return connection;
        } else {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=SOF203";
            String user = "sa";
            String pass = "123456";
            try {
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
    }
}
