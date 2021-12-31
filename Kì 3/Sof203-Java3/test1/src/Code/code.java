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
public class code {
    public String ma, ten, masv;
    public  Float diem;

    public code(String masv) {
        this.masv = masv;
    }

    public code() {
    }

    public code(String ma, String ten, String masv, Float diem) {
        this.ma = ma;
        this.ten = ten;
        this.masv = masv;
        this.diem = diem;
    }

    public code(String ma, String ten, Float diem) {
        this.ma = ma;
        this.ten = ten;
        this.diem = diem;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }
}
