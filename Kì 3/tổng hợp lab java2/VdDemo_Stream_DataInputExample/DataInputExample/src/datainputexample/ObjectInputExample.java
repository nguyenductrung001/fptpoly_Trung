/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datainputexample;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ObjectInputExample {
 public static void main(String[] args) {  
  try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileInputStream fis = new FileInputStream("I:\\Data\\fpt-Polytechnic\\Java2\\Vidu_demo\\Lab5_RWFile\\stock.txt");
    ObjectInputStream ois = new ObjectInputStream(fis);

    //Bước 2: Đọc dữ liệu
    Stock sArr[] = (Stock[]) ois.readObject();
    for(Stock s : sArr){
      System.out.println(s.toString());
    }

    //Bước 3: Đóng luồng
    fis.close();
    ois.close();
  } catch (Exception ex) {
    System.out.println("Loi doc file: "+ex);
 }
 }
}
