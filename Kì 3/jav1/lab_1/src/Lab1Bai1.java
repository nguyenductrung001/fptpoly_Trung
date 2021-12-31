
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
public class Lab1Bai1 {

    //psvm
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Họ và tên: ");
        String hoTen = scanner.nextLine();
        
        System.out.print("Điểm TB: ");
        double diemTB = scanner.nextDouble();
        
        System.out.printf("%s %f điểm", hoTen, diemTB);
    }
}
