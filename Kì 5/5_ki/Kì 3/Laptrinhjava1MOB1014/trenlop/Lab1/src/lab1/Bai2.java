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
public class Bai2 {
    public static void main(String[] args) {
        double a, b;
        System.out.println("Moi ban nhap vao canh a va b:");
        Scanner scan = new Scanner(System.in);
        System.out.print("a: ");
        a = Double.parseDouble(scan.nextLine());
        System.out.print("b: ");
        b = Double.parseDouble(scan.nextLine());
        double cv, dt,ngan;
        cv = (a + b) * 2;
        dt = a * b;
        ngan=Math.min(a, b);
        System.out.printf("Chu vi: %.1f.\nDien tich: %.1f.\nCanh co chieu dai nho nhat: %.1f",cv,dt,ngan);
    }
}
