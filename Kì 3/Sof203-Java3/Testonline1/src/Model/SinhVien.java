/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Truong Dep Zai
 */
public class SinhVien {
    public String MaSV,HoTen,GioiTinh,MaMon,TenMon;
    public float Diem;

    public SinhVien() {
    }

    public SinhVien(String MaSV, String HoTen, String GioiTinh, String MaMon, String TenMon, float Diem) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.Diem = Diem;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
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

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }
    
}
