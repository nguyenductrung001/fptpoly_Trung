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
    private String MaSV, HoTen,Nganh;
    private int tuoi;

    public HocSinh_1() {
    }

    public HocSinh_1(String MaSV, String HoTen, String Nganh, int tuoi) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.Nganh = Nganh;
        this.tuoi = tuoi;
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

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String Nganh) {
        this.Nganh = Nganh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return MaSV;
    }
    
}
