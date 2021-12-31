/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class HocSinh {
    private String MaHS,HoTen,GioiTinh;
    private float DTB;

    public HocSinh(String MaHS, String HoTen, String GioiTinh, double DTB) {
        this.MaHS = MaHS;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DTB = (float) DTB;
    }

    public HocSinh() {
    }

    public String getMaHS() {
        return MaHS;
    }

    public void setMaHS(String MaHS) {
        this.MaHS = MaHS;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public double getDTB() {
        return DTB;
    }

    public void setDTB(double DTB) {
        this.DTB = (float) DTB;
    }
    
}
