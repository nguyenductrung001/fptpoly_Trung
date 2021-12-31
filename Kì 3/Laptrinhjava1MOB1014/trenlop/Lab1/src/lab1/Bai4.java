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
public class Bai4 {
    public static void main(String[] args) {
        System.out.println("Moi nhap vao so a, b, c: ");
        Scanner s = new Scanner(System.in);
        double a,b,c;
        System.out.print("a: ");
        a = Double.parseDouble(s.nextLine());
        System.out.print("b: ");
        b = Double.parseDouble(s.nextLine());
        System.out.print("c: ");
        c = Double.parseDouble(s.nextLine());
        double delta;
        delta = Math.pow(b, 2) - 4* a*c;
        if(delta>=0){
            double candelta = (double) Math.sqrt(delta);
            System.out.printf("Can delta: %.1f",candelta);
        }
        else{
            System.out.println("Delta nho hon 0.");
        }
    }
}