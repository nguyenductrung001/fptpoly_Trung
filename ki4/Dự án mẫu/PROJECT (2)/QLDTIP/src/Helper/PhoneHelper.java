/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import GUI.QLDT.DienThoai_Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ma-user
 */
public class PhoneHelper {

    public static boolean insert(DienThoai_Class dt) {
        boolean thanhcong = false;
        String sql = "insert into Phone(id,name,amount,sell_price,details,ram,rom,sim,colour,front_cam,behind_cam,screen,os,phone_state)\n"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
        try {
            PreparedStatement pstm = Helper.connection.prepareStatement(sql);
            pstm.setNString(1, dt.getMaDT());
            pstm.setNString(2, dt.getTenDT());
            pstm.setInt(3, dt.getSoLuong());
            pstm.setDouble(4, dt.getGiaBan());
            pstm.setNString(5, dt.getDetails());
            pstm.setNString(6, dt.getRam());
            pstm.setNString(7, dt.getBoNHoTrong());
            pstm.setNString(8, dt.getTheSim());
            pstm.setNString(9, dt.getMauSac());
            pstm.setNString(10, dt.getCamTruoc());
            pstm.setNString(11, dt.getCamSau());
            pstm.setNString(12, dt.getManHinh());
            pstm.setNString(13, dt.getHeDieuHanh());
            int row = pstm.executeUpdate();
            if (row >= 1) {
                thanhcong = true;

            }
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thanhcong;

    }

    public static DienThoai_Class getDienThoai_Class(String maDt) {
        DienThoai_Class dt = new DienThoai_Class();
        String sql = "Select* from Phone where id like ?";
        try {
            PreparedStatement pstm = Helper.connection.prepareStatement(sql);
            pstm.setNString(1, maDt);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                dt.MaDT = rs.getNString("id");
                dt.BoNHoTrong = rs.getNString("rom");
                dt.CamSau = rs.getNString("Bcam");
                dt.CamTruoc = rs.getNString("Fcam");
                dt.Details = rs.getNString("Details");
                dt.HeDieuHanh = rs.getNString("os");
                dt.ManHinh = rs.getNString("Screen");
                dt.MauSac = rs.getNString("colour");
                dt.Ram = rs.getNString("ram");
                dt.SoLuong = rs.getInt("amount");
                dt.TenDT = rs.getNString("name");
                dt.TheSim = rs.getNString("sim");
                dt.GiaBan = rs.getDouble("sell_price");

            }
        } catch (Exception e) {
            return null;
        }
        return dt;
    }

    public static ArrayList<DienThoai_Class> getListPhone() {
        ArrayList<DienThoai_Class> lst = new ArrayList<>();
        String sql = "Select* from Phone";
        try {
            PreparedStatement ps = Helper.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DienThoai_Class dt = new DienThoai_Class();
                dt.setMaDT(rs.getNString("Id"));
                dt.setTenDT(rs.getNString("name"));
                dt.setSoLuong(rs.getInt("amount"));
                dt.setGiaBan(rs.getDouble("sell_price"));
                dt.setDetails(rs.getNString("Details"));
                dt.setRam(rs.getNString("ram"));
                dt.setBoNHoTrong(rs.getNString("rom"));
                dt.setTheSim(rs.getNString("sim"));
                dt.setMauSac(rs.getNString("colour"));
                dt.setCamTruoc(rs.getNString("Front_cam"));
                dt.setCamSau(rs.getNString("Behind_cam"));
                dt.setManHinh(rs.getNString("Screen"));
                dt.setHeDieuHanh(rs.getNString("os"));
                lst.add(dt);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
     public static void deleteDT(DienThoai_Class x) {
        DienThoai_Class dt = new DienThoai_Class();
        String sql = "delete from Phone\n"
                + "where Id like ?";
        try {
            
            PreparedStatement pstm = Helper.connection.prepareStatement(sql);
            pstm.setString(1, x.MaDT);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Delete thanh cong ");
            } else {
                JOptionPane.showMessageDialog(null, "Delete that bai ");
            }
            pstm.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ket noi that bai");
        }
    }
     public static  boolean update(DienThoai_Class x){
         boolean thanhcong = false;
         DienThoai_Class dt = new DienThoai_Class();
         String sql ="update phone\n"
                 + "set name =?, amount =?,sell_price = ?,details = ?, screen=?, colour = ?, os = ?,front_cam=?,behind_cam=?,ram=?,rom=?,sim=?"
                 + "where maDT like ?";
         try {
             PreparedStatement ps = Helper.connection.prepareStatement(sql);
             ps.setNString(13, x.MaDT);
             ps.setNString(1, x.TenDT);
             ps.setInt(2, x.SoLuong);
             ps.setDouble(3, x.GiaBan);
             ps.setNString(4, x.Details);
             ps.setNString(5, x.ManHinh);
             ps.setNString(6, x.MauSac);
             ps.setNString(7, x.HeDieuHanh);
             ps.setNString(8, x.CamTruoc);
             ps.setNString(9, x.CamSau);
             ps.setNString(10, x.Ram);
             ps.setNString(11, x.BoNHoTrong);
             ps.setNString(12, x.TheSim);
             int row = ps.executeUpdate();
             if(row>=1){
                 thanhcong = true;
                }
             ps.close();
         } catch (Exception e) {
         }
         return thanhcong;
     }

    
}
