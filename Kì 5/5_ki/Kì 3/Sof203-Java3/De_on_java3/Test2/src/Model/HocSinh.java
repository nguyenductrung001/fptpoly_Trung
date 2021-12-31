/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class HocSinh {
    public String Mamh,Tenmh,Masv;
    public float Diem;

    public HocSinh() {
    }

    public HocSinh(String Mamh, String Tenmh, String Masv, float Diem) {
        this.Mamh = Mamh;
        this.Tenmh = Tenmh;
        this.Masv = Masv;
        this.Diem = Diem;
    }

    public String getMamh() {
        return Mamh;
    }

    public void setMamh(String Mamh) {
        this.Mamh = Mamh;
    }

    public String getTenmh() {
        return Tenmh;
    }

    public void setTenmh(String Tenmh) {
        this.Tenmh = Tenmh;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String Masv) {
        this.Masv = Masv;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }

   
    
}
