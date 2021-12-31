package lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class bai1 {
    private static ArrayList<Double> soThuc = new ArrayList<>();
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String yN = "";
        double num;
        do {
            System.out.println("Moi nhap vao mot so thuc");
            num = Double.parseDouble(s.nextLine());
            soThuc.add(num);
            System.out.println("Nhap bat ky de nhap tiep (Nhap \"N\" de dung nhap)");
            yN = s.nextLine();
        } while (!yN.equalsIgnoreCase("N"));
        System.out.println("Day vua nhap:");
        for (double e : soThuc) {
            System.out.printf("%f  ", e);
        }
        s.nextLine();
    }
}