package lab6;

import lab4.sanpham;

public class Sanpham {
    private String tenSp;
    private double donGia;
    private String hang;

    public void Sanpham() {
    }

    public void Sanpham(String tenSp, double donGia, String hang) {
        this.tenSp = tenSp;
        this.donGia = donGia;
        this.hang = hang;
    }

    /**
     * @return the donGia
     */
    public double getDonGia() {
        return donGia;
    }

    /**
     * @return the hang
     */
    public String getHang() {
        return hang;
    }

    /**
     * @return the tenSp
     */
    public String getTenSp() {
        return tenSp;
    }

    /**
     * @param donGia the donGia to set
     */
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    /**
     * @param hang the hang to set
     */
    public void setHang(String hang) {
        this.hang = hang;
    }

    /**
     * @param tenSp the tenSp to set
     */
    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void nhap(Sanpham eSanpham) {
        this.tenSp = eSanpham.tenSp;
        this.donGia = eSanpham.donGia;
        this.hang = eSanpham.hang;
    }

    public void xuat() {
        System.out.printf("%s, gia: %.3f vnd, hang: %s\n", this.tenSp.toUpperCase(), this.donGia, this.hang);
    }
}