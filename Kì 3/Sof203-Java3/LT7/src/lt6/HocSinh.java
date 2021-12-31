/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt6;

/**
 *
 * @author THINKPAD T460S
 */
public class HocSinh {

   private String ma,ten,gt;
   private float diemtb;

    public HocSinh() {
    }

    public HocSinh(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        
    }
    
    public HocSinh(String ma, String ten, String gt, float diemtb) {
        this.ma = ma;
        this.ten = ten;
        this.gt = gt;
        this.diemtb = diemtb;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getGt() {
        return gt;
    }

    public float getDiemtb() {
        return diemtb;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public void setDiemtb(float diemtb) {
        this.diemtb = diemtb;
    }
   
    
}
