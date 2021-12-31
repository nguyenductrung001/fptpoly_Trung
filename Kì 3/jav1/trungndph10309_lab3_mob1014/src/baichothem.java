/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author PHUC
 */
public class baichothem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;
        while(true){
            menu();
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    System.out.println("Bạn chọn Bài 1");
                    bai1();
                    break;
                case 2:
                    System.out.println("Bạn chọn bài 2");
                    bai2();
                    break;
                case 3:
                    System.out.println("Bạn chọn Thoát");
                    System.exit(0);//lệnh thoát
                    break;
                default:
                    System.out.println("Mục bạn chọn ko có, vui lòng chọn lại");
                    break;
            }
        }
    }

    static void menu() {
        System.out.println("\n\n|-------------------------------------|");
        System.out.println("| 1. Bài 1                    |");
        System.out.println("| 2. Bài 2                 |");
        System.out.println("| 3. Thoát                            |");
        System.out.println("|-------------------------------------|");
        System.out.print("Mời bạn chọn 1 mục:");
    }

    static void bai1() {
        String[] arr = {"đây","là","bài","tập","thêm"};
        System.out.println("Chuỗi bạn vừa nhập: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        Arrays.sort(arr);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
        for (String x : arr) {
            System.out.println(x);
        }
    }
    static void  bai2(){
        System.out.println("Nhập số phần tử của mảng: ");
       Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        float arr[]= new float[n];
        System.out.println("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = Integer.parseInt(s.nextLine());
        }
        System.out.println("Các phần tử của mảng: ");
        for(float x : arr)
        {
            System.out.println(x);
        }
        System.out.println("Sắp mảng giảm dần: ");
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]>arr[j])
                {
                    float temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp giảm dần: ");
        for(float x : arr)
        {
            System.out.println(x);
        }
        float min=arr[arr.length-1];
        System.out.println("Vị trí của các phần tử min là: ");
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==min)
            {
                System.out.println(i);
            }
        }
    }
}