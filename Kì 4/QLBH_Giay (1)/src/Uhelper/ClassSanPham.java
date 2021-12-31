/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uhelper;

/**
 *
 * @author khanh
 */
public class ClassSanPham {
//    "Mã sản phẩm chi tiết", "Tên sản phẩm", "Danh mục", "Kích cỡ", "Số lượng", "Đơn giá", "Mô tả", "Ảnh"};
    public String maspct,tensp,danhmuc,kichco,soluong,dongia,mota,anh;

    public ClassSanPham() {
    }

    public ClassSanPham(String maspct, String tensp, String danhmuc, String kichco, String soluong, String dongia, String mota, String anh) {
        this.maspct = maspct;
        this.tensp = tensp;
        this.danhmuc = danhmuc;
        this.kichco = kichco;
        this.soluong = soluong;
        this.dongia = dongia;
        this.mota = mota;
        this.anh = anh;
    }

    public String getMaspct() {
        return maspct;
    }

    public void setMaspct(String maspct) {
        this.maspct = maspct;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public String getKichco() {
        return kichco;
    }

    public void setKichco(String kichco) {
        this.kichco = kichco;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    
}
