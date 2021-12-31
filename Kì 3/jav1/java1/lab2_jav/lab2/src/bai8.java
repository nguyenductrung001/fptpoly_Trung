
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Truong Dep Zai
 */
public class bai8 {

    public static void main(String[] args) {
        // khai báo mảng số nguyên gồm 5 phần tử và gán giá trị 
        // dùng 2 cách
        int[] arr = {7, 2, 3, 5, 6};
        // khai báo mảng  số thực goomg 3 phần tử và gan giá trị 
        float crr[] = {2, (float) 4.6, 5};
        double drr[] = {4.5, 6, 7};
        // khai báo mảng chuỗi gồm 4 phần tử và gan gia tri 
        String[] m = {"trung", "phuc", "manh"};
        // lam vc voi mang
        System.out.println("phần tử thứ 2:" + arr[1]);
        System.out.println("độ dài mảng" + arr.length);
        //in các phần tử 
        System.out.println("\n Xuất mảng:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("\nXuất mảng dùng for-each");
        //for(Kieu_DL_mang x:ten mang){
        // làm vc vs x
        //     }
        for (int x : arr) {
            System.out.println(x);
        }
        System.out.println("các số chẵn của mảng là:");
        for (int x : arr) {
            if (x % 2 == 0) {
                System.out.println(x);
            }
        }
        // sắp tăng
        Arrays.sort(arr);
        System.out.println("mảng sau khi sap tang");
        for (int x : arr) {
            System.out.println(x);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("mảng sau khi sắp giảm");
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
