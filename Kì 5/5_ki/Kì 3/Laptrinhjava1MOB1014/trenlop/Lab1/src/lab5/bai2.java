package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * bai2
 */
public class bai2 {
    private static ArrayList<String> name = new ArrayList<>();
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String sel = "";
        do {
            System.out.println("Xin moi chon:");
            System.out.println("1 Nhap danh sach ho ten.");
            System.out.println("2 Xuat danh sach vua nhap");
            System.out.println("3 Sap xep giam dan va xuat danh sach");
            System.out.println("4 Xuat danh sach ngau nhien");
            System.out.println("5 Tim va xoa ho ten tu ban phim");
            System.out.println("0 Thoat chuong trinh");
            sel = s.nextLine();
            switch (sel) {
                case "1":
                    chucNang1();
                    break;
                case "2":
                    chucNang2();

                    break;
                case "3":
                    chucNang3();

                    break;
                case "4":

                    chucNang4();
                    break;
                case "5":

                    chucNang5();
                    break;
                case "0":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Khong co chuc nang nay");
                    break;
            }
        } while (true);
    }

    private static void chucNang1() {
        String yN = "";
        String inName;
        do {
            System.out.println("Moi nhap vao ho ten:");
            inName = s.nextLine();
            name.add(inName);
            System.out.println("Nhap bat ky de nhap tiep (Nhap \"N\" de dung nhap):");
            yN = s.nextLine();
        } while (!yN.equalsIgnoreCase("N"));
    }

    private static void chucNang2() {
        System.out.println("Danh sach:");
        for (String string : name) {
            System.out.println(string);
        }
        s.nextLine();
    }

    private static void chucNang3() {
        System.out.println("Sap xep danh sach");
        System.out.println("Xong");
        Collections.sort(name);
        Collections.reverse(name);
        System.out.println("In danh sach");
        chucNang2();
    }

    private static void chucNang4() {
        System.out.println("Tron ngau nhien danh sach");
        System.out.println("Xong");
        Collections.shuffle(name);
        System.out.println("In danh sach");
        chucNang2();
    }

    private static void chucNang5() {
        boolean check = false;
        System.out.println("Nhap ten can xoa:");
        String delName = s.nextLine();
        for (int i = name.size() - 1; i >= 0; i--) {
            if (name.get(i).equalsIgnoreCase(delName)) {
                name.remove(i);
                check = true;
            }
        }
        if (check) {
            System.out.println("Da xoa xong");
        } else {
            System.out.println("Khong tim thay ten can xoa");
        }
        s.nextLine();
    }

}