package lab2;

import java.util.Scanner;

/**
 * Bai3
 */
public class Bai3 {
    public static void tinhtiendien() {
        // input sodien
        // output sotiendien
        System.out.println("Moi nhap vao so dien da dung");
        Scanner s = new Scanner(System.in);
        int sodien = Integer.parseInt(s.nextLine());
        if (sodien <= 50) {
            int sotien = sodien * 1000;
            System.out.printf("So dien da dung: %d", sotien);
        } else {
            int sotien = 50 * 1000 + (sodien - 50) * 1200;
            System.out.printf("So tien dien: %d", sotien);
        }
    }

    public static void main(String[] args) {
        tinhtiendien();
    }
}