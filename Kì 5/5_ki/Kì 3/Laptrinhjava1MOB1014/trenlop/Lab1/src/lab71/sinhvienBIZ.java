/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

import java.util.Scanner;


public class sinhvienBIZ extends sinhvienpoly{
       private double diemMKT, diemSale;
    @Override
    public double getdiemTB() {
   return (2*diemMKT+diemSale)/3;

    }

    @Override
    public void nhap() {
        Scanner s = new Scanner(System.in);
        System.out.println("\r\nSVBIZ-Nhap ten; Ngang; Diem MKT; diemSale");
        super.setHoten(String.valueOf(s.nextLine()));
        super.setNgang(String.valueOf(s.nextLine()));
        
        this.diemMKT = Double.parseDouble(s.nextLine());
        this.diemSale = Double.parseDouble(s.nextLine());
        System.out.println("SinhVienBIZ - =====");
    }
    @Override
    public void xuat() {
        super.xuat(); //To change body of generated methods, choose Tools | Templates.
        System.out.printf(" Xuat-SinhvienIT: DiemMKT: %.1f; diemSale: %.1f"
        , this.diemMKT, this.diemSale
        );
    }
}
