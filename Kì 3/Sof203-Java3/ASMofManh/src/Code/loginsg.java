/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author manhk
 */
public class loginsg {
    public String taikhoan, matkhau, role;

    public loginsg() {
    }

    public loginsg(String taikhoan, String matkhau, String role) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.role = role;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    
}
