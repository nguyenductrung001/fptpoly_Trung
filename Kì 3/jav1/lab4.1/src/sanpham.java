
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
public class sanpham {
    String tensp;
    double gia,giamgia;
    public double getThueNhapKhau(){
        double tnk= gia*0.1;
        return tnk;
    }
    // nhập thông tin
    public void nhap(){
    Scanner s = new Scanner(System.in);
        System.out.println("\n mời bạn nhập tên sản phẩm:");
        tensp=s.nextLine();
        System.out.println("mời bạn nhập giá sản phẩm:");
        gia= Double.parseDouble(s.nextLine());
         System.out.println("giảm giá:");
        giamgia= Double.parseDouble(s.nextLine());
        
    }
    
    
    // xuất thông tin
   public void xuat(){
       
       System.out.println("tên sản phẩm: "+tensp);
       System.out.println("giá sản phẩm: "+ gia);
       System.out.println("giảm giá: "+ giamgia);
       System.out.println("thuế nhập khẩu: "+ getThueNhapKhau());   
       
   }
// hàm tạo có 3 tham số
    public sanpham(String tensp, double gia, double giamgia) {
        this.tensp = tensp;
        this.gia = gia;
        this.giamgia = giamgia;
    }  
// hàm tạo không có tham số
    public sanpham() {
    }
    // hàm tạo có 2 tham số
    public sanpham(String tensp, double gia) {
        this(tensp,gia,0);
    }
    
}
