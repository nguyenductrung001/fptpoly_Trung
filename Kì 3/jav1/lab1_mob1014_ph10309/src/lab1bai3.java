
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
public class lab1bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);// tạo luồng nhập
        
        System.out.print("canh: ");//in ra màn hình
        double canh = scanner.nextDouble ();//nhập biến a từ bàn phim 
        
        System.out.printf("the tich :%.2f",Math.pow(canh, 3));
        System.out.printf("the tich :%.2f",canh * canh * canh);
        
    }
}
