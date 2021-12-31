/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datainputexample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {   
   try {
     //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
     File f = new File("I:\\Data\\fpt-Polytechnic\\Java2\\Vidu_demo\\Lab5_RWFile\\FileWriter.txt");
     FileWriter fw = new FileWriter(f);

     //Bước 2: Ghi dữ liệu
     fw.write("Ghi dữ liệu bằng luồng character");

     //Bước 3: Đóng luồng
     fw.close(); 
   } catch (IOException ex) {
     System.out.println("Loi ghi file: " + ex);
 }
 }
}
