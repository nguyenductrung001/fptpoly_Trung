/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Truong Dep Zai
 */
public class SQLHelPer {
    public static Connection com;
    public static synchronized Connection OpenConnection(){
    if(com !=null){
        return com;
    }else{
        String url ="jdbc:sqlserver://localhost:1433;databaseName=QLSV";
        String user ="sa";
        String pass ="123456";
        try {
            com = DriverManager.getConnection(url,user,pass);
            return com;
        } catch (SQLException ex) {
           return null;
        }
    }
    }
    public static synchronized  void closeConnection(){
        try {
            if(com != null){
                com.close();
            }
        } catch (Exception e) {
        }finally{
            com = null;
        }
        
    }
    
}
