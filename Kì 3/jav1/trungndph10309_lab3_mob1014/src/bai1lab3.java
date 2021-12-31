
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
public class bai1lab3 {
     public static void main(String[] args) {
        System.out.println("mời bạn nhập số cần kiểm tra");
        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.nextLine());
        boolean isSNT= true;
        for(int i=2;i<a;i++)
        {
            if(a%i==0)
            {
                isSNT = false;//không phải số nguyên tố
            }
            i++;
        }
        if(isSNT==true)
        {
            System.out.println("Là số nguyên tố ");
        }
        else
        {
            System.out.println("không phải là số nguyên tố ");
        }
    }
}
