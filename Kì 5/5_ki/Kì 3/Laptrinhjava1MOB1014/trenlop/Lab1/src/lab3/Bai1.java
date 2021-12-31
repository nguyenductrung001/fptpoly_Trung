package lab3;

import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        System.out.println("Xin moi nhap vao so nguyen");
        Scanner s = new Scanner(System.in);
        int so = Integer.parseInt(s.nextLine());
        boolean ok = true;
        int i = 2;
        for (; i < so;) {
            if (so % i++ == 0) {
                ok = false;
                break;
            }
        }
        if(ok){
            System.out.printf("\n%d la so nguyen to.",so);
        }else{
            System.out.printf("%d khong la so nguyen to.",so);
        }
    }
}