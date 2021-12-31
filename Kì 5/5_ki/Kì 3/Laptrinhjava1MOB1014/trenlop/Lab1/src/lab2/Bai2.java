package lab2;

import java.util.Scanner;

/**
 * Bai2
 */
public class Bai2 {

    public static void giaiPTB2() {
        // input a, b, c
        // output x1, x2
        System.out.println("Moi ban nhap 3 he so a, b, c");
        Scanner s = new Scanner(System.in);
        System.out.print("a: ");
        int a = Integer.parseInt(s.nextLine());
        System.out.print("b: ");
        int b = Integer.parseInt(s.nextLine());
        System.out.print("c: ");
        int c = Integer.parseInt(s.nextLine());
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phuong trinh co vo so nghiem.");
                } else {
                    System.out.println("Phuong trinh vo nghiem.");
                }
            } else {
                float x = (float) -c / b;
                System.out.printf("Phuong trinh co nghiem: x = %f", x);
            }
        } else {
            int delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Phuong trinh vo nghiem");
            } else {
                if (delta == 0) {
                    float x = (float) -b / (2 * a);
                    System.out.printf("Phuong trinh co nghiem: x = %f", x);
                } else {
                    float x1 = (float) (-b - Math.sqrt(delta)) / (2 * a);
                    float x2 = (float) (-b + Math.sqrt(delta)) / (2 * a);
                    System.out.printf("Phuong trinh co nghiem:\nx1 = %f\nx2 = %f", x1, x2);
                }
            }
        }
    }

    public static void main(String[] args) {
        giaiPTB2();
    }
}