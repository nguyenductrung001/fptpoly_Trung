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
public class bai4_lab2 {
    public static void menu()
    { System.out.println("   bài 4 ");
        System.out.println("mời bạn chọn chức năng:");
        System.out.println("-------------");
        System.out.println("1.giải phương trình bậc 1");
        System.out.println("2.giải phương trình bậc 2");
        System.out.println("3.tính tiền điện");
        System.out.println("4.thoát chương trình");
        
        System.out.println("--------------");
        //tạo luồng nhập
        Scanner s = new Scanner(System.in);
        System.out.print("trả lời:");
        int traLoi = s.nextInt();
        switch(traLoi)
        {
            case 1:
                bai1.giaiPTB1();
                menu();
                break;
                
            case 2:
                bai2_lab2.giaiPTB2();
                menu();
                break;
                
            case 3:
                bai3_lab2.tinhTienDien();
                menu();
                break;
                
            case 4:
                System.exit(0); 
                break;
            default:
                System.out.println("không có chức năng này");
        }
    
    }
    public static void main(String[] args) {
        menu();
    }
}
