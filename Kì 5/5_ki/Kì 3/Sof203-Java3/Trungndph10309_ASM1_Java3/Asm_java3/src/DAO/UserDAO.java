/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Data.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Truong Dep Zai
 */
public class UserDAO {

    public static ArrayList<User> getAllUsers() {
        Connection con = SQLConnect.openConnection();
        ArrayList<User> list = new ArrayList<>();
        String sql = "Select * from QLGVSV.dbo.USERS";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                list.add(new User(rs.getNString("username"), rs.getNString("password"), rs.getNString("role")));
            }
            stm.close();
            SQLConnect.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
            list = null;
        }
        return list;
    }
}
