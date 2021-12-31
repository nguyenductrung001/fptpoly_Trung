package lab3;

import java.util.Scanner;

/**
 * Bai4
 */
public class Bai4 {

    public static void main(String[] args) {
        // khai bao mang ho ten va diem
        String[] arrName = new String[5];
        String[] arrRank = new String[5];
        float[] arrScore = new float[5];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < arrScore.length; i++) {
            System.out.printf("Xin moi nhap thong tin sinh vien thu %d\nHo ten: ", i + 1);
            arrName[i] = s.nextLine();
            System.out.print("Diem trung binh: ");
            arrScore[i] = Float.parseFloat(s.nextLine());
            if (arrScore[i] < 5) {
                arrRank[i] = "Yeu";
            } else if (arrScore[i] < 6.5) {
                arrRank[i] = "Trung Binh";
            } else if (arrScore[i] < 7.5) {
                arrRank[i] = "Kha";
            } else if (arrScore[i] < 9) {
                arrRank[i] = "Gioi";
            } else {
                arrRank[i] = "Xuat Sac";
            }
        }
        System.out.println("Danh sach sinh vien:");
        System.out.println("            Ho ten             Diem Trung Binh        Hoc luc       ");
        for (int i = 0; i < arrScore.length; i++) {
            System.out.printf("%25s     %12.2f     %16s\n", arrName[i], arrScore[i], arrRank[i]);
        }
        for (int i = 0; i < arrScore.length - 1; i++) {
            for (int j = i + 1; j < arrScore.length; j++) {
                if (arrScore[i] > arrScore[j]) {
                    float x = arrScore[i];
                    arrScore[i] = arrScore[j];
                    arrScore[j] = x;
                    String y = arrName[i];
                    arrName[i] = arrName[j];
                    arrName[j] = y;
                    y = arrRank[i];
                    arrRank[i] = arrRank[j];
                    arrRank[j] = y;
                }
            }

        }

        System.out.println("\nDanh sach sinh vien da sap xep:");
        System.out.println("            Ho ten             Diem Trung Binh        Hoc luc       ");
        for (int i = 0; i < arrScore.length; i++) {
            System.out.printf("%25s     %12.2f     %16s\n", arrName[i], arrScore[i], arrRank[i]);
        }
    }
}