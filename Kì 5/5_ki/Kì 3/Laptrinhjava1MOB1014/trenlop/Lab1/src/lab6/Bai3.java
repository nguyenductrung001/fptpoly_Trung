package lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        ArrayList<Sinhvien> listSinhviens = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String partternEmail = "\\w+@[a-z]+(\\.[a-z]+){1,2}";
        String partternPhone = "0[\\d]{9}";
        String partternCMND = "[\\d]{9}";
        String inNext;
        while (true) {
            System.out.println("Ban co muon nhap (Y/N) : ");
            inNext = String.valueOf(s.nextLine());
            if (inNext.equalsIgnoreCase("N")) {
                break;
            } else if (inNext.equalsIgnoreCase("Y")) {
                Sinhvien eSinhvien = new Sinhvien();
                boolean hasError = false;
                System.out.println("Moi nhap vao:");
                System.out.print("Ho ten: ");
                eSinhvien.setName(String.valueOf(s.nextLine()));
                System.out.print("Email: ");
                eSinhvien.setEmail(String.valueOf(s.nextLine()));
                System.out.print("Dien thoai: ");
                eSinhvien.setPhone(String.valueOf(s.nextLine()));
                System.out.print("CMND: ");
                eSinhvien.setCmnd(String.valueOf(s.nextLine()));
                if (!eSinhvien.getEmail().matches(partternEmail)) {
                    System.out.println("Emai khong dung dinh dang.");
                    hasError = true;
                }
                if (!eSinhvien.getPhone().matches(partternPhone)) {
                    System.out.println("Dien thoai khong dung dinh dang.");
                    hasError = true;
                }
                if (!eSinhvien.getCmnd().matches(partternCMND)) {
                    System.out.println("CMND khong dung dinh dang.");
                    hasError = true;
                }
                if (hasError) {
                    System.out.println("Moi nhap lai");
                } else {
                     listSinhviens.add(eSinhvien);
                }
            }
        }
    }
}