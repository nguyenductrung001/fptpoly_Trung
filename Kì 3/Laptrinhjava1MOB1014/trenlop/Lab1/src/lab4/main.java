package lab4;

/**
 * main
 */

import java.util.Scanner;

public class main {

    private static Scanner s = new Scanner(System.in);

    public static void bai2() {
        sanpham sp1 = new sanpham();
        sanpham sp2 = new sanpham();
        sp1.nhap();
        sp2.nhap();
        System.out.println("\n\nHai san pham vua nhap la");
        sp1.xuat();
        sp2.xuat();
    }

    public static void bai3() {
        sanpham sp1 = new sanpham("hang nhap lau 1", 3000000);
        sanpham sp2 = new sanpham("hang nhap lau 2", 1000000, 66);
        sp1.xuat();
        sp2.xuat();
    }

    public static void main(String[] args) {
        System.out.println("\n\n\n\nBai 2:");
        bai2();
        System.out.println("\n\n\n\nBai 3:");
        bai3();
    }
}