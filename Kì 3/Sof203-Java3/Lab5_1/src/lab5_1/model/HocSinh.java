
package model;


public class HocSinh {
    private String maHs, hoTen, gioiTinh;
    private float diemTB;

    public HocSinh() {
    }

    public HocSinh(String maHs, String hoTen, String gioiTinh, float diemTB) {
        this.maHs = maHs;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diemTB = diemTB;
    }

    public String getMaHs() {
        return maHs;
    }

    public void setMaHs(String maHs) {
        this.maHs = maHs;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "HocSinh{" + "maHs=" + maHs + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diemTB=" + diemTB + '}';
    }
    
    
}
