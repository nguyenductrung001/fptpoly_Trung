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
public class HocSinh_1 {
    public String MaMH,TenMon,MaSV;
    public float diem;

    public HocSinh_1() {
    }

    public HocSinh_1(String MaMH, String TenMon, String MaSV, float diem) {
        this.MaMH = MaMH;
        this.TenMon = TenMon;
        this.MaSV = MaSV;
        this.diem = diem;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
}
