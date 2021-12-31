/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Class.SinhVien;
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
     public static void themDatavaoTable(DefaultTableModel model, String Mamh) {

        try {
            Connection con = ketnoi("TestAss1");
            String sql = "select SINHVIEN.MaSV , HoTenSV,DIEM.diem from SINHVIEN inner join DIEM on SINHVIEN.MaSV = DIEM.Masv\n"
                    + "where Mamh like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setNString(1, Mamh);
            ResultSet rs = pstm.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getNString("MaSV"), rs.getNString("HoTenSV"), rs.getFloat("Diem")});
            }
            pstm.close();
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
     public static void delete(SinhVien d) {
        Connection con = ketnoi("TestAss1");
        String sql = "delete from Diem\n"
                + "where Masv like ? and Mamh like ? ";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            // muốn  xóa hay tìm hay gì gì đó thì sql cần phải biết khóa chính của nó... trong bảng 
            //điểm có khóa chính là cụm masv và mamh nên cần cái đó > ok?
            //k.. cần phải đưa khóa chính vào để biêt là xóa dòng nào. 
            // chuẩn. 
            //đấy là sql. ví dụ m muốn xóa 1 dòng trong bảng sql thì làm sao để xác định dòng nào?
            //
            pstm.setNString(2, d.MaMH);// cái preparedstament là dùng để chuẩn bị lệnh sql.
            //trong đó nó sẽ có các dấu ? dùng để đưa tham số vào.
            // khi set tham số thì chỉ mục(index) nó sẽ là từ 1-...
            //theo thứ tự từng dấu ? trong câu lệnh sql set tham số cho nó.
            pstm.setNString(1, d.MaSV);//để sai thứ tự nãy để maasv la mamh nen sai
             // hoặc nếu mà dùng statement thì nó sẽ kiểu
             //ví dụ: sql = "Select * from diem \n"
             // "where  mamh like '" + d.mamh + "'" ; kieu như thế.
             //cái dấu ? đấy là để mình không bị lẫn lộn. 
            // vì nếu viết theo ví dụ thế có thể bị thiếu các dâu ''' mà mình k biết.
            //ok?
           int i = pstm.executeUpdate();
           if(i>0){
               JOptionPane.showMessageDialog(null, "Xóa thành công!");
           }else{
                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
           }
           pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lối phần xóa!");
        }
    }
    
     // phần đặt vào trong form_Thi

     // thêm vào nút delete

     
     // thêm vào mountoinclick

     

     
     
   
}
