/*
Tổ chức chương trình cho các bài Lab2 + bài sau (bài 4):
Xây dựng chương trình con thực hiện nhập thông tin về con vịt:
Nhập vào color, age. 
In: color, age, status (in Status bằng 2 cách: dùng toán tử điều kiện, dùng if)

Status như sau:
age <2: bình thường.
age >=2: vịt già.
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author Truong Dep Zai
 */
public class bài5lab2 {
 public static void convit()
 {
     System.out.println("mời bạn nhập màu sắc và tuổi của con vịt:");
        Scanner s = new Scanner(System.in);
        System.out.print("color:");
        String color = s.nextLine();

        System.out.print("age=");
        double age = s.nextDouble();

        String status = age < 2 ? "Binh Thuong" : "Vit Gia";
        System.out.printf("\nStatus: %s", status);

        if (age < 2) {
            System.out.printf("\nVit mau: %s", color);
            System.out.printf("\nVit %.1f tuoi", age);
            System.out.println("\nStatus: Binh Thuong");
        } else {
            System.out.printf("\nVit mau: %s", color);
            System.out.printf("\nVit %.1f tuoi", age);
            System.out.println("\nStatus: Vit Gia");
        }
 }
    public static void main(String[] args) {
        convit();

    }
}

