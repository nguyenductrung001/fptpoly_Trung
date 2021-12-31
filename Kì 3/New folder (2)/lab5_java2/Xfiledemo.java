/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_java2;


public class Xfiledemo {
 public static void main(String[] args) {
     try {
         
     
 String path="d:/lab5.ex1.dat";
 XFile.write(path, "hello".getBytes());
 byte[] data=XFile.read(path);
     System.out.println("read data "+ new String(data));
     
} catch (Exception e) {
         System.out.println("lỗi"+e.getMessage());
     }

    
}
}