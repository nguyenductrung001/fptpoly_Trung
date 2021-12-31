package lab7;

import java.util.Scanner;

public class SinhvienBiz extends SinhvienFpoly {
    private double pointMarketing;
    private double pointSales;

    @Override
    public Double getDiemTB() {
        return (this.pointMarketing * 2 + this.pointSales) / 3;
    }

    @Override
    public void nhap() {
        Scanner s = new Scanner(System.in);
        SinhvienBiz eSinhvienBiz = new SinhvienBiz();
        do {
            try {
                System.out.println("Xin moi nhap (Ho ten, nganh, diem marketing, diem sales)");
                eSinhvienBiz.setName(String.valueOf(s.nextLine()));
                eSinhvienBiz.setMajor(String.valueOf(s.nextLine()));
                eSinhvienBiz.setPointMarketing(Double.parseDouble(s.nextLine()));
                eSinhvienBiz.setPointSales(Double.parseDouble(s.nextLine()));
            } catch (Exception e) {
                System.out.println("Co loi xay ra. xin moi nhap lai");
                continue;
            }
            break;
        } while (true);
    }

    /**
     * @return the pointMarketing
     */
    public double getPointMarketing() {
        return pointMarketing;
    }

    /**
     * @return the pointSales
     */
    public double getPointSales() {
        return pointSales;
    }

    /**
     * @param pointMarketing the pointMarketing to set
     */
    public void setPointMarketing(double pointMarketing) {
        this.pointMarketing = pointMarketing;
    }

    /**
     * @param pointSales the pointSales to set
     */
    public void setPointSales(double pointSales) {
        this.pointSales = pointSales;
    }

}