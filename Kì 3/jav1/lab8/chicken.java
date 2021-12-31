/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.Scanner;

public class chicken {

    private String name, color;
    private double price;

    public chicken() {
    }

    public chicken(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "chicken{" + "name=" + name + ", color=" + color + ", price=" + price +
                "trang thai" + getStatus()+'}';
    }
  public String getStatus(){
      if(price>200){
          return "tot";
      } else{
          return "binh thuong";
      }
  }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("moi ban nhap name:");
        name = sc.nextLine();
        System.out.print("moi ban nhap color:");
        color = sc.nextLine();
        System.out.print("moi ban nhap price:");
        price = Double.parseDouble(sc.nextLine());
    }
    public void xuat(){
        System.out.println(toString());
    }
}
//Lớp Chicken:
//- đầy đủ thuộc tính: name, color, price (int)
//- Hàm tạo, set, get, toString
//- void output(): xuất thông tin, xuất cả trạng thái (status)
//- String getStatus(): nếu price <200 thì status là tốt, còn lai: bình thường.
//Lớp DSChicken:
//- 1 ArrayList <Chicken>
//- void init(): thêm 4 phần tử vào list
//- void outputChicken(): xuất thông tin các phần tử, xuất cả trạng thái
//- void findChicken(int min, int max): In các phần tử có price từ min đến max
//- void sortChicken(): sắp xếp các phần tử giảm dần theo price
//- void printMax(): In thông tin các phần tử có price lớn nhất
//Lớp Demo (giống Ass1): chứa main
//- Dùng while(true), switch tổ chức chương trình
//- Tạo đối tượng DSChicken: ds
//- Gọi các phương thức vừa tạo của ds
