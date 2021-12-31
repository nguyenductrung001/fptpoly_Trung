
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
public class lab4bai1 {
    public static void main(String[] args) {
        double a,b,c,delta,canDelta;
         Scanner scanner = new Scanner (System.in);
         System.out.println("nhập các hệ só của phương trình bậc 2");
         System.out.print("a= ");
         a = scanner.nextDouble();
         
          System.out.print("b= ");
         b = scanner.nextDouble();
         
         
          System.out.print("c= ");
         c = scanner.nextDouble();
         
         delta = Math.pow(b, 2) - 4 * a * c  ;
  if (delta>=0){
      double canDelta1 = (double)Math.sqrt(delta);
      System.out.printf("can delta la:%.1f",canDelta1);
   
  }
  else{
      System.out.println("căn delta<0 thì candelta không tồn tại");
  }
}
}