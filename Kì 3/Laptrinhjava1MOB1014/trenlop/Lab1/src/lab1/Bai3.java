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
public class Bai3 {
    public static void main(String[] args) {
        System.out.println("Moi nhap vao canh a: ");
        Scanner s = new Scanner(System.in);
        double a;
        a = Double.parseDouble(s.nextLine());
        double tt;
        tt = Math.pow(a, 3);
        System.out.printf("The tich la: %.1f", tt);
    }
}