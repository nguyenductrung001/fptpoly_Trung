/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Students;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Truong Dep Zai
 */
public class Students_Dao {

    public static ArrayList<Students> GetAllStudent() {
        ArrayList<Students> lst = new ArrayList<>();
        Connection conn = SQLHelPer.OpenConnection();
        String sql = "Select *\n"
                + " from Students";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String MaSV = rs.getNString("MaSV");
                String HoTen = rs.getNString("HoTen");
                String Email = rs.getNString("Email");
                String SDT = rs.getNString("SoDienThoai");
                String DiaChi = rs.getNString("DiaChi");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                Students s = new Students(MaSV, HoTen, Email, SDT, DiaChi, GioiTinh);
                lst.add(s);
            }
            stm.close();
        } catch (SQLException ex) {

        }
        return lst;
    }

    public static Students GetStudent(String MaSV) {
        Students s = null;
        Connection conn = SQLHelPer.OpenConnection();
        String sql = "Select *\n"
                + " from Students";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setNString(1, MaSV);
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                String HoTen = rs.getNString("HoTen");
                String Email = rs.getNString("Email");
                String SDT = rs.getNString("SoDienThoai");
                String DiaChi = rs.getNString("DiaChi");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                s = new Students(MaSV, HoTen, Email, SDT, DiaChi, GioiTinh);
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {

        }
        return s;
    }

    public static boolean insert(Students s) {
        boolean thanhcong = false;
        Connection conn = SQLHelPer.OpenConnection();
        String sql = "insert into Students(MaSV,HoTen,Email,SoDienThoai,GioiTinh,DiaChi)\n"
                + " values(?,?,?,?,?,?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setNString(1, s.getMaSV());
            stm.setNString(2, s.getHoTen());
            stm.setNString(3, s.getEmail());
            stm.setNString(4, s.getSDT());
            stm.setNString(6, s.getDiaChi());
            stm.setBoolean(5, s.isGioiTinh());

            int row = stm.executeUpdate();
            if (row > 0) {
                thanhcong = true;
            }
            stm.close();
        } catch (Exception e) {
        }
        SQLHelPer.closeConnection();
        return thanhcong;
    }

    public static boolean UpDate(Students s) {
        boolean thanhcong = false;
        Connection conn = SQLHelPer.OpenConnection();
        String sql = "update Students\n"
                + " set HoTen=?, Email=?, SoDienThoai = ?,GioiTinh = ?,DiaChi=?"
                + "Where masv = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setNString(6, s.getMaSV());
            stm.setNString(1, s.getHoTen());
            stm.setNString(2, s.getEmail());
            stm.setNString(3, s.getSDT());
            stm.setNString(5, s.getDiaChi());
            stm.setBoolean(4, s.isGioiTinh());

            int row = stm.executeUpdate();
            if (row > 0) {
                thanhcong = true;
            }
            stm.close();
        } catch (Exception e) {
        }
        SQLHelPer.closeConnection();
        return thanhcong;
    }

    public static boolean Delete(Students s) {
        boolean thanhcong = false;
        Connection conn = SQLHelPer.OpenConnection();
        String sql = "Delete from Students\n"
                + "Where MaSV = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setNString(1, s.getMaSV());
            int row = stm.executeUpdate();
            if (row > 0) {
                thanhcong = true;
            }
            stm.close();
        } catch (Exception e) {
        }
        SQLHelPer.closeConnection();
        return thanhcong;
    }
}
