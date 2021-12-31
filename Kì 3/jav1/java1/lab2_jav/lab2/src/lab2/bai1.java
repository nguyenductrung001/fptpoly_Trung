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
public class bai1 {
    public static void giaiPTB1()
    {//input a,b;
       //output:-b/a;
        System.out.println("mời bạn nhập 2 hệ số a,b");//in ra màn hình
       Scanner s= new Scanner(System.in);
        System.out.print("a= :");
        double a =s.nextDouble();
        
        System.out.print("b= :");
        double b =s.nextDouble();
    if(a==0){
        if(b==0)
        {
            System.out.println("phương trình vô ngiệm:");
        }
        else 
        {
            System.out.println("Phương trình vô nghiệm:");
        
        }
    }
    else{
        System.out.printf("nhiệm là : x=%.1f",(float)-b/a);
    
    }}
    //psvm
    public static void main(String[] args) {
         
      giaiPTB1();
        
    }
}
