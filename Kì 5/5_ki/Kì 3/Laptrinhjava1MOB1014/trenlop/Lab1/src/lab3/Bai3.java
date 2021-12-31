package lab3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Bai3
 */
public class Bai3 {

    public static void main(String[] args) {
        System.out.println("Mang\nXin moi nhap vao:");
        // khai bao mang
        int myArr[] = new int[10], n = 0;
        Scanner s = new Scanner(System.in);
        // nhap mang
        for (int i = 0; i < myArr.length; i++) {
            System.out.printf("phan tu thu %d: ", i + 1);
            myArr[i] = Integer.parseInt(s.nextLine());
        }
        // in mang
        System.out.println("Mang vua nhap:");
        for (int i = 0; i < myArr.length; i++) {
            System.out.printf("%d ", myArr[i]);
        }
        // sap xep va in mang + in phan tu nho nhat
        Arrays.sort(myArr);
        System.out.println("\nMang da sap xep:");
        for (int i = 0; i < myArr.length; i++) {
            System.out.printf("%d ", myArr[i]);
        }
        System.out.printf("\nPhan tu nho nhat: %d\n", myArr[0]);
        // tinh va xuat tb cong cac so nho hon 3
        int tong = 0;
        int dem = 0;
        for (int i : myArr) {
            if (i % 3 == 0) {
                dem++;
                tong += i;
            }
        }
        if (dem > 0) {
            float tb = (float) tong / dem;
            System.out.printf("Trung binh cong cac so lon chia het cho 3 la: %f", tb);
        } else {
            System.out.println("Khong co so chia het cho 3 trong mang");
        }
    }
}