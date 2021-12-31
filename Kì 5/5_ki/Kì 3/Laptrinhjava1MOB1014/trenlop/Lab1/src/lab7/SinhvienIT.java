package lab7;

import java.util.Scanner;

public class SinhvienIT extends SinhvienFpoly {
    private double pointJava;
    private double pointHtml;
    private double pointCss;

    @Override
    public Double getDiemTB() {
        return (this.pointJava * 2 + this.pointHtml + this.pointCss) / 4;
    }

    @Override
    public void nhap() {
        Scanner s = new Scanner(System.in);
        SinhvienIT eSinhvienIT = new SinhvienIT();
        do {
            try {
                System.out.println("Xin moi nhap (Ho ten, nganh, diem java, diem html, diem css)");
                eSinhvienIT.setName(String.valueOf(s.nextLine()));
                eSinhvienIT.setMajor(String.valueOf(s.nextLine()));
                eSinhvienIT.setPointJava(Double.parseDouble(s.nextLine()));
                eSinhvienIT.setPointHtml(Double.parseDouble(s.nextLine()));
                eSinhvienIT.setPointCss(Double.parseDouble(s.nextLine()));
            } catch (Exception e) {
                System.out.println("Co loi xay ra. xin moi nhap lai");
                continue;
            }
            break;
        } while (true);
    }

    /**
     * @return the pointJava
     */
    public double getPointJava() {
        return pointJava;
    }

    /**
     * @return the pointHtml
     */
    public double getPointHtml() {
        return pointHtml;
    }

    /**
     * @return the pointCss
     */
    public double getPointCss() {
        return pointCss;
    }

    /**
     * @param pointCss the pointCss to set
     */
    public void setPointCss(double pointCss) {
        this.pointCss = pointCss;
    }

    /**
     * @param pointHtml the pointHtml to set
     */
    public void setPointHtml(double pointHtml) {
        this.pointHtml = pointHtml;
    }

    /**
     * @param pointJava the pointJava to set
     */
    public void setPointJava(double pointJava) {
        this.pointJava = pointJava;
    }

}