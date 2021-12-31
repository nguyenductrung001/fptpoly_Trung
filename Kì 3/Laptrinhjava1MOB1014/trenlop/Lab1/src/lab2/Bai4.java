package lab2;

import java.util.Scanner;

/**
 * Bai4
 */
public class Bai4 {
    public static void giaitri() {
        System.out.println("Bai 4");
        System.out.println("Moi ban chon chuc nang:");
        System.out.println("------------------------------");
        System.out.println("1. Giai phuong trinh bac nhat");
        System.out.println("2. Giai phuong trinh bac hai");
        System.out.println("3. Tinh tien dien");
        System.out.println("4. Thoat chuong trinh");
        System.out.println("------------------------------");
        // nhap
        Scanner s = new Scanner(System.in);
        int traloi = Integer.parseInt(s.nextLine());
        switch (traloi) {
            case 1:
                Bai1.giaiPTB1();
                break;
            case 2:
                Bai2.giaiPTB2();
                break;
            case 3:
                Bai3.tinhtiendien();
                break;
            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("Khong co chuc nang nay");
                break;
        }
    }

    public static void main(String[] args) {
        giaitri();
    }
}