/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Scanner;

/**
 *
 * @author Ma
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Moi ban nhap");
        String hoten;
        double diemtb;
        Scanner s = new Scanner(System.in);
        System.out.print("Ho va ten:");
        hoten = s.nextLine();
        System.out.print("Diem tb:");
        diemtb = Double.parseDouble(s.nextLine());
        System.out.printf("%s %.1f diem", hoten, diemtb);
    }

}
