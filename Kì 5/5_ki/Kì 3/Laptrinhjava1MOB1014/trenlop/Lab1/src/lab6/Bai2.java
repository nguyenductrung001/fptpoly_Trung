package lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Sanpham> listSanphams = new ArrayList<Sanpham>();
        String inNext;
        while (true) {
            System.out.println("Ban co muon nhap (Y/N) : ");
            inNext = String.valueOf(s.nextLine());
            if (inNext.equalsIgnoreCase("N")) {
                break;
            } else if (inNext.equalsIgnoreCase("Y")) {
                Sanpham eSanpham = new Sanpham();
                System.out.println("Moi nhap vao:");
                System.out.print("Ten san pham: ");
                eSanpham.setTenSp(String.valueOf(s.nextLine()));
                System.out.print("Gia: ");
                eSanpham.setDonGia(Double.parseDouble(s.nextLine()));
                System.out.print("Hang: ");
                eSanpham.setHang(String.valueOf(s.nextLine()));
                listSanphams.add(eSanpham);
            }
        }
        System.out.println("Danh sach san pham nokia:");
        for (Sanpham sanpham : listSanphams) {
            if (sanpham.getHang().equalsIgnoreCase("Nokia")) {
                sanpham.xuat();
            }
        }
    }
}