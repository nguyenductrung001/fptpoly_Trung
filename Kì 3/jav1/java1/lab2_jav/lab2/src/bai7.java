/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Truong Dep Zai
 */
public class bai7 {
    public static void main(String[] args) {
        System.out.println("bảng nhân 5:");
        for(int i =1;i<=10;i++){
            System.out.printf("5 x %d = %d\n",i,5*i);
        }
        
        // bảng cửu chương
        System.out.println("\n \n bảng cửu chương");
        int i;
        int j;
        for(i=2;i<=10;i++){
            System.out.printf("bảng nhân %d:\n",i);
            for(j=2;i<11;j++){
                System.out.printf("%d x %d =%d\n",i,j,i*j);
            }
        }
    }
}
