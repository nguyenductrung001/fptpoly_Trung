package lab8;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap vao 4 so double");
        double a = Double.parseDouble(s.nextLine());
        double b = Double.parseDouble(s.nextLine());
        double c = Double.parseDouble(s.nextLine());
        double d = Double.parseDouble(s.nextLine());
        System.out.printf("Tong cac so da nhap: %f\n", XPoly.sum(a, b, c, d));
        System.out.printf("So be nhat: %f\n", XPoly.min(a, b, c, d));
        System.out.printf("So lon nhat: %f\n", XPoly.max(a, b, c, d));
        System.out.println("Nhap vao mot doan text:");
        String text = s.nextLine();
        System.out.printf("Doan text da viet hoa chu cai dau tien moi tu la:\n%s", XPoly.toUpperFirstChar(text));
    }
}