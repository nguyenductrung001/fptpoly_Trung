
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
public class Lab1Bai2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Chieu dai: ");
        double dai = scanner.nextDouble();

        System.out.print("Chieu rong: ");
        double rong = scanner.nextDouble();

        System.out.printf("Chu vi: %.1f", (dai + rong) * 2);
        System.out.println("");
        System.out.printf("Dien tich: %.1f", dai * rong);
        System.out.println("");
        System.out.printf("Canh nho nhat: %f", Math.min(dai, rong));
        System.out.println("");
    }

}
