/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Code.Info_students;
import Code.Points;
import Code.loginsg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
            } catch (Exception ex) {
                ex.printStackTrace();
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

    public static loginsg getUses(loginsg x) {
        loginsg u = null;
        try {
            Connection con = helper.openConnection("FPL_daotao");
            String sql = "select username,password,role\n"
                    + "from FPL_daotao.dbo.USERS\n"
                    + "where USERNAME like ? and password like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setNString(1, x.taikhoan);
            pstm.setNString(2, x.matkhau);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                u = new loginsg(rs.getNString("username"), rs.getNString("password"), rs.getNString("role"));
            }
            rs.close();
            pstm.close();
//            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Loi ket noi csdl");
        }
        return u;
    }

    public static void putDataToTable(DefaultTableModel model) {
        try {
            Connection conn = helper.openConnection("FPL_daotao");
            String sql = "Select * from STUDENS\n"
                    + "order by MASV";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                do {
                    String Gioitinh;
                    if (rs.getBoolean("MASV")) {
                        Gioitinh = "Nam";
                    } else {
                        Gioitinh = "Nu";
                    }
                    model.addRow(new Object[]{
                        rs.getNString("MASV"),
                        rs.getNString("Hoten"),
                        rs.getNString("Email"),
                        rs.getNString("SoDT"),
                        Gioitinh,
                        rs.getNString("Diachi"),
                        rs.getNString("Hinh")

                    });
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "chua them sinh vien");
            }
            rs.close();
            stm.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Loi ket noi csdl");
        }
    }

    public static void insertSV(Info_students x) {
        Connection conn = helper.openConnection("FPL_daotao");
        String sql = "insert into Studens(MASV,Hoten,Email,SoDT,Gioitinh,Diachi,Hinh)\n"
                + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setNString(1, x.MaSV);
            pstm.setNString(2, x.Hoten);
            pstm.setNString(3, x.email);
            pstm.setNString(4, x.SDT);
            pstm.setBoolean(5, x.gioitinh);
            pstm.setNString(6, x.Diachi);
            pstm.setNString(7, x.hinh);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Them thanh cong");
            } else {
                JOptionPane.showMessageDialog(null, "them that bai");
            }
            pstm.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ket noi that bai");
        }
    }

    public static void updateSV(Info_students x) {
        Connection conn = helper.openConnection("FPL_daotao");
        String sql = "update Studens\n"
                + "set Hoten=?,Email=?,SoDT=?,Gioitinh=?,Diachi=?,Hinh=?\n"
                + "where MASV like ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setNString(7, x.MaSV);
            pstm.setNString(1, x.Hoten);
            pstm.setNString(2, x.email);
            pstm.setNString(3, x.SDT);
            pstm.setBoolean(4, x.gioitinh);
            pstm.setNString(5, x.Diachi);
            pstm.setNString(6, x.hinh);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Update thanh cong");
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

    public static void deleteSV(Info_students x) {
        Connection conn = helper.openConnection("FPL_daotao");
        String sql = "delete from Studens\n"
                + "where MASV like ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setNString(1, x.MaSV);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Delete thanh cong sinh vien");
            } else {
                JOptionPane.showMessageDialog(null, "Delete that bai sinh vien");
            }
            pstm.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ket noi that bai");
        }
    }

    // quan ly diem 
    public static void insertPoint(Points x) {
        Connection conn = helper.openConnection("FPL_daotao");
        String sql = "insert into GRADE(MASV,tienganh,tinhoc,gdtc)\n"
                + "values(?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setNString(1, x.mssv);
            pstm.setFloat(2, x.tienganh);
            pstm.setFloat(3, x.tinhoc);
            pstm.setFloat(4, x.gdtc);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Them thanh cong");
            } else {
                JOptionPane.showMessageDialog(null, "them that bai");
            }
            pstm.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ket noi that bai");
        }
    }

    public static void updatePoint(Points x) {
        Connection conn = helper.openConnection("FPL_daotao");
        String sql = "update GRADE\n"
                + "set tienganh=?,tinhoc=?,gdtc=?\n"
                + "where MASV like ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setNString(4, x.mssv);
            pstm.setFloat(1, x.tienganh);
            pstm.setFloat(2, x.tinhoc);
            pstm.setFloat(3, x.gdtc);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Update thanh cong");
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

    public static void deletePoint(Points x) {
        Connection conn = helper.openConnection("FPL_daotao");
        String sql = "delete from GRADE\n"
                + "where MASV like ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setNString(1, x.mssv);
            int i = pstm.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Delete thanh cong diem");
            } else {
                JOptionPane.showMessageDialog(null, "Delete that bai diem");
            }
            pstm.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ket noi that bai");
        }
    }

    public static void putTop3DataToTable(DefaultTableModel model) {
        try {
            Connection conn = helper.openConnection("FPL_daotao");
            String sql = "Select top 3 GRADE.MASV as MASV,hoten,tienganh,tinhoc,gdtc\n"
                    + "from GRADE inner join Studens on GRADE.MASV = Studens.MASV\n"
                    + "order by (tienganh+tinhoc+gdtc)/3 desc";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                do {
                    Points d = new Points(
                            rs.getNString("MASV"),
                            rs.getNString("Hoten"),
                            rs.getFloat("tienganh"),
                            rs.getFloat("tinhoc"),
                            rs.getFloat("gdtc")
                    );
                    model.addRow(new Object[]{
                        d.mssv,
                        d.hoten,
                        d.tienganh,
                        d.tinhoc,
                        d.gdtc,
                        d.layDiemTb()

                    });
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "chua them diem sinh vien");
            }
            rs.close();
            stm.close();
//            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Loi ket noi csdl");
        }
    }

    public static Points checkPoint(String masv) {
        Points p = null;
        Connection conn = helper.openConnection("FPL_daotao");
        String sql = "Select studens.MASV as MASV,hoten,tienganh,tinhoc,gdtc\n"
                + "from GRADE right outer join Studens on GRADE.MASV = Studens.MASV\n"
                + "where GRADE.MASV like ?";
        try {

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setNString(1, masv);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                p = new Points(masv,
                        rs.getNString("hoten"),
                        rs.getFloat("tienganh"),
                        rs.getFloat("tinhox"),
                        rs.getFloat("gdtc"));
            }
            rs.close();
            pstm.close();
//            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public static ArrayList<Points> getAllPoint() {
        ArrayList<Points> list = null;
        Connection conn = helper.openConnection("FPL_daotao");
        String sql = "Select Studens.MASV as MASV,hoten,tienganh,tinhoc,gdtc\n"
                + "from GRADE right outer join Studens on GRADE.MASV = Studens.MASV\n"
                + "order by MASV";
        try {

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                list = new ArrayList<>();
                do {
                    list.add(new Points(rs.getNString("MASV"),
                            rs.getNString("hoten"),
                            rs.getFloat("tienganh"),
                            rs.getFloat("tinhoc"),
                            rs.getFloat("gdtc")));
                } while (rs.next());
            }
            rs.close();
            stm.close();
//            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
