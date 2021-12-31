/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class SinhVien {
    public String Mamon,Tenmon,Masv;
    public float diem;

    public SinhVien() {
    }

    public SinhVien(String Mamon, String Tenmon, String Masv, float diem) {
        this.Mamon = Mamon;
        this.Tenmon = Tenmon;
        this.Masv = Masv;
        this.diem = diem;
    }

    public String getMamon() {
        return Mamon;
    }

    public void setMamon(String Mamon) {
        this.Mamon = Mamon;
    }

    public String getTenmon() {
        return Tenmon;
    }

    public void setTenmon(String Tenmon) {
        this.Tenmon = Tenmon;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String Masv) {
        this.Masv = Masv;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
}
