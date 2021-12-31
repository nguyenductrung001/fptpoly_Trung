/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datainputexample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author giasutinhoc.vn
 */
public class ObjectOutputExample {
 public static void main(String[] args) { 
  try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileOutputStream fos = new FileOutputStream("I:\\Data\\fpt-Polytechnic\\Java2\\Vidu_demo\\Lab5_RWFile\\stock.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    //Khai báo mảng
    Stock s[] = {
     new Stock(1, "CD ROM", 100, 2)
    ,new Stock(2, "CPU", 500, 2)
    ,new Stock(3, "HP Scanner", 75, 1)
    };
   //Bước 2: Ghi mảng đối tượng vào file
   oos.writeObject(s);

   //Bước 3: Đóng luồng
   fos.close();
   oos.close();
 } catch (IOException ex) {
   System.out.println("Loi ghi file: "+ex);
 }
 }
}