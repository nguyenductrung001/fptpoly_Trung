package lab4;

/**
 * sanpham
 */
import java.util.Scanner;

public class sanpham {

    private String tensp;
    private double dongia;
    private int giamgia;

    double getThueNhapKhau() {
        return 0;
    };

    public String getTensp() {
        return tensp;
    }

    public double getDongia() {
        return dongia;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    sanpham() {
    };

    sanpham(String ten, double gia, int giam) {
        this.tensp = ten;
        this.dongia = gia;
        this.giamgia = giam;
    };

    sanpham(String ten, double gia) {
        this(ten, gia, 0);

    };

    public void xuat() {
        System.out.printf("%s:\nDon gia: %.3f dong\nGiam:%d%%\n\n",tensp.toUpperCase(),dongia,giamgia);
    };

    void nhap() {
        Scanner s = new Scanner(System.in);
        System.out.println("nhap san pham");
        System.out.print("Ten:");
        tensp = s.nextLine();
        System.out.print("don gia:");
        dongia = Double.parseDouble(s.nextLine());
        System.out.print("giam gia:");
        giamgia = Integer.parseInt(s.nextLine());
    };

}