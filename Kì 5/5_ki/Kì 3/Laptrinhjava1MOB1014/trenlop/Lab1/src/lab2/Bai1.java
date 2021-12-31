package lab2;

import java.util.Scanner;

/**
 * Bai1
 */
public class Bai1 {

    public static void giaiPTB1() {
        // input a, b
        // output x = -b/a
        System.out.println("Moi ban nhap 2 he so a va b");
        Scanner s = new Scanner(System.in);
        System.out.print("a: ");
        int a = Integer.parseInt(s.nextLine());
        System.out.print("b: ");
        int b = Integer.parseInt(s.nextLine());
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh co vo so nghiem.");
            } else {
                System.out.println("Phuong trinh vo nghiem.");
            }
        } else {
            float x = (float) -b / a;
            System.out.printf("Phuong trinh co nghiem: x = %.2f", x);
        }
    }

    public static void main(String[] args) {
        giaiPTB1();
    }
}