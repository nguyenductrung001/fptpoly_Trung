/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Truong Dep Zai
 */
public class Student {
    public String MaSV, HoTen,GioiTinh,MaMon,TenMon;
    public float diem;

    public Student(String MaSV, String HoTen, String GioiTinh, String MaMon, String TenMon, float diem) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.MaMon = MaMon;
        this.TenMon = TenMon;
        this.diem = diem;
    }

    public Student() {
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
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
}
