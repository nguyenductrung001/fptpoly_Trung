
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
public class Cat {

    private String name;
    private double weight;
    private int age;

    public Cat() {
    }

    public Cat(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void nhap() {
        Scanner s = new Scanner(System.in);
        System.out.println("tên con cat là:");
        name = s.nextLine();
        System.out.println("cân nặng:");
        weight = Double.parseDouble(s.nextLine());
        System.out.println("tuổi:");
        age = Integer.parseInt(s.nextLine());

    }
    
    public void print() {
        System.out.println("Tên con mèo: " + this.name);
        System.out.println("Cân nặng: " + this.weight + " kg");
        System.out.println("Tuổi: " + this.age);
    }

    public String getXeploai() {
        if (this.weight < 0.5) {
            return "còi xương";
        } else if (this.weight < 2) {
            return "trung bình";
        } else {
            return "béo phì";
        }

    }
}

//BT Thêm lab4: Tạo lớp Cat (name, weight (double), age(int)
//-	Hàm tạo
//-	Set,get, toString
//-	Nhập
//-	String getXeploai(double weight):
//weight<0.5: còi xương
//weight<2: trung bình
//còn lại: béo phì
//1.	Tạo lớp Test chứa main
//-	Tạo 2 đối tượng Cat, dùng hàm tạo có tham số, không tham số
//-	Xuất thông tin, yêu cầu xuất cả xếp loại
