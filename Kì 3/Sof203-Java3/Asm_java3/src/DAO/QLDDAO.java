/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Data.QLD;
import asm_java3.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Truong Dep Zai
 */
public class QLDDAO {

    public static ArrayList<QLD> getAll() {
        ArrayList<QLD> lst = new ArrayList<>();
        String sql = "SELECT students.masv as masv, hoten,tienganh,tinhoc,gdtc \n"
                + "FROM Students left join grade on students.masv = grade.masv \n"
                + "order by students.masv asc";
        try {
            Statement stm = Main.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                lst.add(new QLD(rs.getNString("masv"),
                        rs.getNString("hoten"),
                        rs.getFloat("tienganh"),
                        rs.getFloat("tinhoc"),
                        rs.getFloat("GDTC")));
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
        }
        return lst;
    }

    public static ArrayList<QLD> getTop3() {
        ArrayList<QLD> lst = new ArrayList<>();
        String sql = "SELECT top 3 students.masv as masv, hoten,tienganh,tinhoc,gdtc \n"
                + "FROM Students left join grade on students.masv = grade.masv \n"
                + "group by students.masv as masv, hoten,tienganh,tinhoc,gdtc"
                + "order by (tienganh + tinhoc + gdtc)/3 desc";
        try {
            Statement stm = Main.conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                lst.add(new QLD(rs.getNString("masv"),
                        rs.getNString("hoten"),
                        rs.getFloat("tienganh"),
                        rs.getFloat("tinhoc"),
                        rs.getFloat("GDTC")));
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
        }
        return lst;
    }

    public static boolean insert(QLD diem) {
        boolean thanhcong = false;
        String sql = "insert into grade(masv,tienganh,tinhoc,gdtc)\n"
                + "values (?,?,?,?)";
        try {
            PreparedStatement pstm = Main.conn.prepareStatement(sql);
            pstm.setNString(1, diem.getMasv());
            pstm.setFloat(2, diem.getTienganh());
            pstm.setFloat(3, diem.getTinhoc());
            pstm.setFloat(4, diem.getGdtc());
            int row = pstm.executeUpdate();
            if (row >= 1) {
                thanhcong = true;
            }
            pstm.close();
        } catch (Exception e) {
        }
        return thanhcong;
    }

    public static boolean update(QLD diem) {
        boolean thanhcong = false;
        String sql = "update grade\n"
                + "set tienganh=?,tinhoc=?,gdtc=?\n"
                + "where masv like ?";
        try {
            PreparedStatement pstm = Main.conn.prepareStatement(sql);
            pstm.setNString(4, diem.getMasv());
            pstm.setFloat(1, diem.getTienganh());
            pstm.setFloat(2, diem.getTinhoc());
            pstm.setFloat(3, diem.getGdtc());
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
        String sql = "delete from grade\n"
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
