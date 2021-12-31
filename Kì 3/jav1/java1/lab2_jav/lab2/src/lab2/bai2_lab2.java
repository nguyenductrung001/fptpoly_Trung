/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author Truong Dep Zai
 */
public class bai2_lab2 {
    public static void giaiPTB2()
    {System.out.println("mời bạn nhập 3 hệ số a,b,c");
        Scanner s = new Scanner(System.in);
       int a = Integer.parseInt(s.nextLine());
       int b = Integer.parseInt(s.nextLine());
       int c = Integer.parseInt(s.nextLine());
        if(a==0)
        {
            if(b==0)
            {
                if(c==0)
                {
                    System.out.println("phương trình vô số nghiệm");
                }
                else
                {
                    System.out.println("phương trình vô nghiệm");
                }
            }
            else
            {
                System.out.printf("phương trình có nghiệm là: x=%.1f",(float)-(c/b));
            }
        }
        else 
        {
            int delta=b*b-4*a*c;
            if(delta<0)
            {
                System.out.println("pt vn");
            }
            else if(delta==0)
            {
                System.out.printf("pt có nghiệm duy nhất là x=%.1f",(float)(-b/2*a));
            }
            else
            {
                float canDelta=(float)Math.sqrt(delta);
                float x1 = (-b+canDelta)/(2*a);
                float x2 = (-b-canDelta)/(2*a);
                System.out.printf("x1 = %.1f;x2 =%.1f",x1,x2);
            }
        }}
    public static void main(String[] args) {
        giaiPTB2();
    }
}
