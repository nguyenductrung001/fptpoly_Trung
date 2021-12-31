/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datainputexample;

/**
 *
 * @author HongAnh
 */
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author giasutinhoc.vn
 */
public class DataInputExample {
 public static void main(String[] args) {
  try {
   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
   FileInputStream fis = new FileInputStream("I:\\Data\\fpt-Polytechnic\\Java2\\Vidu_demo\\Lab5_RWFile\\mydata.txt");
   DataInputStream dis = new DataInputStream(fis);

   //Bước 2: Đọc dữ liệu
   int n = dis.readInt(); 
   double m = dis.readDouble();

   //Bước 3: Đóng luồng
   fis.close();
   dis.close();

   //Hiển thị nội dung đọc từ file
   System.out.println("Số nguyên: " + n);
   System.out.println("Số thực: " + m);
  } catch (IOException ex) {
    ex.printStackTrace();
  } 
 }
}
