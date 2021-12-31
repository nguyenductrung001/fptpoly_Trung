/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Truong Dep Zai
 */
public class helper {
    public static Connection ketnoi(String database) {
        try {
            String user = "sa";
            String pass = "123456";
            String url = "jdbc:sqlserver://localhost:1433" + (database.equals("") ? "" : ";databaseName=" + database);
            Connection cn = DriverManager.getConnection(url, user, pass);
            return cn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
