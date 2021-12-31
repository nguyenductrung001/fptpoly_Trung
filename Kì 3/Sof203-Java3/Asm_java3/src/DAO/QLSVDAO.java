/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Data.QLSV;
import asm_java3.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Truong Dep Zai
 */
public class QLSVDAO {

    public static void showDataToTable(DefaultTableModel model) {
        String sql = "SELECT *\n"
                + "FROM STUDENTS\n"
                + "order by masv asc";
        try {
            Statement stm = Main.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getNString("Masv"),
                    rs.getNString("hoten"),
                    rs.getNString("email"),
                    rs.getNString("sodt"),
                    (rs.getBoolean("gioitinh") ? "Nam" : "Nữ"),
                    rs.getNString("diachi"),
                    rs.getNString("hinh"),});
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean insert(QLSV sv) {
        boolean thanhcong = false;
        String sql = "insert into students(masv,hoten,email,sodt,gioitinh,diachi,hinh)\n"
                + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = Main.conn.prepareStatement(sql);
            pstm.setNString(1, sv.getMaSV());
            pstm.setNString(2, sv.getHoTen());
            pstm.setNString(3, sv.getEmail());
            pstm.setNString(4, sv.getSDT());
            pstm.setBoolean(5, sv.isGioitinh());
            pstm.setNString(6, sv.getDiaChi());
            pstm.setNString(7, sv.getImg());

            int row = pstm.executeUpdate();
            if (row >= 1) {
                thanhcong = true;
            }
            pstm.close();
        } catch (Exception e) {
        }
        return thanhcong;
    }

    public static boolean update(QLSV sv) {
        boolean thanhcong = false;
        String sql = "update students\n"
                + "set hoten=?,email=?,sodt=?,gioitinh=?,diachi=?,hinh=? \n"
                + "where masv like ?";
        try {
            PreparedStatement pstm = Main.conn.prepareStatement(sql);
            pstm.setNString(7, sv.getMaSV());
            pstm.setNString(1, sv.getHoTen());
            pstm.setNString(2, sv.getEmail());
            pstm.setNString(3, sv.getSDT());
            pstm.setBoolean(4, sv.isGioitinh());
            pstm.setNString(5, sv.getDiaChi());
            pstm.setNString(6, sv.getImg());

            int row = pstm.executeUpdate();
            if (row >= 1) {
                thanhcong = true;
            }
            pstm.close();
        } catch (Exception e) {
        }
        return thanhcong;
    }

    public static boolean delete(String masv) {
        boolean thanhcong = false;
        String sql = "delete from students\n"
                + "where masv like ?";
        try {
            PreparedStatement pstm = Main.conn.prepareStatement(sql);
            pstm.setNString(1, masv);

            int row = pstm.executeUpdate();
            if (row >= 1) {
                thanhcong = true;
            }
            pstm.close();
        } catch (Exception e) {
        }
        return thanhcong;
    }
}
