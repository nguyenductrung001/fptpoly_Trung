
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Truong Dep Zai
 */
public class bai3lab3 {
    public static void main(String[] args) {
        System.out.println("Mời bạn nhập  một mảng");
        Scanner s = new Scanner(System.in);
        Integer a[] = new Integer[5]; //a là một mảng đói tượng
        int b[] = new int[5];// b là một mảng số
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(s.nextLine());// nhập một số vào mảng
        }
        System.out.println("Bạn  vừa nhập 1 mảng");
        for (Integer a1 : a) {
            System.out.println(a1);
        }
        Arrays.sort(a);//sắp xếp mảng

        System.out.println("Mnagr sau khi đã sắp xếp:");
        for (Integer a1 : a) {
            System.out.println(a1);
        }
        System.out.printf("phần tử nhỏ nhất: %d", a[0]);
        int tong = 0;//tổng ban đầu = 0
        int dem = 0;//đếm xem có bao nhiêu phần tử chia hết cho 3
        for (Integer a1 : a) //duyệt mảng
        {
            if (a1 % 3 == 0) {
                tong += a1;
                dem++;//từ bảng đếm 
            }
        }
        if (dem != 0) {
            float tbc = (float) (tong / dem);//trung bình cộng
            System.out.println("trung bình cộng các số chia hết cho 3 là" + tbc);
        } else {
            System.out.println("trung bình cộng các số chia hết cho 3 là 0" );
        }
    }
}
