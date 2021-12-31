/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author Truong Dep Zai
 */
public class bai3_lab2 {
    public static void tinhTienDien()
    {System.out.println("nhập số điện sử dụng");
        Scanner s = new Scanner(System.in);
        System.out.print("Số điện là:");
       float soDien=s.nextFloat();
       
       float tien=0;
       if(soDien<50)
       {
           tien = soDien*1000;
       }
       else
       {
           tien = 50*1000+(soDien-50)*1200;
       }
        System.out.printf("Số tiền là:%.1f",tien);}
    public static void main(String[] args) {
        tinhTienDien();
    }
}
