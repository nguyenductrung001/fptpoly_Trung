
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
public class bai4lab3 {
     public static void main(String[] args) {
        // khai báo 2 mang hoten,diem, co n pahn tu-n nhap
        Scanner s = new Scanner(System.in);
        int n ;
        System.out.println("mời bạn nhập số phần tử mảng");
        n = Integer.parseInt(s.nextLine());
        String hoten[]= new String[n];
        double diem[]= new double[n];
        
        // nhap cac pha tu mang
        for(int i =0;i<hoten.length;i++)
        {
            System.out.printf("mời nhập phần tử thứ %d",(i+1));
            System.out.print("mời bạn nhập họ tên:");
            hoten[i]=s.nextLine();
            System.out.print("mời bạn nhập điểm:");
            diem[i]= Double.parseDouble(s.nextLine());
            
        }
        // xuat mang
        System.out.println("xuât mảng:");
        for(int i = 0;i<diem.length;i++)
        {
            String xeploai;
            if(diem[i]<5){
                xeploai="yếu";
            }else if(diem[i]<6.5)
            {
                xeploai="TB";
            }else if(diem[i]<7.5)
            {
                xeploai="khá";
            }
            else if(diem[i]<9)
            {
                xeploai="gioi";
            }
            else
            {
                xeploai="xuất sắc";
            }
            System.out.printf("Hoten:%s,diem:%.2f,xeploai:%s",hoten[i],diem[i],xeploai);
        }
        // Sap mang
        for(int i=0;i<diem.length-1;i++)
        {
            for(int j=i+1;j<diem.length;j++)
            {
                if(diem[i]>diem[j])
                {
                    // doi cho diem
                    double tmp=diem[j];
                    diem[i]=diem[j];
                    diem[j]=tmp;
                    //doi cho ten
                    String tmps=hoten[i];
                    hoten[i]=hoten[j];
                    hoten[j]=tmps;
                }
            }
        }
        //xuat mang sau khi sap
        System.out.println("mảng sau khi sắp:");
        for(int i =0;i<hoten.length;i++)
        {
             String xeploai;
            if(diem[i]<5){
                xeploai="yếu";
            }else if(diem[i]<6.5)
            {
                xeploai="TB";
            }else if(diem[i]<7.5)
            {
                xeploai="khá";
            }
            else if(diem[i]<9)
            {
                xeploai="gioi";
            }
            else
            {
                xeploai="xuất sắc";
            }
            System.out.printf("Hoten:%s,diem:%.2f,xeploai:%s",hoten[i],diem[i],xeploai);
        }
    }
}
