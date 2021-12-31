/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.Scanner;


public class Demo {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        DSChicken ds = new DSChicken();
        ds.init();
        int chon;

        while (true) {
            menu();
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    System.out.println("| 1. Nhập danh sách chicken |");
                    
                    break;
                case 2:
                    System.out.println("| 2. xuất thông tin các phần tử, xuất cả trạng thái |");
                    ds.outputChicken();
                    break;
                case 3:
                    System.out.println("| 3.In các phần tử có price từ min đến max. |");
                    ds.findChicken();
                    break;
                case 4:
                    System.out.println("| 4.sắp xếp các phần tử giảm dần theo price |");
                    ds.sortChicken();
                    break;
                    
                    case 5:
                    System.out.println("| 5.In thông tin các phần tử có price lớn nhất |");
                    ds.printMax();
                    break;
               
                case 0:
                    System.out.println("| 0. Thoát                     |");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mục bạn chọn ko có, vui lòng chọn lại");
                    break;

            }
        }

    }

    static void menu() {

        System.out.println("\n\n|------------------------------------------------     |");
        System.out.println("| 1. Nhập danh sách nhân viên từ bàn phím                  |");
        System.out.println("| 2. xuất thông tin các phần tử, xuất cả trạng thái                  |");
        System.out.println("| 3. In các phần tử có price từ min đến max    |");
        System.out.println("| 4. sắp xếp các phần tử giảm dần theo price                |");
         System.out.println("|5. In thông tin các phần tử có price lớn nhất                |");
        System.out.println("| 0. Thoát                                                 |");
        System.out.println("|-------------------------------------------------         |");
        System.out.print("Mời bạn chọn 1 mục:");
    }
}
