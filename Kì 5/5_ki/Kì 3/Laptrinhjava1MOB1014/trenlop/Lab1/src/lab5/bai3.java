package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class bai3 {
    private static ArrayList<Sanpham> list = new ArrayList<>();
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String sel = "";
        do {
            System.out.println("Xin moi chon:");
            System.out.println("1 Nhap vao san pham");
            System.out.println("2 Sap xep giam dan theo gia va in ra danh sach san pham");
            System.out.println("3 Tim va xoa san pham");
            System.out.println("4 Xuat gia trung binh cua cac san pham");
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
        int inPrice;
        Sanpham eSanpham;
        do {
            System.out.println("Moi nhap ten san pham:");
            inName = s.nextLine();
            System.out.println("Moi nhap gia san pham:");
            inPrice = Integer.parseInt(s.nextLine());
            eSanpham = new Sanpham(inName, inPrice);
            list.add(eSanpham);
            System.out.println("Nhap bat ky de nhap tiep (Nhap \"N\" de dung nhap):");
            yN = s.nextLine();
        } while (!yN.equalsIgnoreCase("N"));
    }

    private static void xuat() {
        System.out.println("Danh sach San pham:");
        for (Sanpham eSanpham : list) {
            System.out.println(eSanpham.toString());
        }
        s.nextLine();
    }

    private static void chucNang2() {
        System.out.println("Sap xep danh sach");
        Collections.sort(list, new Comparator<Sanpham>() {
            @Override
            public int compare(Sanpham s1, Sanpham s2) {
                return s1.getPrice() - s2.getPrice();
            }
        });
        Collections.reverse(list);
        System.out.println("Xong");
        System.out.println("In danh sach");
        xuat();
    }

    private static void chucNang3() {
        boolean check = false;
        System.out.println("Nhap ten san pham can xoa:");
        String delName = s.nextLine();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getName().equalsIgnoreCase(delName)) {
                list.remove(i);
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

    private static void chucNang4() {
        if (list.size() <= 0) {
            System.out.println("Khong co phan tu nao");
        } else {
            int sum = 0;
            for (Sanpham sanpham : list) {
                sum += sanpham.getPrice();
            }
            System.out.printf("Trung binh gia cac san pham la: %.3f\n", (float) sum / list.size());
        }
        s.nextLine();
    }

}