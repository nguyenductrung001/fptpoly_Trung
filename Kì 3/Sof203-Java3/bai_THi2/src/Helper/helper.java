/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Class.Student;
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
public class helper {

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
                JOptionPane.showMessageDialog(null, "Kết nối thành công!");
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

    public static void themDatavaoTable(DefaultTableModel model) {

        try {
            Connection con = ketnoi("TestAss1");
            String sql = "select SinhVien.MaSV,HoTenSV,GioiTinh,MONHOC.MaMH,TenMH,DIEM.diem from Diem inner join SINHVIEN on DIEM.Masv = SINHVIEN.MaSV\n"
                    + "					inner join MONHOC on DIEM.MaMH = MONHOC.MaMH\n";
            Statement stm = con.createStatement();
//            pstm.setNString(1, Mamh);
            ResultSet rs = stm.executeQuery(sql);
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getNString("MaSV"), rs.getNString("HoTenSV"),
                    rs.getNString("GioiTinh"),
                    rs.getNString("Mamh"), 
                    rs.getNString("TenMH"),
                    rs.getFloat("Diem")});
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi load thêm vào Data");
        }
    }

    public static void themDatavaoComboBox(DefaultComboBoxModel model_cbo) {
        try {
            Connection con = ketnoi("TestAss1");
            String sql = "select MonHoc.Mamh from MonHoc ";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String Mamh = rs.getNString(1);
                model_cbo.addElement(Mamh);
            }
            stm.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi load thêm vào Data");
        }
    }
//     public static void delete(Student d) {
//        Connection con = ketnoi("TestAss1");
//        String sql = "delete from Diem\n"
//                + "where Masv like ? and Mamh like ? ";
//        try {
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setNString(1, d.MaMH);
//            pstm.setNString(2, d.Masv);
//           int i = pstm.executeUpdate();
//           if(i>0){
//               JOptionPane.showMessageDialog(null, "Xóa thành công!");
//           }else{
//                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
//           }
//           pstm.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Lối phần xóa!");
//        }
//    }

   

    
}
