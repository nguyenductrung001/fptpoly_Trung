/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

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
 * @author manhk
 */
public class helper {
        private static Connection connection;

    public static synchronized Connection openConnection(String dbName) {
        if (connection != null) {
            return connection;
        } else {

            String url = "jdbc:sqlserver://localhost:1433" + (dbName.equals("") ? "" : ";databaseName=" + dbName);
            String user = "sa";
            String pass = "1";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url, user, pass);
                 JOptionPane.showMessageDialog(null, "ket noi thanh cong");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "ket noi that bai");
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
    public static void putDataToTable(DefaultTableModel model, String Masv){
             try {
            Connection conn = helper.openConnection("TestAss1");
            String sql = "Select Diem.MaMH, Diem, TenMH \n"
                    + "from DIEM inner join MONHOC on DIEM.MAMH = MONHOC.MAMH\n"
                    + "where MASV like ?";
                   PreparedStatement pstm = conn.prepareStatement(sql);
                   pstm.setNString(1, Masv);
                   ResultSet rs = pstm.executeQuery();
                   model.setRowCount(0);
             while (rs.next()) {                
                    model.addRow(new Object[]{
                        rs.getNString("MaMH"),
                        rs.getNString("TenMH"),
                        rs.getFloat("Diem")
                    });
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Loi ket noi csdl");
        }
    }
    public static void putDataToCombo(DefaultComboBoxModel model_cb){
         try {
            Connection con = openConnection("TestAss1");
            String sql = "select MaSV from Diem ";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String MaSV = rs.getNString(1);
                model_cb.addElement(MaSV);
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi load thêm vào Data");
        }
              
    }
    public static void insertDate(Code.code x){
          Connection conn = helper.openConnection("Testass1");
        String sql = "insert into Diem(masv,MaMH,Diem)\n"
                + "values(?,?,?)"; 
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setNString(1, x.masv);
            pstm.setNString(2, x.ma);
            pstm.setFloat(3, x.diem);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Them thanh cong");
            } else {
                JOptionPane.showMessageDialog(null, "them that bai");
            }
            pstm.close();
//            conn.close();
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ket noi that bai");
        }
    }
     public static void updateDate(Code.code x){
         Connection conn = helper.openConnection("TestAss1");
        String sql = "update Diem\n"
                + "set diem=?\n"
                + "where masv like ? and mamh like ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setFloat(1, x.diem);
            pstm.setNString(2, x.masv);
            pstm.setNString(3, x.ma);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "update thanh cong");
            } else {
                JOptionPane.showMessageDialog(null, "update that bai");
            }
            pstm.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ket noi that bai");
        }
    }
     public static void deletePoint(Code.code x){
          Connection con = openConnection("TestAss1");
        String sql = "delete from Diem\n"
                + "where Masv like ? and Mamh like ? ";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setNString(1, x.masv);
            pstm.setNString(2, x.ma);
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

