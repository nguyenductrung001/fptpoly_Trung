/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import GUI.Main;
import Model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ma-user
 */
public class EmployerHelper {

    public static Employee getEmployee(String user, String pass) {
        Employee e = new Employee();
        String sql = "Select * from employee\n"
                + "where username like ? collate SQL_Latin1_General_CP1_CS_AS "
                + "and passwd like ? collate SQL_Latin1_General_CP1_CS_AS";
        try {
            PreparedStatement stm = Helper.connection.prepareStatement(sql);
            stm.setNString(1, user);
            stm.setNString(2, pass);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                e.setUsername(rs.getNString("username"));
                e.setPasswd(rs.getNString("passwd"));
                e.setName(rs.getNString("name"));
                e.setDateofbirth(rs.getDate("dateofbirth"));
                e.setAddress(rs.getNString("addres"));
                e.setEmail(rs.getNString("email"));
                e.setPhone(rs.getNString("phone"));
                e.setPic(rs.getNString("pic"));
                e.setPosition(rs.getNString("position"));
                e.setSalary(rs.getDouble("salary"));
            }
        } catch (Exception ex) {
        }
        return e;
    }

    public static boolean getEmployeeByPhone(String phone) {
        String sql = "Select * from employee\n"
                + "where username like ? ";
        try {
            PreparedStatement stm = Helper.connection.prepareStatement(sql);
            stm.setNString(1, phone);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
        }
        return false;
    }

    public static boolean getEmployeeByEmail(String email) {
        String sql = "Select * from employee\n"
                + "where username like ? ";
        try {
            PreparedStatement stm = Helper.connection.prepareStatement(sql);
            stm.setNString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
        }
        return false;
    }

    public static Employee getEmployee(String user) {
        Employee e = new Employee();
        String sql = "Select * from employee\n"
                + "where username like ? ";
        try {
            PreparedStatement stm = Helper.connection.prepareStatement(sql);
            stm.setNString(1, user);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                e.setUsername(rs.getNString("username"));
                e.setPasswd(rs.getNString("passwd"));
                e.setName(rs.getNString("name"));
                e.setDateofbirth(rs.getDate("dateofbirth"));
                e.setAddress(rs.getNString("addres"));
                e.setEmail(rs.getNString("email"));
                e.setPhone(rs.getNString("phone"));
                e.setPic(rs.getNString("pic"));
                e.setPosition(rs.getNString("position"));
                e.setSalary(rs.getDouble("salary"));
            }
        } catch (Exception ex) {
        }
        return e;
    }

    public static ArrayList<Employee> getAllEmployee(String name) {
        ArrayList<Employee> employees = new ArrayList<>();
        String sql = "Select * from employee\n"
                + "where name like ? and not (position = 'DN')\n"
                + "order by username asc";
        try {
            PreparedStatement stm = Helper.connection.prepareStatement(sql);
            stm.setNString(1, name.equals("") ? "%" : name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setUsername(rs.getNString("username"));
                e.setPasswd(rs.getNString("passwd"));
                e.setName(rs.getNString("name"));
                e.setDateofbirth(rs.getDate("dateofbirth"));
                e.setAddress(rs.getNString("addres"));
                e.setEmail(rs.getNString("email"));
                e.setPhone(rs.getNString("phone"));
                e.setPic(rs.getNString("pic"));
                e.setPosition(rs.getNString("position"));
                e.setSalary(rs.getDouble("salary"));
                employees.add(e);
            }
        } catch (Exception ex) {
        }

        return employees;
    }

    public static boolean changePass(String pass) {
        try {
            String sql = "UPDATE EMPLOYEE\n"
                    + "set passwd = ?\n"
                    + "where username = ?";
            PreparedStatement pstm = Helper.connection.prepareStatement(sql);
            pstm.setNString(1, pass);
            pstm.setNString(2, Main.user.getUsername());
            int i = pstm.executeUpdate();
            if (i == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static int getNumberImployee() {
        int i;
        try {
            String sql = "SELECT COUNT(*) AS SL FROM EMPLOYEE";
            Statement stm = Helper.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                i = rs.getInt("SL");
            } else {
                i = 0;
            }
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public static boolean addEmployee(Employee employee) {
        boolean ok = false;
        try {
            String sql = "insert into employee(username,passwd,name,dateofbirth,phone,email,pic,salary,addres,position)\n"
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = Helper.connection.prepareStatement(sql);
            pstm.setNString(1, employee.getUsername());
            pstm.setNString(2, employee.getPasswd());
            pstm.setNString(3, employee.getName());
            pstm.setNString(4, (new SimpleDateFormat("yyyy-MM-dd")).format(employee.getDateofbirth()));
            pstm.setNString(5, employee.getPhone());
            pstm.setNString(6, employee.getEmail());
            pstm.setNString(7, employee.getPic());
            pstm.setDouble(8, employee.getSalary());
            pstm.setNString(9, employee.getAddress());
            pstm.setNString(10, employee.getPosition());

            int i = pstm.executeUpdate();
            if (i > 0) {
                ok = true;
            }
        } catch (Exception e) {
        }
        return ok;
    }

    public static boolean updateEmployee(Employee employee) {
        boolean ok = false;
        try {
            String sql = "update employee\n"
                    + "set name = ?,dateofbirth = ?,phone = ?,email = ?,pic = ?,salary = ?,addres = ?,position = ?\n"
                    + "where username = ?";
            PreparedStatement pstm = Helper.connection.prepareStatement(sql);
            pstm.setNString(1, employee.getName());
            pstm.setNString(2, (new SimpleDateFormat("yyyy-MM-dd")).format(employee.getDateofbirth()));
            pstm.setNString(3, employee.getPhone());
            pstm.setNString(4, employee.getEmail());
            pstm.setNString(5, employee.getPic() != null ? employee.getPic() : null);
            pstm.setDouble(6, employee.getSalary());
            pstm.setNString(7, employee.getAddress());
            pstm.setNString(8, employee.getPosition());
            pstm.setNString(9, employee.getUsername());

            int i = pstm.executeUpdate();
            if (i > 0) {
                ok = true;
            }
        } catch (Exception e) {
        }
        return ok;
    }

    public static boolean deleteEmployee(Employee employee) {
        boolean ok = false;
        try {
            String sql = "update employee\n"
                    + "set position =?\n"
                    + "where username = ?";
            PreparedStatement pstm = Helper.connection.prepareStatement(sql);
            pstm.setNString(1, "DN");
            pstm.setNString(2, employee.getUsername());

            int i = pstm.executeUpdate();
            if (i > 0) {
                ok = true;
            }
        } catch (Exception e) {
        }
        return ok;
    }

}
