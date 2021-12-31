/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import GUI.QLDT.DienThoai;
import java.sql.PreparedStatement;

/**
 *
 * @author ma-user
 */
public class PhoneHelper {
    public static boolean insert(DienThoai dt) {
        boolean thanhcong = false;
        String sql = "insert into Phone(id,name,amount,sell_price,buy_price,ram,rom,sim,color,front_cam,behind_cam,screen,os)\n"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = Helper.connection.prepareStatement(sql);
            pstm.setNString(1, dt.getMaDT());
            pstm.setNString(2, dt.getTenDT());
            pstm.setInt(3, dt.getSoLuong());
            pstm.setDouble(4, dt.getGiaBan());
            pstm.setDouble(5, dt.getGiaNhap());
            pstm.setInt(6, dt.getRam());
            pstm.setInt(7, dt.getBoNHoTrong());
            pstm.setInt(8, dt.getTheSim());
            pstm.setInt(9, dt.getMauSac());
            pstm.setInt(10, dt.getCamTruoc());
            pstm.setInt(11, dt.getCamSau());
            pstm.setInt(12, dt.getManHinh());
            pstm.setInt(13, dt.getHeDieuHanh());
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
