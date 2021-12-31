/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

import java.util.Scanner;


public class sinhvienIT  extends sinhvienpoly{
      private double diemJava , diemhtml, diemcss;
      
    @Override
    public double getdiemTB() {
        return (2*diemJava+diemhtml+diemcss)/4;
    }

    @Override
    public void nhap() {
        Scanner s = new Scanner(System.in);
        System.out.println("SVIT-Nhap ten; Ngang; Diem java; diemHTML; diemcss");
        super.setHoten(String.valueOf(s.nextLine()));
        super.setNgang(String.valueOf(s.nextLine()));
        
        this.diemJava = Double.parseDouble(s.nextLine());
        this.diemhtml = Double.parseDouble(s.nextLine());
        this.diemcss = Double.parseDouble(s.nextLine());
        System.out.println("SinhVienIT - =====");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" Xuat-SinhvienIT: DiemJava: %.1f; diemhtml: %.1f; diemcss: %.1f",
         this.diemJava, this.diemhtml, this.diemcss
        );
    }
    
}
