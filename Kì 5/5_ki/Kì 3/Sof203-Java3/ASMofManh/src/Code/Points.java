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
public class Points {
    public String mssv, hoten;
    public float tienganh,tinhoc,gdtc;

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public float getTienganh() {
        return tienganh;
    }

    public void setTienganh(float tienganh) {
        this.tienganh = tienganh;
    }

    public float getTinhoc() {
        return tinhoc;
    }

    public void setTinhoc(float tinhoc) {
        this.tinhoc = tinhoc;
    }

    public float getGdtc() {
        return gdtc;
    }

    public void setGdtc(float gdtc) {
        this.gdtc = gdtc;
    }

    public Points() {
    }

    public Points(String mssv, String hoten, float tienganh, float tinhoc, float gdtc) {
        this.mssv = mssv;
        this.hoten = hoten;
        this.tienganh = tienganh;
        this.tinhoc = tinhoc;
        this.gdtc = gdtc;
    }
    public double layDiemTb(){
      return(tienganh+tinhoc+gdtc)/3;
      
    }
}
