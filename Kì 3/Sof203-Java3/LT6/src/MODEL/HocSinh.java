/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;


public class HocSinh {
    private String MaHS,TenHS;

    public HocSinh() {
    }

    public HocSinh(String MaHS, String TenHS) {
        this.MaHS = MaHS;
        this.TenHS = TenHS;
    }

    public String getMaHS() {
        return MaHS;
    }

    public void setMaHS(String MaHS) {
        this.MaHS = MaHS;
    }

    public String getTenHS() {
        return TenHS;
    }

    public void setTenHS(String TenHS) {
        this.TenHS = TenHS;
    }
    
}
