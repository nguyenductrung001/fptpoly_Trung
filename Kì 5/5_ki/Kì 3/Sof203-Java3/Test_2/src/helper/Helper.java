/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Class.SinhVien_Test2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Truong Dep Zai
 */
public class Helper {
    
    private static Connection con;
    
    public static synchronized Connection ketnoi(String database) {
        if (con != null) {
            return con;
        } else {
            String user = "sa";
            String pass = "123456";
            String url = "jdbc:sqlserver://localhost:1433" + (database.equals("") ? "" : ";databaseName=" + database);
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                con = DriverManager.getConnection(url, user, pass);
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Kết nối thất bại!");
            }
            return con;
        }
    }
    
    public static synchronized void DongKetNoi() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                
            } finally {
                con = null;
            }
        }
    }
    
    public static void themDatavaoTable(DefaultTableModel model, String Mamh) {
        
        try {
            Connection con = ketnoi("TestAss1");
            String sql = "select SINHVIEN.MaSV , HoTenSV , DIEM.diem from SINHVIEN inner join DIEM on SINHVIEN.MaSV = DIEM.Masv\n"
                    + "where MaMH like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setNString(1, Mamh);
            ResultSet rs = pstm.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getNString("MASV"), rs.getNString("HoTenSV"), rs.getFloat("Diem")});
            }
            pstm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi load Data vào table!");
        }
    }
    
    public static void themDatavaoComboBox(DefaultComboBoxModel model_cbo) {
        try {
            Connection con = ketnoi("TestAss1");
            String sql = "select MonHoc.Mamh from MonHoc ";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String MaSV = rs.getNString(1);
                model_cbo.addElement(MaSV);
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi load combobox");
        }
    }
    
    public static void delete(SinhVien_Test2 d) {
        Connection con = ketnoi("TestAss1");
        String sql = "delete from Diem\n"
                + "where Masv like ? and Mamh like ? ";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setNString(1, d.MaSV);
            pstm.setNString(2, d.MaMH);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
            }
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lối phần xóa!");
        }
    }
}
